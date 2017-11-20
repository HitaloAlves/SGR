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
-- Temporary view structure for view `cw_radioselocutores`
--

DROP TABLE IF EXISTS `cw_radioselocutores`;
/*!50001 DROP VIEW IF EXISTS `cw_radioselocutores`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cw_radioselocutores` AS SELECT 
 1 AS `nome`,
 1 AS `telefone`,
 1 AS `email`,
 1 AS `site`,
 1 AS `lnome`,
 1 AS `ltelefone`,
 1 AS `lemail`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cw_listasmusicadlocutor`
--

DROP TABLE IF EXISTS `cw_listasmusicadlocutor`;
/*!50001 DROP VIEW IF EXISTS `cw_listasmusicadlocutor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cw_listasmusicadlocutor` AS SELECT 
 1 AS `nome`,
 1 AS `id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cw_convidadosdprogramasradio`
--

DROP TABLE IF EXISTS `cw_convidadosdprogramasradio`;
/*!50001 DROP VIEW IF EXISTS `cw_convidadosdprogramasradio`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cw_convidadosdprogramasradio` AS SELECT 
 1 AS `nome`,
 1 AS `telefone`,
 1 AS `email`,
 1 AS `sexo`,
 1 AS `obs`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cw_logmodificacaotiposprogramasradio`
--

DROP TABLE IF EXISTS `cw_logmodificacaotiposprogramasradio`;
/*!50001 DROP VIEW IF EXISTS `cw_logmodificacaotiposprogramasradio`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cw_logmodificacaotiposprogramasradio` AS SELECT 
 1 AS `comando`,
 1 AS `usuario`,
 1 AS `data`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cw_responsaveisdradio`
--

DROP TABLE IF EXISTS `cw_responsaveisdradio`;
/*!50001 DROP VIEW IF EXISTS `cw_responsaveisdradio`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cw_responsaveisdradio` AS SELECT 
 1 AS `nome`,
 1 AS `telefone`,
 1 AS `email`,
 1 AS `cargos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cw_logmodificacaoestilomusicais`
--

DROP TABLE IF EXISTS `cw_logmodificacaoestilomusicais`;
/*!50001 DROP VIEW IF EXISTS `cw_logmodificacaoestilomusicais`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cw_logmodificacaoestilomusicais` AS SELECT 
 1 AS `comando`,
 1 AS `usuario`,
 1 AS `data`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `cw_radioselocutores`
--

/*!50001 DROP VIEW IF EXISTS `cw_radioselocutores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cw_radioselocutores` AS select `r`.`nome` AS `nome`,`r`.`telefone` AS `telefone`,`r`.`email` AS `email`,`r`.`site` AS `site`,`l`.`nome` AS `lnome`,`l`.`telefone` AS `ltelefone`,`l`.`email` AS `lemail` from (`radios` `r` join `locutores` `l` on((`r`.`id` = `l`.`Radio_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cw_listasmusicadlocutor`
--

/*!50001 DROP VIEW IF EXISTS `cw_listasmusicadlocutor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cw_listasmusicadlocutor` AS select `li`.`nome` AS `nome`,`li`.`id` AS `id` from (`listasmusica` `li` join `locutores` `lo`) where (`lo`.`id` = `li`.`Locutores_idLocutores`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cw_convidadosdprogramasradio`
--

/*!50001 DROP VIEW IF EXISTS `cw_convidadosdprogramasradio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cw_convidadosdprogramasradio` AS select `co`.`nome` AS `nome`,`co`.`telefone` AS `telefone`,`co`.`email` AS `email`,`co`.`sexo` AS `sexo`,`co`.`obs` AS `obs` from (`convidados` `co` join `programasradio` `tp`) where (`co`.`id` = `tp`.`TiposProgramasRadio_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cw_logmodificacaotiposprogramasradio`
--

/*!50001 DROP VIEW IF EXISTS `cw_logmodificacaotiposprogramasradio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cw_logmodificacaotiposprogramasradio` AS select `lr`.`comando` AS `comando`,`lr`.`usuario` AS `usuario`,`lr`.`data` AS `data` from `adminlog` `lr` where (`lr`.`tabela` = 'TiposProgramasRadio') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cw_responsaveisdradio`
--

/*!50001 DROP VIEW IF EXISTS `cw_responsaveisdradio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cw_responsaveisdradio` AS select `re`.`nome` AS `nome`,`re`.`telefone` AS `telefone`,`re`.`email` AS `email`,`re`.`cargos` AS `cargos` from (`responsaveis` `re` join `radios` `ra`) where (`ra`.`id` = `re`.`Radio_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cw_logmodificacaoestilomusicais`
--

/*!50001 DROP VIEW IF EXISTS `cw_logmodificacaoestilomusicais`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cw_logmodificacaoestilomusicais` AS select `lr`.`comando` AS `comando`,`lr`.`usuario` AS `usuario`,`lr`.`data` AS `data` from `adminlog` `lr` where (`lr`.`tabela` = 'EstiloMusicais') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-20  0:38:48
