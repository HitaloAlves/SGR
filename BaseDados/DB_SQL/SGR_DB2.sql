CREATE SCHEMA IF NOT EXISTS SGR_DB DEFAULT CHARACTER SET utf8;
use SGR_DB;


-- -----------------------------------------------------
-- Convidados
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Convidados (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  obs VARCHAR(100) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Radios
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Radios (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  modulacao VARCHAR(15) NOT NULL,
  frequencia DOUBLE NOT NULL,
  site VARCHAR(30) NOT NULL,
  cep INT(7) NOT NULL,
  complem VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
  
  
-- -----------------------------------------------------
-- Radios Bloqueadas
-- -----------------------------------------------------
CREATE TABLE SGR_DB.RadiosBloqueados (
  Radio_id INT(11) NOT NULL,
  PRIMARY KEY (Radio_id),
    FOREIGN KEY (Radio_id)
    REFERENCES SGR_DB.Radios (id));
    
    
-- -----------------------------------------------------
-- Locutores
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Locutores (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  Radio_id INT(11) NOT NULL,
  PRIMARY KEY (id, Radio_id),
    FOREIGN KEY (Radio_id)
    REFERENCES SGR_DB.Radios (id));


-- -----------------------------------------------------
-- Responsaveis
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Responsaveis (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  cargos VARCHAR(20) NOT NULL,
  Radio_id INT(11) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (id, Radio_id),
    FOREIGN KEY (Radio_id)
    REFERENCES SGR_DB.Radios (id));


-- -----------------------------------------------------
-- TiposProgramasRadio
-- -----------------------------------------------------
CREATE TABLE SGR_DB.TiposProgramasRadio (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- ProgramasRadio
-- -----------------------------------------------------
CREATE TABLE SGR_DB.ProgramasRadio (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  horario TIME NOT NULL,
  tempo TIME NOT NULL,
  tipo INT(11) NOT NULL,
  Radio INT(11) NOT NULL,
  TiposProgramasRadio_id INT(11) NOT NULL,
  PRIMARY KEY (id, Radio),
    FOREIGN KEY (Radio)
    REFERENCES SGR_DB.Radios (id),
    FOREIGN KEY (TiposProgramasRadio_id)
    REFERENCES SGR_DB.TiposProgramasRadio (id));


-- -----------------------------------------------------
-- ListasMusica
-- -----------------------------------------------------
CREATE TABLE SGR_DB.ListasMusica (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NOT NULL,
  Locutores_idLocutores INT(11) NOT NULL,
  Radios_idRadios INT(11) NOT NULL,
  PRIMARY KEY (id, Locutores_idLocutores, Radios_idRadios),
    FOREIGN KEY (Locutores_idLocutores)
    REFERENCES SGR_DB.Locutores (id),
    FOREIGN KEY (Radios_idRadios)
    REFERENCES SGR_DB.Radios (id));


-- -----------------------------------------------------
-- EstiloMusicais
-- -----------------------------------------------------
CREATE TABLE SGR_DB.EstiloMusicais (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Musicas
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Musicas (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NOT NULL,
  nomeCantor VARCHAR(15) NOT NULL,
  banda VARCHAR(15) NOT NULL,
  album VARCHAR(15) NOT NULL,
  caminho VARCHAR(40) NOT NULL,
  ListasMusica_idListasMusica INT(11) NOT NULL,
  EstiloMusicais_id INT(11) NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY(ListasMusica_idListasMusica)
    REFERENCES SGR_DB.ListasMusica(id),
    FOREIGN KEY (EstiloMusicais_id)
    REFERENCES SGR_DB.EstiloMusicais (id));



-- -----------------------------------------------------
-- ListasMusica_Musicas
-- -----------------------------------------------------
CREATE TABLE SGR_DB.ListasMusica_Musicas (
  ListasMusica_id INT(11) NOT NULL,
  Musicas_id INT(11) NOT NULL,
  PRIMARY KEY (ListasMusica_id, Musicas_id),
    FOREIGN KEY (ListasMusica_id)
    REFERENCES SGR_DB.ListasMusica (id),
    FOREIGN KEY (Musicas_id)
    REFERENCES SGR_DB.Musicas (id));

-- -----------------------------------------------------
-- ProgramasRadio_Convidados
-- -----------------------------------------------------
 Create TABLE SGR_DB.ProgramasRadio_Convidados (
  ProgramasRadio_id INT(11) NOT NULL,
  Radio_id INT(11) NOT NULL,
  Convidados_id INT(11) NOT NULL,
  PRIMARY KEY (ProgramasRadio_id, Radio_id, Convidados_id),
    FOREIGN KEY (ProgramasRadio_id , Radio_id)
    REFERENCES SGR_DB.ProgramasRadio (id , Radio),
    FOREIGN KEY (Convidados_id)
    REFERENCES SGR_DB.Convidados (id));

-- -----------------------------------------------------
-- Admin
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Admin (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  sexo VARCHAR(1) NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

-- ---------------------------------------------------------
-- Consultas, Gatilhos, Inserção... 
-- ---------------------------------------------------------  

INSERT INTO `Admin` VALUES (1,'Leonardo','61995811647','leonardobezerra39@gmail.com','06947334561','M','a1l-swko'),(2,'Hitalo','61984822548','hitaloservolo123@gmail.com','05836223450','M','abcd-2017');

INSERT INTO `EstiloMusicais` VALUES (1,'Axé'),(2,'Black Music'),(3,'Clássico'),(4,'Country'),(5,'Dance'),(6,'Evangélica'),(7,'Forró'),(8,'Gospel'),(9,'Instrumental'),(10,'Latino'),(11,'MPB'),(12,'New Age'),(13,'Notícias'),(14,'Oldies'),(15,'Pagode'),(16,'Pop'),(17,'Pop-Rock'),(18,'Popular'),(19,'Rap'),(20,'Reggae'),(21,'Regional'),(22,'Religioso'),(23,'Rock'),(24,'Samba'),(25,'Sertanejo'),(26,'Funk');

INSERT INTO `Radios` VALUES (1,'Serra Grande 2018','88998765352','serragrandefm@gmail.com','WEBRADIO',997,'www.serragrandefm.com.br',62390000,'Posto de Gasolina','87367282000134','serra2017'),(2,'Serra Grande FM','88998765352','serragrandefm@gmail.com','AM',99.7,'www.serragrandefm.com.br',62390000,'Posto de Gasolina','87367282000134','serra2017'),(3,'Serra Grande FM','88998373832','serragrandefm@gmail.com','FM',88.7,'www.serragrandefm.com.br',62390000,'Posto de Gasolina','09838373000123','serrgrande2017');

INSERT INTO `RadiosBloqueados` VALUES (1);

INSERT INTO `TiposProgramasRadio` VALUES (27,'Informativo'),(28,'Musical'),(29,'Munitário'),(30,'Educativo-cultural'),(31,'Místico-religioso'),(32,'Entrevista'),(33,'Manchetes'),(34,'Música - Esporte - Notícia'),(35,'Radiojornal'),(36,'Humorísticos'),(37,'Reportagem'),(38,'Mesa-redonda '),(39,'Radiorevista');

create view listasMusicaDLocutor (nome,id) 
AS select li.nome, li.id 
from ListasMusica as li, Locutores as lo 
where lo.id = li.Locutores_idLocutores;

create view responsaveisDRadio (nome, telefone, email,cargos) 
AS select re.nome, re.telefone, re.email, re.cargos 
from Responsaveis as re, Radios as ra 
where ra.id = re.Radio_id;

create view convidadosDProgramasRadio (nome, telefone, email, sexo, obs)
AS select co.nome, co.telefone, co.email, co.sexo, co.obs 
from Convidados as co, ProgramasRadio as tp 
where co.id = tp.TiposProgramasRadio_id;

DELIMITER //
create procedure quantidadeDMusicas (ListasMusica_id int, nome varchar(20) ) 
BEGIN 
select lmm.ListasMusica_id, lm.nome, count(*) 
from ListasMusica_Musicas as lmm join ListasMusica as lm ON lmm.ListasMusica_id = lm.id -- Dá o id, nome e quantidade de musicas de cada lista.
GROUP BY lmm.ListasMusica_id HAVING count(*)=0; 
END; 
// 

DELIMITER // 
create trigger TR_adicionarIdLista 
after insert on ListasMusica for each row 
BEGIN 
insert into ListasMusica_Musicas (ListasMusica_id) values (ListasMusica (id)); -- insere o id da lista da musica na tabela N:N toda vez que é criada uma lista
END;
//