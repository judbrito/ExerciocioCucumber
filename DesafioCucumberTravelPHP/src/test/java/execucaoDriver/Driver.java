package execucaoDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	private static WebDriver driver;

	public static WebDriver ativarNavegador() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driverChrome/chromedriver.exe");

		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://phptravels.com/demo/");
		}
		return driver;
	}

}
