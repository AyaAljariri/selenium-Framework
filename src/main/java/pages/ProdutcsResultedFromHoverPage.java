package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutcsResultedFromHoverPage extends pageBase {

	public ProdutcsResultedFromHoverPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")
	 public WebElement NoteBookTitle;

}
