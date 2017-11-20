-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: sgr_db
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

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
-- Table structure for table `programasradio_convidados`
--

DROP TABLE IF EXISTS `programasradio_convidados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programasradio_convidados` (
  `ProgramasRadio_id` int(11) NOT NULL,
  `Radio_id` int(11) NOT NULL,
  `Convidados_id` int(11) NOT NULL,
  PRIMARY KEY (`ProgramasRadio_id`,`Radio_id`,`Convidados_id`),
  KEY `Convidados_id` (`Convidados_id`),
  CONSTRAINT `programasradio_convidados_ibfk_1` FOREIGN KEY (`Convidados_id`) REFERENCES `convidados` (`id`),
  CONSTRAINT `programasradio_convidados_ibfk_2` FOREIGN KEY (`ProgramasRadio_id`, `Radio_id`) REFERENCES `programasradio` (`id`, `Radio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programasradio_convidados`
--

LOCK TABLES `programasradio_convidados` WRITE;
/*!40000 ALTER TABLE `programasradio_convidados` DISABLE KEYS */;
INSERT INTO `programasradio_convidados` VALUES (1,1,1),(1,1,2),(2,2,1),(2,2,3),(3,3,2),(3,3,3);
/*!40000 ALTER TABLE `programasradio_convidados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-20  0:38:17
