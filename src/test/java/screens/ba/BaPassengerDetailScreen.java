package screens.ba;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaPassengerDetailScreen extends ScreenBase{

	public BaPassengerDetailScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/view")
	public MobileElement addPassengerDetailsBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/titleEdit")
	public MobileElement editTitleBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/list")
	public MobileElement displayedList;
	
	@AndroidFindBy(id="com.ba.mobile:id/text")
	public List<MobileElement> optionsList;
	
	@AndroidFindBy(id="com.ba.mobile:id/firstNameEdit")
	public MobileElement firstName;
	
	@AndroidFindBy(id="com.ba.mobile:id/lastNameEdit")
	public MobileElement lastName;
	
	@AndroidFindBy(id="com.ba.mobile:id/dateOfBirthRL")
	public MobileElement dob;
	
	@AndroidFindBy(id="com.ba.mobile:id/addPaxTitle")
	public MobileElement addPaxTitle;	
	
	@AndroidFindBy(id="android:id/numberpicker_input")
	public List<MobileElement> dobPickers;
	
	@AndroidFindBy(id="com.ba.mobile:id/maleTick")
	public MobileElement maleBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/femaleTick")
	public MobileElement femaleBtn;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement okBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/noTick")
	public MobileElement notAFrequentFlyerMember;
	
	@AndroidFindBy(id="com.ba.mobile:id/yesTick")
	public MobileElement aFrequentFlyerMember;
	
	@AndroidFindBy(id="com.ba.mobile:id/freqFlyerProgramme")
	public MobileElement flyerProgramme;
	
	@AndroidFindBy(id="com.ba.mobile:id/text")
	public List<MobileElement> flyerProgrammes;
	
	@AndroidFindBy(id="com.ba.mobile:id/programNumber")
	public MobileElement flyerProgrammeNumber;	
	
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
	
	public void clickContinueButton(){
		if(continueOptionBtn.size()>1){
			waitforElementClickable(5, "com.ba.mobile:id/economy_standard_choose_btn");
			standardEconomyPriceBtn.click();
		}else{
			waitforElementClickable(5, "com.ba.mobile:id/continueButton");
			continueButton.click();
		}
	}
	
	public void addPassengerDetailsBtn(){
		waitforElementClickable(10, "com.ba.mobile:id/view");
		addPassengerDetailsBtn.click();
	}
	
	public void clickEditTitleBtn(){
		editTitleBtn.click();
		waitforElementPresence(5, "com.ba.mobile:id/list");
	}
	
	public void selectTitleOption(String tOption){
		for(MobileElement optionList: optionsList){
			if(optionList.getText().equals(tOption)){
				optionList.click();
				break;
			}
		}
	}
	
	public void inputFirstName(String fName){
		firstName.click();
		firstName.sendKeys(fName);
	}
	
	public void inputLastName(String lName){
		lastName.click();
		lastName.sendKeys(lName);
	}
	
	public void dobTouch(){
		TouchAction action = new TouchAction(driver);
		dob.click();
		action.press(283,1151).moveTo(283, 634).release().perform();
		action.press(283,1151).moveTo(283, 837).release().perform();
		action.press(521,1151).moveTo(521, 634).release().perform();
		action.press(760,634).moveTo(760, 1151).release().perform();
		action.press(760,634).moveTo(760, 1151).release().perform();
		action.press(760,634).moveTo(760, 1151).release().perform();
		action.press(760,634).moveTo(760, 1151).release().perform();
		action.press(760,634).moveTo(760, 1151).release().perform();
		action.press(760,634).moveTo(760, 1151).release().perform();
		okBtn.click();
	}
	
	public void inputDOB(String year, String month, String day){
		dob.click();
		for(MobileElement dobPicker: dobPickers){
			//if(dobPicker.getText().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd")))){
			if(dobPicker.getText()==LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd"))){
				log.debug(dobPicker.getText());
				dobPicker.click();
				dobPicker.clear();
				dobPicker.sendKeys(day);
				//driver.getKeyboard().sendKeys(year);
			//}else if(dobPicker.getText().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM")))){
			}else if(dobPicker.getText()==LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM"))){
				log.debug(dobPicker.getText());
				dobPicker.click();
				dobPicker.clear();
				dobPicker.sendKeys(month);
				//driver.getKeyboard().sendKeys(month);
			//}else if(dobPicker.getText().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy")))){
			}else if(dobPicker.getText()==LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"))){
				log.debug(dobPicker.getText());
				dobPicker.click();
				dobPicker.clear();
				dobPicker.sendKeys(year);
				//driver.getKeyboard().sendKeys(day);
				//dobPicker.pressKeyCode(66);
				//driver.pressKeyCode(AndroidKeyCode.BACK);
				hideKeyboard();
				break;
			}
		}
		okBtn.click();
	}
	
	public void selectFlyerProgramme(String flyerProgrammeName){
		for(MobileElement flyerProgramme: flyerProgrammes){
			if(flyerProgramme.getText().equals(flyerProgrammeName)){
				flyerProgramme.click();
				break;
			}
		}
	}
	
	public void frequentFlyerOption(String frequentFlyerMember, String flyerProgrammeName, String flyerMemberNumber){
		if(frequentFlyerMember == "No" || frequentFlyerMember == null){
			notAFrequentFlyerMember.click();
		}else{
			aFrequentFlyerMember.click();
			waitforElementPresence(5, "com.ba.mobile:id/freqFlyerProgramme");
			flyerProgramme.click();
			selectFlyerProgramme(flyerProgrammeName);
			flyerProgrammeNumber.sendKeys(flyerMemberNumber);
		}
		
	}
	
	public void genderOption(String gender){
		if(gender == "Male"){
			maleBtn.click();
		}else{
			femaleBtn.click();
		}
	}
	
	public void addPassengerDetails(String tOption, String fName, String lName, String year, String month, String day, String gender, String frequentFlyerMember, String flyerProgrammeName, String flyerMemberNumber){
		addPassengerDetailsBtn();
		clickEditTitleBtn();
		selectTitleOption(tOption);
		inputFirstName(fName);
		inputLastName(lName);
		//"Add adult passenger", "Add young adult passenger", "Add child passenger", "Add infant passenger"
		//if(addPaxTitle.getText().contains("Add adult passenger")){=
		try{
			if(!driver.findElementById("com.ba.mobile:id/dateOfBirthRL").isDisplayed()){
				log.debug("Date of Birth not required for " + fName + " " + lName);
			}else{
				inputDOB(year,month,day);
			}
		} catch(NoSuchElementException e){
			e.printStackTrace();
		}
/*		if(!driver.findElementById("com.ba.mobile:id/dateOfBirthRL").isDisplayed()){
			log.debug("Date of Birth not required for " + fName + " " + lName);
//		}else if(addPaxTitle.getText().contains("Add child passenger")){
//			log.debug("Date of Birth not required for " + fName + " " + lName);
		}else{
			//dobTouch();
			inputDOB(year,month,day);
		}*/
		try{
			if(!driver.findElementById("com.ba.mobile:id/dateOfBirthRL").isDisplayed()){
				hideKeyboard();
			}else{
				log.debug("SoftKeyboard not displayed");
			}
		} catch(NoSuchElementException e){
			e.printStackTrace();
		}
		try{
			if(!driver.findElementById("com.ba.mobile:id/maleTick").isDisplayed()){
				log.debug("Gender Selection not Displayed");
			}else{
				genderOption(gender);
			}
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		/*if(!driver.findElementById("com.ba.mobile:id/maleTick").isDisplayed()){
			log.debug("Gender Selection not Displayed");
		}else{
			genderOption(gender);
		}*/
		frequentFlyerOption(frequentFlyerMember, flyerProgrammeName, flyerMemberNumber);
		clickContinueButton();
	}
	//int adultCount, int youngAdultCount, int childCount, int infantCount
	public void addAdultPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day, String gender, String frequentFlyerMember, String flyerProgrammeName, String flyerMemberNumber){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day, gender, frequentFlyerMember, flyerProgrammeName, flyerMemberNumber);
		}
		clickContinueButton();
	}
	
	public void addYoungAdultPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day, String gender, String frequentFlyerMember, String flyerProgrammeName, String flyerMemberNumber){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day, gender, frequentFlyerMember, flyerProgrammeName, flyerMemberNumber);
		}
		if(count == 0){
			System.out.println("No Young Adult Passenger");
		}else{
			clickContinueButton();
		}		
	}
	
	public void addChildPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day, String gender, String frequentFlyerMember, String flyerProgrammeName, String flyerMemberNumber){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day, gender, frequentFlyerMember, flyerProgrammeName, flyerMemberNumber);
		}
		if(count == 0){
			System.out.println("No Child Passenger");
		}else{
			clickContinueButton();
		}	
	}
	
	public void addInfantPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day, String gender, String frequentFlyerMember, String flyerProgrammeName, String flyerMemberNumber){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day, gender, frequentFlyerMember, flyerProgrammeName, flyerMemberNumber);
		}
		if(count == 0){
			System.out.println("No Infant Passenger");
		}else{
			clickContinueButton();
		}	
	}

}
