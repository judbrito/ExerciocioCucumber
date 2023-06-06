package test.business.formulario;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FormularioSteps {
	private FormularioLogic execucao = new FormularioLogic();

	@Dado("que acesse o site")
	public void queAcesseOSite() {
		execucao.navegar();
	}

	@Quando("extrair as informações do excel  first name, last name, business name, email")
	public void extrairAsInformaçõesDoExcelFirstNameLastNameBusinessNameEmail() {
		execucao.preencherTxt();

	}

	@Quando("somar para o campo de validação")
	public void somarParaOCampoDeValidação() {
		execucao.calcularsoma();

	}

	@Então("executar o botão {string};")
	public void executarOBotão(String string) {
		execucao.botaoSubmit();

	}

	@Então("validar a mensagem de sucesso para requisição")
	public void validarAMensagemDeSucessoParaRequisição() {
		execucao.mensagemValidar();

	}

}
