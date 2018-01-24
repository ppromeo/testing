package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RPLogin {

	public WebDriver dr;
	public WebElement element;
	
	/**Constructor**/
	public RPLogin(WebDriver dr) 
	{
		this.dr = dr;
	}
	
	By username = By.id("ctl00_ContentPlaceHolder1_txtUserName");
	By password = By.id("ctl00_ContentPlaceHolder1_txtPassword");
	By login = By.id("ctl00_ContentPlaceHolder1_btnSubmit");

	public WebElement username()
	{
		 if (dr instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)dr).executeScript("arguments[0].style.border='3px solid red'", dr.findElement(username));
		    }
		return dr.findElement(username);
	}
	public WebElement password()
	{
		 if (dr instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)dr).executeScript("arguments[0].style.border='3px solid red'", dr.findElement(password));
		    }
		return dr.findElement(password);
	}
	public WebElement login()
	{
		return dr.findElement(login);
	}
}
