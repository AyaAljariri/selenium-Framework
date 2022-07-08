package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.loginPage;
import pages.userregistrationPage;

public class userRegistrationusingCSVFile extends TestBase {

	HomePage homeObj ;
	userregistrationPage registrationObj ;
	loginPage loginObj ;

	


	CSVReader reader;

	@Test (priority = 1 )
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException {
		//to get the path from userdata.csv file 
		
		String CSVPath =  System.getProperty("user.dir")+"/src/test/java/data/UserData.csv"; 
		reader = new CSVReader(new FileReader(CSVPath));
		String [] csvCell ;
		//while loop will be executed until the final value of the csv file 
		while ((csvCell = reader.readNext())!= null)
		{
			String fname = csvCell [0];
			String lname = csvCell [1];
			String mail = csvCell [2];
			String passw =csvCell [3];

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
			registrationObj.UserLogout();
			
		}

	}



}
