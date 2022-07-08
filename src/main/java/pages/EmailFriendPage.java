package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends pageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FriendEmail")
	WebElement friendsEmailTxtBox;
	
	@FindBy(id="YourEmailAddress")
	WebElement myEmailTxtBox;
	
	@FindBy (id="PersonalMessage")
	WebElement MsgTxtBox ;
	
	@FindBy (css="button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn ;
	
	public void sendingMail( String Femail , String MyEmail , String Msg) {
		SendingKeys(friendsEmailTxtBox, Femail);
		SendingKeys(MsgTxtBox, MyEmail);
		SendingKeys(MsgTxtBox, Msg);
		ClickBtn(sendEmailBtn);
		
	}
	
	@FindBy(css="div.result")
	public WebElement MailIsSent ;
	
	

}
