package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class LoginPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginLink;

	@FindBy(xpath = "//div[text()='Mobile Number']")
	private WebElement mobileRadioBtn;

	@FindBy(xpath = "//div[text()='Email']")
	private WebElement emailRadioBtn;

	@FindBy(xpath = "//input[@data-testid='user-mobileno-input-box']")
	private WebElement mobilenumberField;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailidField;

	@FindBy(xpath = "//div[text()='LOGIN']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[text()='Hi Tharun']")
	private WebElement userName;

	@FindBy(xpath = "//div[text()='Log Out']")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[text()='Please enter a valid mobile number']")
	private WebElement mobileNumberErrorMessage;

	@FindBy(xpath = "//div[text()='Please enter a valid email address']")
	private WebElement emailIDErrorMessage;

	@FindBy(xpath = "//div[text()='Please enter a valid password']")
	private WebElement emptypasswordErrorMessage;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79 r-15zivkp']")
	private WebElement errorPasswordPopupTitle;

	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n r-1mlwlqe')]/following-sibling::div)[1]")
	private WebElement clickOnCloseLink;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Click the Email radio button on the Login page
	public LoginPage clickEmailRadioButton() {

		clickabilityOfWebElement(emailRadioBtn, 20);
		clickOnElement(emailRadioBtn);
		return this;
	}

	// Method to Enter the Mobile number 0n the Loign page
	public LoginPage enterMobileNumber(String mobilenumber) {
		clickabilityOfWebElement(mobilenumberField, 10);
		mobilenumberField.sendKeys(mobilenumber);
		return this;

	}

	// Method to Enter the Email address on the Loign page
	public LoginPage enterEmailID(String emailID) {
		clickabilityOfWebElement(emailidField, 10);
		emailidField.sendKeys(emailID);
		return this;
	}

	// Method to Enter the Password in the Loign page
	public LoginPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	// Method to Click the Login button on the Login page
	public LoginPage clickOnLoginButton() {
		clickabilityOfWebElement(loginButton, 30);
		clickOnElement(loginButton);
		return this;
	}

	// Method to Validate the Mobile number using Assertion
	public HomePage assertValidMobileNo(String mobilenumber) {
		Assert.assertTrue(userName.isDisplayed());
		System.out.println("Entered Mobile Number: " + mobilenumber + " is Valid");
		return new HomePage(driver);
	}

	// Method to Validate the Email address using Assertion
	public HomePage assertValidEmailID(String emailID) {
		Assert.assertTrue(userName.isDisplayed());
		System.out.println("Entered Email Address: " + emailID + " is Valid");
		return new HomePage(driver);
	}

	// Method to Validate the Username
	public LoginPage verifyRedirectionToUserDashboard() {
		visibiltiyOfWebElement(userName, 20);
		String usernameText = userName.getText();
		Assert.assertTrue(userName.isDisplayed());
		System.out.println("Welcome " + usernameText + " is Displayed on the home page");
		userName.click();
		return this;
	}

	// Method to Click the Logout button on the Home page
	public HomePage clickOnLogoutButton() {

		logoutButton.click();
		return new HomePage(driver);

	}

	// Method to Validate the Email address for Invalid details using Assertions
	public LoginPage assertNegativeData_EmailID(String scenario, String emailID, String password) {

		System.out.println("Invalid scenarios for Login with EmailID are validated below");
		System.out.println("Entered Email Address is:" + emailID + " | Password is: " + password);

		if (scenario.equals("InvalidEmailID") || scenario.equals("EmptyEmailID")) {
			visibiltiyOfWebElement(emailIDErrorMessage, 50);
			String actualMessage = emailIDErrorMessage.getText();
			String expectedMessage = "Please enter a valid email address";
			Assert.assertEquals(actualMessage, expectedMessage);
			System.out.println("Entered Email Address :" + emailID + " is Invalid");

		} else if (scenario.equals("InvalidPassword") || scenario.equals("EmptyPassword")) {
			visibiltiyOfWebElement(errorPasswordPopupTitle, 30);

			String actualMessage = errorPasswordPopupTitle.getText();
			String expectedMessage = "Invalid Username/Password";
			Assert.assertEquals(actualMessage, expectedMessage);
			System.out.println("Entered Password :" + password + " is Invalid");
		}
		return this;
	}

	// Method to Validate the Mobile number for Invalid details using Assertions
	public LoginPage assertNegativeData_MobileNumber(String scenario, String mobilenumber, String password) {

		System.out.println("Invalid scenarios for Login with Mobile number are validated below");
		System.out.println("Entered Mobile number is:" + mobilenumber + " | Password is: " + password);

		if (scenario.equals("InvalidMobileNumber") || scenario.equals("EmptyMobileNumber")) {
			visibiltiyOfWebElement(mobileNumberErrorMessage, 30);
			String actualMessage = mobileNumberErrorMessage.getText();
			String expectedMessage = "Please enter a valid mobile number";
			Assert.assertEquals(actualMessage, expectedMessage);
			System.out.println("Entered Mobile Number :" + mobilenumber + " is Invalid");

		} else if (scenario.equals("InvalidPassword") || scenario.equals("EmptyPassword")) {

			visibiltiyOfWebElement(errorPasswordPopupTitle, 30);

			String actualMessage = errorPasswordPopupTitle.getText();
			String expectedMessage = "Invalid Username/Password";
			Assert.assertEquals(actualMessage, expectedMessage);
			System.out.println("Entered Password :" + password + " is Invalid");
		}
		return this;
	}
}
