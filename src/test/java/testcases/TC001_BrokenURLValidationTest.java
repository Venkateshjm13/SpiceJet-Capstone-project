
package testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;

public class TC001_BrokenURLValidationTest extends ProjectSpecification {

	@Parameters({ "baseUrl" })
	@Test
	public void BrokenURLValidation(String baseURL) throws IOException {

		try {

			brokenURLValidation(baseURL);

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_TC001_BrokenURLValidationTest");
			System.out.println(
					"TC001_BrokenURLValidationTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();

		}
	}

}
