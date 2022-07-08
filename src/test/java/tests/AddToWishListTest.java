package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;
import pages.WishListPage;
import pages.productDetailsPage;

public class AddToWishListTest extends TestBase{
	SearchPage searchObj;
	productDetailsPage productdetailsObj ;
	WishListPage WishListObj;
	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";


	@Test
	public void userCanAddProductToWishList() throws InterruptedException {

		searchObj=new SearchPage(driver);
		searchObj.SearchForProductsAutocomplete(SearchTxt);
		productdetailsObj = new productDetailsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,150)");
		productdetailsObj.clickOnAddToWishList();
		Thread.sleep(3000);
		Assert.assertTrue(productdetailsObj.ResultedFromAddingToWishList.getText()
				.contains("The product has been added"));
		productdetailsObj.clickOnwishlistBtnFromResultNotifftcation();
		WishListObj=new WishListPage(driver);
		WishListObj.RemovingfromWishList();
		Assert.assertTrue(WishListObj.ResultedFromRemovingfromWishList.getText().contains("The wishlist is empty!"));
				
	}


}
