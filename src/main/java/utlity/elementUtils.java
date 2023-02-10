package utlity;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class elementUtils 
{
	public WebDriver driver;
	public elementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public By getBy(String locatorType, String locatorValue)
	{
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
		locator = By.id(locatorValue);	
			break;
		case "name":
			locator = By.name(locatorValue);	
				break;
		case "classname":
			locator = By.className(locatorValue);	
				break;
		case "xpath":
			locator = By.xpath(locatorValue);	
				break;
		case "linktext":
			locator = By.linkText(locatorValue);
				break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
		default:
			System.out.println("Invalid locator");
			break;
		}
		return locator;
	}
	
	public WebElement getElement(String locatorType, String locatorValue)
	{
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(String locatorType, String locatorValue)
	{
		return driver.findElements(getBy(locatorType, locatorValue));
	}
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public void doClick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void doSendKey(By locator, String text)
	{
		driver.findElement(locator).sendKeys(text);
	}
	
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String getAttribute(By locator, String attributeName)
	{
		return driver.findElement(locator).getAttribute(attributeName);
	}
	
	public Select selectDropDownHandelling(WebElement el)
	{
		Select sel = new Select(el);
		return sel;
	}
	
	public void selectByIndex(WebElement el,int index)
	{
		Select sel = selectDropDownHandelling(el);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement el, String val)
	{
		Select sel = selectDropDownHandelling(el);
		sel.selectByValue(val);
	}
	
	public void selectByVisibleText(WebElement el, String text)
	{
		Select sel = selectDropDownHandelling(el);
		sel.selectByVisibleText(text);
	}
	
	public String getAllSelectDropDownOptions(WebElement el)
	{
		String value = null;
		Select sel = selectDropDownHandelling(el);
		List<WebElement> options = sel.getOptions();
		for(WebElement option:options)
		{
			value = option.getText();
		}
		return value;
	}
}
