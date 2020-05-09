package excel;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Read {
  public static String filePath = System.getProperty("user.dir")+"/Excel/sample_test.xlsx";
	public static String[] readExcel() throws Exception {
		String[] arr = new String[2];
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		arr[0] = String.valueOf(sheet.getRow(0).getCell(0));
		arr[1] = String.valueOf(sheet.getRow(1).getCell(0));
		workbook.close();
		file.close();
		return arr;
		
	}

}
