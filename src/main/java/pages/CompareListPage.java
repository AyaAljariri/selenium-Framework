package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends pageBase {

	public CompareListPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css = "a.clear-list")
    private WebElement clearListLink;
	
    @FindBy(css = "div.no-data")
    public WebElement noDataLbl;
    
    @FindBy(css = "table.compare-products-table")
    private WebElement compareTable;
    
    @FindBy(tagName = "tr")
    public List<WebElement> allRows;
    
    @FindBy(tagName = "td")
    public List<WebElement> allCol;
    
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a")
    public WebElement firstProductName; 
    
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]/a")
    public WebElement secodProductName ; 
    
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[4]/a")
    public WebElement thirdProductName ;
   
    public void clearCompareList() 
    {
    	ClickBtn(clearListLink);
    }
    
    public void CompareProducts() 
    {
    	// Get all Rows
    	//System.out.println(allRows.size());
    	// Get data from each Row 
    	for(WebElement row : allRows) 
    	{
    		System.out.println(row.getText() + "\t");
    		for(WebElement col : allCol) 
    		{
    			System.out.println(col.getText()+"\t");
    		}
    	}
    }
    
}
