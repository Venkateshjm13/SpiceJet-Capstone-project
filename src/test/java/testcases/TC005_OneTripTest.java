
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

public class TC005_OneTripTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Login_ValidDetails_And_LocationInfo";

	}

	@Test(dataProvider = "getData")
	public void OneWayTrip(String mobilenumber, String password, String emailid, String origin, String destination)
			throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);

		try {

			homePage.navigateToLogin().enterMobileNumber(mobilenumber).enterPassword(password).clickOnLoginButton()
					.verifyRedirectionToUserDashboard().assertValidMobileNo(mobilenumber).clickOnLogoutButton()
					.navigateToLogin().clickEmailRadioButton().enterEmailID(emailid).enterPassword(password)
					.clickOnLoginButton().verifyRedirectionToUserDashboard().assertValidEmailID(emailid)
					.clickOneWayTrip().enterOriginInfo(origin).enterDestinationInfo(destination).selectDepatureDate()
					.clickOnSearchFlightButton().clickOnContinueButton().checkPrimaryPasenger().clickOnContinueButton()
					.clickOnContinueButton().skipForComfort().enterCardDetails().clickOnProceedToPayButton();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_OneTripTest");
			System.out.println("OneTripTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();

		}
	}
}
