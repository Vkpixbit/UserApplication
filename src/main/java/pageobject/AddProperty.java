package pageobject;

import java.time.Duration;
import java.util.List;
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

public class AddProperty extends AndroidActions {

	AndroidDriver driver;

	public AddProperty(AndroidDriver driver) {
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

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement propertyNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='11']")
	private WebElement propertyValueField;

	@AndroidFindBy(id = "android:id/title")
	private List<WebElement> DocumentsList;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement titleDeedNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement communityField;

	@AndroidFindBy(accessibility = "Calender")
	private WebElement calender;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Year Picker']")
	private WebElement yearPicker;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select One']")
	private WebElement areaRegionClick;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement unitNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement plotAreaSqMtField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement plotAreaSqFtField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='10']")
	private WebElement buildUpAreaField;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@index='6']")
	private WebElement propertyTypeScroll;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement buildingNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement buildingNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='10']")
	private WebElement propertyNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement floorNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement parkingField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='10']")
	private WebElement suiteAreaField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='12']")
	private WebElement balconyAreaField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement totalAreaSqMt;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement totalAreaSqFt;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='10']")
	private WebElement commonArea;

	@AndroidFindBy(accessibility = "My Location")
	private WebElement myLocationClick;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Location']")
	private WebElement selectLocation;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save Property']")
	private WebElement savePropertyButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip Now, I will add it later']")
	private WebElement skipRentButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
	private WebElement countryEnterField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+91']")
	private WebElement clickIndia;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+971']")
	private WebElement countryPickerClick;

	//private boolean isPermissionApproved;

	public void titleDeedVerification(String titledeedDocument, String title_deed_number, String year)
			throws InterruptedException {
		titleDeedUpload.click();
		approvePermission();
		/*if (!isPermissionApproved) {
			approvePermission();
			isPermissionApproved = true;
		}*/
		scrollToElementByText(titledeedDocument);
		for (WebElement DocumentList : DocumentsList) {
			String DocumentName = DocumentList.getText();
			if (DocumentName.equals(titledeedDocument)) {
				DocumentList.click();
			}
		}
		Thread.sleep(2000);
		continueButton.click();
		Thread.sleep(4000);
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
	
	public void selectSingleOwnership() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Single ownership']")).click();
	}

	// all owners in india
	// Add one owner and skip one owner
	public void addOneOwnerAndSkipOne(String owner_1_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
	}

	// Owner all India
	// both owners are in the prosper
	public void twoOwnerCountSelectionAndAdd(String owner_1_percentage, String owner_2_phone_number,
			String owner_2_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_2_phone_number);
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_2_percentage);
		clickSave.click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save & Continue\"));"));
		clickSaveAndContinue.click();
	}

	// Owner all India
	// Added Two owners are in the prosper
	public void threeOwnerCountSelectionAndSkipOne(String owner_1_percentage, String owner_2_phone_number,
			String owner_2_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_2_phone_number);
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_2_percentage);
		clickSave.click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
	}

	// all owners in India
	// Add three owners, 1 owner not in prosper and skip one
	public void fourOwnerAddThreeSkipOne(String owner_1_percentage, String owner_2_phone_number,
			String owner_2_percentage, String owner_3_phone_number, String owner_3_email, String owner_3_name,
			String owner_3_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_2_phone_number);
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_2_percentage);
		clickSave.click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_3_phone_number);
		ownerEmailField.sendKeys(owner_3_email);
		ownerNameField.sendKeys(owner_3_name);
		ownerPercentageField.sendKeys(owner_3_percentage);
		clickSave.click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
	}

	// added owner not verified
	// second owner is guest
	// third is verifed
	// fourth is  verified
	// skip one
	public void fiveOwnerAddFourSkipOne(String owner_1_percentage, String owner_2_phone_number, String owner_2_email,
			String owner_2_name, String owner_2_percentage, String owner_3_phone_number, String owner_3_percentage,
			String owner_4_phone_number, String owner_4_percentage) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();
		addOwner.click();
		Thread.sleep(2000);
		ownerPercentageField.sendKeys(owner_1_percentage);
		clickSave.click();
		Thread.sleep(3000);
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_2_phone_number);
		ownerEmailField.sendKeys(owner_2_email);
		ownerNameField.sendKeys(owner_2_name);
		ownerPercentageField.sendKeys(owner_2_percentage);
		clickSave.click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Owner 3/5\"));"));
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_3_phone_number);
		ownerPercentageField.sendKeys(owner_3_percentage);
		clickSave.click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Owner 4/5\"));"));
		addOwner.click();
		countryPickerClick.click();
		countryEnterField.sendKeys("India");
		clickIndia.click();
		ownerPhoneField.sendKeys(owner_4_phone_number);
		ownerPercentageField.sendKeys(owner_4_percentage);
		clickSave.click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
	}
	
	//skip all owners adding
	public void twoOwnersSkipAll() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Skip & Continue\"));"));
		skipAndContinue.click();
	}

	// Joint property,Property type not add service apartment,Office,Apartment
	public void propertyAdd(String property_name, String property_category, String property_type,
			String property_status, String age_of_property, String present_use, String area_region,
			String property_value, String unit_number, String plot_area_sq_mt, String plot_area_sq_ft,
			String buildup_area, String furnishing_status) throws InterruptedException {
		propertyNameField.sendKeys(property_name);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\'" + property_category + "\']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + property_type + "']")); // Not add
																									// property
																									// type as
																									// Service
																									// Apartment,Office,Apartment
		WebElement propertyStatus = driver
				.findElement(By.xpath("//android.widget.TextView[@text='" + property_status + "']"));
		propertyStatus.click();
		if (propertyStatus.isSelected() && property_status.equals("Under construction")) {
			nextButtonClick();
		} else {
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + age_of_property + "']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + present_use + "']")).click();
			driver.findElement(
					AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
			nextButtonClick();
		}
		areaRegionClick.click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + area_region + "\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + area_region + "']")).click();
		AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Purchase Amount (Required)\"));");
		propertyValueField.sendKeys(property_value);
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
		unitNumberField.sendKeys(unit_number);
		plotAreaSqMtField.sendKeys(plot_area_sq_mt);
		plotAreaSqFtField.sendKeys(plot_area_sq_ft);
		buildUpAreaField.sendKeys(buildup_area);
		nextButtonClick();
		Thread.sleep(2000);
		myLocationClick.click();
		Thread.sleep(2000);
		alwaysGivePermission();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.xpath("//android.widget.TextView[@text='Select Location']")), "text",
				"Select Location"));
		selectLocation.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + furnishing_status + "']")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Property\"));"));
		savePropertyButton.click();
		skipRentButton.click();
		Thread.sleep(2000);
	}

}
