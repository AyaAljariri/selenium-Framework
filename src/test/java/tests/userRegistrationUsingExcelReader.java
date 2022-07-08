package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.loginPage;
import pages.userregistrationPage;

public class userRegistrationUsingExcelReader extends TestBase {

	HomePage homeObj ;
	userregistrationPage registrationObj ;
	loginPage loginObj ;

	//String fname = "Aya" ;
	//String lname = "Alhissan";
	//String mail = "aya.alhissan98719700@gmail.com";
	//String passw = "Abu.7abes" ;

	@DataProvider(name="ExcelData")
	public Object[][] registeredFromExcelSheet () throws IOException{
		ExcelReader reader=new ExcelReader();
		return reader.getExcelData();
	}

	@Test (priority = 1 , dataProvider = "ExcelData" )
	public void UserCanRegisterSuccessfully(String fname ,String lname ,String mail ,String passw) {

		//we make two objects from the pages to call it from the tests 

		//I started With the home page because i have to click on register to Forward To the Registration Page 
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();



		//here the registration method holds 4 parameters , i have to fill it to the test 
		registrationObj = new userregistrationPage(driver);
		registrationObj.UserRegistartion(fname, lname, mail, passw);


		//For Assertion :
		assertTrue(registrationObj.SuccessMsgRegistration.getText().contains("Your registration completed"));
		registrationObj.UserLogout();
		homeObj.openLoginPage();

		loginObj = new loginPage(driver);
		loginObj.userCanLogin(mail, passw);
		Assert.assertTrue(registrationObj.LogoutAfterRegistration.isDisplayed());
		//Assert.assertTrue(homeObj.LogoutAfterRegistrationTry.getText().contains("Log out"));
		registrationObj.UserLogout();

	}



}
