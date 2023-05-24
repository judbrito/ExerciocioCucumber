package execucaoPage;

import static execucaoDriver.Driver.ativarNavegador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import execucaoUtils.ExcelUtils;

public class PageUtils {

	public static void digitar() {

		ExcelUtils excelUtils = new ExcelUtils("./src/main/resources/MassaDadosExcel/Login.xlsx", "massaDados");

		String firstName = excelUtils.getCellData(1, 0);
		String lastName = excelUtils.getCellData(1, 1);
		String businessName = excelUtils.getCellData(1, 2);
		String email = excelUtils.getCellData(1, 3);

		System.out.println("Dados da célula: " + firstName);

		WebElement name = ativarNavegador().findElement(By.name("first_name"));
		name.sendKeys(firstName);

		System.out.println("O valor do nome é " + firstName);

		WebElement sobreNome = ativarNavegador().findElement(By.name("last_name"));
		sobreNome.sendKeys(lastName);

		System.out.println("O valor do sobrenome é " + lastName);

		WebElement empresa = ativarNavegador().findElement(By.name("business_name"));
		empresa.sendKeys(businessName);

		System.out.println("O valor do nome é " + businessName);

		WebElement emails = ativarNavegador().findElement(By.name("email"));
		emails.sendKeys(email);

		System.out.println("Dados da célula : " + email);

	}

}
