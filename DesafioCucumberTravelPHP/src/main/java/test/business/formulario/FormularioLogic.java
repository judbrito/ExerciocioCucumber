package test.business.formulario;

import static core.driver.WebDriverManager.getWebDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.FormularioModel;

public class FormularioLogic {

	private FormularioPage page;
	private FormularioModel model;

	public FormularioLogic() {
		page = new FormularioPage();
		model = new FormularioModel();
	}

	public void navegar() {

		model.getPagina("https://phptravels.com/demo/");

	}

	public void preencherTxt() {
		page.getTxtFirstName().sendKeys(model.getTxtFirstName());
		page.getTxtLastName().sendKeys(model.getTxtLastName());
		page.getTxtBusinessName().sendKeys(model.getTxtBusinessName());
		page.getTxtEmail().sendKeys(model.getTxtEmail());

	}

	// validar interação humana
	public void calcularsoma() {

		int numeroUm = parseInteger(page.getLblNumeroUm().getText());
		int numeroDois = parseInteger(page.getLblNumeroDois().getText());
		int campoResultados = numeroUm + numeroDois;

		page.getTxtResultado().sendKeys(String.valueOf(campoResultados));

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
		WebElement botaoClicar = page.getBtnButton();
		JavascriptExecutor clicarBotao = (JavascriptExecutor) getWebDriver();
		clicarBotao.executeScript("arguments[0].click();", botaoClicar);
	}

	// validar mensagem sucesso
	public void mensagemValidar() {
		String textoEsperado = "Thank you!";
		WebDriverWait espera = new WebDriverWait(getWebDriver(), 10);
		WebElement textoElemento = espera
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/strong[text()=' Thank you!']")));
		String textoObtido = textoElemento.getText();

		Assert.assertEquals(textoEsperado, textoObtido);
	}

}
