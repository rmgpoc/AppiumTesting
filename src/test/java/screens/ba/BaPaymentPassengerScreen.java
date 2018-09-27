package screens.ba;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaPaymentPassengerScreen extends ScreenBase{

	public BaPaymentPassengerScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/noTick")
	public MobileElement notAFrequentFlyerMember;
	
	@AndroidFindBy(id="com.ba.mobile:id/paxView")
	public MobileElement payingCustomer;
	
	@AndroidFindBy(id="com.ba.mobile:id/emailAddress")
	public MobileElement email;
	
	@AndroidFindBy(id="com.ba.mobile:id/dialingCode")
	public MobileElement dialingCode;
	
	@AndroidFindBy(id="com.ba.mobile:id/text")
	public List<MobileElement> dialingCodeOptions;
	
	@AndroidFindBy(id="com.ba.mobile:id/phoneNumber")
	public MobileElement phoneNumber;
	
	public void selectPayingCustomer(){
		waitforElementPresence(5, "com.ba.mobile:id/paxView");
		payingCustomer.click();
	}
	
	public void inputPayingEmail(String pEmail){
		waitforElementPresence(5, "com.ba.mobile:id/emailAddress");
		email.click();
		email.sendKeys(pEmail);
	}
	
	public void selectDialingCode(String dialCode){
		dialingCode.click();
		waitforElementPresence(5, "com.ba.mobile:id/text");
		for(MobileElement dialingCodeOption: dialingCodeOptions){
			if(dialingCodeOption.getText().equals(dialCode)){
				dialingCodeOption.click();
				break;
			}
		}
	}
	
	public void inputPayingPhoneNumber(String pNumber){
		waitforElementPresence(5, "com.ba.mobile:id/phoneNumber");
		phoneNumber.click();
		phoneNumber.sendKeys(pNumber);
	}
	
/*	public void addPayingCustomerDetails(String pEmail){
		selectPayingCustomer();
		inputPayingEmail(pEmail);
		hideKeyboard();
		//selectDialingCode(dialCode);
		//hideKeyboard();
		//inputPayingPhoneNumber(pNumber);
		//hideKeyboard();
		//frequentFlyerOption();
		//clickContinueButton();
	}*/

}
