package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends pageBase {
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="small-searchterms")
	WebElement SearchTxtBox ;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement SearchBtn ;
	
	@FindBy (id="ui-id-1")
	List <WebElement> ProductAutoComplete ;
	
	public void searchForProducts(String ProductName) {
		SendingKeys(SearchTxtBox, ProductName);
		ClickBtn(SearchBtn);
		
	}
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement productnameinDetails;
	
	public void productDetails() {
		ClickBtn(productnameinDetails);
		
	}
	public void SearchForProductsAutocomplete(String producttxt) throws InterruptedException {
		SendingKeys(SearchTxtBox, producttxt);
		Thread.sleep(3000);
		ProductAutoComplete.get(0).click();
	}

}
