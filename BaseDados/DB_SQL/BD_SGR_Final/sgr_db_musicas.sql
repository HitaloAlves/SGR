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
-- Table structure for table `musicas`
--

DROP TABLE IF EXISTS `musicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musicas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `nomeCantor` varchar(15) NOT NULL,
  `banda` varchar(15) NOT NULL,
  `album` varchar(15) NOT NULL,
  `EstiloMusicais_id` int(11) NOT NULL,
  `nomeFileMusica` varchar(60) NOT NULL,
  `Locutores_id` int(11) NOT NULL,
  `Locutores_Radio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `EstiloMusicais_id` (`EstiloMusicais_id`),
  KEY `Locutores_id` (`Locutores_id`,`Locutores_Radio_id`),
  KEY `ind_Musicas` (`id`),
  CONSTRAINT `musicas_ibfk_1` FOREIGN KEY (`EstiloMusicais_id`) REFERENCES `estilomusicais` (`id`),
  CONSTRAINT `musicas_ibfk_2` FOREIGN KEY (`Locutores_id`, `Locutores_Radio_id`) REFERENCES `locutores` (`id`, `Radio_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicas`
--

LOCK TABLES `musicas` WRITE;
/*!40000 ALTER TABLE `musicas` DISABLE KEYS */;
INSERT INTO `musicas` VALUES (1,'lua de mel','Roger','Hubs','paradise',5,'https://www.youtube.com/watch?v=0pwqiyuahG0&list=RDMM',1,1),(2,'Eu sem você','Katarina','Skank','number',2,'https://www.youtube.com/watch?v=QYyHZNBUO4k',2,2),(3,'Chora meu bem','Rebeca','Hit','mouse',11,'https://www.youtube.com/watch?v=KpGGmqZP5z4',3,3);
/*!40000 ALTER TABLE `musicas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-20  0:38:45
