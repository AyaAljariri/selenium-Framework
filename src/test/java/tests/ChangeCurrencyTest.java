package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPage;
import pages.productDetailsPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage homeObj ;
	productDetailsPage pdObj ;
	SearchPage searchObj;
	String SearchTxt ="MacB";
	String productname ="Apple MacBook Pro 13-inch";



	@Test 
	public void changethecurrencytest() throws InterruptedException {
		homeObj = new HomePage(driver) ;
		pdObj=new productDetailsPage(driver);

		homeObj.changethecurrancyfromtheselect();
		searchObj=new SearchPage(driver);
		searchObj.SearchForProductsAutocomplete(SearchTxt);
		pdObj = new productDetailsPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,150)");
		Assert.assertEquals(pdObj.CurrancyLabel.getText(),"€1548.00");
		System.out.println(pdObj.CurrancyLabel.getText());





	}








}
