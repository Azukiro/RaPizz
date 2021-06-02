---Meilleur Client
SELECT
    C.firstname,
    C.lastname,
    O.id_client,
    COUNT(O.id_client) AS nbOrders
FROM
    orders O
INNER JOIN clients C ON
    O.id_client = C.id_client
GROUP BY
    O.id_client
ORDER BY
    nbOrders
DESC
LIMIT 1;

--Meilleur pizza
SELECT
    P.label,
    O.id_pizza,
    COUNT(O.id_pizza) AS nbOrders
FROM
    orders O
INNER JOIN pizzas P ON
    O.id_pizza = P.id_pizza
GROUP BY
    O.id_pizza
ORDER BY
    nbOrders
DESC
LIMIT 1;

--Pire pizza
SELECT
    P.label,
    O.id_pizza,
    COUNT(O.id_pizza) AS nbOrders
FROM
    orders O
INNER JOIN pizzas P ON
    O.id_pizza = P.id_pizza
GROUP BY
    O.id_pizza
ORDER BY
    nbOrders
ASC
LIMIT 1;