INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Olives Verte");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Olives Noire");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Champignon");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Sauce tomate");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Mozarella");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Ricotta");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Poulet");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Jambon");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Chorizo");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Saucisson");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Gorgonzola");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Sauce barbecue");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Sauce chedar");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Crème fraiche");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Basilic");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Truffe");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Merguez");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Sauce piquante");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Oeuf");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Fromage râpée");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Pomme de terre");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Parmesan");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Ail");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Sel");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Saumon fumée");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Jambon de pays");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Roquette");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Maïs");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Tomate séchée");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Tomate cerise");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Fromage de chèvre");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Miel");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Persil");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Huile d'olive");
INSERT INTO ingredients(id_ingredient, label) VALUES (null,"Huile piquante");



INSERT INTO pizzas(id_pizza, label, price) VALUES (null,"Regina",10.5);
INSERT INTO pizzas(id_pizza, label, price) VALUES (null,"Chèvre Miel",12.5);
INSERT INTO pizzas(id_pizza, label, price) VALUES (null,"Margherita",8);


INSERT INTO composing(id_pizza, id_ingredient) VALUES (1,4);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (1,5);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (1,3);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (1,2);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (1,34);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (1,15);

INSERT INTO composing(id_pizza, id_ingredient) VALUES (2,32);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (2,31);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (2,14);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (2,15);

INSERT INTO composing(id_pizza, id_ingredient) VALUES (3,4);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (3,5);
INSERT INTO composing(id_pizza, id_ingredient) VALUES (3,3);



INSERT INTO sizes(id_size, label, multiplicator) VALUES (null,"naine",0.6);
INSERT INTO sizes(id_size, label, multiplicator) VALUES (null,"humaine",1);
INSERT INTO sizes(id_size, label, multiplicator) VALUES (null,"ogresse",1.3);



INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:40:13","2021-06-10 19:00:13",1,1,2,1,1);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-12 18:10:23","2021-06-12 18:20:13",2,2,2,1,1);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:22:45","2021-06-10 18:35:13",3,5,3,5,3);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:35:23","2021-06-10 18:01:13",1,4,1,2,3);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:40:53","2021-06-10 19:30:13",2,5,2,3,3);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:33:35","2021-06-10 19:03:13",3,1,5,4,3);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:32:48","2021-06-10 19:12:13",1,2,4,4,2);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:47:46","2021-06-10 19:46:13",2,5,1,1,2);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:46:18","2021-06-10 19:32:13",3,4,3,2,2);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:12:19","2021-06-10 19:46:13",1,5,1,3,2);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:43:56","2021-06-10 19:06:13",2,1,4,5,2);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:26:47","2021-06-10 19:04:13",3,2,2,1,3);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:46:36","2021-06-10 19:12:13",1,3,2,5,2);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:35:42","2021-06-10 19:45:13",2,4,5,2,3);
INSERT INTO orders(id_order, order_timestamp, delivry_timestamp, id_size, id_vehicle, id_client, id_delivery_guy, id_pizza) VALUES (null,"2021-06-10 18:22:43","2021-06-10 19:58:13",3,5,1,1,1);




