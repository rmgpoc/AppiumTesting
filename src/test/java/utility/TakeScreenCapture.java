package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TakeScreenCapture {
	
	public static AndroidDriver<MobileElement> driver;
	public static String destDir;
	public static DateFormat dateFormat;
	
	public static void screenCapture() throws IOException{
		//destination directory
		destDir = "screenshots";
		//capturing screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//set date
		dateFormat = new SimpleDateFormat("yyyy-MM-DD'T'HH_mm_ss.SSSz");
		//create folder
		new File(destDir).mkdir();
		//naming the screenshot
		String destFile = dateFormat.format(new Date())+".png";
		//moving screenshot to destination directory
		FileUtils.copyFile(scrFile, new File(destDir+"/"+destFile));
	}
	
	public static String elementScreenCapture(MobileElement ele){
		
		File screenshotLocation = null;
		try{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			BufferedImage fullImg = ImageIO.read(scrFile);
			//Get the location of element on the page
			Point point = ele.getLocation();
			//Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			//Crop the entire page screenshot to get only element screen
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", scrFile);
			dateFormat = new SimpleDateFormat("yyyy-MM-DD'T'HH_mm_ss.SSSz");
			String fileName = "elementScreenCapture";
			screenshotLocation = new File("./screenshots/"+ fileName + "_" + dateFormat.format(new Date()) + ".jpg");
			FileUtils.copyFile(scrFile, screenshotLocation);
			System.out.println(screenshotLocation.toString());
			
		} catch (IOException e){
			e.printStackTrace();
		}
			return screenshotLocation.toString();		
	}

}
