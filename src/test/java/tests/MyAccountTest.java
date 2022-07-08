package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccountPage;
import pages.loginPage;
import pages.userregistrationPage;

public class MyAccountTest extends TestBase {
	HomePage homeObj ;
	userregistrationPage registrationObj ;
	MyAccountPage myaccountObj ;
	loginPage loginObj ;

	
	String fname="Aya";
	String lname = "Alhissan";
	String mail="aya.alhissan9876910@gmail.com";
	String oldPass="987654321";
	String newPass="123456789";
	
	//we gonna make test case to : 
	//Register then go to my account btn then go to change the password btn 
	//then go to logout btn then go to login page 
	
	
	@Test (priority = 1 )
	public void UserCanRegisterSuccessfully() {
		
		//we make two objects from the pages to call it from the tests 
		
		//I started With the home page because i have to click on register to Forward To the Registration Page 
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		
		
		
		//here the registration method holds 4 parameters , i have to fill it to the test 
		registrationObj = new userregistrationPage(driver);
		registrationObj.UserRegistartion(fname, lname, mail, oldPass);
		
		
		//For Assertion :
		assertTrue(registrationObj.SuccessMsgRegistration.getText().contains("Your registration completed"));
		
		registrationObj.myaccountLink();
	}
	
	@Test (priority = 2)
	public void changingThePass() throws InterruptedException  {
		myaccountObj = new MyAccountPage(driver);
		myaccountObj.changingThePassword();
		myaccountObj.Passwordchange(oldPass, newPass);
		Assert.assertTrue(myaccountObj.PasswordChangedSuccessfully.getText().contains("Password was changed"));
		
		myaccountObj.closeBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);

		}

	@Test (priority = 3)
	public void UserCanLogOut() {
	
		registrationObj.UserLogout();
	}
	
	@Test (priority = 4)
	public void RegisteredUserCanLogin() {
		homeObj.openLoginPage();

		loginObj = new loginPage(driver);
		loginObj.userCanLogin(mail, newPass);
		Assert.assertTrue(registrationObj.LogoutAfterRegistration.isDisplayed());
		//Assert.assertTrue(homeObj.LogoutAfterRegistrationTry.getText().contains("Log out"));

		
	}
	@Test (priority = 5)
	public void UserCanLogOuttwice() {
	
		registrationObj.UserLogout();
	}
	

}
