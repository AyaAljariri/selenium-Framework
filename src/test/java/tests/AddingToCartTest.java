package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.productDetailsPage;

public class AddingToCartTest extends TestBase {
	SearchPage searchObj;
	productDetailsPage productdetailsObj ;
	ShoppingCartPage cartObj;
	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";
	@Test
	public void shoppingCartTest() throws InterruptedException {

		//searchingFor A product from searchPage 
		searchObj=new SearchPage(driver);
		searchObj.SearchForProductsAutocomplete(SearchTxt);
		productdetailsObj = new productDetailsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,150)");
		Assert.assertEquals(productdetailsObj.productName.getText(), productname);

		//Click On add to cart from product Details Page 
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
		System.out.println("The total price of all quantity you will buy is :  " + " " +cartObj.totalprice.getText() );
		
		cartObj.ClickOnRemoveFromCart();
		assertTrue(cartObj.NoDataExistLabel.getText().contains("Your Shopping Cart is empty!"));


	}
}





