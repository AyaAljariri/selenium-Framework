package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends pageBase{

	public ReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxtBox;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTxtBox ;
	
	@FindBy (id="addproductrating_4")
	WebElement ratingExcellent;
	
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement submitReviewBtn ;
	
	@FindBy (css="div.result")
	public WebElement reviewResult;

	
	public void RegisteredUserCanReview(String title , String openion) {
		SendingKeys(reviewTitleTxtBox, title);
		SendingKeys(reviewTxtBox, openion);
		ClickBtn(ratingExcellent);
		ClickBtn(submitReviewBtn);
}
}
