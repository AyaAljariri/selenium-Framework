package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.OrderDetailsPage;
import pages.RegisteredUserCheckoutPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.TochkeoutAsAguestPage;
import pages.productDetailsPage;

public class GuestCheckoutTest extends TestBase {
	/*
	 * Search For products 
	 * Go Product Details page 
	 * Click On Add to cart 
	 * Go To Cart page 
	 * click to check out btn 
	 *  Go To Check out as a guest btn and click on it 
	 *  Go to Check out page 
	 *  Filling the txt boxes 
	  */
	
	SearchPage searchObj;
	productDetailsPage productdetailsObj ;
	ShoppingCartPage cartObj ; 
	RegisteredUserCheckoutPage checkoutObj;
	TochkeoutAsAguestPage guestObj;
	OrderDetailsPage orderObj;

	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";
	
	String fname ="aya";
	String lname="alhissan";
	String email="aya.alhissan@gmail.com";
	String country = "Jordan";
	String city="Amman";
	String zip="11180";
	String num="0799876543";
	String address="Jabal Amman";

	
	//Search for a product 
	@Test(priority = 1)
	public void AutocompleteSearch() throws InterruptedException {
		
			searchObj=new SearchPage(driver);
		searchObj.SearchForProductsAutocomplete(SearchTxt);
		productdetailsObj = new productDetailsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,150)");
		Assert.assertEquals(productdetailsObj.productName.getText(), productname);

	}
	
	//To click on add to cart 
	@Test (priority = 2)
	public void AddToCart() throws InterruptedException {
		productdetailsObj = new productDetailsPage(driver);
		productdetailsObj.ClickOnAddToCart();
		Assert.assertTrue(productdetailsObj.AddedToCartNotification.getText().contains("has been added"));
		productdetailsObj.ClickOnshoppingCartToGoForwardCartPage();
		Thread.sleep(3000);



		//Go To ShoppingCart
		cartObj=new ShoppingCartPage(driver);
		Thread.sleep(3000);
		assertTrue(cartObj.ProductAddedToCartName.getText().contains("MacBook"));
		cartObj.addingnumberTotheTxtBox("4");
		cartObj.ToClickOnUpdate();
		assertTrue(cartObj.totalprice.getText().contains("7,200.00"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		cartObj.checkboxclickonit();
		cartObj.ToChecOut();
		Thread.sleep(3000);
		checkoutObj=new RegisteredUserCheckoutPage(driver);
		js.executeScript("window.scrollBy(0,100)");
		guestObj = new TochkeoutAsAguestPage(driver);
		guestObj.CheckingoutasAguestBtn();
		Thread.sleep(3000);
		
		checkoutObj.GuestCheckoutProduct(fname, lname, email, country, city, address, zip, num);
		Assert.assertTrue(checkoutObj.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObj.prodcutName.getText().contains(productname));
		checkoutObj.confirmOrder();
		Assert.assertTrue(checkoutObj.ThankYoulbl.isDisplayed());
	}

	@Test(priority=4)
	public void UserCanViewOrderDetails() throws InterruptedException {
		orderObj = new OrderDetailsPage(driver);
		checkoutObj.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObj.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderObj.PrintOrderDetails();
	}
		
		
	}
	



		
	


