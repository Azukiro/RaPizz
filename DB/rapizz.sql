-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 01 juin 2021 à 16:50
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `rapizz`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id_login` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `account_balance` double NOT NULL,
  `id_client` int(11) NOT NULL,
  PRIMARY KEY (`id_login`),
  UNIQUE KEY `id_client` (`id_client`),
  UNIQUE KEY `mail` (`mail`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `zip` char(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`zip`,`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `phone` char(10) NOT NULL,
  `adress` varchar(50) NOT NULL,
  `zip` char(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id_client`),
  KEY `zip` (`zip`,`name`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `composing`;
CREATE TABLE IF NOT EXISTS `composing` (
  `id_pizza` int(11) NOT NULL,
  `id_ingredient` int(11) NOT NULL,
  PRIMARY KEY (`id_pizza`,`id_ingredient`),
  KEY `id_ingredient` (`id_ingredient`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `deliveryguys`;
CREATE TABLE IF NOT EXISTS `deliveryguys` (
  `id_delivery_guy` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `phone` char(10) NOT NULL,
  `mail` varchar(50) NOT NULL,
  PRIMARY KEY (`id_delivery_guy`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `ingredients`;
CREATE TABLE IF NOT EXISTS `ingredients` (
  `id_ingredient` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(20) NOT NULL,
  PRIMARY KEY (`id_ingredient`),
  UNIQUE KEY `label` (`label`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ingredients`
--

INSERT INTO `ingredients` (`id_ingredient`, `label`) VALUES
(1, 'Olives Verte'),
(2, 'Olives Noire'),
(3, 'Champignon'),
(4, 'Sauce tomate'),
(5, 'Mozarella'),
(6, 'Ricotta'),
(7, 'Poulet'),
(8, 'Jambon'),
(9, 'Chorizo'),
(10, 'Saucisson'),
(11, 'Gorgonzola'),
(12, 'Sauce barbecue'),
(13, 'Sauce chedar'),
(14, 'Crème fraiche'),
(15, 'Basilic'),
(16, 'Truffe'),
(17, 'Merguez'),
(18, 'Sauce piquante'),
(19, 'Oeuf'),
(20, 'Fromage râpée'),
(21, 'Pomme de terre'),
(22, 'Parmesan'),
(23, 'Ail'),
(24, 'Sel'),
(25, 'Saumon fumée'),
(26, 'Jambon de pays'),
(27, 'Roquette'),
(28, 'Maïs'),
(29, 'Tomate séchée'),
(30, 'Tomate cerise'),
(31, 'Fromage de chèvre'),
(32, 'Miel'),
(33, 'Persil'),
(34, 'Huile piquante');

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `order_timestamp` datetime NOT NULL,
  `delivry_timestamp` datetime DEFAULT NULL,
  `id_size` int(11) NOT NULL,
  `id_vehicle` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_delivery_guy` int(11) NOT NULL,
  `id_pizza` int(11) NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `id_size` (`id_size`),
  KEY `id_vehicle` (`id_vehicle`),
  KEY `id_client` (`id_client`),
  KEY `id_delivery_guy` (`id_delivery_guy`),
  KEY `id_pizza` (`id_pizza`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `pizzas`;
CREATE TABLE IF NOT EXISTS `pizzas` (
  `id_pizza` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(20) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id_pizza`),
  UNIQUE KEY `label` (`label`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `pizzasizes`;
CREATE TABLE IF NOT EXISTS `pizzasizes` (
  `id_size` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(8) NOT NULL,
  `multiplicator` double NOT NULL,
  PRIMARY KEY (`id_size`),
  UNIQUE KEY `label` (`label`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
CREATE TABLE IF NOT EXISTS `sizes` (
  `id_size` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(8) NOT NULL,
  `multiplicator` double NOT NULL,
  PRIMARY KEY (`id_size`),
  UNIQUE KEY `label` (`label`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sizes`
--

INSERT INTO `sizes` (`id_size`, `label`, `multiplicator`) VALUES
(1, 'naine', 0.6),
(2, 'humaine', 1),
(3, 'ogresse', 1.3);

-- --------------------------------------------------------

--
-- Structure de la table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE IF NOT EXISTS `vehicles` (
  `id_vehicle` int(11) NOT NULL AUTO_INCREMENT,
  `licence_plate` char(9) DEFAULT NULL,
  `label` varchar(20) NOT NULL,
  `id_vehicle_types` int(11) NOT NULL,
  PRIMARY KEY (`id_vehicle`),
  KEY `id_vehicle_types` (`id_vehicle_types`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vehicles`
--

INSERT INTO `vehicles` (`id_vehicle`, `licence_plate`, `label`, `id_vehicle_types`) VALUES
(1, 'A1-A1A-1A', 'Renault 4L', 1),
(2, 'B1-A1A-1N', 'Peugeot 208', 1),
(3, 'B1-314-1N', 'Bugatti Chiron', 1),
(4, 'B1-4Z4-1N', 'Honda Forza 125', 2),
(5, '1Y-4D4-34', 'BMW R1200 ST', 2);

-- --------------------------------------------------------

--
-- Structure de la table `vehicletypes`
--

DROP TABLE IF EXISTS `vehicletypes`;
CREATE TABLE IF NOT EXISTS `vehicletypes` (
  `id_vehicle_types` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(10) NOT NULL,
  PRIMARY KEY (`id_vehicle_types`),
  UNIQUE KEY `label` (`label`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vehicletypes`
--

INSERT INTO `vehicletypes` (`id_vehicle_types`, `label`) VALUES
(2, 'moto'),
(1, 'voiture');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
