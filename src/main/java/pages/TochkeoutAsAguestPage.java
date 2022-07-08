package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TochkeoutAsAguestPage extends pageBase {

	public TochkeoutAsAguestPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
	WebElement asAguestBheckout ; 
	
	public void CheckingoutasAguestBtn () {
		ClickBtn(asAguestBheckout);
	}
}
