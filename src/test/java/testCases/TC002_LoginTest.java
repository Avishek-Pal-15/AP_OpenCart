package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;

public class TC002_LoginTest extends TestBase {

	@Test(groups={"Sanity", "Master"})
	public void verifyLogin() {
		logger.info("************ Starting TC002 *************");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email1"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			
			// My Account page
			MyAccountPage map = new MyAccountPage(driver);
			Assert.assertTrue(map.isMyAccountDisplayed()); 
		} catch (Exception e) {
			Assert.fail();
		}
		
		
		logger.info("************ Stopping TC002 *************");
		
		
	}
}
