package test.business.formulario;

import static core.driver.WebDriverManager.getWebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioPage {

	public FormularioPage() {

		PageFactory.initElements(getWebDriver(), this);
	}

	// identificação elemento
	@FindBy(name = "first_name")
	private WebElement txtFirstName;

	@FindBy(name = "last_name")
	private WebElement txtLastName;

	@FindBy(name = "business_name")
	private WebElement txtBusinessName;

	@FindBy(name = "email")
	private WebElement txtEmail;

	// Interação humana
	@FindBy(xpath = "//span[@id='numb1']")
	private WebElement lblNumeroUm;

	@FindBy(xpath = "//span[@id='numb2']")
	private WebElement lblNumeroDois;

	@FindBy(xpath = "//input[@id='number']")
	private WebElement txtResultado;

	// Botão Submit
	@FindBy(xpath = "//button[@id='demo']")
	private WebElement btnButton;

	// Validação Mensagem de sucesso
	@FindBy(xpath = "//h2/strong[text()=' Thank you!']")
	private WebElement txtAssercao;

	// metodos do selenium
	public WebElement getLblNumeroUm() {
		return lblNumeroUm;
	}

	public WebElement getLblNumeroDois() {
		return lblNumeroDois;
	}

	public WebElement getTxtResultado() {
		return txtResultado;
	}

	public WebElement getBtnButton() {
		return btnButton;
	}

	public WebElement getTxtAssercao() {
		return txtAssercao;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtBusinessName() {
		return txtBusinessName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public String getAssercao() {

		return txtAssercao.getText();
	}

}
