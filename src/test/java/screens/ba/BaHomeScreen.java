package screens.ba;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaHomeScreen extends ScreenBase {

	public BaHomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/tickImage")
	public MobileElement advertBtn;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public MobileElement menuIconBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/label")
	public List<MobileElement> menuBtns;
	
	@AndroidFindBy(id="com.ba.mobile:id/button1")
	public MobileElement bookFlightBtn;

	@AndroidFindBy(id="com.ba.mobile:id/button2")
	public MobileElement logInBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/button3")
	public MobileElement findBookingBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/lppy_image1")
	public MobileElement rtnFareImg1;
	
	@AndroidFindBy(id="com.ba.mobile:id/lppy_image2")
	public MobileElement rtnFareImg2;
	
	@AndroidFindBy(id="com.ba.mobile:id/topDestinationsShowMore")
	public MobileElement showMoreTopDestBtn;
	
	public void advertBtn(){
		waitforElementPresence(5, "com.ba.mobile:id/tickImage");
		advertBtn.click();
	}
	
	public void menuIconBtn(){
		waitforEleClassNamePresence(25, "android.widget.ImageButton");
		menuIconBtn.click();
	}
	
	public void menuHomeBtn(){
		waitforElementPresence(5, "com.ba.mobile:id/label");
		for(MobileElement menuBtn: menuBtns){
			if(menuBtn.getText().equals("Home")){
				menuBtn.click();
				break;
			}
		}
			
	}
	
	public void bookFlightHomePage(){
		try{
			if(!bookFlightBtn.isDisplayed()){
				menuIconBtn();
				menuHomeBtn();
			}else{
				log.debug("Already on Book Flight Homepage");			
			}
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}	
	}
	
	public void bookFlightBtn() throws InterruptedException{
				waitforElementClickable(25, "com.ba.mobile:id/button1");
				bookFlightBtn.click();	
				Thread.sleep(15000);
	}
	
	public void logInBtn(){
		logInBtn.click();
	}
	
	public void findBookingBtn(){
		findBookingBtn.click();
	}
	
	public void rtnFareImg1(){
		rtnFareImg1.click();
	}
	
	public void rtnFareImg2(){
		rtnFareImg2.click();
	}
	
	public void showMoreTopDestBtn(){
		showMoreTopDestBtn.click();
	}

}
