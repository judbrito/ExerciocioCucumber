package excucaoWeb;

import static execucaoDriver.Driver.ativarNavegador;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ValidacaoWeb {

	public static void validar() {

		WebElement span1 = ativarNavegador().findElement(By.id("numb1"));
		WebElement span2 = ativarNavegador().findElement(By.id("numb2"));
		WebElement campoResultado = ativarNavegador().findElement(By.id("number"));
		int numero1 = Integer.parseInt(span1.getText());
		int numero2 = Integer.parseInt(span2.getText());

		int resultado = numero1 + numero2;

		campoResultado.sendKeys(String.valueOf(resultado));
		System.out.println(numero1);
		System.out.println(numero2);
		System.out.println(resultado);
	}

	public static void botaoSubmit() {
		WebElement botaoClicar = ativarNavegador().findElement(By.xpath("//button[@id='demo']"));
		JavascriptExecutor clicarBotao = (JavascriptExecutor) ativarNavegador();
		clicarBotao.executeScript("arguments[0].click();", botaoClicar);

	}

	public static void mensagemValidar() {

		WebElement validarMensagem = ativarNavegador().findElement(By.xpath("//h2/strong[text()=' Thank you!']"));
		System.out.println(validarMensagem.getText());
		Assert.assertEquals("Thank you!", validarMensagem.getText());
	}
}