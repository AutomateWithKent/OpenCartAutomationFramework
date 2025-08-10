package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	String path;
	
	public ExcelUtils(String path)
	{
		this.path = path;
	}
	
	public int getRow(String sheetName) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetName);
		int totalRowNum = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return totalRowNum;
	}
	
	public int getCellNum(String sheetName, int rowNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		wb.close();
		fi.close();
		return row.getLastCellNum();
	}
	
	public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		wb.close();
		fi.close();
		return cell.toString();
	}

}
