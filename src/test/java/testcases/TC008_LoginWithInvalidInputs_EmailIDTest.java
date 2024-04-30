

package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

public class TC008_LoginWithInvalidInputs_EmailIDTest extends ProjectSpecification{

	@BeforeTest
	public void setup() {

		excelfile = "Login_InvalidEmailIdDetails";

	}

	@Test(priority = 1, dataProvider = "getData")
	public void LoginCredentials_EmailID(String scenario, String EmailID, String password) throws IOException {

		HomePage homePage = new HomePage(driver);
		try {

			homePage.navigateToLogin().clickEmailRadioButton().enterEmailID(EmailID).enterPassword(password)
					.clickOnLoginButton().assertNegativeData_EmailID(scenario, EmailID, password);
 				 
		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_TC012_LoginWithInvalidInputs_EmailIDTest");
			System.out.println("TC012_LoginWithInvalidInputs_EmailIDTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}

