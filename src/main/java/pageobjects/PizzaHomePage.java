package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzaHomePage {
	WebDriver driver;

	public PizzaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[data-item-id='tab--delivery']")
	private WebElement DeliveryTab;

	public void clickDeliveryTab() {
		DeliveryTab.click();
	}

	@FindBy(css = "[data-item-id='tab--collection']")
	private WebElement CollectionTab;

	public void clickCollectionTab() {
		CollectionTab.click();
	}

	@FindBy(css = "[placeholder='Enter your location for delivery']")
	private WebElement LocationForDelivery;

	public void enterLocationForDelivery(String enterLocation) {
		LocationForDelivery.sendKeys(enterLocation);
		LocationForDelivery.sendKeys(Keys.ENTER);
	}

	// Notification container Popup
	@FindBy(css = "div[data-test='app-container']#app")
	private WebElement NotificationContainer;

	public void NotificationContainerBasket() {
		NotificationContainer.click();
	}

	// Validate that the URL has text as ‘deals’

	// Black Popup for "Why are you leaving this page"
	// @FindBy(css = "[id='svg-CloseIcon-YnjGPzk']")
	@FindBy(id = "svg-CloseIcon-YnjGPzk")
	private WebElement PageLeavingPopup;

	public void whyPageLeavingPopUp() {
		PageLeavingPopup.click();
	}

}
