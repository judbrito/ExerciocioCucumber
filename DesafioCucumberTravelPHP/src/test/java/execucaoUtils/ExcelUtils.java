package execucaoUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private String nomeDoArquivo;
	private Sheet planilha;

	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}

	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public void lerArquivoExcel() {
		try (FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
				Workbook workbook = new XSSFWorkbook(arquivo)) {

			planilha = workbook.getSheet("massaDados");

			if (planilha != null) {
				int primeiraLinha = planilha.getFirstRowNum() + 1;

				for (int i = primeiraLinha; i <= planilha.getLastRowNum(); i++) {
					Row linha = planilha.getRow(i);

					if (linha != null) {
						for (int j = linha.getFirstCellNum(); j < linha.getLastCellNum(); j++) {
							Cell celula = linha.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

							if (celula != null) {
								String valorCelula = celula.toString();
								System.out.println("Valor da célula (" + i + ", " + j + "): " + valorCelula);
								System.out.println("------------------------------------");

							}
						}
					}
				}
			} else {
				System.out.println("A planilha 'massaDados' não foi encontrada.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void dadosDoSite() {
		ExcelUtils excelUtils = new ExcelUtils();
		excelUtils.setNomeDoArquivo("./src/main/resources/massaDadosExcel/Login.xlsx");
		excelUtils.lerArquivoExcel();
	}
}
