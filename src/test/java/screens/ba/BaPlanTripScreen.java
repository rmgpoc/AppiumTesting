package screens.ba;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaPlanTripScreen extends ScreenBase {

	public BaPlanTripScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.ba.mobile:id/departureLL")
	public MobileElement departureBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/departureLabel")
	public MobileElement departureLabel;
	
	@AndroidFindBy(id = "com.ba.mobile:id/message")
	public MobileElement messageLatestPriceLoad;
	
	@AndroidFindBy(id="com.ba.mobile:id/arrivalLL")
	public MobileElement arrivalBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/arrivalLabel")
	public MobileElement arrivalLabel;
	
	@AndroidFindBy(id="com.ba.mobile:id/filterText")
	public MobileElement inputField;
	
	@AndroidFindBy(id="com.ba.mobile:id/airportName")
	public MobileElement acceptAirportEntered;
	
	@AndroidFindBy(id="com.ba.mobile:id/tripTypeLL")
	public MobileElement journeyType;
	
	@AndroidFindBy(id="com.ba.mobile:id/tripTypeLabel")
	public MobileElement journeyTypeText;
	
	@AndroidFindBy(id="com.ba.mobile:id/outboundDateLL")
	public MobileElement outboundTravelDateBtn;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.view.View/android.view.View[2]/android.widget.FrameLayout[1]/android.widget.TextView")
	public MobileElement hardCodedOutboundTravelDate;
	
	@AndroidFindBy(id="com.ba.mobile:id/inboundDateLL")
	public MobileElement inboundTravelDateBtn;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.view.View/android.view.View[6]/android.widget.FrameLayout[3]/android.widget.TextView")
	public MobileElement hardCodedInboundTravelDate;
	
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
		
	@AndroidFindBy(id="com.ba.mobile:id/classTypeLL")
	public MobileElement classTypeBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/classTypeLabel")
	public MobileElement classTypeLabel;
		
	@AndroidFindBy(id="com.ba.mobile:id/ticketTypeLL")
	public MobileElement ticketTypeBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/ticketTypeLabel")
	public MobileElement ticketTypeLabel;
	
	@AndroidFindBy(id="com.ba.mobile:id/text")
	public List<MobileElement> selectOptions;
		
//	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ba.mobile:id/search\")")
//	public MobileElement searchFlyBtn;
	
	@AndroidFindBy(id="com.ba.mobile:id/search")
	public MobileElement searchFlightBtn;
	
/*	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button")
	public MobileElement searchFlightButton;
	
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
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement okBtn;
	
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
	public MobileElement phoneNumber;*/
	
//	@AndroidFindBy(id="com.ba.mobile:id/phoneNumber")
//	public MobileElement phoneNumber;
	
	public void messageLatestPriceLoad(){
		waitforElementPresence(5, "com.ba.mobile:id/message");
	}
		
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
		Assert.assertTrue(departureLabel.getText().contains(outboundAirportName), "Outbound Airport entered is incorrect");
	}
	
	public void arrivalFlight(String inboundAirportName){
		arrivalBtn();
		clickInputField();
		InputInboundField(inboundAirportName);
		acceptAirportEntered();
		Assert.assertTrue(arrivalLabel.getText().contains(inboundAirportName), "Inbound Airport entered is incorrect");
	}
	
	public void selectJourneyType(String journeyTypeInput){
		String journeyTypeState = String.valueOf(journeyTypeText.getText());
		if(journeyTypeState.equals(journeyTypeInput)){
			waitforElementPresence(20, "com.ba.mobile:id/tripTypeLL");
			log.debug("Ticket Required is a " + journeyTypeInput + " Ticket");
			Assert.assertTrue(journeyTypeText.getText().contains(journeyTypeInput), "Journey Type entered is incorrect");
		}else{
			waitforElementPresence(20, "com.ba.mobile:id/tripTypeLL");
			journeyType.click();
			log.debug("Ticket Required is a " + journeyTypeInput + " Ticket");
			Assert.assertTrue(journeyTypeText.getText().contains(journeyTypeInput), "Journey Type entered is incorrect");
		}
	}
	
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
			clickOutboundTravelDate();
			doneBtn();			
		}
		
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
		for(int i=1; i<adultCount; i++){
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
		for(int i=0; i<youngAdultCount; i++){
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
		for(int i=0; i>childCount; i++){
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
		for(int i=0; i<infantCount; i++){
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
	
	public void selectClassType(String classTypeOption){
		waitforElementClickable(5, "com.ba.mobile:id/classTypeLL");
		classTypeBtn.click();		
		for(MobileElement selectOption: selectOptions){
			if(selectOption.getText().equals(classTypeOption)){
				selectOption.click();
				break;
			}
		}
		Assert.assertTrue(classTypeLabel.getText().contains(classTypeOption), "Class Type entered is incorrect");
	}
	
	public void selectTicketType(String ticketTypeOption){
		waitforElementClickable(5, "com.ba.mobile:id/ticketTypeLL");
		ticketTypeBtn.click();		
		for(MobileElement selectOption: selectOptions){
			if(selectOption.getText().equals(ticketTypeOption)){
				selectOption.click();
				break;
			}
		}
		Assert.assertTrue(ticketTypeLabel.getText().contains(ticketTypeOption), "Ticket Type entered is incorrect");
	}
	
	public void searchFlightBtn(){
		waitforElementClickable(5, "com.ba.mobile:id/search");
		searchFlightBtn.click();
		//searchFlyBtn.click();
	}
/*	
	public void logAndSelectFlightPrice(){
		waitforElementClickable(10, "com.ba.mobile:id/flightPriceView1");
		log.debug("Flight Price in one direction is "+flightPriceBtn.getText());
		flightPriceBtn.click();
	}
	
	public void clickContinueButton(){
		if(continueOptionBtn.size()>1){
			waitforElementClickable(5, "com.ba.mobile:id/economy_standard_choose_btn");
			standardEconomyPriceBtn.click();
		}else{
			waitforElementClickable(5, "com.ba.mobile:id/continueButton");
			continueButton.click();
		}
	}
	
	public void clickContinueBtn(){
			waitforElementClickable(5, "com.ba.mobile:id/continueBtn");
			continueBtn.click();
	}
	
	public void outboundFlightPrice(){
		logAndSelectFlightPrice();
		clickContinueButton();
	}
	
	public void inboundFlightPrice(){
		logAndSelectFlightPrice();
		clickContinueButton();
	}
	
	public void displayTotalFlightCost(){
		log.debug("Total Flight cost is "+totalFlightPrice.getText());
		clickContinueBtn();
	}
	
	public void addPassengerDetailsBtn(){
		waitforElementClickable(5, "com.ba.mobile:id/view");
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
		TouchAction action = new TouchAction(driver);
		dob.click();
		for(MobileElement dobPicker: dobPickers){
			if(dobPicker.getText().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd")))){
				dobPicker.click();
				action.press(283,1151).moveTo(283, 634).release().perform();
				action.press(283,1151).moveTo(283, 837).release().perform();
				//driver.getKeyboard().sendKeys(day);
				//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/numberpicker_input\")).scrollIntoView(new UiSelector().textContains(\""+day+"\"))")).click();
				//dobPicker.sendKeys(day);
				//dobPicker.pressKeyCode(66);
				//driver.pressKeyCode(AndroidKeyCode.BACK);
			}else if(dobPicker.getText().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM")))){
				dobPicker.click();
				action.press(521,1151).moveTo(521, 634).release().perform();
				//driver.getKeyboard().sendKeys(month);
				//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/numberpicker_input\")).scrollIntoView(new UiSelector().textContains(\""+month+"\"))")).click();
				//dobPicker.sendKeys(month);
			}else if(dobPicker.getText().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy")))){
				dobPicker.click();
				action.press(760,634).moveTo(760, 1151).release().perform();
				action.press(760,634).moveTo(760, 1151).release().perform();
				action.press(760,634).moveTo(760, 1151).release().perform();
				action.press(760,634).moveTo(760, 1151).release().perform();
				action.press(760,634).moveTo(760, 1151).release().perform();
				action.press(760,634).moveTo(760, 1151).release().perform();
				//driver.getKeyboard().sendKeys(year);
				hideKeyboard();
				//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/numberpicker_input\")).scrollIntoView(new UiSelector().textContains(\""+year+"\"))")).click();				
				//dobPicker.sendKeys(year);
				break;
			}
		}
		okBtn.click();
	}
	
	public void frequentFlyerOption(){
		notAFrequentFlyerMember.click();
	}
	
	public void addPassengerDetails(String tOption, String fName, String lName, String year, String month, String day){
		addPassengerDetailsBtn();
		clickEditTitleBtn();
		selectTitleOption(tOption);
		inputFirstName(fName);
		inputLastName(lName);
		//"Add adult passenger", "Add young adult passenger", "Add child passenger", "Add infant passenger"
		if(addPaxTitle.getText().contains("Add adult passenger")){
			log.debug("Date of Birth not required for " + fName + " " + lName);
		}else if(addPaxTitle.getText().contains("Add child passenger")){
			log.debug("Date of Birth not required for " + fName + " " + lName);
		}else{
			dobTouch();
			//inputDOB(year,month,day);
		}
		hideKeyboard();
		frequentFlyerOption();
		clickContinueButton();
	}
	//int adultCount, int youngAdultCount, int childCount, int infantCount
	public void addAdultPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day);
		}
		clickContinueButton();
	}
	
	public void addYoungAdultPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day);
		}
		if(count == 0){
			System.out.println("No Young Adult Passenger");
		}else{
			clickContinueButton();
		}		
	}
	
	public void addChildPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day);
		}
		if(count == 0){
			System.out.println("No Child Passenger");
		}else{
			clickContinueButton();
		}	
	}
	
	public void addInfantPassengerCountDetails(int count, String tOption, String fName, String lName, String year, String month, String day){
		for(int i=0; i<count; i++){
			addPassengerDetails(tOption, fName, lName, year, month, day);
		}
		if(count == 0){
			System.out.println("No Infant Passenger");
		}else{
			clickContinueButton();
		}	
	}
	
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
	
	public void addPayingCustomerDetails(String pEmail){
		selectPayingCustomer();
		inputPayingEmail(pEmail);
		hideKeyboard();
		//selectDialingCode(dialCode);
		//hideKeyboard();
		//inputPayingPhoneNumber(pNumber);
		//hideKeyboard();
		//frequentFlyerOption();
		//clickContinueButton();
	}

	*/
}
