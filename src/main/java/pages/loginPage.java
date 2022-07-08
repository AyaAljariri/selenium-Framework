package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends pageBase {

	public loginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id="Email")
	WebElement emailTxtBox ;
	
	@FindBy (id="Password")
	WebElement passwordTxtBox ;
	
	@FindBy (css="button.button-1.login-button")
	WebElement loginBtn ; 
	
	public void userCanLogin(String mail , String pass) {
		SendingKeys(emailTxtBox, mail);
		SendingKeys(passwordTxtBox, pass);
		ClickBtn(loginBtn);
		
	}
	

}
