package test;

import static core.driver.WebDriverManager.getWebDriver;

import core.utils.ExcelUtils;

public class FormularioModel {

	public static final String ENDERECO_ARQUIVO = "./src/main/resources/MassaDadosExcel/Login.xlsx";
	public static final String PLANILHA = "massaDados";

	private ExcelUtils excelUtils;
	private String txtFirstName;
	private String txtLastName;
	private String txtBusinessName;
	private String txtEmail;

	public String getPagina(String pagina) {

		getWebDriver().get(pagina);

		return pagina;
	}

	public FormularioModel() {
		excelUtils = new ExcelUtils(ENDERECO_ARQUIVO, PLANILHA);

		txtFirstName = excelUtils.getCellData(1, 0);
		txtLastName = excelUtils.getCellData(1, 1);
		txtBusinessName = excelUtils.getCellData(1, 2);
		txtEmail = excelUtils.getCellData(1, 3);

	}

	public String getTxtFirstName() {
		return txtFirstName;
	}

	public String getTxtLastName() {
		return txtLastName;
	}

	public String getTxtBusinessName() {
		return txtBusinessName;
	}

	public String getTxtEmail() {
		return txtEmail;
	}

}
