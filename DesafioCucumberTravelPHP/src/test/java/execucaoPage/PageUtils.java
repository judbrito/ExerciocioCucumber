package execucaoPage;

import static excucaoWeb.DriverWeb.ativarNavegador;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {

	public PageUtils() {

		PageFactory.initElements(ativarNavegador(), this);
	}

	@FindBy(name = "first_name")
	private WebElement firstName;

	@FindBy(name = "last_name")
	private WebElement lastName;

	@FindBy(name = "business_name")
	private WebElement businessName;

	@FindBy(name = "email")
	private WebElement email;

	// Interação humana

	@FindBy(xpath = "//span[@id='numb1']")
	private WebElement selecaoNumeroUm;

	@FindBy(xpath = "//span[@id='numb2']")
	private WebElement selecaoNumeroDois;

	@FindBy(xpath = "//input[@id='number']")
	private WebElement resultado;

	// Botão Submit

	@FindBy(xpath = "//button[@id='demo']")
	private WebElement submit;

	// Validação Mensagem de sucesso

	@FindBy(xpath = "//button[@id='demo']")
	private WebElement tempoEspera;

	@FindBy(xpath = "//h2/strong[text()=' Thank you!']")
	private WebElement assercao;

	// metodos do selenium

	public void getFirstName(String usuarioNome) {
		firstName.sendKeys(usuarioNome);

	}

	public void getLastName(String usuarioSobreNome) {
		lastName.sendKeys(usuarioSobreNome);

	}

	public void getBusinessName(String businessNames) {
		businessName.sendKeys(businessNames);

	}

	public void getEmail(String emails) {
		email.sendKeys(emails);

	}

	public WebElement getSelecaoNumeroUm() {
		return selecaoNumeroUm;

	}

	public WebElement getSelecaoNumeroDois() {
		return selecaoNumeroDois;

	}

	public WebElement getResultado() {
		return resultado;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getTempoEspera() {
		WebDriverWait wait = new WebDriverWait(ativarNavegador(), 5);
		wait.until(ExpectedConditions.visibilityOf(assercao));
		return tempoEspera;
	}

	public String getAssercao() {
		WebDriverWait wait = new WebDriverWait(ativarNavegador(), 5);
		wait.until(ExpectedConditions.visibilityOf(assercao));

		return assercao.getText();
	}

}
