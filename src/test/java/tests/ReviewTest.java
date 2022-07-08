package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ReviewPage;
import pages.SearchPage;
import pages.productDetailsPage;
import pages.userregistrationPage;

public class ReviewTest extends TestBase {

	//we have to register 
	//search for products
	//go to add the review element 
	//go to review page 


	HomePage homeObj ;
	userregistrationPage registrationObj ;
	SearchPage searchObj;
	productDetailsPage productdetailsObj ;
	ReviewPage reviewObj;

	String fname = "Aya" ;
	String lname = "Alhissan" ;
	String mail = "aya.alhissan98729100@gmail.com";
	String passw = "123456789" ;
	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";

	String reviewtitle="Mac Book Review";
	String reviewMsg="This Product is really good";




	//user Registration
	@Test (priority = 1 )
	public void UserRegistration() {
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registrationObj = new userregistrationPage(driver);
		registrationObj.UserRegistartion(fname, lname, mail, passw);
		assertTrue(registrationObj.SuccessMsgRegistration.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void usercanGivehisReview() throws InterruptedException {

		searchObj=new SearchPage(driver);
		searchObj.SearchForProductsAutocomplete(SearchTxt);
		productdetailsObj = new productDetailsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,400)");
		productdetailsObj.clickonAddreview();
		reviewObj=new ReviewPage(driver);
		reviewObj.RegisteredUserCanReview(reviewtitle, reviewMsg);
		Assert.assertTrue(reviewObj.reviewResult.getText().contains("is successfully added"));
	}
	@Test (priority = 5)
	public void UserCanLogOut() {
		registrationObj.UserLogout();
	}

}
