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
  "name": "que acesse o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "TravelPhpSteps.queAcesseOSite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "extrair as informações do excel  first name, last name, business name, email",
  "keyword": "Quando "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});