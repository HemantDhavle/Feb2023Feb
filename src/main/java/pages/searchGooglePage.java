package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utlity.elementUtils;

public class searchGooglePage 
{
	public WebDriver driver;
	public elementUtils eU;
	private By searchBox = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
	public searchGooglePage(WebDriver driver)
	{
		this.driver = driver;
		eU = new elementUtils(driver);
	}
	
	public void validateSearch(String text)
	{
		eU.doSendKey(searchBox, text);
	}

}
