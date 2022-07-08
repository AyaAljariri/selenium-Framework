package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.loginPage;
import pages.userregistrationPage;

public class userRegistrationUsingFakeLibrary extends TestBase {

	HomePage homeObj ;
	userregistrationPage registrationObj ;
	loginPage loginObj ;

	//i added it in the dependencies 
	Faker fakeData = new Faker();
	
	String fname=fakeData.name().firstName();
	String lname = fakeData.name().lastName();
	String mail = fakeData.internet().emailAddress();
	String passw = fakeData.number().digits(8).toString();

	@Test (priority = 1 )
	public void UserCanRegisterSuccessfully() {
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registrationObj = new userregistrationPage(driver);
		registrationObj.UserRegistartion(fname, lname, mail, passw);
		System.out.println("The Data of the user who is entered is : " + fname +" " + lname + " " + mail +" "+ passw);
		assertTrue(registrationObj.SuccessMsgRegistration.getText().contains("Your registration completed"));
	}

	@Test (priority = 2)
	public void UserCanLogOut() {
		registrationObj.UserLogout();
	}

	@Test (priority = 3)
	public void RegisteredUserCanLogin() {
		homeObj.openLoginPage();

		loginObj = new loginPage(driver);
		loginObj.userCanLogin(mail, passw);
		Assert.assertTrue(registrationObj.LogoutAfterRegistration.isDisplayed());
		//Assert.assertTrue(homeObj.LogoutAfterRegistrationTry.getText().contains("Log out"));


	}
	@Test (priority = 4)
	public void UserCanLogOuttwice() {
		registrationObj.UserLogout();
	}

}
