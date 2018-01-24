package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


/**
 * Hello world!
 *
 */
public class Initialize 
{
    public static WebDriver dr;
    public static WebElement element;


	public WebDriver browserlaunch() throws IOException
    {
        String value= PropertiesLoad().getProperty("browser");
        if(value.equals("chrome"))
        	{
        		System.setProperty("webdriver.chrome.driver", PropertiesLoad().getProperty("chromedriver"));
        		dr = new ChromeDriver();
        	}
        else if(value.equals("firefox"))
        {
        	System.setProperty("webdriver.chrome.driver", PropertiesLoad().getProperty("geckodriver"));
    		dr = new FirefoxDriver();
        }
        else if(value.equals("ie"))
        {
        	System.setProperty("webdriver.chrome.driver", PropertiesLoad().getProperty("iedriver"));
    		dr = new FirefoxDriver();
        }
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return dr;
    }
    
    public Properties PropertiesLoad() throws IOException
    {
    	Properties prop = new Properties();
    	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\dataFile.properties");
        prop.load(file);
        return prop;
    }
    public String[] ExcelLoad (String sheetname,int cellno) throws IOException
    {
    	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\ROMEODataExcel.xlsx");
    	XSSFWorkbook wb = new XSSFWorkbook(file);
    	XSSFSheet sheet = wb.getSheet(sheetname);    	
    	int rowvalue = sheet.getPhysicalNumberOfRows();
    	String[] names = new String[rowvalue];
    	for(int i=0;i<rowvalue;i++)
    	{
    		XSSFRow row = sheet.getRow(i);
        	XSSFCell cell = row.getCell(cellno);
        	String data = cell.getStringCellValue();
        	names[i]=data;
    	}   
    	return names;
    }
    @AfterTest
    public void CloseDriver() throws IOException
    {
    	dr.close();
    	dr=null;
    }
    public void ScreenShot(String result) throws IOException
    {
    	File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(src, new File("C:\\Users\\Deepan\\Error\\"+result+"error"+".png"));
    }
}
