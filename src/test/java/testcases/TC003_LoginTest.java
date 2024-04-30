package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

public class TC003_LoginTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Login_ValidDetails_And_LocationInfo";

	}

	@Test(dataProvider = "getData")
	public void LoginCredential(String mobilenumber, String password, String emailID, String origin, String destination)
			throws IOException {
		HomePage homePage = new HomePage(driver);

		try {

			homePage.navigateToLogin().enterMobileNumber(mobilenumber).enterPassword(password).clickOnLoginButton()
					.verifyRedirectionToUserDashboard().assertValidMobileNo(mobilenumber).clickOnLogoutButton()
					.navigateToLogin().clickEmailRadioButton().enterEmailID(emailID).enterPassword(password)
					.clickOnLoginButton().verifyRedirectionToUserDashboard().assertValidEmailID(emailID);

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_TC003_LoginTest");
			System.out.println("TC003_LoginTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}

	}
}
