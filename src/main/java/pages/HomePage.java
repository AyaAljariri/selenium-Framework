package pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends pageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor) driver;
		action = new Actions(driver);


	}

	//finding the register link 
	@FindBy(linkText = "Register")
	 public WebElement registration ;
	//implement the method to click on 

	public void openRegistrationPage() {
		//registration.click();
		ClickBtn(registration);
	}

	@FindBy(linkText="Log in")
	public WebElement login;

	public void openLoginPage() {

		ClickBtn(login);
	}

	//those two elements to hover on computers and click on notebooks
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement ComputerMenu; 

	@FindBy(xpath = "html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement NotbooksMenu; 

	public void selectNotebooksMenu() 
	{
		action.moveToElement(ComputerMenu).moveToElement(NotbooksMenu).click().build().perform();
	}



	@FindBy(linkText = "Contact us")
	WebElement ContactUs;

	public void openContactUsPage() 

	{
		scrollToBottom();
		ClickBtn(ContactUs);
	}

	@FindBy(id="customerCurrency")
	WebElement CurrancyElement ;

	public void changethecurrancyfromtheselect() {
		select= new Select(CurrancyElement) ;
		select.selectByVisibleText("Euro");
	}
	
	//adding two items to add to compare page from here 
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/button[2]")
	WebElement Item1 ;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[2]")
	WebElement Item2 ;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[2]")
	WebElement Item3 ;
	@FindBy(css="p.content")
	public WebElement ResultedFromAddingToCompareList ;
	@FindBy(linkText = "product comparison")
	WebElement LinkToGoToComparePage;
	
	public void clickOnproductcomparisonBtn() {
		ClickBtn(LinkToGoToComparePage);
	}
	@FindBy(css="span.close")
	WebElement Close ;
	public void closeTheNotification() {
		ClickBtn(Close);
		
	}
	
	public void addingitemonetoComparePage() {
		ClickBtn(Item1);
	}
	public void addingitemtwotoComparePage() {
		ClickBtn(Item2);
	}
	public void addingitemthreetoComparePage() {
		ClickBtn(Item3);
		
	}
	



}
