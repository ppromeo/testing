package Smoke.Com_Rom;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Initialize;
import resources.Listener;
import org.testng.annotations.Test;
import resources.lazyload;



@Listeners(Listener.class)
public class SmokeTest  extends Initialize
{
	public base b = new base();
	
   
@Test
public void RPLogin() throws IOException
{		
	b.RPLogin();
	lazyload lazy = new lazyload(dr);
	lazy.rp().username().sendKeys(PropertiesLoad().getProperty("suusername"));
    lazy.rp().password().sendKeys(PropertiesLoad().getProperty("supassword"));
    lazy.rp().login().click();
    List<WebElement> linkscollection = lazy.suhome().linksspan().findElements(By.tagName("li"));
    b.exceldatacompare(linkscollection,"Sheet2");
 }

}
