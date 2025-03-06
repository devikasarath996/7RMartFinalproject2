package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenshot(WebDriver driver,String failedTestCase) throws IOException
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver;//takescreenshot is an interface here driver is casted
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //reference variable of File--screenShot,,output type is an interface
		//get screenshot and stores in a specific location
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//simpledateformat and date is a class,
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");
		if (!f1.exists()) {
			f1.mkdirs();   //incase if file is not created above, here by use of mkdirs method creates a file
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
	}
	
}

