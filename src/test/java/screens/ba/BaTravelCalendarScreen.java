package screens.ba;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaTravelCalendarScreen extends ScreenBase{

	public BaTravelCalendarScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/outboundDateLL")
	public MobileElement outboundTravelDateBtn;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.view.View/android.view.View[4]/android.widget.FrameLayout[1]/android.widget.TextView")
	public MobileElement hardCodedOutboundTravelDate;
	
	@AndroidFindBy(id="com.ba.mobile:id/inboundDateLL")
	public MobileElement inboundTravelDateBtn;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.view.View/android.view.View[6]/android.widget.FrameLayout[3]/android.widget.TextView")
	public MobileElement hardCodedInboundTravelDate;
	
	@AndroidFindBy(id="com.ba.mobile:id/doneFilter")
	public MobileElement doneBtn;
	
	public void clickOutboundTravelDateBtn(){
		outboundTravelDateBtn.click();
	}
	
	public void clickInboundTravelDateBtn(){
		inboundTravelDateBtn.click();
	}
	
	public void clickOutboundTravelDate(){
		hardCodedOutboundTravelDate.click();
	}
	
	public void clickInboundTravelDate(){
		hardCodedInboundTravelDate.click();
	}
	
	public void doneBtn(){
		doneBtn.click();
	}
	
	public void travelDate(String journeyTypeInput){
		if(journeyTypeInput=="Return"){
			clickOutboundTravelDateBtn();
			clickOutboundTravelDate();
			clickInboundTravelDate();
			doneBtn();			
		}else{
			clickOutboundTravelDateBtn();
			clickInboundTravelDate();
			doneBtn();			
		}
		
	}

}
