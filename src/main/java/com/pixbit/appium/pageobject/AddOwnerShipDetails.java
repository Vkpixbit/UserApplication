package com.pixbit.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify & Continue']")
	private WebElement verifyButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	public WebElement continueButton;

	@AndroidFindBy(accessibility = "Add")
	private WebElement addOwner;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose Title Deed (optional)']")
	private WebElement tenantTitleDeed;
	
	/*
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement ownerPhoneField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement ownerEmailField;
	*/

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement ownerNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement ownerPercentageField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	private WebElement clickSave;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save & Continue']")
	public WebElement clickSaveAndContinue;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip & Continue']")
	public WebElement skipAndContinue;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement titleDeedNumberField;

	@AndroidFindBy(accessibility = "Calender")
	private WebElement calender;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Year Picker']")
	private WebElement yearPicker;

	/*
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
	private WebElement countryEnterField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+91']")
	private WebElement clickIndia;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+971']")
	private WebElement countryPickerClick;
	*/

	private boolean permissionApproved = false;
	
	public void deedSelection(String isTitleDeed,String titledeedDocument) throws InterruptedException {
		boolean isDeed = Boolean.parseBoolean(isTitleDeed);
		if(isDeed) {
			titleDeedUpload.click();
			if (!permissionApproved) {
				approvePermission();
				permissionApproved = true; // Set the flag to true after approval
			}
			driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Title_Deed']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='used_deed']")).click();
			scrollToElementByText(titledeedDocument);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + titledeedDocument + "']")).click();
			Thread.sleep(3000);
			verifyButton.click();
		}
		else {
			titleDeedUpload.click();
			if (!permissionApproved) {
				approvePermission();
				permissionApproved = true; // Set the flag to true after approval
			}
			driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='inital_contract']")).click();
			scrollToElementByText(titledeedDocument);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + titledeedDocument + "']")).click();
			Thread.sleep(3000);
			verifyButton.click();
		}
	}
	
	
	public void deedSelectionForRent(String isTitleDeed,String titledeedDocument) throws InterruptedException {
		boolean isDeed = Boolean.parseBoolean(isTitleDeed);
		if(isDeed) {
			tenantTitleDeed.click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Title_Deed']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='used_deed']")).click();
			scrollToElementByText(titledeedDocument);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + titledeedDocument + "']")).click();
			Thread.sleep(3000);
		}
		else {
			tenantTitleDeed.click();
			if (!permissionApproved) {
				approvePermission();
				permissionApproved = true; // Set the flag to true after approval
			}
			driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='inital_contract']")).click();
			scrollToElementByText(titledeedDocument);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + titledeedDocument + "']")).click();
			Thread.sleep(3000);
		}
	}
	
	/*public void open_title_deed_section(String titledeedDocument) throws InterruptedException {
		titleDeedUpload.click();
		if (!permissionApproved) {
			approvePermission();
			permissionApproved = true; // Set the flag to true after approval
		}
		driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Title_Deed']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='used_deed']")).click();
		scrollToElementByText(titledeedDocument);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + titledeedDocument + "']")).click();
		Thread.sleep(3000);
		
	}
	
	public void open_initial_contract_section(String titledeedDocument) throws InterruptedException {
		titleDeedUpload.click();
		if (!permissionApproved) {
			approvePermission();
			permissionApproved = true; // Set the flag to true after approval
		}
		driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='inital_contract']")).click();
		scrollToElementByText(titledeedDocument);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + titledeedDocument + "']")).click();
		Thread.sleep(3000);
	}

	public void titleDeedVerification(String titledeedDocument)
			throws InterruptedException {
		open_title_deed_section(titledeedDocument);
		verifyButton.click();
	}
	
	public void initialContractVerification(String titledeedDocument) throws InterruptedException {
		open_initial_contract_section(titledeedDocument);
		verifyButton.click();		
	}
	*/

	public void selectJointOwnership() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Joint ownership']")).click();

	}

	public AddProperty selectSingleOwnership() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Single ownership']")).click();
		continueButton.click();
		return new AddProperty(driver);
	}
	
	public void ownnershipAdd(String ownersCount,String skipAll,String ownerName,String ownerNercentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ownersCount+"']")).click();
		if(Boolean.parseBoolean("skipAll")) {
			skipAndContinue.click();
		}
		else {
			for(int i=0; i<Integer.parseInt(ownersCount);i++) {
				driver.findElement(AppiumBy
						.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Owner\"));"));
				ownerAdd(ownerName,ownerNercentage);
			}
		}
		
	}
	
	
	/*
	 * skip all owners adding
	 */
	public AddProperty twoOwnersSkipAll() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Owner\"));"));
		skipAndContinue.click();
		return new AddProperty(driver);
	}

	/*
	 * Ownership add
	 */
	public void ownerAdd(String ownerNames,String ownerNercentage) throws InterruptedException {
		if()
		addOwner.click();
		Thread.sleep(2000);
		ownerNameField.sendKeys(ownerName);
		ownerPercentageField.sendKeys(ownerNercentage);
		clickSave.click();

	}

	/*
	 * all owners in india Add one owner and skip one owner
	 */
	public AddProperty addOwnerAndSkipOne(String ownerName,String ownerPercentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
		Thread.sleep(2000);
		ownerAdd(ownerName, ownerPercentage);
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
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
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
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		owner_adding(country_code, owner_2_phone_number, owner_2_email, owner_2_name, owner_2_percentage);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
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
		//owner_adding(country_code,owner_2_phone_number, owner_2_email, owner_2_name, owner_2_percentage);
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
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		owner_adding(country_code_2,owner_2_phone_number,owner_2_email,owner_2_name,owner_2_percentage);
		Thread.sleep(3000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		owner_adding(country_code_3,owner_3_phone_number,owner_3_email,owner_3_name,owner_3_percentage);
		Thread.sleep(2000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		owner_adding(country_code_4,owner_4_phone_number,owner_4_email,owner_4_name,owner_4_percentage);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save & Continue\"));"));
		clickSaveAndContinue.click();
		return new AddProperty(driver);
	}

	
}
