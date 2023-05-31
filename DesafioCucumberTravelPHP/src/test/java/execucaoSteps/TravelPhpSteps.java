package execucaoSteps;

import static execucaoPagina.DriverPagina.ativarNavegador;

import java.io.IOException;

import execucaoPagina.FormularioPagina;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class TravelPhpSteps {

	private FormularioPagina execucao = new FormularioPagina();

	@Dado("que acesse o site")
	public void queAcesseOSite() {
		ativarNavegador();

	}

	@Quando("extrair as informações do excel  first name, last name, business name, email")
	public void extrairAsInformaçõesDoExcelFirstNameLastNameBusinessNameEmail() throws IOException {
		execucao.digitarDados();

	}

	@Quando("somar para o campo de validação")
	public void somar_para_o_campo_de_validação() {
		execucao.interacaoHumana();

	}

	@Entao("executar o botão {string};")
	public void executar_o_botão(String string) {
		execucao.botaoSubmit();

	}

	@Então("validar a mensagem de sucesso para requisição")
	public void validarAMensagemDeSucessoParaRequisição() throws InterruptedException {
		execucao.mensagemValidar();

	}

}
