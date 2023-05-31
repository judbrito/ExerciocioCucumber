package execucaoPagina;

import static execucaoPagina.DriverPagina.ativarNavegador;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execucaoUtils.ExcelUtils;

public class FormularioPagina {

	private PageUtil pageUtil;

	public FormularioPagina() {
		pageUtil = new PageUtil();
	}

	public void digitarDados() {
		String arquivo = "./src/main/resources/MassaDadosExcel/Login.xlsx";
		String planilha = "massaDados";

		ExcelUtils excelUtils = null;

		try {
			excelUtils = new ExcelUtils(arquivo, planilha);

			String usuarioNome = excelUtils.getCellData(1, 0);
			String usuarioSobrenome = excelUtils.getCellData(1, 1);
			String businessName = excelUtils.getCellData(1, 2);
			String email = excelUtils.getCellData(1, 3);

			pageUtil.setFirstName(usuarioNome);
			pageUtil.setLastName(usuarioSobrenome);
			pageUtil.setBusinessName(businessName);
			pageUtil.setEmail(email);

			excelUtils.setCellData(1, 4, "ok");

			excelUtils.saveWorkbook(arquivo);

			System.out.println("Teste concluído com sucesso.");
		} finally {
			if (excelUtils != null) {
				excelUtils.close();
			}
		}
	}

	// validar interação humana
	public void interacaoHumana() {
		WebElement selecaoNumeroUm = pageUtil.setSelecaoNumeroUm();
		WebElement selecaoNumeroDois = pageUtil.setSelecaoNumeroDois();
		WebElement campoResultado = pageUtil.setResultado();

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
		WebElement botaoClicar = pageUtil.setSubmit();
		JavascriptExecutor clicarBotao = (JavascriptExecutor) ativarNavegador();
		clicarBotao.executeScript("arguments[0].click();", botaoClicar);
	}

	// validar mensagem sucesso
	public void mensagemValidar() {
		String textoEsperado = "Thank you!";
		WebDriverWait espera = new WebDriverWait(ativarNavegador(), 10);
		WebElement textoElemento = espera
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/strong[text()=' Thank you!']")));
		String textoObtido = textoElemento.getText();

		Assert.assertEquals(textoEsperado, textoObtido);
	}

	public void digitarDadosEmMassa(int quantidadeClientes) {
		for (int i = 1; i <= quantidadeClientes; i++) {
			String usuarioNome = "Nome" + i;
			String usuarioSobrenome = "Sobrenome" + i;
			String businessName = "Empresa" + i;
			String email = "cliente" + i + "@exemplo.com";

			pageUtil.setFirstName(usuarioNome);
			pageUtil.setLastName(usuarioSobrenome);
			pageUtil.setBusinessName(businessName);
			pageUtil.setEmail(email);

			System.out.println("Dados do cliente " + i + " preenchidos com sucesso.");
		}

		System.out.println("Teste concluído com sucesso.");
	}
}
