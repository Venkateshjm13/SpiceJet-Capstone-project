package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.Utilityclass;

public class ProjectSpecification extends Utilityclass {

	
	// Method to launch browser and load url
	// Parameter tag to pass the browser and url values from testng xml
	@Parameters({"browser","baseUrl"})
	@BeforeMethod
	public void browserLaunch(String browser,String baseUrl) {
	    
		 launchBrowser(browser,baseUrl);
		  
	  }
	
	
	//Method to read the data from Excel 
	@DataProvider(name = "getData")
	public String[][] getData() throws IOException {
		
		String[][] data = readExcel(excelfile);
		return data;
	}
	
	//Method to close the browser 
	 @AfterMethod 
	  public void closeBrowser() {
		   
		  terminateBrowser();
	  }
}
