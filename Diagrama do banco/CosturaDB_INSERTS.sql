-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Andres Sobieski', 'asobieski0@blogtalkradio.com', 'Goldenrod');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Ursala Leifer', 'uleifer1@bigcartel.com', 'Orange');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Seana Borland', 'sborland2@sphinn.com', 'Orange');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Reeta Edworthye', 'redworthye3@google.es', 'Maroon');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Dalton Lewry', 'dlewry4@vkontakte.ru', 'Red');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Hunt Loder', 'hloder5@goo.gl', 'Pink');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Chelsea Nayer', 'cnayer6@scientificamerican.com', 'Maroon');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Vernon Grimsdyke', 'vgrimsdyke7@addthis.com', 'Yellow');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Marsha Conybear', 'mconybear8@bloglines.com', 'Mauv');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Cletus Gaythwaite', 'cgaythwaite9@tuttocitta.it', 'Maroon');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Darb Czapla', 'dczaplaa@telegraph.co.uk', 'Green');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Fabian Scoggans', 'fscoggansb@cbc.ca', 'Yellow');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Siegfried Heiton', 'sheitonc@quantcast.com', 'Pink');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Marlow Comello', 'mcomellod@soup.io', 'Indigo');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Hilton Pegler', 'hpeglere@theguardian.com', 'Fuscia');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Stafani Blincowe', 'sblincowef@nps.gov', 'Blue');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Karia Barnard', 'kbarnardg@over-blog.com', 'Blue');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Elle Sandeford', 'esandefordh@goodreads.com', 'Indigo');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Cornelia Dailly', 'cdaillyi@nasa.gov', 'Purple');
insert into usuario (codigo, nome, email, senha) values (DEFAULT, 'Andi Pee', 'apeej@si.edu', 'Goldenrod');

-- -----------------------------------------------------
-- Table categoria
-- -----------------------------------------------------
insert into categoria (codigo, descricao) values (DEFAULT, 'Camisetas');
insert into categoria (codigo, descricao) values (DEFAULT, 'Camisas');
insert into categoria (codigo, descricao) values (DEFAULT, 'Casacos e Jaquetas');
insert into categoria (codigo, descricao) values (DEFAULT, 'Malha e Suéter');
insert into categoria (codigo, descricao) values (DEFAULT, 'Moletom');
insert into categoria (codigo, descricao) values (DEFAULT, 'Vestido');
insert into categoria (codigo, descricao) values (DEFAULT, 'Calça Social');
insert into categoria (codigo, descricao) values (DEFAULT, 'Calça Jeans');
insert into categoria (codigo, descricao) values (DEFAULT, 'Calça Esportiva');
insert into categoria (codigo, descricao) values (DEFAULT, 'Camiseta Esportiva');
insert into categoria (codigo, descricao) values (DEFAULT, 'Camisa Esportiva');

-- -----------------------------------------------------
-- Table tamanho
-- -----------------------------------------------------
insert into tamanho (codigo, tamanho) values (DEFAULT, 'PP');
insert into tamanho (codigo, tamanho) values (DEFAULT, 'P');
insert into tamanho (codigo, tamanho) values (DEFAULT, 'M');
insert into tamanho (codigo, tamanho) values (DEFAULT, 'G');
insert into tamanho (codigo, tamanho) values (DEFAULT, 'GG');
insert into tamanho (codigo, tamanho) values (DEFAULT, '36');
insert into tamanho (codigo, tamanho) values (DEFAULT, '38');
insert into tamanho (codigo, tamanho) values (DEFAULT, '40');
insert into tamanho (codigo, tamanho) values (DEFAULT, '42');
insert into tamanho (codigo, tamanho) values (DEFAULT, '44');
insert into tamanho (codigo, tamanho) values (DEFAULT, '46');
insert into tamanho (codigo, tamanho) values (DEFAULT, '48');
insert into tamanho (codigo, tamanho) values (DEFAULT, '50');

-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
insert into produto (codigo, referencia, descricao, preco, genero, codigo_categoria) values (DEFAULT, 10, 'Produto teste', '35.50', 'Unisex', 3);