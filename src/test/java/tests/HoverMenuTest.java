package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProdutcsResultedFromHoverPage;

public class HoverMenuTest extends TestBase{

	HomePage homeObject ; 
	ProdutcsResultedFromHoverPage PRHObject;
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu() throws InterruptedException 
	{
		homeObject = new HomePage(driver); 
		Thread.sleep(2000);
		homeObject.selectNotebooksMenu();
		PRHObject = new ProdutcsResultedFromHoverPage(driver);
		Assert.assertTrue(PRHObject.NoteBookTitle.getText().equalsIgnoreCase("Notebooks"));
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/notebooks"));
		//Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
