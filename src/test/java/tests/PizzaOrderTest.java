package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.PizzaBase;
import pageobjects.PizzaCheckOutPage;
import pageobjects.PizzaDrinksPage;
import pageobjects.PizzaHomePage;
import pageobjects.PizzaSidesPage;

@Listeners(listeners.MyListeners.class)

public class PizzaOrderTest extends PizzaBase {

	public WebDriver driver;
	String fileName;

	@BeforeSuite
	public void setup() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1)
	public void EnterLocation() throws IOException {
		PizzaHomePage pizzahomepage = new PizzaHomePage(driver);

		// pizzahomepage.whyPageLeavingPopUp();
		pizzahomepage.clickDeliveryTab();
		takeScreenShot(fileName, driver);
		// pizzahomepage.clickCollectionTab();
		pizzahomepage.enterLocationForDelivery(prop.getProperty("locationForDelivery"));
		pizzahomepage.NotificationContainerBasket();
		pizzahomepage.enterLocationForDelivery(prop.getProperty("locationForDelivery"));
		// pizzahomepage.whyPageLeavingPopUp();

		// driver.get("https://www.pizzahut.co.in/order/deals/");
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("deals")) {
			System.out.println("URL contains 'deals'." + currentUrl);
		} else {
			System.out.println("URL contains 'deals'." + currentUrl);
		}
	}

	@Test(priority = 2)
	public void SidePage() throws IOException {
		PizzaSidesPage pizzaSidesPage = new PizzaSidesPage(driver);
		pizzaSidesPage.clickSidesTab();
		takeScreenShot(fileName, driver);
		pizzaSidesPage.addItemLessThan200();
	}

	@Test(priority = 3)
	public void DrinkPage() throws IOException {
		PizzaDrinksPage pizzaDrinksPage = new PizzaDrinksPage(driver);
		pizzaDrinksPage.clickDrinksPage();
		pizzaDrinksPage.addTwoMoreDrinks();
		pizzaDrinksPage.addTwoMoreDrinks();
		takeScreenShot(fileName, driver);
	}

	@Test(priority = 4)
	public void CheckoutPage() {
		PizzaCheckOutPage pizzaCheckOutPage = new PizzaCheckOutPage(driver);
		pizzaCheckOutPage.clickCheckOutButton();

		pizzaCheckOutPage.enterUserName(prop.getProperty("enterUserName"));
		pizzaCheckOutPage.enterUserPhone(prop.getProperty("enterUserPhone"));
		pizzaCheckOutPage.enterUserEmail(prop.getProperty("enterUserEmail"));
	}

	@Test(priority = 5)
	public void RadioButton() throws IOException {
		PizzaCheckOutPage pizzaCheckOutPage = new PizzaCheckOutPage(driver);
		pizzaCheckOutPage.checkOnlinePayRadioButton();
		takeScreenShot(fileName, driver);
		// pizzaCheckOutPage.checkCashPayRadioButton();
		pizzaCheckOutPage.checkIagreeCheckBox();
	}

	@Test(priority = 6)
	public void GiftCard() throws IOException {
		PizzaCheckOutPage pizzaCheckOutPage = new PizzaCheckOutPage(driver);
		pizzaCheckOutPage.clickApplyGiftCard();
		pizzaCheckOutPage.clickCouponTab();
		pizzaCheckOutPage.EnterCouponCode(prop.getProperty("couponCode"));
		pizzaCheckOutPage.clickCouponCodeSubmit();
		pizzaCheckOutPage.errorCouponCode();
		pizzaCheckOutPage.clickCloseCouponPopUp();
		takeScreenShot(fileName, driver);
	}

}
