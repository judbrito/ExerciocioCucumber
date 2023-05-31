package execucaoPagina;

import static execucaoPagina.DriverPagina.ativarNavegador;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageUtil {

	public PageUtil() {

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
	@FindBy(how = How.XPATH, using = "//h2/strong[text()=' Thank you!']")
	private WebElement assercao;
	// metodos do selenium

	public void setFirstName(String usuarioNome) {
		firstName.sendKeys(usuarioNome);

	}

	public void setLastName(String usuarioSobreNome) {
		lastName.sendKeys(usuarioSobreNome);

	}

	public void setBusinessName(String businessNames) {
		businessName.sendKeys(businessNames);

	}

	public void setEmail(String emails) {
		email.sendKeys(emails);

	}

	public WebElement setSelecaoNumeroUm() {
		return selecaoNumeroUm;

	}

	public WebElement setSelecaoNumeroDois() {
		return selecaoNumeroDois;

	}

	public WebElement setResultado() {
		return resultado;
	}

	public WebElement setSubmit() {
		return submit;
	}

	public String getAssercao() {

		return assercao.getText();
	}

}
