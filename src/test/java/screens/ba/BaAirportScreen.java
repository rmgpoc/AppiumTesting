package screens.ba;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaAirportScreen extends ScreenBase{

	public BaAirportScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/departureLL")
	public MobileElement departureBtn;
	
	@AndroidFindBy(id = "com.ba.mobile:id/message")
	public MobileElement messageLatestPriceLoad;
	
	@AndroidFindBy(id="com.ba.mobile:id/arrivalLL")
	public MobileElement arrivalBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/filterText")
	public MobileElement inputField;
	
	@AndroidFindBy(id="com.ba.mobile:id/airportName")
	public MobileElement acceptAirportEntered;
	
	public void departureBtn(){
		waitforElementPresence(20, "com.ba.mobile:id/departureLL");
		departureBtn.click();
	}

	public void arrivalBtn(){
		waitforElementClickable(5, "com.ba.mobile:id/arrivalLL");
		arrivalBtn.click();
	}

	public void clickInputField(){
		inputField.click();
	}

	public void InputOutboundField(String outboundAirportName){
		inputField.sendKeys(outboundAirportName);
	}

	public void InputInboundField(String inboundAirportName){
		inputField.sendKeys(inboundAirportName);
	}

	public void acceptAirportEntered(){
		acceptAirportEntered.click();
	}

	public void departureFlight(String outboundAirportName){
		departureBtn();
		clickInputField();
		InputOutboundField(outboundAirportName);
		acceptAirportEntered();
	}

	public void arrivalFlight(String inboundAirportName){
		arrivalBtn();
		clickInputField();
		InputInboundField(inboundAirportName);
		acceptAirportEntered();
	}

}
