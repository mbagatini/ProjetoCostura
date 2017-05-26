select projeto.id, 
       projeto.nome, 
       projeto.datainiprev,
       cliente.codcli,
       cliente.nome,
       cliente.codcid
  from projeto, cliente
 where projeto.codcli = cliente.codcli

;

 select projeto.id, 
       projeto.nome, 
       projeto.datainiprev,
       cliente.codcli,
       cliente.nome,
       cliente.codcid,
       cidade.nome,
       cidade.uf
  from projeto, cliente, cidade
 where projeto.codcli = cliente.codcli
   and cidade.codcid  = cliente.codcid

;

select projeto.id, 
       projeto.nome, 
       projeto.datainiprev,
       cliente.codcli,
       cliente.nome,
       cliente.codcid,
       cidade.nome,
       cidade.uf
  from projeto, cliente, cidade
 where projeto.codcli      = cliente.codcli
   and cidade.codcid       = cliente.codcid
   and projeto.datafimprev > '01/10/2013'