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

public class BaFlightCostScreen extends ScreenBase{

	public BaFlightCostScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/flightPriceView1")
	public MobileElement flightPriceBtn;
	
	@AndroidFindBy(id="android.widget.Button")
	public List<MobileElement> continueOptionBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/economy_standard_choose_btn")
	public MobileElement standardEconomyPriceBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/economy_basic_choose_btn")
	public MobileElement basicEconomyPriceBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/continueButton")
	public MobileElement continueButton;
	
	@AndroidFindBy(id="com.ba.mobile:id/continueBtn")
	public MobileElement continueBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/totalPriceValue")
	public MobileElement totalFlightPrice;
	
	@AndroidFindBy(id="com.ba.mobile:id/button")
	public MobileElement fareAlertBtn;
	
	public void logAndSelectFlightPrice(){
				waitforElementClickable(10, "com.ba.mobile:id/flightPriceView1");
				log.debug("Flight Price in one direction is "+flightPriceBtn.getText());
				flightPriceBtn.click();
	}
	
	public void clickContinueButton(){
		try{
			if(continueOptionBtn.size()>1){
				waitforElementClickable(5, "com.ba.mobile:id/economy_standard_choose_btn");
				standardEconomyPriceBtn.click();
			}else if(continueButton.isDisplayed()){
				waitforElementClickable(5, "com.ba.mobile:id/continueButton");
				continueButton.click();
			}else{
				log.debug("Continue Button not displayed");
			}
			
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	public void clickContinueBtn(){
			waitforElementClickable(5, "com.ba.mobile:id/continueBtn");
			continueBtn.click();
	}
	
	public void outboundFlightPrice(String journeyType){
		if(journeyType == "Return"){
			logAndSelectFlightPrice();
			clickContinueButton();
		}else{
			logAndSelectFlightPrice();
			clickContinueButton();
		}
		
	}
	
	public void inboundFlightPrice(String journeyType){
		if(journeyType == "Return"){
			logAndSelectFlightPrice();
			clickContinueButton();
		}else{
			log.debug("One way Flight.");
		}
	}
	
	public void displayTotalFlightCost(String journeyType){
		if(journeyType == "Return"){
			waitforElementPresence(10, "com.ba.mobile:id/totalPriceValue");
			log.debug("Total Flight cost is "+totalFlightPrice.getText());
			clickContinueBtn();
		}else if (journeyType == "One way"){
			log.debug("Total Flight cost is the same as Flight Price in one direction");
			clickContinueBtn();
		}
	}

}
