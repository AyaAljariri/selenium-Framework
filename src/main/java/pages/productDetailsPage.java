package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPage extends pageBase {

	public productDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="div.product-name")
	public WebElement productName;
	
	@FindBy(tagName = "h1")
	public WebElement productNameFromAutoComplete ;
	
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement MailAfriendBtn ;
	
	public void openmailPage() {
		ClickBtn(MailAfriendBtn);
		
	}
	
	//the element to ssert the cyrrency
	@FindBy(css="span.price-value-4")
	public WebElement CurrancyLabel;
	
	//the element to give a review about the product
	@FindBy(linkText = "Add your review")
	WebElement GiveYourReview ;
	
	public void clickonAddreview() {
		ClickBtn(GiveYourReview);
	}
	
	//adding a product to wish list
	@FindBy(id="add-to-wishlist-button-4")
	WebElement wishlistBtn;
	
	public void clickOnAddToWishList() {
		ClickBtn(wishlistBtn);
	}
	@FindBy(css="p.content")
	public WebElement ResultedFromAddingToWishList;
	
	@FindBy(linkText = "wishlist")
	WebElement wishlistBtnFromResultNotifftcation ;
	
	public void clickOnwishlistBtnFromResultNotifftcation() {
		ClickBtn(wishlistBtnFromResultNotifftcation);
		
	}
	//to add products to shopping cart 
	@FindBy(id="add-to-cart-button-4")
	WebElement AddToCartBtn ; 
	public void ClickOnAddToCart() {
		ClickBtn(AddToCartBtn);
		
	}
	
	@FindBy(css="p.content")
	public WebElement AddedToCartNotification ; 
	
	@FindBy(linkText = "shopping cart")
	WebElement shoppingcartLinkText ;
	
	public void ClickOnshoppingCartToGoForwardCartPage() {
		ClickBtn(shoppingcartLinkText);
		
	}
	
}
