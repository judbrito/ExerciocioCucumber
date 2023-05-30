package execucaoUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	private Workbook arquivo;
	private Sheet planilha;
	private FileInputStream fileInputStream;

	public ExcelUtils(Workbook arquivos, Sheet planilhas) {
		this.arquivo = arquivos;
		this.planilha = planilhas;
	}

	public ExcelUtils(String arquivoName, String planilhaName) {
		try {
			fileInputStream = new FileInputStream(new File(arquivoName));
			arquivo = WorkbookFactory.create(fileInputStream);
			planilha = arquivo.getSheet(planilhaName);
		} catch (IOException e) {
			throw new RuntimeException("Falha ao localizar ", e);
		}
	}

	public String getCellData(int linha, int coluna) {
		Row linhas = planilha.getRow(linha);
		Cell colunas = linhas.getCell(coluna);

		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(colunas);
	}

	public int getRowCount() {
		return planilha.getLastRowNum() + 1;
	}

	public void close() {
		try {
			arquivo.close();
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
