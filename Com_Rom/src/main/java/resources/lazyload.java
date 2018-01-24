package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.RPLogin;
import pageObjects.SUHomePage;


public class lazyload {
	
	public WebDriver dr;
	public WebElement element;	
	
	/**Constructor**/
	public lazyload(WebDriver dr) 
	{
		this.dr = dr;
	}
	
	public RPLogin rp()
	{
		RPLogin rp = new RPLogin(dr);
		return rp;
	}
	public SUHomePage suhome()
	{
		SUHomePage suhome = new SUHomePage(dr);
		return suhome;
	}
	
}
