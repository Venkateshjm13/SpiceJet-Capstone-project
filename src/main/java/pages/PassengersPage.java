package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class PassengersPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//div[text()='I am flying as the primary passenger']")
	private WebElement primaryPassenger;

	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	private WebElement firstAndMiddleNameField;

	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	private WebElement contactNumberField;

	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	private WebElement emailAddressField;

	@FindBy(xpath = "//div[text()='Contact Details']")
	private WebElement contactDetailsText;

	// Constructor
	public PassengersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Click the Checkbox of Primary passenger on the Passenger page
	public PassengersPage checkPrimaryPasenger() {
		visibiltiyOfWebElement(contactDetailsText, 50);
		scrollThePage(350);
		clickabilityOfWebElement(primaryPassenger, 30);
		primaryPassenger.click();

		return this;
	}

	// Method to Scroll the page and Click the Continue button on the Passenger page
	public AddOnsPage clickOnContinueButton() {
		scrollThePage(250);
		clickabilityOfWebElement(continueButton, 60);
		clickOnElement(continueButton);
		System.out.println("Passengers details are entered properly ");
		return new AddOnsPage(driver);
	}

	// remove the below methods once code are megred
	// Once you signed in and below info are automatically filled in that page

	// Method to Enter the First and Middle name of the Passenger
	public PassengersPage enterFirstAndMiddleName() throws InterruptedException {
		Thread.sleep(6000);
		clickabilityOfWebElement(firstAndMiddleNameField, 50);
		firstAndMiddleNameField.sendKeys("Tharun");
		return this;
	}

	// Method to Enter the Last name of the Passenger
	public PassengersPage enterLastName() {
		lastNameField.sendKeys("JM");
		return this;
	}

	// Method to Enter the Contact number of the Passenger
	public PassengersPage enterContactNumber() {
		contactNumberField.sendKeys("8310057124");
		return this;
	}

	// Method to Enter the Email address of the Passenger
	public PassengersPage enterEmailAddress() {
		emailAddressField.sendKeys("jmvenkatesh05@gmail.com");
		return this;
	}
}
