package resources;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


//import Smoke.Com_Rom.SmokeTest;
import org.testng.annotations.Test;
import resources.Initialize;
public class Listener implements ITestListener{
	 public WebDriver dr;
	 Initialize i = new Initialize();
	private static Logger Log = LogManager.getLogger(Listener.class.getName());

public void onFinish(ITestContext result) {
	// TODO Auto-generated method stub
	Log.info("----------------------"+result.getName()+"----------------------");
	Log.info("----------------------Test Completed----------------------");
		
}

public void onStart(ITestContext result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	// TODO Auto-generated method stub
	
}

public void onTestFailure(ITestResult result) 
{
	// TODO Auto-generated method stub
	Log.info("----------------------Test Failed----------------------");
		try {
			i.ScreenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info("----------------------"+result.getName()+"----------------------");
}

public void onTestSkipped(ITestResult arg0) {
	// TODO Auto-generated method stub
	
}

public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	Log.info("***----------------------Test Started----------------------***");
	Log.info("----------------------"+result.getName()+"----------------------");
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	Log.info("----------------------Test Success----------------------");
	Log.info("----------------------"+result.getName()+"----------------------");
}
}
