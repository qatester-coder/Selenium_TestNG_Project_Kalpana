package AllureReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.PizzaBase;
import pageobjects.PizzaCheckOutPage;
import pageobjects.PizzaDrinksPage;
import pageobjects.PizzaHomePage;
import pageobjects.PizzaSidesPage;

@Listeners(listeners.MyListeners.class)

public class testAllure extends PizzaBase {

	public WebDriver driver;
	String fileName;

	@BeforeMethod
	public void setup() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {

		// driver.quit();
	}

	@Test
	public void pizzaOrder() throws IOException {

		System.out.println("Pizza Order Testing");
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

		// driver.get("https://www.pizzahut.co.in/order/deals/");

		PizzaSidesPage pizzaSidesPage = new PizzaSidesPage(driver);
		pizzaSidesPage.clickSidesTab();
		takeScreenShot(fileName, driver);
		pizzaSidesPage.addItemLessThan200();

		PizzaDrinksPage pizzaDrinksPage = new PizzaDrinksPage(driver);
		pizzaDrinksPage.clickDrinksPage();
		pizzaDrinksPage.addTwoMoreDrinks();
		pizzaDrinksPage.addTwoMoreDrinks();
		takeScreenShot(fileName, driver);

		PizzaCheckOutPage pizzaCheckOutPage = new PizzaCheckOutPage(driver);
		pizzaCheckOutPage.clickCheckOutButton();

		pizzaCheckOutPage.enterUserName(prop.getProperty("enterUserName"));
		pizzaCheckOutPage.enterUserPhone(prop.getProperty("enterUserPhone"));
		pizzaCheckOutPage.enterUserEmail(prop.getProperty("enterUserEmail"));

		pizzaCheckOutPage.checkOnlinePayRadioButton();
		takeScreenShot(fileName, driver);
		// pizzaCheckOutPage.checkCashPayRadioButton();
		pizzaCheckOutPage.checkIagreeCheckBox();

		pizzaCheckOutPage.clickApplyGiftCard();
		pizzaCheckOutPage.clickCouponTab();
		pizzaCheckOutPage.EnterCouponCode(prop.getProperty("couponCode"));
		pizzaCheckOutPage.clickCouponCodeSubmit();
		pizzaCheckOutPage.errorCouponCode();
		pizzaCheckOutPage.clickCloseCouponPopUp();

		// pizzaCheckOutPage.checkOnlinePayRadioButton();
		// pizzaCheckOutPage.checkCashPayRadioButton();
		// pizzaCheckOutPage.checkIagreeCheckBox();

		takeScreenShot(fileName, driver);
	}

}
