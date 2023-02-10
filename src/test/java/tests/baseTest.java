package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import factory.driverFactory;
import pages.loginPage;
import pages.searchGooglePage;

public class baseTest 
{
	public WebDriver driver;
	public loginPage lPage;
	public searchGooglePage sPage;
	public Properties prop;
	public driverFactory factory;
	
	@BeforeTest
	public void setUp()
	{
		factory = new driverFactory();
		prop = factory.getProperty();
		driver = factory.getDriver(prop);
		lPage = new loginPage(driver);
		sPage = new searchGooglePage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
