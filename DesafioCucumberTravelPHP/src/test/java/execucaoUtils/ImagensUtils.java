package execucaoUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import execucaoPagina.DriverPagina;
import io.cucumber.core.api.Scenario;

public class ImagensUtils {
	public void imagens(Scenario scenario) {

		File arquivo = ((TakesScreenshot) DriverPagina.ativarNavegador()).getScreenshotAs(OutputType.FILE);
		String imagens = new SimpleDateFormat("dd-MM-yyyy-HHmmss").format(new Date());

		String mensagem;
		if (scenario.isFailed()) {
			mensagem = "Falhou";
		} else {
			mensagem = "Passou";
		}

		try {
			FileUtils.copyFile(arquivo,
					new File("./LoginSimples" + scenario.getName() + "-" + imagens + "-" + mensagem + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
