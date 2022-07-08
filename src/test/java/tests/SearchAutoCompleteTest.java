package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;
import pages.productDetailsPage;

public class SearchAutoCompleteTest extends TestBase {
	SearchPage searchObj;
	productDetailsPage productdetailsObj ;
	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";

	
	@Test
	public void AutocompleteSearch() throws InterruptedException {
		try {
			searchObj=new SearchPage(driver);
		searchObj.SearchForProductsAutocomplete(SearchTxt);
		productdetailsObj = new productDetailsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,150)");
		Assert.assertEquals(productdetailsObj.productName.getText(), productname);
		//Assert.assertEquals(productdetailsObj.productNameFromAutoComplete.getText(), productname);

			
		} catch (Exception e) {
		System.out.println( "Error Msg : "+e.getMessage()) ;
		}
		
		
	}

}
