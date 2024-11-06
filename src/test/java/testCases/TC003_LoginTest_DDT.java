package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;
import utilities.DataProviders;

public class TC003_LoginTest_DDT extends TestBase {

	@Test(dataProvider = "excelData", dataProviderClass = DataProviders.class, groups="DataDriver")
	public void verifyLogin_DDT(String email, String password, String expectedResult) {
		
		logger.info("************ Starting TC003 *************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();

			// My Account page
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountDisplayed();

			if (expectedResult.equalsIgnoreCase("valid")) { // Valid data
				if (targetPage) { // login is success
					map.clickLogout();
					Assert.assertTrue(true);
				} else { // Data valid but login failed
					Assert.assertTrue(false);
				}
			} else { // invalid data
				if (targetPage) { // login is success
					map.clickLogout();
					Assert.assertTrue(false);
				} else { // Data invalid and login failed
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}

		logger.info("************ Stopping TC003 *************");
	}

}
