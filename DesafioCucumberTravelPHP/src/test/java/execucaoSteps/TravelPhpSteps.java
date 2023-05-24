package execucaoSteps;

import static excucaoWeb.ValidacaoWeb.botaoSubmit;
import static excucaoWeb.ValidacaoWeb.mensagemValidar;
import static excucaoWeb.ValidacaoWeb.validar;
import static execucaoDriver.Driver.ativarNavegador;
import static execucaoPage.PageUtils.digitar;

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

		digitar();
	}

	@Quando("somar para o campo de validação")
	public void somar_para_o_campo_de_validação() {
		validar();
	}

	@Entao("executar o botão {string};")
	public void executar_o_botão(String string) {
		botaoSubmit();
	}

	@Então("validar a mensagem de sucesso para requisição")
	public void validarAMensagemDeSucessoParaRequisição() {
		mensagemValidar();
	}

}
