package execucaoSteps;

import static execucaoDriver.Driver.ativarNavegador;
import static execucaoUtils.ExcelUtils.dadosDoSite;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class TravelPhpSteps {

	@Dado("que acesse o site")
	public void queAcesseOSite() {
		ativarNavegador();

	}

	@Quando("extrair as informações do excel  first name, last name, business name, email")
	public void extrairAsInformaçõesDoExcelFirstNameLastNameBusinessNameEmail() {

		dadosDoSite();
	}

	@Quando("somar para o campo de validação")
	public void somar_para_o_campo_de_validação() {

	}

	@Entao("executar o botão {string};")
	public void executar_o_botão(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Então("validar a mensagem de sucesso para requisição")
	public void validarAMensagemDeSucessoParaRequisição() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

}
