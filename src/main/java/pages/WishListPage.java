package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends pageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="button.remove-btn")
	WebElement RemoveTheItemFromWishList ;
	
	public void RemovingfromWishList() {
		ClickBtn(RemoveTheItemFromWishList);
		
	}
	
	@FindBy(css="div.no-data")
	public WebElement ResultedFromRemovingfromWishList ;
	

}
