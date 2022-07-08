package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.HomePage;

public class AddingToCompareListTest extends TestBase {
	HomePage homeObj;
	CompareListPage compareObj;
	@Test(priority = 1)
	public void addingToCompareListTest() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,650)");
		homeObj=new HomePage(driver);
		homeObj.addingitemonetoComparePage();
		Thread.sleep(3000);

		Assert.assertTrue(homeObj.ResultedFromAddingToCompareList.getText().contains("has been added"));
		homeObj.closeTheNotification();
		Thread.sleep(2500);
		homeObj.addingitemtwotoComparePage();
		Thread.sleep(3000);

		Assert.assertTrue(homeObj.ResultedFromAddingToCompareList.getText().contains("has been added"));
		homeObj.closeTheNotification();
		homeObj.addingitemthreetoComparePage();
		Thread.sleep(3000);

		Assert.assertTrue(homeObj.ResultedFromAddingToCompareList.getText().contains("has been added"));
		homeObj.clickOnproductcomparisonBtn();
		Thread.sleep(7000);
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		compareObj=new CompareListPage(driver);
		
		Assert.assertTrue(compareObj.firstProductName.getText().contains("HTC One M8 Android L 5.0 Lollipop"));
		Assert.assertTrue(compareObj.secodProductName.getText().contains("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(compareObj.thirdProductName.getText().contains("Build your own computer"));
		System.out.println(compareObj.firstProductName.getText() + " " + compareObj.secodProductName.getText()+ " " +compareObj.firstProductName.getText());

		

		//Assert.assertTrue(compareObj.firstProductName.getText().equals("Apple MacBook Pro 13-inch"));
		//Assert.assertTrue(compareObj.secodProductName.getText().equals("Build your own computer"));
		compareObj.CompareProducts();	

	}
	@Test(priority=2)
	public void UserCanClearCompareList() {
		compareObj.clearCompareList();
		Assert.assertTrue(compareObj.noDataLbl.getText().contains("You have no items to compare."));
	}

}
