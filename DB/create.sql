DROP TABLE IF EXISTS Ingredients;
CREATE TABLE Ingredients(
   id_ingredient INT AUTO_INCREMENT,
   label VARCHAR(20) NOT NULL,
   PRIMARY KEY(id_ingredient),
   UNIQUE(label)
);

DROP TABLE IF EXISTS DeliveryGuys;
CREATE TABLE DeliveryGuys(
   id_delivery_guy INT AUTO_INCREMENT,
   firstname VARCHAR(30) NOT NULL,
   lastname VARCHAR(30) NOT NULL,
   phone CHAR(10) NOT NULL,
   mail VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_delivery_guy)
);

DROP TABLE IF EXISTS VehicleTypes;
CREATE TABLE VehicleTypes(
   id_vehicle_types INT AUTO_INCREMENT,
   label VARCHAR(10) NOT NULL,
   PRIMARY KEY(id_vehicle_types),
   UNIQUE(label)
);

DROP TABLE IF EXISTS City;
CREATE TABLE City(
   zip CHAR(5),
   name VARCHAR(30),
   PRIMARY KEY(zip, name)
);

DROP TABLE IF EXISTS Vehicles;
CREATE TABLE Vehicles(
   id_vehicle INT AUTO_INCREMENT,
   licence_plate CHAR(9),
   label VARCHAR(20) NOT NULL,
   id_vehicle_types INT NOT NULL,
   PRIMARY KEY(id_vehicle),
   FOREIGN KEY(id_vehicle_types) REFERENCES VehicleTypes(id_vehicle_types)
);

DROP TABLE IF EXISTS Clients;
CREATE TABLE Clients(
   id_client INT AUTO_INCREMENT,
   firstname VARCHAR(20) NOT NULL,
   lastname VARCHAR(20) NOT NULL,
   phone CHAR(10) NOT NULL,
   adress VARCHAR(50) NOT NULL,
   zip CHAR(5) NOT NULL,
   name VARCHAR(30) NOT NULL,
   PRIMARY KEY(id_client),
   FOREIGN KEY(zip, name) REFERENCES City(zip, name)
);

DROP TABLE IF EXISTS Account;
CREATE TABLE Account(
   id_login INT AUTO_INCREMENT,
   mail VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   account_balance DOUBLE NOT NULL,
   id_client INT NOT NULL,
   PRIMARY KEY(id_login),
   UNIQUE(id_client),
   UNIQUE(mail),
   FOREIGN KEY(id_client) REFERENCES Clients(id_client)
);

DROP TABLE IF EXISTS Composing;
CREATE TABLE Composing(
   id_pizza INT,
   id_ingredient INT,
   PRIMARY KEY(id_pizza, id_ingredient),
   FOREIGN KEY(id_pizza) REFERENCES Pizzas(id_pizza),
   FOREIGN KEY(id_ingredient) REFERENCES Ingredients(id_ingredient)
);

DROP TABLE IF EXISTS Pizzas;
CREATE TABLE Pizzas(
   id_pizza INT AUTO_INCREMENT,
   label VARCHAR(20) NOT NULL,
   price DOUBLE NOT NULL,
   PRIMARY KEY(id_pizza),
   UNIQUE(label)
);

DROP TABLE IF EXISTS PizzaSizes;
CREATE TABLE PizzaSizes(
   id_size INT AUTO_INCREMENT,
   label VARCHAR(8) NOT NULL,
   multiplicator DOUBLE NOT NULL,
   PRIMARY KEY(id_size),
   UNIQUE(label)
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders(
   id_order INT AUTO_INCREMENT,
   order_timestamp DATETIME NOT NULL,
   delivry_timestamp DATETIME,
   id_size INT NOT NULL,
   id_vehicle INT NOT NULL,
   id_client INT NOT NULL,
   id_delivery_guy INT NOT NULL,
   id_pizza INT NOT NULL,
   PRIMARY KEY(id_order),
   FOREIGN KEY(id_size) REFERENCES PizzaSizes(id_size),
   FOREIGN KEY(id_vehicle) REFERENCES Vehicles(id_vehicle),
   FOREIGN KEY(id_client) REFERENCES Clients(id_client),
   FOREIGN KEY(id_delivery_guy) REFERENCES DeliveryGuys(id_delivery_guy),
   FOREIGN KEY(id_pizza) REFERENCES Pizzas(id_pizza)
);






