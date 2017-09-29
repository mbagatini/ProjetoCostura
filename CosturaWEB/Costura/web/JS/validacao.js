/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar(){
   // so permitira o envio se os dados forem fornecidos
   if(document.login.emailUsuario.value === ""){
     alert("Informe o nome do usuário");
     document.login.emailUsuario.focus();
     return false;
   }
   else if(document.login.senha.value === ""){
     alert("Informe a senha do usuário");
     document.login.senha.focus();
     return false;
   }
   else
     return true; 
}
