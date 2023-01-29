drop database if exists tv;
create database if not exists tv;
use tv;

CREATE TABLE CANAL (
	codCanal int auto_increment not null,
    emissora varchar(50),
    número int,
    tipo varchar(20),
    PRIMARY KEY(codCanal));
    
CREATE TABLE FILME (
	codFilme int auto_increment not null,
    avaliação int,
    bilheteria varchar(14),
    canal varchar(14),
    classificação varchar(14),
    dataPrograma varchar(10),
    descrição varchar(200),
    horário varchar(14),
    tipo varchar(14),
    título varchar(50),
    PRIMARY KEY(codFilme));
    
CREATE TABLE SERIADO (
	codSeriado int auto_increment not null,
    canal varchar(14),
    classificação varchar(14),
    dataPrograma varchar(10),
    descrição varchar(200),
    horário varchar(14),
    qtdEpisódios int,
    qtdTemporadas int,
    tipo varchar(14),
    título varchar(50),
    PRIMARY KEY(codSeriado));
    
CREATE TABLE TELEJORNAL (
	codTelejornal int auto_increment not null,
    apresentadores varchar(80),
    canal varchar(14),
    classificação varchar(14),
    dataPrograma varchar(10),
    descrição varchar(200),
    gênero varchar(20),
    horário varchar(14),
    tipo varchar(14),
    título varchar(50),
    PRIMARY KEY(codTelejornal));
    
    