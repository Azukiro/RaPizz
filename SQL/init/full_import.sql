-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 08 juin 2021 à 09:09
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `esiee`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `id_login` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `account_balance` double NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id_login`, `mail`, `password`, `account_balance`, `id_client`) VALUES
(1, 'ewen.bouquet@free.fr', 'c2fd602dba0e90c5418ce9fcbf0af9052e0e14b8', 1500.5, 1),
(2, 'fabien.courtois@gmail.com', 'af6cd4cbb67d2d73471dadd7005a23921c9bc829', 700.3, 2),
(3, 'loic.fournier@gmail.com', '57baf0938a84d48beabcd899514a14d0901b5927', 15, 3),
(4, 'serge.razionaff@gmail.com', '23e0f529d2146b2c9c5f50b5ad4ceafa4fa1e83b', 0, 4),
(5, 'lucas.billard@yahoo.fr', 'd89332e7bdab30358ae09713e494259d133541c7', 2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `city`
--

CREATE TABLE `city` (
  `zip` char(5) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `city`
--

INSERT INTO `city` (`zip`, `name`) VALUES
('77207', 'Torcy'),
('77400', 'Lagny-sur-Marne'),
('77427', 'Champs-sur-Marne'),
('77600', 'Bussy-Saint-Georges'),
('93161', 'Noisy-le-Grand'),
('93330', 'Neuilly-sur-Marne');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `id_client` int(11) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `phone` char(10) NOT NULL,
  `adress` varchar(50) NOT NULL,
  `zip` char(5) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`id_client`, `firstname`, `lastname`, `phone`, `adress`, `zip`, `name`) VALUES
(1, 'Ewen', 'Bouquet', '0781282363', '9 promenade Henri Xavier', '77600', 'Bussy-Saint-Georges'),
(2, 'Fabien', 'Courtois', '0781529456', '8 rue de la Fougère', '77427', 'Champs-sur-Marne'),
(3, 'Loïc', 'Fournier', '0782594678', '6 rue du Pamplemousse Sacré', '93330', 'Neuilly-sur-Marne'),
(4, 'Serge', 'Razianoff', '0794568271', '66 impasse Visotéra', '77427', 'Champs-sur-Marne'),
(5, 'Lucas', 'Billard', '0698452519', '36 rue du Kiwixi', '77600', 'Bussy-Saint-Georges');

-- --------------------------------------------------------

--
-- Structure de la table `composing`
--

CREATE TABLE `composing` (
  `id_pizza` int(11) NOT NULL,
  `id_ingredient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `composing`
--

INSERT INTO `composing` (`id_pizza`, `id_ingredient`) VALUES
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 15),
(1, 34),
(2, 14),
(2, 15),
(2, 31),
(2, 32),
(3, 3),
(3, 4),
(3, 5);

-- --------------------------------------------------------

--
-- Structure de la table `deliveryguys`
--

