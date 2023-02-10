package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory 
{
	public WebDriver driver;
	optionManager om;
	public Properties prop;
	public static ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();

	public WebDriver getDriver(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		om = new optionManager(prop);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver(om.chromeOption()));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				tl.set(new FirefoxDriver(om.firefoxOption()));
			}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tl.set(new EdgeDriver(om.edgeOption()));
		}
		else
		{
			System.out.println("Please pass the validate browser as "+browserName);
		}
		
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		return getDriver();
	}
	public static synchronized WebDriver getDriver()
	{
		return tl.get();
	}
	public Properties getProperty()
	{
		FileInputStream fs = null;
		prop = new Properties();
		try {
			fs = new FileInputStream("./src/test/resources/config/config.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public String takeScreenshot()
	{
		File src  = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String fileName = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File des = new File(fileName);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}

}
