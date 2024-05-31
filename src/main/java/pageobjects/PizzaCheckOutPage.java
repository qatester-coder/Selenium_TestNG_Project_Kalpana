package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzaCheckOutPage {
	WebDriver driver;

	public PizzaCheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a")
	private WebElement CheckOutButton;

	public void clickCheckOutButton() {
		CheckOutButton.click();
	}

	@FindBy(id = "checkout__name")
	private WebElement UserName;

	public void enterUserName(String username) {
		UserName.sendKeys(username);
	}

	@FindBy(id = "checkout__phone")
	private WebElement UserPhone;

	public void enterUserPhone(String userphone) {
		UserPhone.sendKeys(userphone);
	}

	@FindBy(id = "checkout__email")
	private WebElement UserEmail;

	public void enterUserEmail(String useremail) {
		UserEmail.sendKeys(useremail);
	}

	// @FindBy(className = "w-full")
	@FindBy(css = "div.sc-fzqMdD.eohbfP")
	private WebElement ApplyGiftCard;

	public void clickApplyGiftCard() {
		ApplyGiftCard.click();
	}

	// Apply a Giftcard
	@FindBy(css = "div.sc-fznMnq.gdZumo")
	private WebElement CouponTab;

	public void clickCouponTab() {
		CouponTab.click();
	}

	// Coupon Code
	@FindBy(name = "voucherId")
	private WebElement CouponCode;

	public void EnterCouponCode(String couponcode) {
		CouponCode.sendKeys(couponcode);
	}

	// CouponCode Submit button
	@FindBy(css = "button.sc-AxheI.fhPHUH")
	private WebElement CouponCodeSubmit;

	public void clickCouponCodeSubmit() {
		CouponCodeSubmit.click();
	}

	// Error Message
	@FindBy(css = "div.sc-fznJRM.ciBEcK")
	private WebElement CouponCodeError;

	public void errorCouponCode() {
		if (CouponCodeError.getText().contains("Sorry, we don’t currently support that coupon code")) {
			System.out.println("Error message indicates that the coupon code is incorrect");
		} else {
			System.out.println("Error message does not indicate that the coupon code is incorrect");
		}
	}

	// Close CouponCode PopUp
	@FindBy(css = "button.sc-AxheI.fdmZdE")
	private WebElement CloseCouponPopUp;

	public void clickCloseCouponPopUp() {
		CloseCouponPopUp.click();
	}

	@FindBy(id = "payment-method--razorpay")
	private WebElement OnlinePayRadioButton;

	public void checkOnlinePayRadioButton() {
		if (OnlinePayRadioButton.isSelected()) {
			System.out.println("Online Payment Radio Button is selected by default.");
		} else {
			System.out.println("Online Payment Radio Button is not selected by default.");
		}
	}

	// @FindBy(xpath = "//*[@id='payment-method--cash']")
	// @FindBy(partialLinkText = "Cash")
	// @FindBy(id = "payment-method--cash")
	// @FindBy(css = "input#payment-method--cash")
	@FindBy(css = "label[for='payment-method--cash']:nth-of-type(2)")
	private WebElement CashPayRadioButton;

	public void checkCashPayRadioButton() {
		CashPayRadioButton.click();
		System.out.println("Cash Pay Radio Button is selected.");
	}

	@FindBy(id = "marketingOptIn")
	private WebElement IagreeCheckBox;

	public void checkIagreeCheckBox() {
		if (IagreeCheckBox.isSelected()) {
			System.out.println("I agree CheckBox is selected by default.");
		} else {
			System.out.println("I agree CheckBox is not selected by default.");
		}
	}

}
