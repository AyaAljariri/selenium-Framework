package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends pageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
		@FindBy(css = "a.button-2.pdf-invoice-button")
		WebElement pdfInvoiceLink;

		@FindBy(css = "a.button-2.print-order-button")
		WebElement printInvoiceLnk;

		public void PrintOrderDetails() {
			ClickBtn(printInvoiceLnk);
		}

		public void DownloadPDFInvoice() throws InterruptedException {
			ClickBtn(pdfInvoiceLink);
			Thread.sleep(2000);
		}

	


}
