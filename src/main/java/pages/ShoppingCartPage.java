package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage  extends pageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		action=new Actions(driver);
	}
	@FindBy(css="button.remove-btn")
	WebElement ButtonToRemoveFromCart;

	public void ClickOnRemoveFromCart() {
		ClickBtn(ButtonToRemoveFromCart);

	}
	//To change the quantity
	@FindBy(css="input.qty-input")
	WebElement ToChangeTheQuantityTxtBox ;
	public void addingnumberTotheTxtBox(String number) throws InterruptedException {
		action.moveToElement(ToChangeTheQuantityTxtBox).click().build().perform();
		cleartxtBox(ToChangeTheQuantityTxtBox);
		Thread.sleep(500);
		SendingKeys(ToChangeTheQuantityTxtBox, number);
	}
	@FindBy (id="updatecart")
	WebElement updateBtn;
	public void ToClickOnUpdate() {
		ClickBtn(updateBtn);
		
	}
	@FindBy(css="span.product-subtotal")
	public WebElement totalprice;

	//for assertion after clearing 

	@FindBy(css="div.no-data")
	public WebElement NoDataExistLabel;

	//for assertion after adding 
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement ProductAddedToCartName ; 


	//To Check out 
	@FindBy(id="termsofservice")
	 WebElement CheckBoxToCheckOut;

	@FindBy (id="checkout")
	WebElement CheckOutBtn ;

	public void checkboxclickonit() {
		ClickBtn(CheckBoxToCheckOut);
	}
	public void ToChecOut() {
		ClickBtn(CheckOutBtn);

	}



}
