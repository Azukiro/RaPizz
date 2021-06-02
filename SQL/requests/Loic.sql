-- Meilleur Client
SELECT
    clie.firstname,
    clie.lastname,
    orde.id_client,
    COUNT(orde.id_client) AS nbOrders
FROM
    orders orde
INNER JOIN clients clie ON
    orde.id_client = clie.id_client
GROUP BY
    orde.id_client
ORDER BY
    nbOrders
DESC
LIMIT 1;

-- Meilleur pizza
SELECT
    pizz.label,
     orde.id_pizza,
    COUNT( orde.id_pizza) AS nbOrders
FROM
    orders  orde
INNER JOIN pizzas pizz ON
    orde.id_pizza = pizz.id_pizza
GROUP BY
    orde.id_pizza
ORDER BY
    nbOrders
DESC
LIMIT 1;

-- Pire pizza
SELECT
    pizz.label,
     orde.id_pizza,
    COUNT( orde.id_pizza) AS nbOrders
FROM
    orders  orde
INNER JOIN pizzas pizz ON
    orde.id_pizza = pizz.id_pizza
GROUP BY
    orde.id_pizza
ORDER BY
    nbOrders
ASC
LIMIT 1;

-- Verification du solde
SELECT
    acco.account_balance
FROM
    account acco
WHERE  
    acco.id_client = 1; -- => $clientId

-- Facturation de la commande
UPDATE account acco
SET
    acco.account_balance = acco.account_balance -(
        -- Order price
    SELECT
        pizz.price * pisi.multiplicator AS price
    FROM
        orders AS orde
    JOIN pizzas AS pizz
    ON
        pizz.id_pizza = orde.id_pizza
    JOIN pizzasizes AS pisi
    ON
        pisi.id_size = orde.id_size
    WHERE
        orde.id_order = 1 -- => $orderId
    )
WHERE
    acco.id_client = 1; -- => $clientId
