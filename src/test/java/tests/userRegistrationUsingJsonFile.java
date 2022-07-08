package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.loginPage;
import pages.userregistrationPage;

public class userRegistrationUsingJsonFile extends TestBase {

	HomePage homeObj ;
	userregistrationPage registrationObj ;
	loginPage loginObj ;

	/*String fname = "Aya" ;
	String lname = "Alhissan";
	String mail = "aya.alhissan98719700@gmail.com";
	String passw = "Abu.7abes" ;*/



	@Test (priority = 1 )
	public void UserCanRegisterSuccessfully() throws IOException, ParseException, Throwable {
		JsonDataReader jsonreader = new JsonDataReader();
		jsonreader.JsonReader();
		
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registrationObj = new userregistrationPage(driver);
		registrationObj.UserRegistartion(jsonreader.Firstname , jsonreader.Lastname , jsonreader.email , jsonreader.password);
		assertTrue(registrationObj.SuccessMsgRegistration.getText().contains("Your registration completed"));
		registrationObj.UserLogout();
		homeObj.openLoginPage();

		loginObj = new loginPage(driver);
		loginObj.userCanLogin( jsonreader.email , jsonreader.password);
		Assert.assertTrue(registrationObj.LogoutAfterRegistration.isDisplayed());
		registrationObj.UserLogout();

	}



}
