package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// pattern @FindBy(xpath="xpathvalue") WebElement;
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement pwdField;
			
	@FindBy(xpath="//input[@value='Login']") 
	WebElement loginBtn;
	
	public void setEmail(String value) {
		emailField.sendKeys(value);
	}
	public void setPassword(String value) {
		pwdField.sendKeys(value);
	}
	public void clickLogin() {
		loginBtn.click();
	}

}
