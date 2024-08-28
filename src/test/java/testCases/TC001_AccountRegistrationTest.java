package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC001_AccountRegistrationTest extends TestBase {
		
		// WebDriver driver;  getting from parent class TestBase
	// dummy
		
		
		@Test
		void verifyRegistration() { 
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			
			arp.setFN("Avi");
			arp.setLN("Anu");
			arp.setEmail("abc@gmail.com");
			arp.setPH("1234567891");
			arp.setPwd("abcd1234");
			arp.setConfirm("abcd1234");
			arp.selectRadio();
			arp.agreeCheckbox();
			arp.submit();
		}
		
		
		
		
		
		
		
}