CREATE TABLE `deliveryguys` (
  `id_delivery_guy` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `phone` char(10) NOT NULL,
  `mail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `deliveryguys`
--

INSERT INTO `deliveryguys` (`id_delivery_guy`, `firstname`, `lastname`, `phone`, `mail`) VALUES
(1, 'Jean-Marie', 'Bigard', '0794531629', 'jean.heude@free.fr'),
(2, 'Jérémy', 'Ferrary', '0784956348', 'jeremy.ferrary@gmail.com'),
(3, 'Jean-Claude', 'Van Damme', '0794536148', 'jc.van-damme@gmail.com'),
(4, 'Kev', 'Adams', '0698462718', 'kev.adams@yahoo.fr'),
(5, 'Arnaud', 'Tsamere', '0798694827', 'arnaud.tsamere@free.fr');

-- --------------------------------------------------------

--
-- Structure de la table `ingredients`
--

CREATE TABLE `ingredients` (
  `id_ingredient` int(11) NOT NULL,
  `label` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ingredients`
--

INSERT INTO `ingredients` (`id_ingredient`, `label`) VALUES
(23, 'Ail'),
(15, 'Basilic'),
(3, 'Champignon'),
(9, 'Chorizo'),
(14, 'Crème fraiche'),
(31, 'Fromage de chèvre'),
(20, 'Fromage râpée'),
(11, 'Gorgonzola'),
(34, 'Huile piquante'),
(8, 'Jambon'),
(26, 'Jambon de pays'),
(28, 'Maïs'),
(17, 'Merguez'),
(32, 'Miel'),
(5, 'Mozarella'),
(19, 'Oeuf'),
(2, 'Olives Noire'),
(1, 'Olives Verte'),
(22, 'Parmesan'),
(33, 'Persil'),
(21, 'Pomme de terre'),
(7, 'Poulet'),
(6, 'Ricotta'),
(27, 'Roquette'),
(12, 'Sauce barbecue'),
(13, 'Sauce chedar'),
(18, 'Sauce piquante'),
(4, 'Sauce tomate'),
(10, 'Saucisson'),
(25, 'Saumon fumée'),
(24, 'Sel'),
(30, 'Tomate cerise'),
(29, 'Tomate séchée'),
(16, 'Truffe');

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `order_timestamp` datetime NOT NULL,
  `delivry_timestamp` datetime DEFAULT NULL,
  `id_size` int(11) NOT NULL,
  `id_vehicle` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_delivery_guy` int(11) NOT NULL,
  `id_pizza` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `orders`
--

INSERT INTO `orders` (`id_order`, `order_timestamp`, `delivry_timestamp`, `id_size`, `id_vehicle`, `id_client`, `id_delivery_guy`, `id_pizza`) VALUES
(1, '2021-06-10 18:40:13', '2021-06-10 19:00:13', 1, 1, 2, 1, 1),
(2, '2021-06-12 18:10:23', '2021-06-12 18:20:13', 2, 2, 2, 1, 1),
(3, '2021-06-10 18:22:45', '2021-06-10 18:35:13', 3, 5, 3, 5, 3),
(4, '2021-06-10 18:35:23', '2021-06-10 18:01:13', 1, 4, 1, 2, 3),
(5, '2021-06-10 18:40:53', '2021-06-10 19:30:13', 2, 5, 2, 3, 3),
(6, '2021-06-10 18:33:35', '2021-06-10 19:03:13', 3, 1, 5, 4, 3),
(7, '2021-06-10 18:32:48', '2021-06-10 19:12:13', 1, 2, 4, 4, 2),
(8, '2021-06-10 18:47:46', '2021-06-10 19:46:13', 2, 5, 1, 1, 2),
(9, '2021-06-10 18:46:18', '2021-06-10 19:32:13', 3, 4, 3, 2, 2),
(10, '2021-06-10 18:12:19', '2021-06-10 19:46:13', 1, 5, 1, 3, 2),
(11, '2021-06-10 18:43:56', '2021-06-10 19:06:13', 2, 1, 4, 5, 2),
(12, '2021-06-10 18:26:47', '2021-06-10 19:04:13', 3, 2, 2, 1, 3),
(13, '2021-06-10 18:46:36', '2021-06-10 19:12:13', 1, 3, 2, 5, 2),
(14, '2021-06-10 18:35:42', '2021-06-10 19:45:13', 2, 4, 5, 2, 3),
(15, '2021-06-10 18:22:43', '2021-06-10 19:58:13', 3, 5, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `pizzas`
--

CREATE TABLE `pizzas` (
  `id_pizza` int(11) NOT NULL,
  `label` varchar(20) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pizzas`
--

INSERT INTO `pizzas` (`id_pizza`, `label`, `price`) VALUES
(1, 'Regina', 10.5),
(2, 'Chèvre Miel', 12.5),
(3, 'Margherita', 8);

-- --------------------------------------------------------

--
-- Structure de la table `pizzasizes`
--

CREATE TABLE `pizzasizes` (
  `id_size` int(11) NOT NULL,
  `label` varchar(8) NOT NULL,
  `multiplicator` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pizzasizes`
--

INSERT INTO `pizzasizes` (`id_size`, `label`, `multiplicator`) VALUES
(1, 'naine', 0.6),
(2, 'humaine', 1),
(3, 'ogresse', 1.3);

-- --------------------------------------------------------

--
-- Structure de la table `vehicles`
--

CREATE TABLE `vehicles` (
  `id_vehicle` int(11) NOT NULL,
  `licence_plate` char(9) DEFAULT NULL,
  `label` varchar(20) NOT NULL,
  `id_vehicle_types` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vehicles`
--

INSERT INTO `vehicles` (`id_vehicle`, `licence_plate`, `label`, `id_vehicle_types`) VALUES
(1, 'A1-A1A-1A', 'Renault 4L', 1),
(2, 'B1-A1A-1N', 'Peugeot 208', 1),
(3, 'B1-314-1N', 'Bugatti Chiron', 1),
(4, 'B1-4Z4-1N', 'Honda Forza 125', 2),
(5, '1Y-4D4-34', 'BMW R1200 ST', 2),
(6, '2Y-RD4-14', 'Volkswagen Arteon Sh', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vehicletypes`
--

CREATE TABLE `vehicletypes` (
  `id_vehicle_types` int(11) NOT NULL,
  `label` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vehicletypes`
--

INSERT INTO `vehicletypes` (`id_vehicle_types`, `label`) VALUES
(2, 'moto'),
(1, 'voiture');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_login`),
  ADD UNIQUE KEY `id_client` (`id_client`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- Index pour la table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`zip`,`name`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_client`),
  ADD KEY `zip` (`zip`,`name`);

--
-- Index pour la table `composing`
--
ALTER TABLE `composing`
  ADD KEY `id_ingredient` (`id_ingredient`),
  ADD KEY `composing_ibfk_1` (`id_pizza`);

--
-- Index pour la table `deliveryguys`
--
ALTER TABLE `deliveryguys`
  ADD PRIMARY KEY (`id_delivery_guy`);

--
-- Index pour la table `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`id_ingredient`),
  ADD UNIQUE KEY `label` (`label`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_size` (`id_size`),
  ADD KEY `id_vehicle` (`id_vehicle`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_delivery_guy` (`id_delivery_guy`),
  ADD KEY `id_pizza` (`id_pizza`);

--
-- Index pour la table `pizzas`
--
ALTER TABLE `pizzas`
  ADD PRIMARY KEY (`id_pizza`),
  ADD UNIQUE KEY `label` (`label`);

--
-- Index pour la table `pizzasizes`
--
ALTER TABLE `pizzasizes`
  ADD PRIMARY KEY (`id_size`),
  ADD UNIQUE KEY `label` (`label`);

--
-- Index pour la table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`id_vehicle`),
  ADD KEY `id_vehicle_types` (`id_vehicle_types`);

--
-- Index pour la table `vehicletypes`
--
ALTER TABLE `vehicletypes`
  ADD PRIMARY KEY (`id_vehicle_types`),
  ADD UNIQUE KEY `label` (`label`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id_login` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `deliveryguys`
--
ALTER TABLE `deliveryguys`
  MODIFY `id_delivery_guy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `ingredients`
--
ALTER TABLE `ingredients`
  MODIFY `id_ingredient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pour la table `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `pizzas`
--
ALTER TABLE `pizzas`
  MODIFY `id_pizza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `pizzasizes`
--
ALTER TABLE `pizzasizes`
  MODIFY `id_size` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `id_vehicle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `vehicletypes`
--
ALTER TABLE `vehicletypes`
  MODIFY `id_vehicle_types` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`);

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`zip`,`name`) REFERENCES `city` (`zip`, `name`);

--
-- Contraintes pour la table `composing`
--
ALTER TABLE `composing`
  ADD CONSTRAINT `composing_ibfk_1` FOREIGN KEY (`id_pizza`) REFERENCES `pizzas` (`id_pizza`),
  ADD CONSTRAINT `composing_ibfk_2` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredients` (`id_ingredient`);

--
-- Contraintes pour la table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_size`) REFERENCES `pizzasizes` (`id_size`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`id_vehicle`) REFERENCES `vehicles` (`id_vehicle`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`),
  ADD CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`id_delivery_guy`) REFERENCES `deliveryguys` (`id_delivery_guy`),
  ADD CONSTRAINT `orders_ibfk_5` FOREIGN KEY (`id_pizza`) REFERENCES `pizzas` (`id_pizza`);

--
-- Contraintes pour la table `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`id_vehicle_types`) REFERENCES `vehicletypes` (`id_vehicle_types`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
