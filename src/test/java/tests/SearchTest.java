package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;
import pages.productDetailsPage;

public class SearchTest extends TestBase {

	SearchPage searchObj ;
	productDetailsPage productdetailsObj;
	String productname ="Apple MacBook Pro 13-inch";



	@Test
	public void SearchOnProduct() {
		searchObj=new SearchPage(driver);
		productdetailsObj=new productDetailsPage(driver);
		searchObj.searchForProducts(productname);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,350)");
		Assert.assertTrue(searchObj.productnameinDetails.getText().equals(productname));
		searchObj.productDetails();
		Assert.assertEquals(productdetailsObj.productName.getText(), productname);
		System.out.println("Your Search is Successed");

	}

}
