package excel;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Read {
  public static String filePath = System.getProperty("user.dir")+"/Excel/sample_test.xlsx";
	public static String readExcel(){
		String testData = null;
		try {
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		testData = String.valueOf(sheet.getRow(0).getCell(0));
		workbook.close();
		file.close();
		}catch(IOException e) {
			System.out.println("error while reading the file at "+filePath);
			e.printStackTrace();
		}
		return testData;
		
	}

}
