package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.SearchPage;
import pages.loginPage;
import pages.productDetailsPage;
import pages.userregistrationPage;

public class EmailFriendTest extends TestBase {

	HomePage homeObj ;
	userregistrationPage registrationObj ;
	loginPage loginObj ;
	SearchPage searchObj;
	EmailFriendPage mailObj;
	productDetailsPage productdetailsObj ;

	String fname = "Aya" ;
	String lname = "Alhissan" ;
	String mail = "aya.alhissan987510@gmail.com";
	String passw = "987159753" ;
	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";
	String myfriendmail ="aya.alhissan55@gmail.com";
	String TextMessage ="Hello From the otherside my friend";




	//user Registration
	@Test (priority = 1 )
	public void UserRegistration() {

		//we make two objects from the pages to call it from the tests 

		//I started With the home page because i have to click on register to Forward To the Registration Page 
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();



		//here the registration method holds 4 parameters , i have to fill it to the test 
		registrationObj = new userregistrationPage(driver);
		registrationObj.UserRegistartion(fname, lname, mail, passw);


		//For Assertion :
		assertTrue(registrationObj.SuccessMsgRegistration.getText().contains("Your registration completed"));


	}
	//Searching For products

	@Test(priority = 2)
	public void AutocompleteSearch() throws InterruptedException {
		try {
			searchObj=new SearchPage(driver);
			searchObj.SearchForProductsAutocomplete(SearchTxt);
			productdetailsObj = new productDetailsPage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver ;
			js.executeScript("window.scrollBy(0,400)");
			//Assert.assertEquals(productdetailsObj.productName.getText(), productname);
			Assert.assertEquals(productdetailsObj.productNameFromAutoComplete.getText(), productname);


		} catch (Exception e) {
			System.out.println( "Error Msg : "+e.getMessage()) ;
		}


	}
	//clicking on Mail a friend

	@Test(priority = 3)
	public void clickonmailfriendfromDetailsPage() {
		productdetailsObj = new productDetailsPage(driver);
		productdetailsObj.openmailPage();
	}

	//sending a product to friend
	@Test (priority = 4)
	public void RegistereduserCanSendEmail() throws InterruptedException {
		mailObj=new EmailFriendPage(driver);
		mailObj.sendingMail(myfriendmail, mail, TextMessage);
		assertTrue(mailObj.MailIsSent.getText().contains("has been sent"));
		Thread.sleep(3000);

	}

	//log out
	@Test (priority = 5)
	public void UserCanLogOut() {
		registrationObj.UserLogout();
	}







}
