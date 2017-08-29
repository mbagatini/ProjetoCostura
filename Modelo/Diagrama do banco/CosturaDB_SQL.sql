-- MySQL Script generated by MySQL Workbench
-- 08/27/17 18:15:47
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Table estado
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estado (
  codigo INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  sigla VARCHAR(45) NOT NULL,
  PRIMARY KEY (codigo))
;


-- -----------------------------------------------------
-- Table cidade
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cidade (
  codigo INT NOT NULL,
  nome VARCHAR(30) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  estado INT NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_cidades_estado1
    FOREIGN KEY (estado)
    REFERENCES estado (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX fk_cidades_estado1_idx ON cidade (estado ASC);


-- -----------------------------------------------------
-- Table endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS endereco (
  codigo INT NOT NULL,
  logradouro VARCHAR(200) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  cidade_codigo INT NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_endereco_cidade1
    FOREIGN KEY (cidade_codigo)
    REFERENCES cidade (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX fk_endereco_cidade1_idx ON endereco (cidade_codigo ASC);


-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
CREATE SEQUENCE usuario_codigo_seq;
CREATE TABLE IF NOT EXISTS usuario (
  codigo INT NOT NULL DEFAULT nextval('usuario_codigo_seq'),
  nome VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  senha VARCHAR(20) NOT NULL,
  PRIMARY KEY (codigo))
;
ALTER SEQUENCE usuario_codigo_seq OWNED BY usuario.codigo;

CREATE UNIQUE INDEX usu_email_UNIQUE ON usuario (email ASC);