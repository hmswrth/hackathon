package excel;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Write {
  public static String filePath = System.getProperty("user.dir")+"/Excel/sample_test.xlsx";
	public static void writeExcel(String result) throws Exception {   //write test result to the excel file
			XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new File(filePath));
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
			row.createCell(1).setCellValue(result);
			FileOutputStream fileOut = new FileOutputStream("result.xlsx");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();

		}

}
