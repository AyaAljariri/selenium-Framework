package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userregistrationPage extends pageBase  {

	public userregistrationPage(WebDriver driver) {
		super(driver);

	}

	//Finding the required elements

	//to find the gender element
	@FindBy(id ="gender")
	WebElement GenderRadioBtn ;

	//to find the firstname element 
	@FindBy(id="FirstName")
	WebElement FirstNameTxt ;

	//to find the last element
	@FindBy(id="LastName")
	WebElement LastNameTxt;

	//to find the e=mail element
	@FindBy(id="Email")
	WebElement EmailTxt ;

	//to find the password element
	@FindBy(id ="Password")
	WebElement PasswordTxt ;

	//to find the element confirmation the password 
	@FindBy(id="ConfirmPassword")
	WebElement ConfirmThePasswordTxt ;

	//to find the element RegosterBtn 
	@FindBy(id="register-button")
	WebElement RegisterBtn ;
	
	//to find the successMsg For Registration
	@FindBy(css = "div.result")
	public WebElement SuccessMsgRegistration ; 
	//we have to assert it in the userregistrationTest
	
	@FindBy (linkText ="Log out")
	public WebElement LogoutAfterRegistration ;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement usercanlogoutforDDT;
	public void DDTLogout(){
		ClickBtn(usercanlogoutforDDT);
	}
	
	@FindBy(linkText = "My account")
	public WebElement MyAccountLink ;

	public void UserRegistartion(String fname , String lname , String email , String password) {
		ClickBtn(GenderRadioBtn);
		//by method defined in the pagebase

		SendingKeys(FirstNameTxt, fname);
		//we made it in the pageBase 
		
		SendingKeys(LastNameTxt, lname);
		SendingKeys(EmailTxt, email);
		SendingKeys(PasswordTxt, password);
		SendingKeys(ConfirmThePasswordTxt, password);
		ClickBtn(RegisterBtn);
		//by the methid defined in the pageBase

	}
	public void UserLogout() {
		ClickBtn(LogoutAfterRegistration);
	}
	public void myaccountLink() {
		ClickBtn(MyAccountLink);
		
	}






}
