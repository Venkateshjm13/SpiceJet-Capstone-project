package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class AddOnsPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "(//div[text()='Continue'])[3]")
	private WebElement continueButton;

	@FindBy(id = "skipfrompopup")
	private WebElement skipForSkipComfort;

	// Constructor
	public AddOnsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Click the Skip for comfort on the Add ons page
	public PaymentPage skipForComfort() {
		clickabilityOfWebElement(skipForSkipComfort, 10);
		clickOnElement(skipForSkipComfort);
		System.out.println("Skip for comfort in the Add on screen was Clicked successfully");
		return new PaymentPage(driver);

	}

	// Method to Click the continue button on the Add ons page
	public AddOnsPage clickOnContinueButton() {

		clickabilityOfWebElement(continueButton, 80);
		// Javascript executor to click on the Continue button in the Addons page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", continueButton);
		System.out.println("Clicked on Continue button and Proceeded to Payment page");
		return this;

	}
}
