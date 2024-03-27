package com.pixbit.appium.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class AddOwnerShipDetails extends AndroidActions {

	AndroidDriver driver;

	public AddOwnerShipDetails(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "ic_doc_upload_btn")
	private WebElement titleDeedUpload;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
	private WebElement verifyButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	public WebElement continueButton;

	@AndroidFindBy(accessibility = "Add")
	private WebElement addOwner;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement ownerPhoneField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement ownerEmailField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
	private WebElement ownerNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement ownerPercentageField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	private WebElement clickSave;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save & Continue']")
	private WebElement clickSaveAndContinue;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip & Continue']")
	private WebElement skipAndContinue;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement titleDeedNumberField;

	@AndroidFindBy(accessibility = "Calender")
	private WebElement calender;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Year Picker']")
	private WebElement yearPicker;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
	private WebElement countryEnterField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+91']")
	private WebElement clickIndia;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+971']")
	private WebElement countryPickerClick;

	private boolean permissionApproved = false;

	public void titleDeedVerification(String titledeedDocument, String title_deed_number, String year)
			throws InterruptedException {
		titleDeedUpload.click();
		if (!permissionApproved) {
			approvePermission();
			permissionApproved = true; // Set the flag to true after approval
		}
		scrollToElementByText(titledeedDocument);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + titledeedDocument + "']")).click();
		Thread.sleep(3000);
		continueButton.click();
		titleDeedNumberField.sendKeys(title_deed_number);
		calender.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(yearPicker));
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + year + "\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + year + "']")).click();
		verifyButton.click();
	}

	public void selectJointOwnership() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Joint ownership']")).click();

	}

	public AddProperty selectSingleOwnership() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Single ownership']")).click();
		continueButton.click();
		return new AddProperty(driver);
	}
	
	/*
	 * skip all owners adding
	 */
	public AddProperty twoOwnersSkipAll() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
		return new AddProperty(driver);
	}

	/*
	 * Ownership add
	 */
	public void owner_adding(String country_code, String owner_phone_number, String owner_email, String owner_name,
			String owner_percentage) throws InterruptedException {
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys(country_code);
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_phone_number);
		Thread.sleep(2000);
		if (ownerEmailField.getText().isEmpty()) {
			ownerEmailField.sendKeys(owner_email);
			ownerNameField.sendKeys(owner_name);
			ownerPercentageField.sendKeys(owner_percentage);
		} else {
			ownerPercentageField.sendKeys(owner_percentage);
		}
		Thread.sleep(2000);
		clickSave.click();

	}

	/*
	 * all owners in india Add one owner and skip one owner
	 */
	public AddProperty addOneOwnerAndSkipOne(String owner_1_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
		return new AddProperty(driver);
	}

	/*
	 * Owner all India add two owners from prosper
	 */
	public AddProperty twoOwnerCountSelectionAndAdd(String owner_1_percentage,String country_code, String owner_2_phone_number,String owner_2_email,String owner_2_name,
			String owner_2_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		owner_adding(country_code,owner_2_phone_number,owner_2_email,owner_2_name,owner_2_percentage);
		Thread.sleep(2000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save & Continue\"));"));
		clickSaveAndContinue.click();
		return new AddProperty(driver);
	}

	/*
	 * Three owner select and add three owners
	 */
	public AddProperty threeOwnersSelectAndAdd(String owner_1_percentage, String country_code,
			String owner_2_phone_number, String owner_2_email, String owner_2_name, String owner_2_percentage,
			String owner_3_phone_number, String owner_3_email, String owner_3_name, String owner_3_percentage)
			throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		owner_adding(country_code, owner_2_phone_number, owner_2_email, owner_2_name, owner_2_percentage);
		Thread.sleep(2000);
		owner_adding(country_code, owner_3_phone_number, owner_3_email, owner_3_name, owner_3_percentage);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save & Continue\"));"));
		clickSaveAndContinue.click();
		return new AddProperty(driver);
	}

	/* 
	 * Three owners add two and skip one owner
	 */
	public AddProperty threeOwnerCountSelectionAndSkipOne(String owner_1_percentage,String country_code, String owner_2_phone_number,
			String owner_2_name, String owner_2_email, String owner_2_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		owner_adding(country_code,owner_2_phone_number, owner_2_email, owner_2_name, owner_2_percentage);
		Thread.sleep(2000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
		return new AddProperty(driver);
	}

	/*
	 * Four owners and add four owners
	 */
	public AddProperty fourOwnerAddFour(String owner_1_percentage,String country_code_2, String owner_2_phone_number,
			String owner_2_email, String owner_2_name, String owner_2_percentage,String country_code_3, String owner_3_phone_number,String owner_3_email,String owner_3_name,
			String owner_3_percentage,String country_code_4,String owner_4_phone_number,String owner_4_email,String owner_4_name, String owner_4_percentage)
			throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Owner 2/4\"));"));
		owner_adding(country_code_2,owner_2_phone_number,owner_2_email,owner_2_name,owner_2_percentage);
		Thread.sleep(3000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Owner 3/4\"));"));
		owner_adding(country_code_3,owner_3_phone_number,owner_3_email,owner_3_name,owner_3_percentage);
		Thread.sleep(2000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Owner 4/4\"));"));
		owner_adding(country_code_4,owner_4_phone_number,owner_4_email,owner_4_name,owner_4_percentage);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save & Continue\"));"));
		skipAndContinue.click();
		return new AddProperty(driver);
	}

	
}
