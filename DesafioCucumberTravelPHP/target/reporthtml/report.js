$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/feature/siteTravelPhp.feature");
formatter.feature({
  "name": "",
  "description": "Teste de Requisição e demonstração do site",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Logando na pagina Web",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "que preencha os valores no site",
  "keyword": "Dado "
});
formatter.match({
  "location": "TravelPhpSteps.que_preencha_os_valores_no_site()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat execucaoSteps.TravelPhpSteps.que_preencha_os_valores_no_site(TravelPhpSteps.java:13)\r\n\tat ✽.que preencha os valores no site(file:src/main/resources/feature/siteTravelPhp.feature:7)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "digitar \"First Name\", \"Last Name\", \"Business Name\", e \"Email\";",
  "keyword": "Quando "
});
formatter.match({
  "location": "TravelPhpSteps.digitar_e(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "somar para o campo de validação",
  "keyword": "E "
});
formatter.match({
  "location": "TravelPhpSteps.somar_para_o_campo_de_validação()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "executar o botão \"SUBMIT\";",
  "keyword": "Então "
});
formatter.match({
  "location": "TravelPhpSteps.executar_o_botão(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "validar a mensagem de sucesso para requisição",
  "keyword": "E "
});
formatter.match({
  "location": "TravelPhpSteps.validarAMensagemDeSucessoParaRequisição()"
});
formatter.result({
  "status": "skipped"
});
});