package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactUsPage extends pageBase {

	public contactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FullName")
	WebElement FullNameTxtBox ;
	
	@FindBy(id="Email")
	WebElement EmailTextBox ;
	
	@FindBy(id="Enquiry")
	WebElement EnquiryTxtBox;
	
	@FindBy(css="button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement SuccessfulMsg ;
	

	public void ContactUsForm(String name , String mail , String enquiry ) {
		SendingKeys(FullNameTxtBox, name);
		SendingKeys(EmailTextBox, mail);
		SendingKeys(EnquiryTxtBox, enquiry);
		ClickBtn(submitBtn);
	}
}
