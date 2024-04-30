package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class PaymentPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	
	@FindBy(xpath = "//input[@id='card_number']")
	private WebElement enterCardNumberField;

	@FindBy(id = "name_on_card")
	private WebElement enterNameOnCard;

	@FindBy(id = "card_exp_month")
	private WebElement enterCardExpiryMonth;

	@FindBy(id = "card_exp_year")
	private WebElement enterCardExpiryYear;

	@FindBy(id = "security_code")
	private WebElement enterSecurityCode;

	@FindBy(xpath = "//div[text()='Proceed to pay']")
	private WebElement proceedToPayButton;

	@FindBy(xpath = "//iframe[@class='card_number_iframe']")
	private WebElement iframeCardNumber;

	@FindBy(xpath = "//iframe[@class='name_on_card_iframe']")
	private WebElement iframeNameOnCard;

	@FindBy(xpath = "//div[text()='Invalid Card Details']")
	private WebElement errorMessage;

	@FindBy(xpath = "//iframe[@class='card_exp_month_iframe']")
	private WebElement iframeCardExpiryMonth;

	@FindBy(xpath = "//iframe[@class='card_exp_year_iframe']")
	private WebElement iframeCardExpiryYear;

	@FindBy(xpath = "//iframe[@class='security_code_iframe']")
	private WebElement iframeSecurityCode;

	// Constructor
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Scroll the page and Click the Proceed to pay button on the Payment page
	public PaymentPage clickOnProceedToPayButton() {
		scrollThePage(250);
		clickabilityOfWebElement(proceedToPayButton, 10);
		clickOnElement(proceedToPayButton);
		visibiltiyOfWebElement(errorMessage, 10);
		Assert.assertTrue(errorMessage.isDisplayed());
		System.out.println("Proceed to pay button was clicked successfully");
		return this;
	}

	public PaymentPage enterCardDetails() throws InterruptedException {

		// Switch to Card number iframe and Enter the Credit/Debit card number
		Thread.sleep(10000);
		driver.switchTo().frame(iframeCardNumber);
		System.out.println("Switch to iframe card number");
		Thread.sleep(10000);
		//Sometimes it will enter the value and sometimes it will not 
		enterCardNumberField.sendKeys("8978349820983578");
		driver.switchTo().defaultContent();

		// Switch to Name on card iframe and Enter the Card holder name
		Thread.sleep(5000);
		driver.switchTo().frame(iframeNameOnCard);
		//Sometimes it will enter the value and sometimes it will not 
		enterNameOnCard.sendKeys("Tharun");
		driver.switchTo().defaultContent();

		// Switch to Card expiry month iframe and Enter the Expiry month of the
		// Credit/Debit card
		driver.switchTo().frame(iframeCardExpiryMonth);
		enterCardExpiryMonth.sendKeys("06");
		driver.switchTo().defaultContent();

		// Switch to Card expiry year iframe and Enter the Expiry year of the
		// Credit/Debit card
		driver.switchTo().frame(iframeCardExpiryYear);
		enterCardExpiryYear.sendKeys("05");
		driver.switchTo().defaultContent();

		// Switch to Security code iframe and Enter the CVV of the Credit/Debit card
		driver.switchTo().frame(iframeSecurityCode);
		enterSecurityCode.sendKeys("345");
		driver.switchTo().defaultContent();

		return this;
	}
}