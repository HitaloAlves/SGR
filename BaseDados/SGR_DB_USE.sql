-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: SGR_DB
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES (1,'Leonardo','61995811647','leonardobezerra39@gmail.com','06947334561','M','a1l-swko'),(2,'Hitalo','61984822548','hitaloservolo123@gmail.com','05836223450','M','abcd-2017');
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Convidados`
--

DROP TABLE IF EXISTS `Convidados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Convidados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `obs` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Convidados`
--

LOCK TABLES `Convidados` WRITE;
/*!40000 ALTER TABLE `Convidados` DISABLE KEYS */;
/*!40000 ALTER TABLE `Convidados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EstiloMusicais`
--

DROP TABLE IF EXISTS `EstiloMusicais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EstiloMusicais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EstiloMusicais`
--

LOCK TABLES `EstiloMusicais` WRITE;
/*!40000 ALTER TABLE `EstiloMusicais` DISABLE KEYS */;
INSERT INTO `EstiloMusicais` VALUES (1,'Axé'),(2,'Black Music'),(3,'Clássico'),(4,'Country'),(5,'Dance'),(6,'Evangélica'),(7,'Forró'),(8,'Gospel'),(9,'Instrumental'),(10,'Latino'),(11,'MPB'),(12,'New Age'),(13,'Notícias'),(14,'Oldies'),(15,'Pagode'),(16,'Pop'),(17,'Pop-Rock'),(18,'Popular'),(19,'Rap'),(20,'Reggae'),(21,'Regional'),(22,'Religioso'),(23,'Rock'),(24,'Samba'),(25,'Sertanejo'),(26,'Funk');
/*!40000 ALTER TABLE `EstiloMusicais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ListasMusica`
--

DROP TABLE IF EXISTS `ListasMusica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ListasMusica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `Locutores_idLocutores` int(11) NOT NULL,
  `Radios_idRadios` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Locutores_idLocutores`,`Radios_idRadios`),
  KEY `fk_ListasMusica_Locutores1_idx` (`Locutores_idLocutores`),
  KEY `fk_ListasMusica_Radios1_idx` (`Radios_idRadios`),
  CONSTRAINT `fk_ListasMusica_Locutores1` FOREIGN KEY (`Locutores_idLocutores`) REFERENCES `Locutores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ListasMusica_Radios1` FOREIGN KEY (`Radios_idRadios`) REFERENCES `Radios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ListasMusica`
--

LOCK TABLES `ListasMusica` WRITE;
/*!40000 ALTER TABLE `ListasMusica` DISABLE KEYS */;
INSERT INTO `ListasMusica` VALUES (1,'Rock 2000',2,2),(2,'Play list 2017',2,2),(3,'Iron Maiden',2,2),(4,'Lililianne Play List',2,2);
/*!40000 ALTER TABLE `ListasMusica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ListasMusica_Musicas`
--

DROP TABLE IF EXISTS `ListasMusica_Musicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ListasMusica_Musicas` (
  `ListasMusica_id` int(11) NOT NULL,
  `Musicas_id` int(11) NOT NULL,
  PRIMARY KEY (`ListasMusica_id`,`Musicas_id`),
  KEY `fk_ListasMusica_has_Musicas_Musicas1_idx` (`Musicas_id`),
  KEY `fk_ListasMusica_has_Musicas_ListasMusica_idx` (`ListasMusica_id`),
  CONSTRAINT `fk_ListasMusica_has_Musicas_ListasMusica` FOREIGN KEY (`ListasMusica_id`) REFERENCES `ListasMusica` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ListasMusica_has_Musicas_Musicas1` FOREIGN KEY (`Musicas_id`) REFERENCES `Musicas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ListasMusica_Musicas`
--

