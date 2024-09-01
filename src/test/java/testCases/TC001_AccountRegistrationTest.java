package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC001_AccountRegistrationTest extends TestBase {
		
		// WebDriver driver;  getting from parent class TestBase
			
		@Test
		void verifyRegistration() { 
			
			try {
				logger.info("************ Starting TC001 ****************");
				
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				hp.clickRegister();
				
				AccountRegistrationPage arp = new AccountRegistrationPage(driver);
				
				arp.setFN("Avi");
				arp.setLN("Anu");
				arp.setEmail(generateRandomString(5, 10) + "@gmail.com");
				arp.setPH("1234567891");
				arp.setPwd("abcd1234");
				arp.setConfirm("abcd1234");
				arp.selectRadio();
				arp.agreeCheckbox();
				arp.submit();
				
				//Thread.sleep(2000);
				waitUntilPageLoad(driver, 5);
		        
				String confMsg = arp.getConfMsg(); 
				System.out.println(confMsg);
				
				if(confMsg.contains("successfully created")) {
					Assert.assertTrue(true);
				} else {
					logger.error("Test Failed");
					logger.debug("Debug logs");
					Assert.assertTrue(false);
				}
				
			} catch (Exception e) {	
				Assert.fail();
			}
			
			logger.info("************ Submitted form. End of TC001 ****************");
			
		}
		
		
		
		
		
		
		
}
