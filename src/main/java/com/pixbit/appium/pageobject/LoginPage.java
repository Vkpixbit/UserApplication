package com.pixbit.appium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
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

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	private WebElement otpEnterField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
	private WebElement verifyButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement signUpPhoneField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement signUpFullNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement signUpPasswordField;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@index='9']")
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

	public HomePage loginToApp(String emailId, String password) {
		emailField.sendKeys(emailId);
		passwordField.sendKeys(password);
		loginButton.click();
		return new HomePage(driver);
	}

	public void userSignUp(String emailId,String phoneNumber, String userName, String password)
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
		
	}

	public HomePage skipVerification() throws InterruptedException {
		Thread.sleep(2000);
		skipVerification.click();
		return new HomePage(driver);
	}
}
