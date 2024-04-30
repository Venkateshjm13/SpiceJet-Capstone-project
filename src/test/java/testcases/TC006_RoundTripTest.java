
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

public class TC006_RoundTripTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Login_ValidDetails_And_Locationinfo";

	}

	@Test(dataProvider = "getData")
	public void RoundWayTrip(String mobilenumber, String password, String emailid, String origin, String destination)
			throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);

		try {

			homePage.navigateToLogin().enterMobileNumber(mobilenumber).enterPassword(password).clickOnLoginButton()
					.verifyRedirectionToUserDashboard().assertValidMobileNo(mobilenumber).clickOnLogoutButton()
					.navigateToLogin().clickEmailRadioButton().enterEmailID(emailid).enterPassword(password)
					.clickOnLoginButton().verifyRedirectionToUserDashboard().assertValidEmailID(emailid)
					.clickRoundTrip().enterOriginInfo(origin).enterDestinationInfo(destination).selectDepatureDate()
					.selectReturnDate().clickOnSearchFlightButton().clickOnContinueButton().checkPrimaryPasenger()
					.clickOnContinueButton().clickOnContinueButton().skipForComfort().enterCardDetails()
					.clickOnProceedToPayButton();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_RoundTripTest");
			System.out.println("RoundTripTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();

		}
	}
}
