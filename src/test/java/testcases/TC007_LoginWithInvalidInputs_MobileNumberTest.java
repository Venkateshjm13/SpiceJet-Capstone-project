
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

public class TC007_LoginWithInvalidInputs_MobileNumberTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Login_InvalidMobilenumberDetails";

	}

	@Test(priority = 1, dataProvider = "getData")
	public void LoginCredentials_MobileNumber(String scenario, String mobilenumber, String password)
			throws IOException {

		HomePage homePage = new HomePage(driver);
		try {

			homePage.navigateToLogin().enterMobileNumber(mobilenumber).enterPassword(password).clickOnLoginButton()
					.assertNegativeData_MobileNumber(scenario, mobilenumber, password);

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_TC011_LoginWithInvalidInputs_MobileNumberTest");
			System.out.println("TC011_LoginWithInvalidInputs_MobileNumberTest is failed :Screenshot is captured and saved in "
							+ savedPath);
			e.printStackTrace();
		}
	}
}
