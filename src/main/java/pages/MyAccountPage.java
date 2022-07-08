package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends pageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Change password")
	WebElement changeoldpassword ;
	
	public void changingThePassword() {
		ClickBtn(changeoldpassword);
		
	}
	
	@FindBy(id = "OldPassword")
	WebElement oldPassTxtBox ;
	
	@FindBy(id = "NewPassword")
	WebElement newPassTxtBox ;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPassTxtBox ;
	
	@FindBy(css="button.button-1.change-password-button")
	WebElement changePasswordBtn ;
	
	public void Passwordchange(String oldpass , String newpass) {
		SendingKeys(oldPassTxtBox, oldpass);
		SendingKeys(newPassTxtBox, newpass);
		SendingKeys(confirmNewPassTxtBox, newpass);
		ClickBtn(changePasswordBtn);
		
	}
	
	@FindBy(css ="p.content")
	public WebElement PasswordChangedSuccessfully ;
	
	@FindBy(css="span.close")
	public WebElement closesuccessedMsg ; 
	
	public void closeBtn() {
		ClickBtn(closesuccessedMsg);
		
	}
	
	
	
	
	

}
