package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	// Will store all data providers here. 
	// Not all tests can use the same data provider
	// Each will have its own
	// Storing in a common place so that multiple data driven tests can refer to data provider centrally.
	
	@DataProvider(name = "excelData")
    public String[][] getData() throws IOException {
    	String path = ".\\testData\\LoginData.xlsx";
    	
    	ExcelUtility xlutil = new ExcelUtility(path);
    	int noOfRows = xlutil.getRowCount("Details");
        int noOfCols = xlutil.getCellCount("Details", 1);
        
        String[][] loginData = new String[noOfRows][noOfCols];
        
        for(int i = 1; i <= noOfRows; ++i) { // 0-th row has headers
        	for(int j = 0; j < noOfCols; ++j) {
        		loginData[i-1][j] = xlutil.getCellData("Details", i, j);
        	}
        }
        
        return loginData;
    }
	
	/* Reference: https://qaautomation.expert/2021/10/19/dataprovider-in-testng-using-excel/
	@DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
 
        // We are creating an object from the excel sheet data by calling a method that
        // reads data from the excel stored locally in our system
        Object[][] arrObj = getExcelData(".\\testData\\LoginData.xlsx","Details");
        return arrObj;
}
 
    // This method handles the excel - opens it and reads the data from the
    // respective cells using a for-loop & returns it in the form of a string array
    public String[][] getExcelData(String fileName, String sheetName) throws IOException {
        String[][] data = null;
        try {
 
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];
 
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }
    */
    
    
}
