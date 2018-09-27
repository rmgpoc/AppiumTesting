package testcases.ba;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.ba.BaAirportScreen;
import screens.ba.BaFlightCostScreen;
import screens.ba.BaHomeScreen;
import screens.ba.BaPassengerCountScreen;
import screens.ba.BaPassengerDetailScreen;
import screens.ba.BaPaymentPassengerScreen;
import screens.ba.BaPlanTripScreen;
import screens.ba.BaTravelCalendarScreen;
import utility.CommonUtils;

public class baPlanTripTest extends TestBase {
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	 String baAppPackageName="com.ba.mobile";
	 String baAppActivityName="com.ba.mobile.activity.launch.LaunchActivity";
	
	BaHomeScreen baHome;
	BaPlanTripScreen baTrip;
	BaAirportScreen baAirport;
	BaTravelCalendarScreen baTravelDate;
	BaPassengerCountScreen baPassengerCount;
	BaFlightCostScreen baFlightCost;
	BaPassengerDetailScreen baPassengerDetail;
	BaPaymentPassengerScreen baPaymentPassenger;
	
	@BeforeTest
	public void init() throws InterruptedException, IOException{
		baHome = new BaHomeScreen(driver);
		baTrip = new BaPlanTripScreen(driver);
		baAirport = new BaAirportScreen(driver);
		baTravelDate = new BaTravelCalendarScreen(driver);
		baPassengerCount = new BaPassengerCountScreen(driver);
		baFlightCost = new BaFlightCostScreen(driver);
		baPassengerDetail = new BaPassengerDetailScreen(driver);
		baPaymentPassenger = new BaPaymentPassengerScreen(driver);
	}
	
	@Test(priority=1)
	public void oneAdultOneChildRtn(ITestContext context) throws InterruptedException{
		log.debug("########Executing TC1 - Purchase One Adult One Child Return Ticket TestCase########");
		baHome.bookFlightHomePage();
		baHome.bookFlightBtn();
		baAirport.departureFlight("LHR");
		baAirport.arrivalFlight("KUL");
		baTrip.selectJourneyType("Return");
		baTravelDate.travelDate("Return");
		baPassengerCount.addPassengerCount(1, 0, 1, 0);
		baTrip.selectClassType("Economy");
		baTrip.selectTicketType("Flexible ticket");
		baTrip.searchFlightBtn();
		baFlightCost.outboundFlightPrice("Return");
		baFlightCost.inboundFlightPrice("Return");
		baFlightCost.displayTotalFlightCost("Return");
		baPassengerDetail.addAdultPassengerCountDetails(1, "Lord", "Martin", "King", null, null, null, null, "No", null, null);
		baPassengerDetail.addYoungAdultPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPassengerDetail.addChildPassengerCountDetails(1, "Mstr", "Jamie", "Blogg", null, null, null, null, "No", null, null);
		baPassengerDetail.addInfantPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPaymentPassenger.selectPayingCustomer();
		baHome.menuIconBtn();
		baHome.menuHomeBtn();
		log.debug("########Completed Execution of TC1 - Purchase One Adult One Child Return Ticket TestCase########");
	}
	
	@Test(priority=2)
	public void oneAdultOneWay(ITestContext context) throws InterruptedException{
		log.debug("########Executing TC2 - Purchase One Adult One way Ticket TestCase########");
		baHome.bookFlightHomePage();
		baHome.bookFlightBtn();
		baAirport.departureFlight("LHR");
		baAirport.arrivalFlight("DMM");
		baTrip.selectJourneyType("One way");
		baTravelDate.travelDate("One way");
		baPassengerCount.addPassengerCount(1, 0, 0, 0);
		baTrip.selectClassType("Business");
		baTrip.selectTicketType("Flexible ticket");
		baTrip.searchFlightBtn();
		baFlightCost.outboundFlightPrice("One way");
		baFlightCost.inboundFlightPrice("One way");
		baFlightCost.displayTotalFlightCost("One way");
		baPassengerDetail.addAdultPassengerCountDetails(1, "Capt", "Black", "Smith", null, null, null, null, null, null, null);
		baPassengerDetail.addYoungAdultPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPassengerDetail.addChildPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPassengerDetail.addInfantPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPaymentPassenger.selectPayingCustomer();
		baHome.menuIconBtn();
		baHome.menuHomeBtn();
		log.debug("########Completed Execution of TC2 - Purchase One Adult One way Ticket TestCase########");
	}
	
	@Test(priority=3)
	public void oneAdultRtn(ITestContext context) throws InterruptedException{
		log.debug("########Executing TC3 - Purchase One Adult Return Ticket TestCase########");
		baHome.bookFlightHomePage();
		baHome.bookFlightBtn();
		baAirport.departureFlight("LHR");
		baAirport.arrivalFlight("TXL");
		baTrip.selectJourneyType("Return");
		baTravelDate.travelDate("Return");
		baPassengerCount.addPassengerCount(1, 0, 0, 0);
		baTrip.selectClassType("Business");
		baTrip.selectTicketType("Flexible ticket");
		baTrip.searchFlightBtn();
		baFlightCost.outboundFlightPrice("Return");
		baFlightCost.inboundFlightPrice("Return");
		baFlightCost.displayTotalFlightCost("Return");
		baPassengerDetail.addAdultPassengerCountDetails(1, "Lord", "Jaja", "Opobo", null, null, null, null, null, null, null);
		baPassengerDetail.addYoungAdultPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPassengerDetail.addChildPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPassengerDetail.addInfantPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPaymentPassenger.selectPayingCustomer();
		baHome.menuIconBtn();
		baHome.menuHomeBtn();
		log.debug("########Completed Execution of TC3 - Purchase One Adult Return Ticket TestCase########");
	}
	
	@Test(priority=4)
	public void failureScenario(ITestContext context) throws InterruptedException{
		log.debug("########Executing TC3 - Purchase One Adult Return Ticket TestCase########");
		baHome.bookFlightHomePage();
		baHome.bookFlightBtn();
		baAirport.departureFlight("LHR");
		baAirport.arrivalFlight("XXX");
		baTrip.selectJourneyType("Return");
		baTravelDate.travelDate("Return");
		baPassengerCount.addPassengerCount(1, 0, 0, 0);
		baTrip.selectClassType("Business");
		baTrip.selectTicketType("Flexible ticket");
		baTrip.searchFlightBtn();
		baFlightCost.outboundFlightPrice("Return");
		baFlightCost.inboundFlightPrice("Return");
		baFlightCost.displayTotalFlightCost("Return");
		baPassengerDetail.addAdultPassengerCountDetails(1, "Lord", "Jaja", "Opobo", null, null, null, null, null, null, null);
		baPassengerDetail.addYoungAdultPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPassengerDetail.addChildPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPassengerDetail.addInfantPassengerCountDetails(0, null, null, null, null, null, null, null, null, null, null);
		baPaymentPassenger.selectPayingCustomer();
		baHome.menuIconBtn();
		baHome.menuHomeBtn();
		log.debug("########Completed Execution of TC3 - Purchase One Adult Return Ticket TestCase########");
	}

	
/*	@Test(priority=1, dataProvider="getData")

		
	@DataProvider
	public static Object[][] getData(){

		return TestUtil.getExcelData("baPlanTripTest");				
	}*/

}
