package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utlity.excelUtils;

public class searchPageTest extends baseTest
{
	@Test(dataProvider = "loadExcelData", invocationCount = 2)
	public void searchData(String text)
	{
		System.out.println(text);
		sPage.validateSearch(text);
	}
	
	@DataProvider(parallel = true)
	public Object[][] loadExcelData()
	{
		return excelUtils.loadData("Sheet1");
	}

}
