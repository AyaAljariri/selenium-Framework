package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
static FileInputStream fis = null ; 
	
	public FileInputStream getFileInputStream() 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx"; 
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
			System.exit(0);
		}
		return fis ; 
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream(); 
		//i have added the library poi-ooxml in the dependencies 
		//the default name of any excel project is book
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//to get the data from the sheet 1 i used its index which is 0
		XSSFSheet sheet = wb.getSheetAt(0); 
		//i need rows and cols to get the data inside each cell
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 4 ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		//getting the data from the cells 
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		
		wb.close();
		return arrayExcelData; 
	}
}
