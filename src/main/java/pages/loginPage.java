package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utlity.elementUtils;

public class loginPage 
{
	
	private WebDriver driver;
	private By searchBtnXpath = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]");
	public elementUtils eu;
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		eu = new elementUtils(driver);
	}
	
	public String validateSearchButtonText()
	{
		return eu.getAttribute(searchBtnXpath, "aria-label");
		
	}
	
	

}
