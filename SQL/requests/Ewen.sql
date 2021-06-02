
-- 0) Se connecter
    SELECT 
        ac.id_client
    FROM account AS ac
    WHERE 
        ac.mail = "ewen.bouquet@free.fr"
            AND
        ac.password = "c2fd602dba0e90c5418ce9fcbf0af9052e0e14b8";

-- Interrogation de la base de données

    -- 1) Menu
        SELECT 
            pizz.id_pizza,
            pizz.label,
            (
                SELECT 
                    GROUP_CONCAT(ingr.label)
                FROM composing      AS comp
                JOIN ingredients    AS ingr     ON comp.id_ingredient = ingr.id_ingredient
                WHERE comp.id_pizza = pizz.id_pizza
            )
        FROM pizzas         AS pizz;

        -- ou
        SELECT 
            pizz.id_pizza,
            pizz.label,
            pizz.price
        FROM pizzas         AS pizz
        JOIN composing      AS comp     ON comp.id_pizza       = pizz.id_pizza
        JOIN ingredients    AS ingr     ON comp.id_ingredient  = ingr.id_ingredient;

    -- 3) Questions diverses    
    -- Quels sont les véhicules n’ayant jamais servi ?
        SELECT 
            DISTINCT(vehi.id_vehicle),
            vehi.label
        FROM vehicles           AS vehi     
        LEFT JOIN orders        AS orde     ON orde.id_vehicle = vehi.id_vehicle
        WHERE orde.id_vehicle IS NULL
        GROUP BY vehi.id_vehicle;

    -- Calcul du nombre de commandes par client ?
        SELECT 
            clien.id_client,
            clien.firstname,
            clien.lastname,
            COUNT(orde.id_order) AS `orders_nb`
        FROM clients            AS clien     
        JOIN orders             AS orde     ON orde.id_client = clien.id_client
        GROUP BY clien.id_client;

    -- Calcul de la moyenne des commandes ?
        SELECT
            AVG(pizz.price * size.multiplicator)
        FROM orders             AS orde
        JOIN pizzas             AS pizz     ON orde.id_pizza = pizz.id_pizza
        JOIN pizzasizes              AS size     ON orde.id_size  = size.id_size;


    -- Extraction des clients ayant commandé plus que la moyenne ?
        SELECT
            r1_clien.id_client,
            r1_clien.firstname,
            r1_clien.lastname
        FROM clients            AS r1_clien
        WHERE 
            EXISTS (
                SELECT r2_orde.id_order
                    FROM orders         AS r2_orde
                JOIN pizzas             AS r2_pizz     ON r2_orde.id_pizza   = r2_pizz.id_pizza
                JOIN pizzasizes              AS r2_size     ON r2_orde.id_size    = r2_size.id_size
                WHERE 
                    r2_orde.id_client = r1_clien.id_client
                        AND
                    r2_pizz.price * r2_size.multiplicator > (
                        SELECT
                            AVG(r3_pizz.price * r3_size.multiplicator)
                        FROM orders             AS r3_orde
                        JOIN pizzas             AS r3_pizz     ON r3_orde.id_pizza = r3_pizz.id_pizza
                        JOIN pizzasizes         AS r3_size     ON r3_orde.id_size  = r3_size.id_size
                    )
            );

-- Objectifs du système

    -- Suivi du chiffre d’affaires
    (
        -- Order price
        SELECT
            DATE_FORMAT(orde.delivry_timestamp, "%Y/%d"),
            SUM(pizz.price * pisi.multiplicator) AS turnover 
        FROM orders         AS orde
        JOIN pizzas         AS pizz     ON pizz.id_pizza = orde.id_pizza
        JOIN pizzasizes     AS pisi     ON pisi.id_size  = orde.id_size
        GROUP BY DATE_FORMAT(orde.delivry_timestamp, "%Y/%d")
    );

    -- Refus d’honorer les commandes pour lesquelles le solde du compte client est insuffisant ;
    -- => $orderId, $accountId
    SELECT 
        0 <= (
            (
                -- Client account
                SELECT
                    acco.account_balance
                FROM account AS acco
                WHERE  
                    acco.id_client = 1
            )
                -
            (
                -- Order price
                SELECT
                    pizz.price * pisi.multiplicator AS price
                FROM orders         AS orde
                JOIN pizzas         AS pizz     ON pizz.id_pizza = orde.id_pizza
                JOIN pizzasizes     AS pisi     ON pisi.id_size  = orde.id_size
                WHERE  
                    orde.id_order = 1
            )
        ) AS can_buy;

    -- Non-facturation des pizzas gratuites (retard ou fidélité)
    -- => $orderId, $clientId
    SELECT
        (
            (
                -- Free 10 pizza
                SELECT
                    (
                        COUNT(r2_orde.id_order) % 10
                    ) = 0 AS free_10_pizza
                FROM orders             AS r2_orde
                WHERE 
                    r2_orde.id_client = 1
            )
                OR
            (
                -- Free late pizza
                SELECT
                    (
                        DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= 1
                            OR
                        (
                            DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) = 0
                                AND
                            TIMEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= "00:30:00"
                        )
                    ) AS late_order
                FROM orders             AS r2_orde
                WHERE 
                    r2_orde.id_order = 1
            )
        ) AS is_pizza_free;
        

    --  Identification du plus mauvais livreur et de la voiture utilisée (nombre de retards dans la livraison)
        SELECT 
            r2_degu.id_delivery_guy, 
            r2_degu.firstname,
            r2_degu.lastname,
            r2_vehi.id_vehicle,
            r2_vehi.label,
            r2_vehi.licence_plate,
            COUNT(*) AS late_orders_nb
        FROM deliveryguys 	AS r2_degu 
        JOIN orders 		AS r2_orde		ON r2_orde.id_delivery_guy = r2_degu.id_delivery_guy 	
        JOIN vehicles 		AS r2_vehi      ON r2_orde.id_vehicle      = r2_vehi.id_vehicle
        WHERE
            DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= 1
                OR
            (
                DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) = 0
                    AND
                TIMEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= "00:30:00"
            )
        GROUP BY r2_degu.id_delivery_guy
    	ORDER BY COUNT(*) DESC
        LIMIT 1;

    -- Identification de l’ingrédient favori
    SELECT 
        *,
        COUNT(*) AS order_nb
    FROM ingredients 	AS ingr 
    JOIN composing 		AS comp 	ON comp.id_ingredient = ingr.id_ingredient
    JOIN pizzas			AS pizz  	ON pizz.id_pizza      = comp.id_pizza
    JOIN orders			AS orde		ON orde.id_pizza      = pizz.id_pizza
    GROUP BY ingr.id_ingredient
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    