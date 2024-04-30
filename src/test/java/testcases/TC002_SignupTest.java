package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

public class TC002_SignupTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Signup_ValidDetails";

	}

	@Test(priority = 0, dataProvider = "getData")
	public void SignupCredentials(String title, String first_middlename, String lastname, String countryValue,
			String monthValue, String yearValue, String mobileNumber, String emailID, String password,
			String confirmPassword) throws IOException {

		HomePage homePage = new HomePage(driver);

		try {

			homePage.navigateToSignup().switchToWindow().selectTitle(title).clickOnSubmitButton().checkErrorMessage();

			// Below fields are not interactable in the Spicejet signup window
//			 		.enterUsername(first_middlename, lastname).selectCountry(countryValue)
//			 		.selectDOB(monthValue, yearValue).enterValid_MobileNo_and_EmailID(mobileNumber, emailID)
//			 		.enter_password_and_confirmPassword(password, confirmPassword).accept_Terms_and_Conditions();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_SignupPage");
			System.out.println("Signup test is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();

		}
	}

}
