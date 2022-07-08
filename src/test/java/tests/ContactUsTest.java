package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.contactUsPage;

public class ContactUsTest extends TestBase {

	contactUsPage contactusObj;
	HomePage homeObj;
	String fullname ="alhissan Aya";
	String email="Alhissan9874310@gamil.com";
	String Msg ="hello , from the other side";
	String MsgIsSent="Your enquiry has been successfully sent to the store owner.";

	@Test
	public void openContactusPage() {
		homeObj =new HomePage(driver);
		homeObj.openContactUsPage();
		contactusObj = new contactUsPage(driver);
		contactusObj.ContactUsForm(fullname, email, Msg);
		assertTrue(contactusObj.SuccessfulMsg.getText().equalsIgnoreCase(MsgIsSent));	
	}

}
