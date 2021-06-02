
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
            )

-- Objectifs du système
    --  Identification du plus mauvais livreur (nombre de retards dans la livraison) et du véhicule utilisé