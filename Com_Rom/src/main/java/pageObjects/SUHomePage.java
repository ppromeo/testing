package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SUHomePage {
	public WebDriver dr;
	public WebElement element;
	
	/**Constructor**/
	public SUHomePage(WebDriver dr) 
	{
		this.dr = dr;
	}
	
	By linksspan = By.className("listing");
	
	public WebElement linksspan()
	{
		return dr.findElement(linksspan);
	}

}
