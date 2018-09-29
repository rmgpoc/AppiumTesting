package screens.ba;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaPassengerCountScreen extends ScreenBase{

	public BaPassengerCountScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/doneFilter")
	public MobileElement doneBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/passengersLL")
	public MobileElement addPassengerNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/adultCount")
	public MobileElement adultCountText;
	
	@AndroidFindBy(id="com.ba.mobile:id/adultAddButton")
	public MobileElement addAdultNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/adultMinusButton")
	public MobileElement minusAdultNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/youngAdultCount")
	public MobileElement youngAdultCountText;
	
	@AndroidFindBy(id="com.ba.mobile:id/youngAdultAddButton")
	public MobileElement addYoungAdultNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/youngAdultMinusButton")
	public MobileElement minusYoungAdultNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/childCount")
	public MobileElement childCountText;
	
	@AndroidFindBy(id="com.ba.mobile:id/childAddButton")
	public MobileElement addChildNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/childMinusButton")
	public MobileElement minusChildNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/infantCount")
	public MobileElement infantCountText;
	
	@AndroidFindBy(id="com.ba.mobile:id/infantAddButton")
	public MobileElement addInfantNumberBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/infantMinusButton")
	public MobileElement minusInfantNumberBtn;
	
	public void doneBtn(){
		doneBtn.click();
	}
	
	public void addPassengerCountBtn(){
		addPassengerNumberBtn.click();
	}
	
	public void addAdultNumber(int adultCount){
		int countAdult = Integer.parseInt(adultCountText.getText());
		if (countAdult<adultCount){
			addAdultNumberBtn(adultCount);
		}else if (countAdult>adultCount){
			minusAdultNumberBtn(adultCount);
		}
	}
	
	public void addAdultNumberBtn(int adultCount){
		waitforElementPresence(5, "com.ba.mobile:id/adultAddButton");
			for(int i=1; i<adultCount; i++){
				addAdultNumberBtn.click();			
			}

	}
	
	public void minusAdultNumberBtn(int adultCount){
		waitforElementPresence(5, "com.ba.mobile:id/adultMinusButton");
		int countAdult = Integer.parseInt(adultCountText.getText());
		for(int i=countAdult; i>adultCount; i--){
			minusAdultNumberBtn.click();			
		}		
	}
	
	public void addYoungAdultNumber(int youngAdultCount){
		int countYoungAdult = Integer.parseInt(youngAdultCountText.getText());
		if (countYoungAdult<youngAdultCount){
			addYoungAdultNumberBtn(youngAdultCount);
		}else if (countYoungAdult>youngAdultCount){
			minusYoungAdultNumberBtn(youngAdultCount);
		}
	}
	
	public void addYoungAdultNumberBtn(int youngAdultCount){
		waitforElementPresence(5, "com.ba.mobile:id/youngAdultAddButton");
		for(int i=0; i<youngAdultCount; i++){
			addYoungAdultNumberBtn.click();
		}
	}
	
	public void minusYoungAdultNumberBtn(int youngAdultCount){
		waitforElementPresence(5, "com.ba.mobile:id/youngAdultMinusButton");
		int countYoungAdult = Integer.parseInt(youngAdultCountText.getText());
		for(int i=countYoungAdult; i>youngAdultCount; i--){
			minusYoungAdultNumberBtn.click();
		}
		
	}
	
	public void addChildNumber(int childCount){
		int countChild = Integer.parseInt(childCountText.getText());
		if (countChild<childCount){
			addChildNumberBtn(childCount);
		}else if (countChild>childCount){
			minusChildNumberBtn(childCount);
		}
	}
	
	public void addChildNumberBtn(int childCount){
		waitforElementPresence(5, "com.ba.mobile:id/childAddButton");
		for(int i=0; i<childCount; i++){
			addChildNumberBtn.click();
		}
	}
	
	public void minusChildNumberBtn(int childCount){
		waitforElementPresence(5, "com.ba.mobile:id/childMinusButton");
		int countChild = Integer.parseInt(childCountText.getText());
		for(int i=countChild; i>childCount; i--){
			minusChildNumberBtn.click();
		}
	}
	
	public void addInfantNumber(int infantCount){
		int countInfant = Integer.parseInt(infantCountText.getText());
		if (countInfant<infantCount){
			addInfantNumberBtn(infantCount);
		}else if (countInfant>infantCount){
			minusInfantNumberBtn(infantCount);
		}
	}
	
	public void addInfantNumberBtn(int infantCount){
		waitforElementPresence(5, "com.ba.mobile:id/infantAddButton");
		for(int i=0; i<infantCount; i++){
			addInfantNumberBtn.click();
		}
	}
	
	public void minusInfantNumberBtn(int infantCount){
		waitforElementPresence(5, "com.ba.mobile:id/infantAddButton");
		int countInfant = Integer.parseInt(infantCountText.getText());
		for(int i=countInfant; i>infantCount; i--){
			minusInfantNumberBtn.click();
		}
	}
	
	public void addPassengerCount(int adultCount, int youngAdultCount, int childCount, int infantCount){
		addPassengerCountBtn();
		addAdultNumber(adultCount);
		addYoungAdultNumber(youngAdultCount);
		addChildNumber(childCount);
		addInfantNumber(infantCount);
		doneBtn();
	}

}