LOCK TABLES `ListasMusica_Musicas` WRITE;
/*!40000 ALTER TABLE `ListasMusica_Musicas` DISABLE KEYS */;
INSERT INTO `ListasMusica_Musicas` VALUES (1,2),(2,2),(1,3),(2,3),(1,4),(3,5),(4,6);
/*!40000 ALTER TABLE `ListasMusica_Musicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Locutores`
--

DROP TABLE IF EXISTS `Locutores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Locutores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `dataNasc` date NOT NULL,
  `senha` varchar(45) NOT NULL,
  `Radio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Radio_id`),
  KEY `fk_Locutores_Radios1_idx` (`Radio_id`),
  CONSTRAINT `fk_Locutores_Radios1` FOREIGN KEY (`Radio_id`) REFERENCES `Radios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Locutores`
--

LOCK TABLES `Locutores` WRITE;
/*!40000 ALTER TABLE `Locutores` DISABLE KEYS */;
INSERT INTO `Locutores` VALUES (1,'Hitalo','61999202657','hitalo@gmail.com','72837738861','M','2017-10-01','a1l-swko',2),(2,'Leonardo Bezerra','61995822387','leonardobezerra39@gmail.com','06978346531','M','1997-07-31','a1l-swko',2);
/*!40000 ALTER TABLE `Locutores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Musicas`
--

DROP TABLE IF EXISTS `Musicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Musicas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `nomeCantor` varchar(45) DEFAULT NULL,
  `banda` varchar(45) DEFAULT NULL,
  `album` varchar(45) DEFAULT NULL,
  `EstiloMusicais_id` int(11) NOT NULL,
  `nomeFileMusica` varchar(100) DEFAULT NULL,
  `Locutores_id` int(11) NOT NULL,
  `Locutores_Radio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Locutores_id`,`Locutores_Radio_id`),
  KEY `fk_Musicas_EstiloMusicais1_idx` (`EstiloMusicais_id`),
  KEY `fk_Musicas_Locutores1_idx` (`Locutores_id`,`Locutores_Radio_id`),
  CONSTRAINT `fk_Musicas_EstiloMusicais1` FOREIGN KEY (`EstiloMusicais_id`) REFERENCES `EstiloMusicais` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Musicas_Locutores1` FOREIGN KEY (`Locutores_id`, `Locutores_Radio_id`) REFERENCES `Locutores` (`id`, `Radio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Musicas`
--

LOCK TABLES `Musicas` WRITE;
/*!40000 ALTER TABLE `Musicas` DISABLE KEYS */;
INSERT INTO `Musicas` VALUES (2,'Amo Só você','Mc Marcinho','Mc marcinho','Funk 2000',26,'MAmo So voce_Mc Marcinho.mp3',2,2),(3,'Amo você','Mc Marcinho','Mc Marcinho','Funk 2000',26,'MAmo_voce_Mc_Marcinho.mp3',2,2),(4,'Aces High ','Iron Maiden','Iron Maiden','Iron Maiden',23,'Aces_High__Iron_Maiden.mp3',2,2),(5,'Afraid to Shoot Strangers','Iron Maiden ','Iron Maiden ','Iron Maiden 2000',26,'Afraid_to_Shoot_Strangers_Iron_Maiden_.mp3',2,2),(6,'Someone Like You','Adele','Adele','Adele 2013',16,'Someone_Like_You_Adele.mp3',2,2);
/*!40000 ALTER TABLE `Musicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProgramasRadio`
--

DROP TABLE IF EXISTS `ProgramasRadio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProgramasRadio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `horario` time NOT NULL,
  `tempo` time NOT NULL,
  `tipo` int(11) NOT NULL,
  `Radio` int(11) NOT NULL,
  `TiposProgramasRadio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Radio`),
  KEY `fk_ProgramasRadio_Radios1_idx` (`Radio`),
  KEY `fk_ProgramasRadio_TiposProgramasRadio1_idx` (`TiposProgramasRadio_id`),
  CONSTRAINT `fk_ProgramasRadio_Radios1` FOREIGN KEY (`Radio`) REFERENCES `Radios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProgramasRadio_TiposProgramasRadio1` FOREIGN KEY (`TiposProgramasRadio_id`) REFERENCES `TiposProgramasRadio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProgramasRadio`
--

LOCK TABLES `ProgramasRadio` WRITE;
/*!40000 ALTER TABLE `ProgramasRadio` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProgramasRadio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProgramasRadio_Convidados`
--

DROP TABLE IF EXISTS `ProgramasRadio_Convidados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProgramasRadio_Convidados` (
  `ProgramasRadio_id` int(11) NOT NULL,
  `Radio_id` int(11) NOT NULL,
  `Convidados_id` int(11) NOT NULL,
  PRIMARY KEY (`ProgramasRadio_id`,`Radio_id`,`Convidados_id`),
  KEY `fk_ProgramasRadio_has_Convidados_Convidados1_idx` (`Convidados_id`),
  KEY `fk_ProgramasRadio_has_Convidados_ProgramasRadio1_idx` (`ProgramasRadio_id`,`Radio_id`),
  CONSTRAINT `fk_ProgramasRadio_has_Convidados_Convidados1` FOREIGN KEY (`Convidados_id`) REFERENCES `Convidados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProgramasRadio_has_Convidados_ProgramasRadio1` FOREIGN KEY (`ProgramasRadio_id`, `Radio_id`) REFERENCES `ProgramasRadio` (`id`, `Radio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProgramasRadio_Convidados`
--

LOCK TABLES `ProgramasRadio_Convidados` WRITE;
/*!40000 ALTER TABLE `ProgramasRadio_Convidados` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProgramasRadio_Convidados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Radios`
--

DROP TABLE IF EXISTS `Radios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Radios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `modulacao` varchar(15) DEFAULT NULL,
  `frequencia` double DEFAULT NULL,
  `site` varchar(30) NOT NULL,
  `cep` int(7) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `cnpj` varchar(14) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Radios`
--

LOCK TABLES `Radios` WRITE;
/*!40000 ALTER TABLE `Radios` DISABLE KEYS */;
INSERT INTO `Radios` VALUES (1,'Gi WebRadio','61983737663','leonardobezerra39@gmail.com','WEBRADIO',8870,'',72345900,'Ao lado Unieuro','87467482000134','a1l-swko'),(2,'Serra Grande FM','88998765352','serragrandefm@gmail.com','AM',99.7,'www.serragrandefm.com.br',62390000,'Posto de Gasolina','87367282000134','serra2017'),(3,'Unieuro FM','88998373832','unieurofm@gmail.com','FM',100.8,'www.unieurofm.com.br',72390000,'Posto de Gasolina','09838373000123','unieuro2017');
/*!40000 ALTER TABLE `Radios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RadiosBloqueados`
--

DROP TABLE IF EXISTS `RadiosBloqueados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RadiosBloqueados` (
  `Radio_id` int(11) NOT NULL,
  PRIMARY KEY (`Radio_id`),
  CONSTRAINT `fk_RadiosBloqueados_Radios1` FOREIGN KEY (`Radio_id`) REFERENCES `Radios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RadiosBloqueados`
--

LOCK TABLES `RadiosBloqueados` WRITE;
/*!40000 ALTER TABLE `RadiosBloqueados` DISABLE KEYS */;
/*!40000 ALTER TABLE `RadiosBloqueados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Responsaveis`
--

DROP TABLE IF EXISTS `Responsaveis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Responsaveis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cargos` varchar(20) NOT NULL,
  `data` date NOT NULL,
  `Radio_id` int(11) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`Radio_id`),
  KEY `fk_Responsaveis_Radios1_idx` (`Radio_id`),
  CONSTRAINT `fk_Responsaveis_Radios1` FOREIGN KEY (`Radio_id`) REFERENCES `Radios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Responsaveis`
--

LOCK TABLES `Responsaveis` WRITE;
/*!40000 ALTER TABLE `Responsaveis` DISABLE KEYS */;
/*!40000 ALTER TABLE `Responsaveis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TiposProgramasRadio`
--

DROP TABLE IF EXISTS `TiposProgramasRadio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TiposProgramasRadio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TiposProgramasRadio`
--

LOCK TABLES `TiposProgramasRadio` WRITE;
/*!40000 ALTER TABLE `TiposProgramasRadio` DISABLE KEYS */;
INSERT INTO `TiposProgramasRadio` VALUES (27,'Informativo'),(28,'Musical'),(29,'Munitário'),(30,'Educativo-cultural'),(31,'Místico-religioso'),(32,'Entrevista'),(33,'Manchetes'),(34,'Música - Esporte - Notícia'),(35,'Radiojornal'),(36,'Humorísticos'),(37,'Reportagem'),(38,'Mesa-redonda '),(39,'Radiorevista');
/*!40000 ALTER TABLE `TiposProgramasRadio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-07 20:38:02
