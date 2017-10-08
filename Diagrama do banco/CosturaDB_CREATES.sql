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


-- -----------------------------------------------------
-- Table estado
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estado (
  codigo INT NOT NULL,
  sigla VARCHAR(2) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY (codigo))
;


-- -----------------------------------------------------
-- Table cidade
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cidade (
  codigo INT NOT NULL,
  nome VARCHAR(30) NOT NULL,
  codigo_estado INT NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_cidades_estado1
    FOREIGN KEY (codigo_estado)
    REFERENCES estado (codigo))
;

CREATE INDEX fk_cidades_estado1_idx ON cidade (codigo_estado ASC);


-- -----------------------------------------------------
-- Table endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS endereco (
  codigo INT NOT NULL,
  logradouro VARCHAR(200) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  codigo_cidade INT NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_endereco_cidade1
    FOREIGN KEY (codigo_cidade)
    REFERENCES cidade (codigo))
;

CREATE INDEX fk_endereco_cidade1_idx ON endereco (codigo_cidade ASC);


-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE SEQUENCE cliente_codigo_seq;
CREATE TABLE IF NOT EXISTS cliente (
  codigo INT NOT NULL DEFAULT nextval('cliente_codigo_seq'),
  nome VARCHAR(200) NOT NULL,
  cnpj VARCHAR(18) NULL,
  cpf VARCHAR(14) NULL,
  codigo_endereco INT NOT NULL,
  telefone VARCHAR(45) NULL,
  celular VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  data_cadastro DATE NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_pessoa_endereco1
    FOREIGN KEY (codigo_endereco)
    REFERENCES endereco (codigo));

CREATE INDEX fk_pessoa_endereco1_idx ON cliente (codigo_endereco ASC);

ALTER SEQUENCE cliente_codigo_seq OWNED BY cliente.codigo;


-- -----------------------------------------------------
-- Table categoria
-- -----------------------------------------------------
CREATE SEQUENCE categoria_codigo_seq;
CREATE TABLE IF NOT EXISTS categoria (
  codigo INT NOT NULL DEFAULT nextval('categoria_codigo_seq'),
  descricao VARCHAR(40) NOT NULL,
  PRIMARY KEY (codigo))
;
ALTER SEQUENCE categoria_codigo_seq OWNED BY categoria.codigo;


-- -----------------------------------------------------
-- Table tamanho
-- -----------------------------------------------------
CREATE SEQUENCE tamanho_codigo_seq;
CREATE TABLE IF NOT EXISTS tamanho (
  codigo INT NOT NULL DEFAULT nextval('tamanho_codigo_seq'),
  tamanho VARCHAR(5) NOT NULL,
  PRIMARY KEY (codigo))
;
ALTER SEQUENCE tamanho_codigo_seq OWNED BY tamanho.codigo;


-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
CREATE SEQUENCE produto_codigo_seq;
CREATE TABLE IF NOT EXISTS produto (
  codigo INT NOT NULL DEFAULT nextval('produto_codigo_seq'),
  referencia SMALLINT NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  preco DECIMAL(11,2) NOT NULL,
  genero VARCHAR(50) NOT NULL,
  codigo_categoria INT NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_produto_categoria1
    FOREIGN KEY (codigo_categoria)
    REFERENCES categoria (codigo))
;

CREATE INDEX fk_produto_categoria1_idx ON produto (codigo_categoria ASC);

ALTER SEQUENCE produto_codigo_seq OWNED BY produto.codigo;