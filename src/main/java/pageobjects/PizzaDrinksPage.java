package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzaDrinksPage {
	WebDriver driver;

	public PizzaDrinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div[3]/div[1]/div/a[7]")
	private WebElement DrinksTab;

	public void clickDrinksPage() {
		DrinksTab.click();
	}

	@FindBy(css = "span.w-auto.ml-3")
	private WebElement AddDrinks;

	public void addTwoMoreDrinks() {
		AddDrinks.click();
	}

}
