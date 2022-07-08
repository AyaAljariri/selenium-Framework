package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBase {

	//the protected will work great in the same package 
	protected WebDriver driver ;
	public JavascriptExecutor jse ; 
	public Select select;
	public Actions action;


	//create constructor 
	public pageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//we created this method to make easy instead telling him to click at every btn i can just call it
	protected static void ClickBtn(WebElement Btn) {
		Btn.click();
	}

	protected static void SendingKeys(WebElement TxtElement , String value) {
		TxtElement.sendKeys(value);
		//two parameters one for the element name and one for the value will hold with SendKeys

	}
	protected static void cleartxtBox(WebElement element)
	{ 
		element.clear();
	}


	public void scrollToBottom() 

	{
		jse.executeScript("scrollBy(0,2500)"); 
	}

}
