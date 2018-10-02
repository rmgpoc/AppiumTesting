package rough;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestBA {
	
	public static AndroidDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	
	public static boolean isElementPresent (String id){
		try{
			driver.findElement(By.id(id));
			return true;
		}catch(Throwable t){
			return false;
		}
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
//			Runtime rt = Runtime.getRuntime();
//			rt.exec("cmd /c start " + "C:\\Eclipse\\workspace\\BlueStacks.OneNote.Poc\\src\\test\\resources\\batch\\Start_BlueStacks.bat");
//			Thread.sleep(40000);
	
			
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\ugbene.ositadinma\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")));
		service.start();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability("appPackage", "com.ba.mobile");
		capabilities.setCapability("appActivity", "com.ba.mobile.activity.launch.LaunchActivity");
		capabilities.setCapability("newCommandTimeout", 120);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		//Book a flight
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ba.mobile:id/scrollView")));
		
		//Click Book a flight button
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/button1"))).click();
		//driver.findElementById("com.ba.mobile:id/button1").click();
		
		//Select Departure
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/departureLL")));
		driver.findElementById("com.ba.mobile:id/departureLabel").click();
		driver.findElementById("com.ba.mobile:id/filterText").click();
		driver.findElementById("com.ba.mobile:id/filterText").sendKeys("LHR");
		driver.findElementById("com.ba.mobile:id/airportName").click();
		
		
		//Select Arrival
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/arrivalLL")));
		driver.findElementById("com.ba.mobile:id/arrivalLabel").click();
		driver.findElementById("com.ba.mobile:id/filterText").click();
		driver.findElementById("com.ba.mobile:id/filterText").sendKeys("KUL");
		driver.findElementById("com.ba.mobile:id/airportName").click();
		
		//Select Journey Type - Return or One Way
		//driver.findElementById("com.ba.mobile:id/tripTypeLL").click();
		//driver.findElementById("com.ba.mobile:id/tripTypeLabel").getText().contains("Return");
		//driver.findElementById("com.ba.mobile:id/tripTypeLabel").getText().contains("One way");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ba.mobile:id/tripTypeLabel")));
		
		//Select Outbound Date
		driver.findElementById("com.ba.mobile:id/outboundDateLL").click();
		//driver.findElementByCssSelector(".android.widget.TextView[text=\"3\"]").click();
		String mt = "October 2018";
		List<MobileElement> months = driver.findElementsById("com.ba.mobile:id/title");
		for(MobileElement month: months){
			if(month.getText().equals(mt)){
				month.click();
				String cType = "8";
				List<MobileElement> dates = driver.findElementsByClassName("android.widget.TextView");
				System.out.println("################");
				System.out.println(dates);
				System.out.println("################");
				for(MobileElement date: dates){
					if(date.getText().equals(cType)){
						date.click();
						break;
					}
				}
				
				break;
			}
		}
//		String cType = "30";
//		List<MobileElement> dates = driver.findElementsByClassName("android.widget.TextView");		
//		for(MobileElement date: dates){
//			if(date.getText().equals(cType)){
//				date.click();
//				break;
//			}
//		}
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.FrameLayout[5]/android.widget.TextView").click();
				
		//Select Inbound Date
		//driver.findElementById("com.ba.mobile:id/inboundDateLL").click();
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.FrameLayout[6]/android.widget.TextView").click();
		String mtt = "October 2018";
		List<MobileElement> monhs = driver.findElementsById("com.ba.mobile:id/title");
		for(MobileElement monh: monhs){
			if(monh.getText().equals(mtt)){
				monh.click();
				String cType = "28";
				List<MobileElement> dates = driver.findElementsByClassName("android.widget.TextView");		
				for(MobileElement date: dates){
					if(date.getText().equals(cType)){
						date.click();
						break;
					}
				}
				
				break;
			}
		}
		
		//Click Travel Date selection Done button
		driver.findElementById("com.ba.mobile:id/doneFilter").click();
		
		//Select Number of Passengers
		driver.findElementById("com.ba.mobile:id/passengersLL").click();
		//Set Adult Count 16yrs+
		//driver.findElementById("com.ba.mobile:id/adultMinusButton").click();//Subtract Adult button
		driver.findElementById("com.ba.mobile:id/adultAddButton").click();//Add Adult button
		//driver.findElementById("com.ba.mobile:id/adultCount").getText();
		//Set Young Adult Count 12-15yrs
		//driver.findElementById("com.ba.mobile:id/youngAdultMinusButton").click();//Subtract Young Adult button
		driver.findElementById("com.ba.mobile:id/youngAdultAddButton").click();//Add Young Adult button
		//driver.findElementById("com.ba.mobile:id/youngAdultCount").getText();
		//Set Children Count 2-11yrs
		//driver.findElementById("com.ba.mobile:id/childMinusButton").click();//Subtract Children button
		driver.findElementById("com.ba.mobile:id/childAddButton").click();//Add Children button
		//driver.findElementById("com.ba.mobile:id/childCount").getText();
		//Set Infant Count Under 2yrs
		//driver.findElementById("com.ba.mobile:id/infantMinusButton").click();//Subtract Infant button
		driver.findElementById("com.ba.mobile:id/infantAddButton").click();//Add Infant button
		//driver.findElementById("com.ba.mobile:id/infantCount").getText();		
		//Click Passenger selection Done button
		driver.findElementById("com.ba.mobile:id/doneFilter").click();
		
/*		//Select Class Type - Economy, Premium economy, Business, First
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/classTypeLL")));
		driver.findElementById("com.ba.mobile:id/classTypeLabel").click();
		String cType = "Economy";
		List<MobileElement> classTypes = driver.findElementsById("com.ba.mobile:id/text");		
		for(MobileElement classType: classTypes){
			if(classType.getText().equals(cType)){
				classType.click();
				break;
			}
		}
		
		//Select Ticket Type - Lowest price, Flexible ticket
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ba.mobile:id/ticketTypeLL")));
		driver.findElementById("com.ba.mobile:id/ticketTypeLL").click();
		String tType = "Flexible ticket";
		List<MobileElement> ticketTypes = driver.findElementsById("com.ba.mobile:id/text");		
		for(MobileElement ticketType: ticketTypes){
			if(ticketType.getText().equals(tType)){
				ticketType.click();
				break;
			}
		}*/
		
		//Search for Flight
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/search")));
		MobileElement searchFlight = (MobileElement) driver.findElementById("com.ba.mobile:id/search");
		searchFlight.click();
		//driver.findElementById("com.ba.mobile:id/search").click();
		
		//Swipe Left to see First Class Price
		//driver.swipe(500, 1400, 500, 200, 6000);
		
		//Select Outbound Flight
		String OutboundPrice = driver.findElementById("com.ba.mobile:id/flightPriceView1").getText();
		System.out.println("The Cost of Outbound Flight is " + OutboundPrice);
		driver.findElementById("com.ba.mobile:id/flightPriceView1").click();
		//Click Continue Button
		List<MobileElement> btns = driver.findElementsByClassName("android.widget.Button");
		if(btns.size()>1){
			driver.findElementById("com.ba.mobile:id/economy_standard_choose_btn").click();
		}else{
			driver.findElementById("com.ba.mobile:id/continueButton").click();
		}
		
		
		
		
		//Select Inbound Flight
		String InboundPrice = driver.findElementById("com.ba.mobile:id/flightPriceView1").getText();
		System.out.println("The Cost of Inbound Flight is " + InboundPrice);
		driver.findElementById("com.ba.mobile:id/flightPriceView1").click();
		//Click Continue Button
		List<MobileElement> btns1 = driver.findElementsByClassName("android.widget.Button");
		if(btns1.size()>1){
			driver.findElementById("com.ba.mobile:id/economy_standard_choose_btn").click();
		}else{
			driver.findElementById("com.ba.mobile:id/continueButton").click();
		}

		String TotalPrice = driver.findElementById("com.ba.mobile:id/totalPriceValue").getText();
		System.out.println("The Total Cost of the Flight is " + TotalPrice);		
		//Click Continue Button
		driver.findElementById("com.ba.mobile:id/continueBtn").click();
		
		//####################//
		//Add First Adult passenger 16+ years
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/view"))).click();
		//driver.findElementById("com.ba.mobile:id/view").click();
		//Title
		driver.findElementById("com.ba.mobile:id/titleEdit").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ba.mobile:id/list")));
		String mTitle = "Lord";
		List<MobileElement> titles = driver.findElementsById("com.ba.mobile:id/text");		
		for(MobileElement title: titles){
			if(title.getText().equals(mTitle)){
				title.click();
				break;
			}
		}
		//FirstName
		driver.findElementById("com.ba.mobile:id/firstNameEdit").click();
		driver.findElementById("com.ba.mobile:id/firstNameEdit").sendKeys("John");
		//LastName
		driver.findElementById("com.ba.mobile:id/lastNameEdit").click();
		driver.findElementById("com.ba.mobile:id/lastNameEdit").sendKeys("Blogg");
		//Frequent Flyer Club 
		driver.findElementById("com.ba.mobile:id/noTick").click();
		//Click Continue
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/continueButton"))).click();
		//driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		//####################//
		//Add Second Adult passenger 16+ years
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/view"))).click();
		//driver.findElementById("com.ba.mobile:id/view").click();
		//Title
		driver.findElementById("com.ba.mobile:id/titleEdit").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ba.mobile:id/list")));
		String fTitle = "Mrs";
		List<MobileElement> stitles = driver.findElementsById("com.ba.mobile:id/text");		
		for(MobileElement title: stitles){
			if(title.getText().equals(fTitle)){
				title.click();
				break;
			}
		}
		//FirstName
		driver.findElementById("com.ba.mobile:id/firstNameEdit").click();
		driver.findElementById("com.ba.mobile:id/firstNameEdit").sendKeys("Vera");
		//LastName
		driver.findElementById("com.ba.mobile:id/lastNameEdit").click();
		driver.findElementById("com.ba.mobile:id/lastNameEdit").sendKeys("Blogg");
		//Frequent Flyer Club 
		driver.findElementById("com.ba.mobile:id/noTick").click();
		//Click Continue
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/continueButton"))).click();
		
		//Continue to Children Page
		driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		//####################//
		//Add Young Adult passenger 12 - 15 years
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/view"))).click();
		//driver.findElementById("com.ba.mobile:id/view").click();
		//Title
		driver.findElementById("com.ba.mobile:id/titleEdit").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ba.mobile:id/list")));
		String maTitle = "Mr";
		List<MobileElement> atitles = driver.findElementsById("com.ba.mobile:id/text");		
		for(MobileElement title: atitles){
			if(title.getText().equals(maTitle)){
				title.click();
				break;
			}
		}
		//FirstName
		driver.findElementById("com.ba.mobile:id/firstNameEdit").click();
		driver.findElementById("com.ba.mobile:id/firstNameEdit").sendKeys("Kanye");
		//LastName
		driver.findElementById("com.ba.mobile:id/lastNameEdit").click();
		driver.findElementById("com.ba.mobile:id/lastNameEdit").sendKeys("Blogg");
		//DOB
		driver.findElementById("com.ba.mobile:id/dateOfBirthRL").click();
		List<MobileElement> DOBPickers = driver.findElementsById("android:id/numberpicker_input");
		for(MobileElement DOBPicker: DOBPickers){
			if(DOBPicker.getText().equals("Sep")){
				DOBPicker.click();
				DOBPicker.sendKeys("Mar");
			}else if(DOBPicker.getText().equals("07")){
				DOBPicker.click();
				DOBPicker.sendKeys("11");
			}else if(DOBPicker.getText().equals("2018")){
				DOBPicker.click();
				DOBPicker.sendKeys("2005");
				break;
			}
		}	
		//DOB OK Btn
		driver.findElementById("android:id/button1").click();	
		//Frequent Flyer Club 
		driver.findElementById("com.ba.mobile:id/noTick").click();
		//Click Continue
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/continueButton"))).click();
		//driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		//Continue to Child Page
		driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		//####################//
		//Add Child passenger 2 - 11 years
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/view"))).click();
		//driver.findElementById("com.ba.mobile:id/view").click();
		//Title
		driver.findElementById("com.ba.mobile:id/titleEdit").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ba.mobile:id/list")));
		String fdTitle = "Miss";
		List<MobileElement> sstitles = driver.findElementsById("com.ba.mobile:id/text");		
		for(MobileElement title: sstitles){
			if(title.getText().equals(fdTitle)){
				title.click();
				break;
			}
		}
		//FirstName
		driver.findElementById("com.ba.mobile:id/firstNameEdit").click();
		driver.findElementById("com.ba.mobile:id/firstNameEdit").sendKeys("Sam");
		//LastName
		driver.findElementById("com.ba.mobile:id/lastNameEdit").click();
		driver.findElementById("com.ba.mobile:id/lastNameEdit").sendKeys("Blogg");	
		//DOB
		driver.findElementById("com.ba.mobile:id/dateOfBirthRL").click();
		List<MobileElement> DOBPickers1 = driver.findElementsById("android:id/numberpicker_input");
		for(MobileElement DOBPicker: DOBPickers1){
			if(DOBPicker.getText().equals("Sep")){
				DOBPicker.click();
				DOBPicker.sendKeys("Aug");
			}else if(DOBPicker.getText().equals("07")){
				DOBPicker.click();
				DOBPicker.sendKeys("15");
			}else if(DOBPicker.getText().equals("2018")){
				DOBPicker.click();
				DOBPicker.sendKeys("2012");
				break;
			}
		}	
		//DOB OK Btn
		driver.findElementById("android:id/button1").click();
		
		//Frequent Flyer Club 
		driver.findElementById("com.ba.mobile:id/noTick").click();
		//Click Continue
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/continueButton"))).click();
		//driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		//Continue to Infant Page
		driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		
		//####################//
		//Add Infant passenger Under 2 years
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/view"))).click();
		//driver.findElementById("com.ba.mobile:id/view").click();
		//Title
		driver.findElementById("com.ba.mobile:id/titleEdit").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ba.mobile:id/list")));
		String bTitle = "Mstr";
		List<MobileElement> sbtitles = driver.findElementsById("com.ba.mobile:id/text");		
		for(MobileElement title: sbtitles){
			if(title.getText().equals(bTitle)){
				title.click();
				break;
			}
		}
		//FirstName
		driver.findElementById("com.ba.mobile:id/firstNameEdit").sendKeys("Jamie");
		//LastName
		driver.findElementById("com.ba.mobile:id/lastNameEdit").sendKeys("Blogg");
		
		//DOB
		driver.findElementById("com.ba.mobile:id/dateOfBirthRL").click();
		List<MobileElement> DOBPickers2 = driver.findElementsById("android:id/numberpicker_input");
		for(MobileElement DOBPicker: DOBPickers2){
			if(DOBPicker.getText().equals("Sep")){
				DOBPicker.click();
				DOBPicker.sendKeys("Nov");
			}else if(DOBPicker.getText().equals("07")){
				DOBPicker.click();
				DOBPicker.sendKeys("16");
			}else if(DOBPicker.getText().equals("2018")){
				DOBPicker.click();
				DOBPicker.sendKeys("2016");
				break;
			}
		}	
		//DOB OK Btn
		driver.findElementById("android:id/button1").click();
		
		//Frequent Flyer Club 
		driver.findElementById("com.ba.mobile:id/noTick").click();
		//Click Continue
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/continueButton"))).click();
		//driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		//Continue
		driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		//Paying Customer Selection Page
		List<MobileElement> pCustomers = driver.findElementsById("com.ba.mobile:id/paxName");
		for(MobileElement pCustomer: pCustomers){
			if(pCustomer.getText().equals("Lord John Blogg")){
				driver.findElementById("com.ba.mobile:id/radioButton").click();
				break;
			}
		}
		
		//Paying Customer Email
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ba.mobile:id/emailAddress"))).click();
		driver.findElementById("com.ba.mobile:id/emailAddress").sendKeys("john.blogg@applicationpoc.com");
		
		//Dialling Code
		//driver.findElementById("com.ba.mobile:id/dialingCode").click();
		
		//PhoneNumber
		//driver.findElementById("com.ba.mobile:id/phoneNumber").click();
		//driver.findElementById("com.ba.mobile:id/phoneNumber").sendKeys("7099990088");
		
		//Not Member of Business Programme
		driver.findElementById("com.ba.mobile:id/noTick").click();
		
		//Continue
		driver.findElementById("com.ba.mobile:id/continueButton").click();
		
		Thread.sleep(50000);
		driver.quit();
		service.stop();	
		//rt.exec("cmd /c start " + "C:\\Eclipse\\workspace\\BlueStacks.OneNote.Poc\\src\\test\\resources\\batch\\Stop_BlueStacks.bat");

	}

}
