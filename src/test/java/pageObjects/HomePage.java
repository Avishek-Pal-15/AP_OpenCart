package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
		// WebDriver driver; getting from parent class BasePage
		
		public HomePage(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(xpath="//span[normalize-space()='My Account']")
		WebElement linkMyaccount;
		
		@FindBy(xpath="//a[normalize-space()='Register']")
		WebElement linkRegister;
		
		@FindBy(xpath="//a[normalize-space()='Login']")
		WebElement linkLogin;
		
		public void clickMyAccount() {
			linkMyaccount.click();
		}
		public void clickRegister() {
			linkRegister.click();
		}
		public void clickLogin() {
			linkLogin.click();
		}
}
