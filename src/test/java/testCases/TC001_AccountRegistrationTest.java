package testCases;

import java.io.FileOutputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC001_AccountRegistrationTest extends TestBase {
		
		// WebDriver driver;  getting from parent class TestBase
			
		@Test(groups={"Regression", "Master"})
		void verifyRegistration() { 
			
			try {
				logger.info("************ Starting TC001 ****************");
				
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				hp.clickRegister();
				
				AccountRegistrationPage arp = new AccountRegistrationPage(driver);
				
				arp.setFN("Avi");
				arp.setLN("Anu");
				String email = generateRandomString(5, 10) + "@gmail.com";
				arp.setEmail(email);
				prop.setProperty("email", email);
				prop.store(new FileOutputStream("./src//test//resources//config.properties"), null);
				arp.setPH("1234567891");
				arp.setPwd(prop.getProperty("password"));
				arp.setConfirm(prop.getProperty("password"));
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
