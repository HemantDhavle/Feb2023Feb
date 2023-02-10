package utlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtils 
{
	public static String path = "D:\\ReSkill\\ZZValidation\\src\\test\\resources\\data\\excel.xlsx";
	public static Workbook workbook;
	public static Sheet sheet;
	public static FileInputStream fs = null;
	
	public static Object[][] loadData(String sheetName)
	{
		Object[][] data= null;
		
		try {
			fs = new FileInputStream(path);
			workbook = WorkbookFactory.create(fs);
			sheet  = workbook.getSheet(sheetName);
		} catch (IOException | InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		data = new Object[rows][cols];
		for(int i =0;i<rows;i++)
		{
			for(int j = 0;j<cols;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
//
//	public static void main (String args[])
//	{
//		Object[][]data = loadData("Sheet1");
//		int rows = data.length;
//		int cols = data[0].length;
//		for(int i=0;i<rows;i++){
//			for(int j=0;j<cols;j++)
//			{
//				System.out.println(data[i][j]);
//			}
//		}
//	}
}
