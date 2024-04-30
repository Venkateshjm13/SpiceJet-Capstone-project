package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class HomePage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(linkText = "Signup")
	private WebElement signupLink;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginLink;

	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n r-1mlwlqe')]/following-sibling::div)[1]")
	private WebElement clickOnCloseLink;

	@FindBy(xpath = "//div[text()='check-in']")
	private WebElement checkInField;

	@FindBy(xpath = "//div[text()='flight status']")
	private WebElement flightStatusField;

	@FindBy(xpath = "//div[text()='manage booking']")
	private WebElement manageBookingField;

	@FindBy(xpath = "//div[text()='Hi Tharun']")
	private WebElement userName;

	@FindBy(xpath = "//div[text()='Log Out']")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[text()='one way']")
	private WebElement oneway_RadioBtn;

	@FindBy(xpath = "//div[text()='round trip']")
	private WebElement roundtrip_RadioBtn;

	@FindBy(xpath = "(//input[@dir='auto'])[1]")
	private WebElement originField;

	@FindBy(xpath = "(//input[@dir='auto'])[2]")
	private WebElement destinationField;

	@FindBy(xpath = "//div[text()='Search Flight']")
	private WebElement searchFlightButton;

	@FindBy(xpath = "//div[text()='Departure Date']")
	private WebElement depatureDateField;

	@FindBy(xpath = "//div[text()='Return Date']")
	private WebElement returnDateField;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Click the Signup link on the Home page
	public SignupPage navigateToSignup() {
		clickabilityOfWebElement(signupLink, 20);
		clickOnElement(signupLink);
		return new SignupPage(driver);
	}

	// Method to Click the Login link on the Home page
	public LoginPage navigateToLogin() {
		clickabilityOfWebElement(loginLink, 30);
		clickOnElement(loginLink);
		return new LoginPage(driver);
	}

	// Method to Validate the Check in field on the Home page
	public HomePage verifyCheckInField() {
		Assert.assertTrue(checkInField.isDisplayed());
		System.out.println("Check In field is displayed on Home page");
		return this;
	}

	// Method to Validate the Flight status field on the Home page
	public HomePage verifyFlightStatusField() {
		Assert.assertTrue(flightStatusField.isDisplayed());
		System.out.println("Flight status field is displayed on Home page");
		return this;
	}

	// Method to Validate the Manage booking field on the Home page
	public HomePage verifyManageBookingField() {
		Assert.assertTrue(manageBookingField.isDisplayed());
		System.out.println("Manage Booking field is displayed on Home page");
		return this;
	}

	// Method to Validate the Username is present on the Home page after Login
	public HomePage verifyRedirectionToUserDashboard() {
		visibiltiyOfWebElement(userName, 20);
		String usernameText = userName.getText();
		Assert.assertTrue(userName.isDisplayed());
		System.out.println("Welcome " + usernameText + " is Displayed on the home page");
		clickOnElement(userName);
		return this;
	}

	// Method to Click on the Logout Button on the Home page
	public HomePage clickOnLogoutButton() {

		logoutButton.click();
		return this;

	}

	// Method to Click the One Way Radio button on the Home page
	public HomePage clickOneWayTrip() {

		clickabilityOfWebElement(oneway_RadioBtn, 10);
		clickOnElement(oneway_RadioBtn);
		System.out.println("One Way Trip radio button is selected");
		return this;

	}

	// Method to Click the Round Trip Radio button on the Home page
	public HomePage clickRoundTrip() {

		clickabilityOfWebElement(roundtrip_RadioBtn, 10);
		clickOnElement(roundtrip_RadioBtn);
		System.out.println("Round trip radio button is selected");
		return this;

	}

	// Method to enter the Origin place Information on the Home Page
	public HomePage enterOriginInfo(String originInfo) {
		originField.sendKeys(originInfo);
		System.out.println("Entered Origin location is '" + originInfo + "'");
		return this;
	}

	// Method to enter the Destination place Information on the Home Page
	public HomePage enterDestinationInfo(String destinationInfo) {
		destinationField.clear();
		destinationField.sendKeys(destinationInfo);
		System.out.println("Entered Destination location is '" + destinationInfo + "'");
		return this;
	}

	// Method to Select the Departure date on the Home Page
	public HomePage selectDepatureDate() {

		driver.findElement(By.xpath("(//div[text()='9'])[2]")).click();

		// By Using the Below Method not able to select the Deperature date
		// tried many ways .,Finally used that direct statement
//		 public void selectDepatureDate() {
//		
//			String expectedDay="9";
//			String expectedMonth ="May 2024";
//			 
//			while(true) {
//				
//				List<WebElement>  departMonths = driver.findElements(By.xpath("(//div[@class='css-1dbjc4n r-k8qxaj'])"));
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				wait.until(ExpectedConditions.visibilityOfAllElements(departMonths));
//						 
//				// Instance to increment and count of the date occurrence of every month
//				int i = 1;
//		
//			for (WebElement departMonth : departMonths) {
//				
//				//WebElement currentMonth = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-k8qxaj'])["+i+"]"));
//				String actualMonth = departMonth.getText();
//				System.out.println("actual Month" + actualMonth);
//				if(expectedMonth.equals(actualMonth)) {
//					System.out.println("Depart Month inside the if loop is :"+ actualMonth);
//					break;
//				} else {
//					WebElement nextButton=driver.findElement(By.xpath("//div[contains(@class,'css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73')] "));
//					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//					wait1.until(ExpectedConditions.elementToBeClickable(nextButton));
//					nextButton.click();
//					
//					i++; 
//					 
//				}
//			}
//				driver.findElement(By.xpath("(//div[text()='"+expectedDay+"'])[" + i + "]")).click();
//			}
//			driver.findElement(By.xpath("(//div[text()='"+expectedDay+"'])[" + i + "]")).click();
//		 }

		return this;

	}

	// Method to Select the Return date on the Home Page
	public HomePage selectReturnDate() {

		// Tried many ways to pick the date.,But not able to do it
		// Finally used the Direct statement to pick the return date
		driver.findElement(By.xpath("(//div[text()='7'])[4]")).click();
		return this;
	}

	// Method to Click the Search flight button on the Home page
	public FlightSelectionPage clickOnSearchFlightButton() {
		clickabilityOfWebElement(searchFlightButton, 10);
		clickOnElement(searchFlightButton);
		System.out.println("Clicked on Search flight button");

		return new FlightSelectionPage(driver);
	}

}
