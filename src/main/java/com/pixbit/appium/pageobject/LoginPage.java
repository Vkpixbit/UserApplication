package com.pixbit.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class LoginPage extends AndroidActions {

	AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement emailField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement passwordField;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Login'])[2]")
	private WebElement loginButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign up']")
	private WebElement signUpTab;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement signUpEmailField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Send OTP']")
	private WebElement sendOtpButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement otpEnterField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
	private WebElement verifyButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement signUpPhoneField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement signUpFullNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement signUpPasswordField;

	@AndroidFindBy(xpath = "//android.widget.CheckBox")
	private WebElement privacyPolicyClick;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Create Account Now']")
	private WebElement createAccount;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip now, I will do it later']")
	private WebElement skipVerification;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+971']")
	private WebElement countryPickerClick;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
	private WebElement countryEnterField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+91']")
	private WebElement clickIndia;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='18']")
	private WebElement languageDropdown;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue as Guest']")
	private WebElement guestUsrBtn;

	public HomePage loginToApp(String emailId, String password) {
		emailField.sendKeys(emailId);
		passwordField.sendKeys(password);
		loginButton.click();
		return new HomePage(driver);
	}

	public void selectLanguage(String prefred_language) throws InterruptedException {
		Thread.sleep(3000);
		languageDropdown.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + prefred_language + "']")).click();

	}

	public void userSignUp(String emailId, String phoneNumber, String userName, String password,
			String prefred_language) throws InterruptedException {
		Thread.sleep(2000);
		signUpTab.click();
		signUpEmailField.sendKeys(emailId);
		sendOtpButton.click();
		Thread.sleep(2000);
		otpEnterField.sendKeys("1234");
		verifyButton.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		signUpPhoneField.sendKeys(phoneNumber);
		sendOtpButton.click();
		Thread.sleep(2000);
		otpEnterField.sendKeys("1234");
		verifyButton.click();
		Thread.sleep(2000);
		signUpFullNameField.sendKeys(userName);
		signUpPasswordField.sendKeys(password);
		Thread.sleep(2000);
		selectLanguage(prefred_language);
		privacyPolicyClick.click();
		createAccount.click();

	}

	public void get_language_validation_message() {
		WebElement language_error = driver.findElement(By.id("in.pixbit.proptech:id/alertTitle"));
		if(language_error.isDisplayed()) {
			System.out.println("Language is required for signup user!");
		}
	}

	public void userSignUpWithOutLanguage(String emailId, String phoneNumber, String userName, String password)
			throws InterruptedException {
		signUpTab.click();
		signUpEmailField.sendKeys(emailId);
		sendOtpButton.click();
		Thread.sleep(2000);
		otpEnterField.sendKeys("1234");
		verifyButton.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		signUpPhoneField.sendKeys(phoneNumber);
		sendOtpButton.click();
		Thread.sleep(2000);
		otpEnterField.sendKeys("1234");
		verifyButton.click();
		Thread.sleep(2000);
		signUpFullNameField.sendKeys(userName);
		signUpPasswordField.sendKeys(password);
		Thread.sleep(2000);
		privacyPolicyClick.click();
		createAccount.click();
		get_language_validation_message();

	}
	
	public HomePage guestUsrOpnMarketplace() throws InterruptedException {
		Thread.sleep(2000);
		guestUsrBtn.click();
		return new HomePage(driver);
	}

	public String verifySignUp() {
		String signUpMessage =driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).getText();
		return signUpMessage;
	}
	
	public HomePage skipVerification() throws InterruptedException {
		Thread.sleep(2000);
		skipVerification.click();
		return new HomePage(driver);
	}
}
