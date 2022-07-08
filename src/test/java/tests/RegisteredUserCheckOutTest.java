package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.OrderDetailsPage;
import pages.RegisteredUserCheckoutPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.productDetailsPage;
import pages.userregistrationPage;

public class RegisteredUserCheckOutTest extends TestBase {

	HomePage homeObj ;
	userregistrationPage registrationObj ;
	SearchPage searchObj;
	productDetailsPage productdetailsObj;
	ShoppingCartPage cartObj;
	RegisteredUserCheckoutPage checkoutObj;
	OrderDetailsPage orderObj;

	String fname = "Aya" ;
	String lname = "Alhissan" ;
	String mail = "aya.alhissan9873700@gmail.com";
	String passw = "123456789" ;
	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";
	
	//data for checkout :
	String country = "Jordan";
	String city="Amman";
	String address="Jabal Amman";
	String zip="11180";
	String num="0799784563";
	
	



	//user registration
	@Test (priority = 1 , alwaysRun = true)
	public void Register() {
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();



		//here the registration method holds 4 parameters , i have to fill it to the test 
		registrationObj = new userregistrationPage(driver);
		registrationObj.UserRegistartion(fname, lname, mail, passw);


		//For Assertion :
		assertTrue(registrationObj.SuccessMsgRegistration.getText().contains("Your registration completed"));


	}
	//user serch for products 
	@Test (priority = 2)
	public void Search () throws InterruptedException {
		searchObj=new SearchPage(driver);
		searchObj.SearchForProductsAutocomplete(SearchTxt);
		productdetailsObj = new productDetailsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,250)");
		Assert.assertEquals(productdetailsObj.productName.getText(), productname);
	}

	//user can add products to Cart 

	@Test(priority = 3)
	public void addProductsToCartandcheckout () throws InterruptedException {
		productdetailsObj.ClickOnAddToCart();
		Thread.sleep(3000);
		//Go To ShoppingCart
		productdetailsObj.ClickOnshoppingCartToGoForwardCartPage();
		Thread.sleep(3000);

		cartObj=new ShoppingCartPage(driver);
		Thread.sleep(3000);
		assertTrue(cartObj.ProductAddedToCartName.getText().contains("MacBook"));
		cartObj.addingnumberTotheTxtBox("4");
		cartObj.ToClickOnUpdate();
		assertTrue(cartObj.totalprice.getText().contains("7,200.00"));
		System.out.println("The total price of all quantity you will buy is :  " + " " +cartObj.totalprice.getText() );
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		cartObj.checkboxclickonit();
		cartObj.ToChecOut();
		Thread.sleep(3000);
		checkoutObj=new RegisteredUserCheckoutPage(driver);
		checkoutObj.billingAddress(country,city, address, zip, num , productname);
		
		Assert.assertTrue(checkoutObj.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObj.prodcutName.getText().contains(productname));
		js.executeScript("window.scrollBy(0,350)");
		
		checkoutObj.confirmOrder();
		Assert.assertTrue(checkoutObj.ThankYoulbl.isDisplayed());
		checkoutObj.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObj = new OrderDetailsPage(driver); 
		orderObj.DownloadPDFInvoice();
		orderObj.PrintOrderDetails();
	}
	@Test(priority=5)
	public void RegisteredUserCanLogout() 
	{
		registrationObj.UserLogout();
	}
	
	
}
