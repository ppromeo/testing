package Smoke.Com_Rom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;
import org.testng.annotations.Test;
import resources.Initialize;

public class base extends Initialize{
	private static Logger Log = LogManager.getLogger(base.class.getName());
	public WebDriver dr;
	public void RPLogin() throws IOException
	{
		dr=browserlaunch();
		Properties prop = new Properties();
    	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\dataFile.properties");
        prop.load(file);
		dr.get(prop.getProperty("RPurl"));
	}
	public void ROMEOLogin() throws IOException
	{
		dr=browserlaunch();
		Properties prop = new Properties();
    	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\dataFile.properties");
        prop.load(file);
		dr.get(prop.getProperty("ROMEOurl"));
	}
	
	public void exceldatacompare(List<WebElement> collection,String sheetname) throws IOException
	{
		String[] excellinktext = ExcelLoad(sheetname,1);
		int rowvalue = excellinktext.length;
		for(int i=0;i<rowvalue;i++)
		{
			String linktext = collection.get(i).getText();
			if(linktext.equals(excellinktext[i]))
			{
				Log.info("Link available:"+linktext);
			}
			else
			{			
				Assert.assertTrue(false);
				Log.error("Missing:"+excellinktext[i]);
			}
		
		}
	}

}
