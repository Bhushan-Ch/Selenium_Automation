package utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderUtil {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
	    Object[][] data = null;
	    try {
	        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/loginData.xlsx");
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet("Sheet1");

	        int rows = sheet.getPhysicalNumberOfRows();
	        int cols = sheet.getRow(0).getLastCellNum();
	        data = new Object[rows - 1][cols];

	        for (int i = 1; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
	            }
	        }
	        workbook.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("❌ Error reading Excel file: " + e.getMessage());
	    }
	    return data;
	}

}
