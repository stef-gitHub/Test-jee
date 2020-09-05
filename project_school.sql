-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  sam. 05 sep. 2020 à 21:16
-- Version du serveur :  5.7.26
-- Version de PHP :  7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `project_school`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `annee` int(11) NOT NULL,
  `id_niveau` int(11) NOT NULL,
  PRIMARY KEY (`id_classe`),
  KEY `Classe_Niveau_FK` (`id_niveau`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id_classe`, `nom`, `annee`, `id_niveau`) VALUES
(1, 'CM_1', 2020, 4),
(2, 'CP', 2020, 1),
(3, 'CE_1', 2020, 2),
(4, 'CE_2', 2020, 3),
(5, 'CM_2', 2020, 5);

-- --------------------------------------------------------

--
-- Structure de la table `classe_eleve`
--

DROP TABLE IF EXISTS `classe_eleve`;
CREATE TABLE IF NOT EXISTS `classe_eleve` (
  `id_eleve` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  PRIMARY KEY (`id_eleve`,`id_classe`),
  KEY `classe_eleve_Classe0_FK` (`id_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `classe_professeur`
--

DROP TABLE IF EXISTS `classe_professeur`;
CREATE TABLE IF NOT EXISTS `classe_professeur` (
  `id_professeur` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  PRIMARY KEY (`id_professeur`,`id_classe`),
  KEY `classe_professeur_Classe0_FK` (`id_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe_professeur`
--

INSERT INTO `classe_professeur` (`id_professeur`, `id_classe`) VALUES
(206, 2);

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `id_cours` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `id_classe` int(11) NOT NULL,
  PRIMARY KEY (`id_cours`),
  KEY `Cours_Classe_FK` (`id_classe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id_cours`, `nom`, `date_debut`, `date_fin`, `id_classe`) VALUES
(4, 'Dessin', '2020-09-14', '2020-09-18', 2);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `id_eleve` int(11) NOT NULL AUTO_INCREMENT,
  `nom_pere` varchar(100) NOT NULL,
  `nom_mere` varchar(100) NOT NULL,
  `id_personne` int(11) NOT NULL,
  PRIMARY KEY (`id_eleve`),
  KEY `Eleve_Personne_FK` (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`id_eleve`, `nom_pere`, `nom_mere`, `id_personne`) VALUES
(22, 'Adberrahmane AGHARBI', 'Kenza AGHARBI', 127),
(23, 'Pascal MEUNIER', 'Dominique MEUNIER', 128),
(24, 'Chirstian LAVARIE', 'Nathalie LAVARIE', 129),
(55, 'Patrice COUSIN', 'Martine COUSIN', 130);

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `id_professeur` int(11) NOT NULL,
  `id_livre` int(11) NOT NULL,
  `id_materiel` int(11) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  PRIMARY KEY (`id_professeur`,`id_livre`,`id_materiel`),
  KEY `emprunt_Livre0_FK` (`id_livre`),
  KEY `emprunt_Materiel1_FK` (`id_materiel`),
  KEY `id_livre_2` (`id_livre`),
  KEY `id_livre` (`id_livre`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`id_professeur`, `id_livre`, `id_materiel`, `date_debut`, `date_fin`) VALUES
(206, 3, 103, '2020-09-02', NULL),
(207, 5, 105, '2020-09-02', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `id_livre` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  `auteur` varchar(100) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id_livre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id_livre`, `libelle`, `auteur`, `date`) VALUES
(1, 'Le Seigneur des anneaux', 'J.R.R. Tolkien', '1955-08-25'),
(2, 'L\'Étranger', 'Albert Camus', '1942-08-02'),
(3, 'Les Fleurs du mal', 'Charles Baudelaire', '1827-08-23'),
(4, 'La Horde du Contrevent', 'Alain Damasio', '2004-03-18'),
(5, 'Harry Potter à l\'école des sorciers', 'J. K. Rowling', '1997-10-14'),
(6, 'Dune - Le Cycle de Dune, tome 1', 'Frank Herbert', '1965-06-09'),
(7, 'Fondation - Le Cycle de Fondation, tome 1', 'Isaac Asimov', '1951-02-11'),
(8, 'La Nuit des temps', 'René Barjavel', '1968-03-12'),
(9, 'Les Liaisons dangereuses', 'Choderlos de Laclos', '1782-10-07'),
(10, 'Cyrano de Bergerac', 'Edmond Rostand', '1897-10-23');

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

DROP TABLE IF EXISTS `materiel`;
CREATE TABLE IF NOT EXISTS `materiel` (
  `id_materiel` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `date_achat` date NOT NULL,
  PRIMARY KEY (`id_materiel`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id_materiel`, `nom`, `date_achat`) VALUES
(102, 'PC GAMER', '2020-09-02'),
(103, 'Bureau', '2020-09-02'),
(104, 'Vidéo projecteur', '2020-09-02'),
(105, 'Chaise de bureau', '2020-09-02');

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id_niveau` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  PRIMARY KEY (`id_niveau`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id_niveau`, `libelle`) VALUES
(1, 'CP'),
(2, 'CE1'),
(3, 'CE2'),
(4, 'CM1'),
(5, 'CM2');

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `id_eleve` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  `note` float NOT NULL,
  `date_eval` date NOT NULL,
  PRIMARY KEY (`id_eleve`,`id_cours`),
  KEY `note_Cours0_FK` (`id_cours`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id_personne` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `adresse` varchar(250) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `ville` varchar(100) NOT NULL,
  PRIMARY KEY (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `nom`, `prenom`, `adresse`, `code_postal`, `ville`) VALUES
(125, 'MARTin', 'David', '12 rue des CESI', 72000, 'Le Mans'),
(126, 'PICHON', 'Florian', '12 rue de Symfony', 72700, 'Allonnes'),
(127, 'AGHARBi', 'Ayman', '20 rue du coupe pyramide', 72000, 'Le Mans'),
(128, 'MEUNIER', 'marjorie', '25 rue des acacias ', 41000, 'Saint-Denis-Sur-Loire'),
(129, 'LAVARIE', 'stéphane', '12 rue du verseau', 72100, 'Le Mans'),
(130, 'COUSIN', 'Marvin', '13 rue du gamer', 72000, 'Le Mans');

-- --------------------------------------------------------

--
-- Structure de la table `presence`
--

DROP TABLE IF EXISTS `presence`;
CREATE TABLE IF NOT EXISTS `presence` (
  `id_personne` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  `date_presence` date NOT NULL,
  PRIMARY KEY (`id_personne`,`id_cours`),
  KEY `presence_Cours0_FK` (`id_cours`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `id_professeur` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(100) NOT NULL,
  `id_personne` int(11) NOT NULL,
  PRIMARY KEY (`id_professeur`),
  KEY `Professeur_Personne_FK` (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id_professeur`, `mail`, `id_personne`) VALUES
(206, 'david.martin@onsoft.fr', 125),
(207, 'florian.pichon@onsoft.fr', 126);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `Classe_Niveau_FK` FOREIGN KEY (`id_niveau`) REFERENCES `niveau` (`id_niveau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classe_eleve`
--
ALTER TABLE `classe_eleve`
  ADD CONSTRAINT `classe_eleve_Classe0_FK` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classe_eleve_Eleve_FK` FOREIGN KEY (`id_eleve`) REFERENCES `eleve` (`id_eleve`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classe_professeur`
--
ALTER TABLE `classe_professeur`
  ADD CONSTRAINT `classe_professeur_Classe0_FK` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classe_professeur_Professeur_FK` FOREIGN KEY (`id_professeur`) REFERENCES `professeur` (`id_professeur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `Cours_Classe_FK` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `Eleve_Personne_FK` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_Livre0_FK` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id_livre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `emprunt_Materiel1_FK` FOREIGN KEY (`id_materiel`) REFERENCES `materiel` (`id_materiel`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `emprunt_Professeur_FK` FOREIGN KEY (`id_professeur`) REFERENCES `professeur` (`id_professeur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_Cours0_FK` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id_cours`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `note_Eleve_FK` FOREIGN KEY (`id_eleve`) REFERENCES `eleve` (`id_eleve`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `presence`
--
ALTER TABLE `presence`
  ADD CONSTRAINT `presence_Cours0_FK` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id_cours`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `presence_Personne_FK` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD CONSTRAINT `Professeur_Personne_FK` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
