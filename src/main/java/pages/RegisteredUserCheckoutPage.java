package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisteredUserCheckoutPage extends pageBase {

	public RegisteredUserCheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	private WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;


	@FindBy(id="BillingNewAddress_CountryId")
	WebElement selectFromDropDownList ;

	@FindBy(id="BillingNewAddress_City")
	WebElement CityTxtBox ;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement AddressTxtBox;

	@FindBy (id="BillingNewAddress_ZipPostalCode")
	WebElement ZipCodeTxtBox;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement NumberTxtBox ;

	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continueBtn;


	@FindBy(id = "shippingoption_1")
	private WebElement shippingMethodRdo;
	//shippingoption_1

	@FindBy(css="button.button-1.shipping-method-next-step-button")
	private WebElement continueShippingBtn;

	@FindBy(id="paymentmethod_0")
	WebElement checkmoneyorder;
	
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	private WebElement continuePaymentBtn;
	
	@FindBy(css="button.button-1.payment-info-next-step-button")
	private WebElement continueInfoBtn;

	@FindBy(css = "a.product-name")
	public WebElement prodcutName;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button")
	private WebElement confirmBtn;
	//button-1 shipping-method-next-step-button

	@FindBy(css = "h1")
	public WebElement ThankYoulbl;

	@FindBy(css = "div.title")
	private WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;


	public void billingAddress ( String countryName,String city , String address , String zipcode , 
			String phoneNumber,String productName) throws InterruptedException {
		Select select = new Select (selectFromDropDownList);
		select.selectByVisibleText(countryName);
		SendingKeys(CityTxtBox, city);
		SendingKeys(AddressTxtBox, address);
		SendingKeys(ZipCodeTxtBox, zipcode);
		SendingKeys(NumberTxtBox, phoneNumber);
		ClickBtn(continueBtn);
		ClickBtn(shippingMethodRdo);
		ClickBtn(continueShippingBtn);
		Thread.sleep(1000);
		ClickBtn(continuePaymentBtn);
		Thread.sleep(1000);
		ClickBtn(continueInfoBtn);



	}
	public void confirmOrder() throws InterruptedException 
	{
		ClickBtn(confirmBtn);
		Thread.sleep(2000);
	}
	public void viewOrderDetails() {
		ClickBtn(orderDetailsLink);
	}
	
	public void GuestCheckoutProduct(String firstName, String lastName, String email,String countryName,
			 String address,String city, String postcode, 
			String phone) throws InterruptedException {
		SendingKeys(fnTxt, firstName);
		SendingKeys(lnTxt, lastName);
		SendingKeys(emailTxt, email);
		select = new Select(selectFromDropDownList);
		select.selectByVisibleText(countryName);
		SendingKeys(CityTxtBox, city);
		SendingKeys(AddressTxtBox, address);
		SendingKeys(ZipCodeTxtBox, postcode);
		SendingKeys(NumberTxtBox, phone);
		ClickBtn(continueBtn);
		ClickBtn(shippingMethodRdo);
		ClickBtn(continueShippingBtn);
		Thread.sleep(2000);
		ClickBtn(continuePaymentBtn);
		Thread.sleep(2000);
		ClickBtn(continueInfoBtn);
	}
	

}

