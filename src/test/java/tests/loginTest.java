package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends baseTest 
{
	
	@Test
	public void getData()
	{
		String text = lPage.validateSearchButtonText();
		Assert.assertEquals(text, "Google Search");
	}
	

}
