package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecification;

public class SignupPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(linkText = "Signup")
	private WebElement signupLink;

	@FindBy(xpath = "//div[contains(@class,'col-sm-4 mt-2')]//select[1]")
	private WebElement titleField;

	@FindBy(xpath = "//label[text()='First Name and Middle Name']")
	private WebElement first_MiddleNameField;

	@FindBy(xpath = "//label[text()='Last Name']")
	private WebElement lastNameField;

	@FindBy(xpath = "//select[@class='form-control form-select']")
	private WebElement countryField;

	@FindBy(id = "dobDate")
	private WebElement dobField;

	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	private WebElement monthField;

	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	private WebElement yearField;

	@FindBy(xpath = "//div[text()='16']")
	private WebElement desiredDate;

	@FindBy(xpath = "//input[@placeholder='+91 01234 56789']")
	private WebElement mobilenumberField;

	@FindBy(id = "email_id")
	private WebElement emailidField;

	@FindBy(id = "new-password")
	private WebElement passwordField;

	@FindBy(id = "id=c-password")
	private WebElement confirmPasswordField;

	@FindBy(id = "defaultCheck1")
	private WebElement termsCheckbox;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "(//div[contains(@class,'font-13 mt-10')])[1]")
	private WebElement invalidCredentialErrorMessage;

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginLink;

	// Constructor
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Switch to new window on the Signup page
	public SignupPage switchToWindow() {
		// Get the window handles
		Set<String> windowHandles = driver.getWindowHandles();

		// Switch to the newly opened window
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);

		}
		return this;
	}

	// Method the Select title on the Signup page
	public SignupPage selectTitle(String title) {
		Select drpTitle = new Select(titleField);
		drpTitle.selectByVisibleText(title);

		return this;
	}

	// Method to Enter the Username on the Signup page
	public SignupPage enterUsername(String first_middlename, String lastname) {
		clickabilityOfWebElement(first_MiddleNameField, 10);
		first_MiddleNameField.sendKeys(first_middlename);

		return this;
	}

	// Method to Select the Country on the Signup page
	public SignupPage selectCountry(String countryValue) {
		Select drpCountry = new Select(countryField);
		drpCountry.selectByValue(countryValue);
		return this;
	}

	// Method to Select date of birth on the Signup page
	public SignupPage selectDOB(String monthValue, String yearValue) {

		dobField.click();

		Select drpMonth = new Select(monthField);
		drpMonth.selectByValue(monthValue);

		Select drpYear = new Select(monthField);
		drpYear.selectByValue(yearValue);

		desiredDate.click();

		return this;

	}

	// Method to Enter Mobile number and Email address on the Signup page
	public SignupPage enterValid_MobileNo_and_EmailID(String mobileNumber, String emailID) {
		mobilenumberField.sendKeys(mobileNumber);
		clickabilityOfWebElement(emailidField, 10);
		emailidField.sendKeys(emailID);
		return this;

	}

	// Method to Enter the Password and Confirm password on the Signup page
	public SignupPage enter_password_and_confirmPassword(String password, String confirmPassword) {
		clickabilityOfWebElement(passwordField, 10);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		return this;
	}

	// Method to Click the Terms and conditions on the Signup page
	public SignupPage accept_Terms_and_Conditions() {

		termsCheckbox.click();
		return this;
	}

	// Method to Click the Submit button on the Signup page
	public SignupPage clickOnSubmitButton() {
		clickabilityOfWebElement(submitButton, 10);
		clickOnElement(submitButton);
		return this;
	}

	// Method to Validate the Error Message on the Signup page
	public HomePage checkErrorMessage() {
		visibiltiyOfWebElement(invalidCredentialErrorMessage, 20);
		if (invalidCredentialErrorMessage.isDisplayed()) {
			Assert.assertTrue(invalidCredentialErrorMessage.getText()
					.equals("Please fill all mandatory fields marked with an '*' to proceed"));
			System.out.println("Unable to Enter Signup Credentials through Automation");
		} else {
			System.out.println("Entered Signup Credentials and Signed Up Successfully");
		}
		return new HomePage(driver);
	}

}
