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

	@AndroidFindBy(accessibility = "Mortgage Dropdown")
	private WebElement mortgageDropdown;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement mortgageAmountField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement tenureYearField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement tenureMonthField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='9']")
	private WebElement mortgageStartDateField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='11']")
	private WebElement finaceRateField;

	@AndroidFindBy(id = "android:id/title")
	private List<WebElement> DocumentsList;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement communityField;

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

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
	private WebElement buildingNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement buildingNameField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='9']")
	private WebElement propertyNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='11']")
	private WebElement floorNumberField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement parkingField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
	private WebElement suiteAreaField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Rental Details']")
	private WebElement clickAddRent;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Go to my propertiess']")
	private WebElement goToPropertiesButton;

	@AndroidFindBy(accessibility = "Mortgage Dropdown")
	private WebElement mortgageSelection;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement mortgageAmount;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='9']")
	private WebElement durationYear;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='10']")
	private WebElement durationMonth;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='12']")
	private WebElement financeStartDate;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='14']")
	private WebElement financeRate;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text()='Save Details']")
	private WebElement saveDetailsButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@index='6']")
	private WebElement moreButton;

	/*
	 * Enter Property Name
	 */
	public void enter_property_name(String property_name) {
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys(property_name);

	}

	/*
	 * Select Property Category
	 */
	public void select_property_category(String property_category) {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\'" + property_category + "\']")).click();
	}

	/*
	 * Select Property Type As Apartment
	 */
	public void select_apartment() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Apartment']")).click();
	}

	/*
	 * Select Property Type As Villa
	 */
	public void select_villa() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Villa']")).click();
	}

	/*
	 * Select Property Type As Townhouse
	 */
	public void select_townhouse() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Townhouse']")).click();
	}

	/*
	 * Select Property Type As Office
	 */
	public void select_office() throws InterruptedException {
		moreButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Office']")).click();
	}

	/*
	 * Select Property Type As Service Apartment
	 */
	public void select_service_apartment() throws InterruptedException {
		moreButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Service Apartment']")).click();
	}

	/*
	 * Select Property Status as Ready and Enter Age Of Property and Select Present
	 * Use
	 */
	public void select_ready_status(String age_of_property, String present_use) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Ready']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='2+']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(age_of_property);
		click_done();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + present_use + "']")).click();
	}

	/*
	 * Select Property Status As Under Construction
	 */
	public void select_under_construction_status() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Under construction']")).click();
	}

	/*
	 * Select Title Deed Issue Date
	 */
	public void select_titleded_issue_date(String titledeed_issue_date) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys(titledeed_issue_date);
	}

	/*
	 * Enter Plot Number
	 */
	public void enter_plot_number(String plot_number) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).sendKeys(plot_number);
	}

	/*
	 * Enter Municipality Number
	 */
	public void enter_municipality_number(String municipality_number) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText[@index='5']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@index='5']")).sendKeys(municipality_number);
	}

	/*
	 * Clear The Municipality Number Field
	 */
	public void clear_municipality_number() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText[@index='5']")).clear();
		Thread.sleep(2000);
	}

	/*
	 * Enter Community Data
	 */
	public void enter_community(String community) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText[@index='7']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@index='7']")).sendKeys(community);
	}

	/*
	 * Select Area/Region
	 */
	public void select_area_region(String area_region) throws InterruptedException {
		areaRegionClick.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(area_region);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + area_region + "']")).click();
	}

	/*
	 * Enter Purchase Price
	 */
	public void enter_purchase_price(String property_value) {
		AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Purchase Amount (Required)\"));");
		driver.findElement(By.xpath("//android.widget.EditText[@index='11']")).clear();
		driver.findElement(By.xpath("//android.widget.EditText[@index='11']")).sendKeys(property_value);
	}

	/*
	 * Select Mortgage Status As No
	 */
	public void select_not_mortgaged() throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Mortgage Status (Required)\").instance(0))"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mortgage Dropdown\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mortgage Dropdown\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Not Mortgaged']")).click();
		driver.findElement(AppiumBy.accessibilityId("Back")).click();
	}

	/*
	 * Select Mortgage as Yes and Skip The Fields
	 */
	public void select_mortgaged_skip() throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Building Number (Required)\"));"));
		Thread.sleep(2000);
		mortgageDropdown.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mortgage Dropdown\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mortgaged']")).click();
		AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Details\"));");
		driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
	}

	/*
	 * Select Mortgage And Tenure Is Only with Year Value
	 */
	public void select_mortgaged_tenure_year(String mortgage_amount, String tenure_year, String mortgage_start_date,
			String finance_rate) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mortgage Status (Required)\"));"));
		Thread.sleep(2000);
		mortgageDropdown.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mortgage Dropdown\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mortgaged']")).click();
		mortgageAmountField.sendKeys(mortgage_amount);
		tenureYearField.sendKeys(tenure_year);
		mortgageStartDateField.sendKeys(mortgage_start_date);
		finaceRateField.sendKeys(finance_rate);
		AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Details\"));");
		driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
	}

	/*
	 * Select Mortgage And Tenure Is Only With Month Value
	 */
	public void select_mortgaged_tenure_month(String mortgage_amount, String tenure_month, String mortgage_start_date,
			String finance_rate) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mortgage Status (Required)\"));"));
		Thread.sleep(2000);
		mortgageDropdown.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mortgage Dropdown\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mortgaged']")).click();
		mortgageAmountField.sendKeys(mortgage_amount);
		tenureMonthField.sendKeys(tenure_month);
		mortgageStartDateField.sendKeys(mortgage_start_date);
		finaceRateField.sendKeys(finance_rate);
		AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Details\"));");
		driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
	}

	/*
	 * Select Mortgage And Tenure As Year And Month With Offer Letter
	 */
	public void select_mortgaged_tenure_year_month_offer_letter(String mortgage_amount, String tenure_year,
			String tenure_month, String mortgage_start_date, String finance_rate, String offer_letter)
			throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mortgage Status (Required)\"));"));
		Thread.sleep(2000);
		mortgageDropdown.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mortgage Dropdown\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mortgaged']")).click();
		mortgageAmountField.sendKeys(mortgage_amount);
		tenureYearField.sendKeys(tenure_year);
		tenureMonthField.sendKeys(tenure_month);
		mortgageStartDateField.sendKeys(mortgage_start_date);
		finaceRateField.sendKeys(finance_rate);

	}

	/*
	 * Enter Building Number
	 */
	public void enter_building_number(String building_number) throws InterruptedException {
		/*
		 * driver.findElement(AppiumBy.androidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Building Number (Required)\"));"
		 * ));
		 */
		Thread.sleep(2000);
		buildingNumberField.clear();
		Thread.sleep(2000);
		buildingNumberField.sendKeys(building_number);
	}

	/*
	 * Enter Building Name
	 */
	public void enter_building_name(String building_name) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Building Name (Required)\"));"));
		Thread.sleep(2000);
		buildingNameField.clear();
		Thread.sleep(2000);
		buildingNameField.sendKeys(building_name);
	}

	/*
	 * Enter Property Number
	 */
	public void enter_property_number(String property_number) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Property Number (Required)\"));"));
		Thread.sleep(2000);
		propertyNumberField.clear();
		Thread.sleep(2000);
		propertyNumberField.sendKeys(property_number);
	}

	/*
	 * Enter Floor Number
	 */
	public void enter_floor_number(String floor_number) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Floor Number (Required)\"));"));
		Thread.sleep(2000);
		floorNumberField.clear();
		Thread.sleep(2000);
		floorNumberField.sendKeys(floor_number);
	}

	/*
	 * Enter Parking Data
	 */
	public void enter_parking(String parking) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Common Area (Required)\"));"));
		Thread.sleep(2000);
		parkingField.clear();
		Thread.sleep(2000);
		parkingField.sendKeys(parking);
	}

	/*
	 * Enter Suite Area
	 */
	public void enter_suite_area(String suite_area) throws InterruptedException {
		scroll_to_next();
		suiteAreaField.clear();
		Thread.sleep(2000);
		suiteAreaField.sendKeys(suite_area);
	}

	/*
	 * Enter Balcony Area
	 */
	public void enter_balcony_area(String balcony_area) throws InterruptedException {
		balconyAreaField.clear();
		Thread.sleep(2000);
		balconyAreaField.sendKeys(balcony_area);
	}

	/*
	 * Enter Total Area Sq Mt
	 */
	public void enter_total_area_sqm(String total_area_sqm) throws InterruptedException {
		totalAreaSqMt.clear();
		Thread.sleep(2000);
		totalAreaSqMt.sendKeys(total_area_sqm);
	}

	/*
	 * Enter Total Area Sq Ft
	 */
	public void enter_total_area_sqft(String total_area_sqft) throws InterruptedException {
		// driver.navigate().back();
		totalAreaSqFt.clear();
		Thread.sleep(2000);
		totalAreaSqFt.sendKeys(total_area_sqft);
	}

	/*
	 * Enter Common Area
	 */
	public void enter_common_area(String common_area) throws InterruptedException {
		commonArea.clear();
		Thread.sleep(2000);
		commonArea.sendKeys(common_area);
	}

	/*
	 * Enter Unit number
	 */
	public void enter_unit_number(String unit_number) throws InterruptedException {
		unitNumberField.clear();
		Thread.sleep(2000);
		unitNumberField.sendKeys(unit_number);
	}

	/*
	 * Enter plot area square meter
	 */
	public void enter_plot_area_sqm(String plot_area_sqm) throws InterruptedException {
		plotAreaSqMtField.clear();
		Thread.sleep(2000);
		plotAreaSqMtField.sendKeys(plot_area_sqm);
	}

	/*
	 * Enter plot area square feet
	 */
	public void enter_plot_area_sqft(String plot_area_sqft) throws InterruptedException {
		plotAreaSqFtField.clear();
		Thread.sleep(2000);
		plotAreaSqFtField.sendKeys(plot_area_sqft);
	}

	/*
	 * Enter buildup area
	 */
	public void enter_build_up_area(String build_up_area) throws InterruptedException {
		buildUpAreaField.clear();
		Thread.sleep(2000);
		buildUpAreaField.sendKeys(build_up_area);
	}

	/*
	 * Select Bedroom/Cabin Count
	 */
	public void select_bedroom_cabin_count(String bedroom_cabin_count) throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='4+'])[1]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(bedroom_cabin_count);
		click_done();
	}

	/*
	 * Enter Bathroom Count
	 */
	public void select_bathroom_count(String bathroom_count) throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='4+'])[2]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(bathroom_count);
		click_done();
	}

	/*
	 * Enter Kitchen/Pantry count
	 */
	public void select_kitchen_pantry_count(String kitchen_pantry_count) throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='2+'])[1]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(kitchen_pantry_count);
		click_done();
	}

	public void select_balcony_count(String balcony_count) throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='2+'])[2]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(balcony_count);
		click_done();
	}

	public void select_map_location() throws InterruptedException {
		myLocationClick.click();
		Thread.sleep(2000);
		alwaysGivePermission();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.xpath("//android.widget.TextView[@text='Select Location']")), "text",
				"Select Location"));
		selectLocation.click();
		Thread.sleep(2000);
	}

	public void select_furnishing_status(String furnishing_status) {
		if (driver.findElement(By.xpath("//android.widget.TextView[@text='" + furnishing_status + "']"))
				.isDisplayed()) {
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + furnishing_status + "']")).click();
		} else {

		}
	}

	public void click_save() {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Property\"));"));
		savePropertyButton.click();
	}

	public void scroll_to_next() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
	}

	public void skip_rent() throws InterruptedException {
		skipRentButton.click();
		Thread.sleep(2000);
	}

	public AddRental addRental_propertyAdd() throws InterruptedException {
		clickAddRent.click();
		Thread.sleep(20000);
		return new AddRental(driver);
	}

	public void goToProperties() throws InterruptedException {
		Thread.sleep(2000);
		goToPropertiesButton.click();
	}

}
