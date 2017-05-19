CREATE DATABASE  IF NOT EXISTS `stucom_of_will` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `stucom_of_will`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: stucom_of_will
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.10-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `batalla`
--

DROP TABLE IF EXISTS `batalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batalla` (
  `idbatalla` int(11) NOT NULL AUTO_INCREMENT,
  `jugador1` varchar(45) NOT NULL,
  `jugador2` varchar(45) NOT NULL,
  `ganador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idbatalla`),
  UNIQUE KEY `idbatalla_UNIQUE` (`idbatalla`),
  KEY `fk_battle_1_idx` (`jugador1`),
  KEY `fk_battle_2_idx` (`jugador2`),
  KEY `fk_battle_3_idx` (`ganador`),
  CONSTRAINT `fk_battle_1` FOREIGN KEY (`jugador1`) REFERENCES `usuario` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_battle_2` FOREIGN KEY (`jugador2`) REFERENCES `usuario` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_battle_3` FOREIGN KEY (`ganador`) REFERENCES `usuario` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batalla`
--

LOCK TABLES `batalla` WRITE;
/*!40000 ALTER TABLE `batalla` DISABLE KEYS */;
INSERT INTO `batalla` VALUES (1,'123','321','123'),(2,'123','321','321');
/*!40000 ALTER TABLE `batalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartas`
--

DROP TABLE IF EXISTS `cartas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartas` (
  `idcartas` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `coste` int(11) DEFAULT '0',
  `tipo` varchar(45) NOT NULL,
  `efecto` varchar(45) DEFAULT NULL,
  `ataque` int(11) DEFAULT '0',
  `defensa` int(11) DEFAULT '0',
  `disponibilidad` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idcartas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartas`
--

LOCK TABLES `cartas` WRITE;
/*!40000 ALTER TABLE `cartas` DISABLE KEYS */;
INSERT INTO `cartas` VALUES (1,'carta1',12,'qwe','ataque+',10,10,1);
/*!40000 ALTER TABLE `cartas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruler`
--

DROP TABLE IF EXISTS `ruler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruler` (
  `idruler` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `efecto` text,
  PRIMARY KEY (`idruler`),
  UNIQUE KEY `idruler_UNIQUE` (`idruler`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruler`
--

LOCK TABLES `ruler` WRITE;
/*!40000 ALTER TABLE `ruler` DISABLE KEYS */;
INSERT INTO `ruler` VALUES (1,'ruler1','life+'),(2,'ruler2','attack+');
/*!40000 ALTER TABLE `ruler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `nombre` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `puntos` int(11) NOT NULL,
  `ruler` int(11) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `usurario_ruler_idx` (`ruler`),
  CONSTRAINT `usurario_ruler` FOREIGN KEY (`ruler`) REFERENCES `ruler` (`idruler`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('123','123',0,1),('321','321',1,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-19 14:21:51
