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

-- Meilleure pizza
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

-- Vérification du solde
-- Don't need on app for moment
SELECT
    acco.account_balance
FROM
    account acco
WHERE  
    acco.id_client = 1; -- => $clientId

-- Facturation de la commande
-- Don't need on app for moment
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


-- Vehicules libres
-- public ArrayList<Vehicle> freeVehicles()
SELECT
    vehi.id_vehicle,
    vehi.licence_plate,
    vehi.label
FROM
    orders orde
INNER JOIN vehicles vehi ON
    orde.id_vehicle = vehi.id_vehicle
WHERE
    orde.id_vehicle NOT IN(
    SELECT
        vehi.id_vehicle
    FROM
        orders orde
    INNER JOIN vehicles vehi ON
        orde.id_vehicle = vehi.id_vehicle
    WHERE
        orde.delivry_timestamp IS NULL
    GROUP BY
        vehi.id_vehicle
)
GROUP BY
    vehi.id_vehicle;



-- Livreurs libres
-- public ArrayList<DeliveryGuy> freeDeliveryGuys()
SELECT
    deli.*
FROM
    orders orde
INNER JOIN deliveryguys deli ON
    orde.id_delivery_guy = deli.id_delivery_guy
WHERE
    orde.id_delivery_guy NOT IN(
    SELECT
        deli.id_delivery_guy
    FROM
        orders orde
    INNER JOIN deliveryguys deli ON
        orde.id_delivery_guy = deli.id_delivery_guy
    WHERE
        orde.delivry_timestamp IS NULL
    GROUP BY
        deli.id_delivery_guy
)
GROUP BY
    deli.id_delivery_guy;

-- Insert Order
-- public boolean insertOrder(Pizza pizza, Client client, Vehicle vehicle, DeliveryGuy deliveryGuy,PizzaSize size)
INSERT INTO `orders`(
    `id_order`,
    `order_timestamp`,
    `delivry_timestamp`,
    `id_size`,
    `id_vehicle`,
    `id_client`,
    `id_delivery_guy`,
    `id_pizza`
)
VALUES(
    NULL,
    NOW(), 
    NULL, 
    id_size, 
    id_vehicle, 
    id_client, 
    id_delivery_guy,
    id_pizza
);






