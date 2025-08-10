package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public Object[][] getLoginCredentials() throws IOException
	{
		String path = ".\\testData/Opencart_LoginData.xlsx";
		String sheetName = "sheet";
		ExcelUtils excelUtils = new ExcelUtils(path);
		
		int totalRows = excelUtils.getRow(sheetName);
		int totalColumns = excelUtils.getCellNum(sheetName, 1);
		
		Object[][] loginData = new Object[totalRows][totalColumns];
		
		for (int r=1; r<=totalRows; r++)
		{
			for(int c=0; c<totalColumns; c++)
			{
				loginData[r-1][c] = excelUtils.getCellData(sheetName, r, c);
			}
		}
		return loginData;
	}
	
	
}
