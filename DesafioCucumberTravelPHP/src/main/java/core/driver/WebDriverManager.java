package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	private static WebDriver driver;

	public static void createAcess() {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driverChrome/chromedriver.exe");
		driver = new ChromeDriver();

	}

	public static WebDriver getWebDriver() {

		if (driver == null) {
			createAcess();
		}
		return driver;
	}

	public static void tearDown() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
