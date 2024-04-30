package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

public class TC004_FieldValidationTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Login_ValidDetails_And_LocationInfo";

	}

	@Test(dataProvider = "getData")
	public void FieldValidation(String mobilenumber, String password, String emailID, String origin, String destination)
			throws IOException {

		HomePage homePage = new HomePage(driver);
		try {

			homePage.navigateToLogin().enterMobileNumber(mobilenumber).enterPassword(password).clickOnLoginButton()
					.verifyRedirectionToUserDashboard().assertValidMobileNo(mobilenumber).verifyCheckInField()
					.verifyFlightStatusField().verifyManageBookingField();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_FieldValidationOnHomePage");
			System.out.println("Field validation test is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
