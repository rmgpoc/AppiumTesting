package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
		
		File file =    new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook excelWorkbook = null;

		//Find the file extension by splitting file name in substring  and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){
			excelWorkbook = new XSSFWorkbook(inputStream);
		}else if(fileExtensionName.equals(".xls")){
			excelWorkbook = new HSSFWorkbook(inputStream);
		}

		//Read sheet inside the workbook by its name
		Sheet excelSheet = excelWorkbook.getSheet(sheetName);

		//Find number of rows in excel file
		int rowCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();

		//Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount+1; i++) {
			Row row = excelSheet.getRow(i);
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print Excel data in console
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
			System.out.println();
		}

    }

	public static void main(String...strings) throws IOException{
		//Create an object of ExcelRead class
		ExcelRead objExcelFile = new ExcelRead();
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata";
		objExcelFile.readExcel(filePath,"testdata.xlsx","baPlanTripTest");
    }

}
