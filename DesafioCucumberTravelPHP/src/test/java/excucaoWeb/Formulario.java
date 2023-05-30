package excucaoWeb;

import static excucaoWeb.DriverWeb.ativarNavegador;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import execucaoPage.PageUtils;
import execucaoUtils.ExcelUtils;

public class Formulario {

	private PageUtils pageUtils;

	public Formulario() {
		pageUtils = new PageUtils();

	}

	public void digitarDados() {
		ExcelUtils excelUtils = new ExcelUtils("./src/main/resources/MassaDadosExcel/Login.xlsx", "massaDados");

		int rowCount = excelUtils.getRowCount();

		for (int i = 1; i < rowCount; i++) {
			String usuarioNome = excelUtils.getCellData(i, 0);
			String usuarioSobrenome = excelUtils.getCellData(i, 1);
			String businessName = excelUtils.getCellData(i, 2);
			String email = excelUtils.getCellData(i, 3);

			pageUtils.getFirstName(usuarioNome);
			pageUtils.getLastName(usuarioSobrenome);
			pageUtils.getBusinessName(businessName);
			pageUtils.getEmail(email);

			ativarNavegador().navigate().refresh();

			// Verificar se todos os campos estão vazios para encerrar os testes
			if (usuarioNome.isEmpty() && usuarioSobrenome.isEmpty() && businessName.isEmpty() && email.isEmpty()) {
				break;
			}
		}
	}

	// validar interação humana"

	public void interacaoHumana() {

		WebElement selecaoNumeroUm = pageUtils.getSelecaoNumeroUm();
		WebElement selecaoNumeroDois = pageUtils.getSelecaoNumeroDois();
		WebElement campoResultado = pageUtils.getResultado();

		String valorNumeroUm = selecaoNumeroUm.getText();
		String valorNumeroDois = selecaoNumeroDois.getText();

		int numeroUm = parseInteger(valorNumeroUm);
		int numeroDois = parseInteger(valorNumeroDois);

		int campoResultados = numeroUm + numeroDois;

		campoResultado.sendKeys(String.valueOf(campoResultados));

		System.out.println("valor " + valorNumeroUm);
		System.out.println("valor " + valorNumeroDois);
		System.out.println("valor " + campoResultado.getAttribute("value"));
	}

	private int parseInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	// botão submit
	public void botaoSubmit() {

		WebElement botaoClicar = pageUtils.getSubmit();
		JavascriptExecutor clicarBotao = (JavascriptExecutor) ativarNavegador();
		clicarBotao.executeScript("arguments[0].click();", botaoClicar);
	}

	// validar mensagem sucesso

	public void mensagemValidar() {

		String validarMensagem = pageUtils.getAssercao();
		Assert.assertEquals("Thank you!", validarMensagem);

		System.out.println("valor: " + validarMensagem);
	}

}