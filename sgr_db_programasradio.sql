CREATE DATABASE  IF NOT EXISTS `sgr_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sgr_db`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: sgr_db
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.16-MariaDB

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
-- Table structure for table `programasradio`
--

DROP TABLE IF EXISTS `programasradio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programasradio` (
  `idProgramasRadio` int(11) NOT NULL,
  `nomeProgramasRadio` varchar(30) NOT NULL,
  `horarioProgramasRadio` time NOT NULL,
  `tempoProgramasRadio` time NOT NULL,
  `tipoProgramasRadio` int(11) NOT NULL,
  `Radios_idRadios` int(11) NOT NULL,
  PRIMARY KEY (`idProgramasRadio`,`Radios_idRadios`),
  KEY `fk_ProgramasRadio_Radios1_idx` (`Radios_idRadios`),
  CONSTRAINT `fk_ProgramasRadio_Radios1` FOREIGN KEY (`Radios_idRadios`) REFERENCES `radios` (`idRadios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programasradio`
--

LOCK TABLES `programasradio` WRITE;
/*!40000 ALTER TABLE `programasradio` DISABLE KEYS */;
/*!40000 ALTER TABLE `programasradio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-21 18:03:36
