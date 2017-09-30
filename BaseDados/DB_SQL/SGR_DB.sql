CREATE SCHEMA IF NOT EXISTS SGR_DB DEFAULT CHARACTER SET utf8;
use SGR_DB;


-- -----------------------------------------------------
-- Convidados
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Convidados (
  id INT NOT NULL AUTO_INCREMENT,
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
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  modulacao DOUBLE NOT NULL,
  frequencia VARCHAR(5) NOT NULL,
  site VARCHAR(30) NOT NULL,
  cep INT(7) NOT NULL,
  complem VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Locutores
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Locutores (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  dataNasc DATE NOT NULL,
  senha VARCHAR(45) NOT NULL,
  Radio_id INT NOT NULL,
  PRIMARY KEY (id, Radio_id),
    FOREIGN KEY (Radio_id)
    REFERENCES SGR_DB.Radios (id));


-- -----------------------------------------------------
-- Responsaveis
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Responsaveis (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(30) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  cargos VARCHAR(20) NOT NULL,
  data DATE NOT NULL,
  Radio_id INT NOT NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (id, Radio_id),
    FOREIGN KEY (Radio_id)
    REFERENCES SGR_DB.Radios (id));


-- -----------------------------------------------------
-- TiposProgramasRadio
-- -----------------------------------------------------
CREATE TABLE SGR_DB.TiposProgramasRadio (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- ProgramasRadio
-- -----------------------------------------------------
CREATE TABLE SGR_DB.ProgramasRadio (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  horario TIME NOT NULL,
  tempo TIME NOT NULL,
  tipo INT NOT NULL,
  Radio INT NOT NULL,
  TiposProgramasRadio_id INT NOT NULL,
  PRIMARY KEY (id, Radio),
    FOREIGN KEY (Radio)
    REFERENCES SGR_DB.Radios (id),
    FOREIGN KEY (TiposProgramasRadio_id)
    REFERENCES SGR_DB.TiposProgramasRadio (id));


-- -----------------------------------------------------
-- ListasMusica
-- -----------------------------------------------------
CREATE TABLE SGR_DB.ListasMusica (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NOT NULL,
  Locutores_idLocutores INT NOT NULL,
  Radios_idRadios INT NOT NULL,
  PRIMARY KEY (id, Locutores_idLocutores, Radios_idRadios),
    FOREIGN KEY (Locutores_idLocutores)
    REFERENCES SGR_DB.Locutores (id),
    FOREIGN KEY (Radios_idRadios)
    REFERENCES SGR_DB.Radios (id));


-- -----------------------------------------------------
-- EstiloMusicais
-- -----------------------------------------------------
CREATE TABLE SGR_DB.EstiloMusicais (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Musicas
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Musicas (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(20) NOT NULL,
  nomeCantor VARCHAR(15) NOT NULL,
  banda VARCHAR(15) NOT NULL,
  album VARCHAR(15) NOT NULL,
  EstiloMusicais_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (EstiloMusicais_id)
    REFERENCES SGR_DB.EstiloMusicais (id));

-- -----------------------------------------------------
-- ListasMusica_Musicas
-- -----------------------------------------------------
CREATE TABLE SGR_DB.ListasMusica_Musicas (
  ListasMusica_id INT NOT NULL,
  Musicas_id INT NOT NULL,
  PRIMARY KEY (ListasMusica_id, Musicas_id),
    FOREIGN KEY (ListasMusica_id)
    REFERENCES SGR_DB.ListasMusica (id),
    FOREIGN KEY (Musicas_id)
    REFERENCES SGR_DB.Musicas (id));


-- -----------------------------------------------------
-- ProgramasRadio_Convidados
-- -----------------------------------------------------
CREATE TABLE SGR_DB.ProgramasRadio_Convidados (
  ProgramasRadio_id INT NOT NULL,
  Radio_id INT NOT NULL,
  Convidados_id INT NOT NULL,
  PRIMARY KEY (ProgramasRadio_id, Radio_id, Convidados_id),
    FOREIGN KEY (ProgramasRadio_id , Radio_id)
    REFERENCES SGR_DB.ProgramasRadio (id , Radio),
    FOREIGN KEY (Convidados_id)
    REFERENCES SGR_DB.Convidados (id));


-- -----------------------------------------------------
-- Admin
-- -----------------------------------------------------
CREATE TABLE SGR_DB.Admin (
  id INT NOT NULL AUTO_INCREMENT,
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
