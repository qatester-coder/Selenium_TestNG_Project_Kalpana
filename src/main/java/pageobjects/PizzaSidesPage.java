package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PizzaSidesPage {
	WebDriver driver;

	public PizzaSidesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSidesTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement SidesTab =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[3]/div[1]/div/a[4]")));
		WebElement SidesTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/a[4]/span[1]")));

		SidesTab.click();
	}

	// @FindBy(xpath = "//span[@class='w-auto ml-3' and contains(text(), '₹149')]")
	// @FindBy(css = "span.w-auto.ml-3")
	// @FindBy(className = "list-item list-item--side ")
	// @FindBy(partialLinkText = "Add")
	@FindBy(css = "span.w-auto.ml-3")
	private WebElement AddItem;

	public void addItemLessThan200() {
		AddItem.click();
	}

}
