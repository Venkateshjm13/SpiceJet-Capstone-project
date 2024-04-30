package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class FlightSelectionPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	private WebElement continueButton;

	// Constructor
	public FlightSelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Click the Continue button on the Flight selection page
	public PassengersPage clickOnContinueButton() {

		clickabilityOfWebElement(continueButton, 50);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		clickOnElement(continueButton);
		System.out.println("Flight at Minimal ticket fare is selected automatically and Clicked on Continue button");
		return new PassengersPage(driver);
	}
}
