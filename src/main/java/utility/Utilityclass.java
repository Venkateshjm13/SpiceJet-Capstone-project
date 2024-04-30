package utility;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilityclass {

	public static WebDriver driver;// driver instance
	public String excelfile; // instance of excel file

	// Method to launch browser and load url
	// Verifying the Headless chrome browser
	// Verifying the Given URL is Broken or not
	public void launchBrowser(String browser, String baseUrl) {

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		}

		driver.get(baseUrl);
		System.out.println("Browser is Launched Successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

	}

	// Method to terminate the browser
	public void terminateBrowser() {
		System.out.println("Browser is Closed succesfully");
		driver.quit();
	}

	// Method to Validate the Given URL is Broken or not
	@SuppressWarnings("deprecation")
	public void brokenURLValidation(String baseUrl) {

		try {
			URL link = new URL(baseUrl);

			HttpURLConnection huc = (HttpURLConnection) link.openConnection();
			huc.setConnectTimeout(3000);
			huc.connect();

			if (huc.getResponseCode() == 200) {
				System.out.println("The Given URL:" + baseUrl + " is not broken");
			} else {
				System.out.println("The Given URL:" + baseUrl + " is broken");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Method to read data from Excel file
	public static String[][] readExcel(String excelfile) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("./Data/" + excelfile + ".xlsx"); // open work book
		XSSFSheet sheet = book.getSheetAt(0);

		// Getting the row and column count
		int rowcount = sheet.getLastRowNum();
		short columnCount = sheet.getRow(0).getLastCellNum();

		// two dimensional array to store the row and column values of cells
		String[][] data = new String[rowcount][columnCount];

		// Get into row
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			// Get into column
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				// System.out.println(cell.getStringCellValue());
				data[i - 1][j] = cell.getStringCellValue();

			}
		}
		book.close();// closing the book
		return data;
	}

	// Method to take the screenshot
	public String getScreenShot(String testmethodname) throws IOException {

		String path = "./Selenium_POMScreenshots/" + testmethodname + ".png";
		TakesScreenshot screenShot1 = (TakesScreenshot) driver;
		File source = screenShot1.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(source, dest);
		return path;

	}

	// Method for checking the Visibility of the WebElement
	public void visibiltiyOfWebElement(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	// Method for checking the Clickability of the WebElement
	public void clickabilityOfWebElement(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	// Method for hovering the cursor to the particular Webelement and click on it
	public void clickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	// Method to Scroll the webpage
	public void scrollThePage(int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + value + ")", "");

	}

}
