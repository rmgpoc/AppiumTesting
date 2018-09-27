package rough;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestDUScreenRecorder {
	
	public static AndroidDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;

	public static void main(String[] args) throws InterruptedException, IOException {
		
			Runtime rt = Runtime.getRuntime();
			rt.exec("cmd /c start " + "C:\\Eclipse\\workspace\\BlueStacks.OneNote.Poc\\src\\test\\resources\\batch\\Start_BlueStacks.bat");
			Thread.sleep(40000);
	
			
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\klink\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")));
		service.start();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability("appPackage", "com.duapps.recorder");
		capabilities.setCapability("appActivity", "com.duapps.screen.recorder.WelcomeActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		//Agree with Terms & Conditions
		driver.findElementById("com.duapps.recorder:id/btn_agree").click();
		//Click Permission Allow
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		//Click Turn On ScreenRecorder Button
		driver.findElementById("com.duapps.recorder:id/durec_miui_ok_btn").click();
		//Permit Drawing over Apps
		driver.findElementById("android:id/switch_widget").isEnabled();
		
		//Record Video
		driver.findElementById("com.duapps.recorder:id/durec_home_recorder_button").click();
		//Permission Allow Audio Record
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		//Permission Deny Audio Record
		//driver.findElementById("com.android.packageinstaller:id/permission_deny_button").click();
		//Ok PopUp Message
		driver.findElementById("com.duapps.recorder:id/pos_btn").click();
		//START Recording
		driver.findElementById("android:id/button1").click();
		//CANCEL Recording
		//driver.findElementById("android:id/button2").click();
		Thread.sleep(3000);
		//STOP Recording
		driver.findElementById("com.duapps.recorder:id/durec_home_recorder_button").click();
		
/*		MobileElement button = driver.findElementById("android:id/button2");
		if(button.isDisplayed()){
			driver.findElementById("android:id/button2").click();
			driver.findElementByClassName("android.widget.ImageButton").click();
			driver.findElementsById("com.microsoft.office.onenote:id/recentnotes_text").wait();
			driver.findElementById("com.microsoft.office.onenote:id/entry_title").click();
			driver.findElementById("com.microsoft.office.onenote:id/button_newsection").click();
		}else{
			driver.findElementByClassName("android.widget.ImageButton").click();
			driver.findElementsById("com.microsoft.office.onenote:id/recentnotes_text").wait();
			driver.findElementById("com.microsoft.office.onenote:id/entry_title").click();
			driver.findElementById("com.microsoft.office.onenote:id/button_newsection").click();
		}*/
		
		
		
/*		driver.findElementById("android:id/button1").click();
		
		String text = "No Thanks ";
		MobileElement noSignin = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")");
		
		driver.findElementById("android:id/button1").click();
		wait.until(ExpectedConditions.visibilityOf(noSignin));
		
		driver.findElementsByClassName("android.view.View").get(0).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.xe.currency:id/toursummary_image")));
		
		driver.findElementById("com.xe.currency:id/toursummary_image").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button2")));
		
		driver.findElementById("android:id/button2").click();
		
		System.out.println("+++ Rate is +++ "+ driver.findElementsById("com.xe.currency:id/rate").get(1).getText());
		System.out.println("+++ Currency is +++ "+ driver.findElementsById("com.xe.currency:id/codeAndName").get(1).getText());
		*/
		//List<MobileElement> rates = driver.findElements(By.id("com.xe.currency:id/rate"));
		//List<MobileElement> currencies = driver.findElements(By.id("com.xe.currency:id/rate"));
		//int ratecount = rates.size();
		//int currencycount = currencies.size();
		//System.out.println("+++ Rate count is +++ "+ rates.size());
		//System.out.println("+++ Currency count is +++ "+ currencies.size());
		
		//int[] arrayRate = new int[ratecount];
		/*
		String[] arrayRate = new String[ratecount];
		String[] arrayCurrency = new String[currencycount];
		
		for(int i = 0; i < currencycount; i++){
			
			arrayCurrency[i] = ((MobileElement) currencies).getText();
			arrayRate[i] = ((MobileElement) rates).getText();
			
		}
		
		
		for(int i = 0; i < currencycount; i++){
			
			System.out.println("******The Xe rate for " + arrayCurrency[i] + "is " + arrayRate[i] + "********");
		}
*/
		Thread.sleep(3000);
		driver.quit();
		service.stop();	
		rt.exec("cmd /c start " + "C:\\Eclipse\\workspace\\BlueStacks.OneNote.Poc\\src\\test\\resources\\batch\\Stop_BlueStacks.bat");

	}

}
