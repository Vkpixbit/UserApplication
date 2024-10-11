package com.pixbit.appium.pageobject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
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

	@AndroidFindBy(accessibility = "Add")
	public WebElement addSchedule;

	@AndroidFindBy(id = "in.pixbit.proptech:id/month_navigation_fragment_toggle")
	private WebElement yearPicker;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement sheduleParticulars;

	@AndroidFindBy(accessibility = "Dropdown")
	private WebElement shedulePeriodDropDown;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement sheduleBookingAmount;

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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Go to My Properties']")
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save Details']")
	private WebElement saveDetailsButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@index='6']")
	private WebElement moreButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Mortgage Details (optional)']")
	private WebElement addMortgageButton;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Calender\"])[1]")
	private WebElement bookingDateField;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Calender\"])[2]")
	private WebElement completionDateField;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add Payment Schedule']")
	private WebElement addPaymentPlanButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	private WebElement saveButton;

	public void selectPropertyStatus(String propertyStatus, String presentUse) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + propertyStatus + "']")).click();
		if (propertyStatus.equals("Ready") || propertyStatus.equals("Shell & Core")) {
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + presentUse + "']")).click();
		}

	}

	/*
	 * Select Property Status as Ready and Enter Age Of Property and Select Present
	 * Use
	 */
	public void selectReadyStatus(String present_use) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Ready']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + present_use + "']")).click();
	}

	/*
	 * Select property status as Shell & Core and Enter Age of property and select
	 * Present Use
	 */
	public void selectShellAndCoreStatus(String present_use) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Shell & Core']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + present_use + "']")).click();
	}

	/*
	 * Select Property Status As Under Construction
	 */
	public void selectUnderConstructionStatus() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Under construction']")).click();
	}

	public void selectDate(String desiredYear, String desiredMonth, String desiredDate) throws InterruptedException {
		Thread.sleep(2000); // Wait for the calendar to load
		boolean answer = false;
		WebElement yearPicker = driver.findElement(By.id("in.pixbit.proptech:id/month_navigation_fragment_toggle"));
																																				// structure
		yearPicker.click();
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
						+ desiredYear + "\"))"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + desiredYear + "']")).click();

		// Format the month input to Title Case, e.g., "January", "February"
		//String desiredMonthTitleCase = desiredMonth.substring(0, 1).toUpperCase()
				//+ desiredMonth.substring(1).toLowerCase();

		// Select the correct month by navigating through the calendar
		
		while(driver.findElement(By.id("in.pixbit.proptech:id/month_navigation_fragment_toggle")).getText().contains(desiredMonth) && 
					driver.findElement(By.id("in.pixbit.proptech:id/month_navigation_fragment_toggle")).getText().contains(desiredYear)) {
			driver.findElement(AppiumBy.accessibilityId("Change to next month")).click();
			int nextYear = Integer.parseInt(desiredDate)+1;
			String newYear = String.valueOf(nextYear);
			
			if(driver.findElement(By.id("in.pixbit.proptech:id/month_navigation_fragment_toggle")).getText().contains(newYear)){
				while(driver.findElement(By.id("in.pixbit.proptech:id/month_navigation_fragment_toggle")).getText().contains(desiredMonth)) {
					driver.findElement(AppiumBy.accessibilityId("Change to previous month")).click();
				}
			}
		}
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + desiredDate + "']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
	}
	
	
	
	public WebElement addPaymentSchedule(String scheduleCount, String scheduleParticulars, String periodList, String monthList,
			String shareList) throws InterruptedException {
		int monthIndex = 0;
		for(int i = 0; i < Integer.parseInt(scheduleCount); i++) {
			driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Add Payment Schedule\"));"
				));
			addSchedule.click();
			String[] periodValue = periodList.split(",");
			String[] monthValue = monthList.split(",");
			String[] shareValue = shareList.split(",");

			sheduleParticulars.sendKeys(scheduleParticulars + "_" + i + 1);
			shedulePeriodDropDown.click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + periodValue[i] + "']")).click();
			if (periodValue[i].equals("After Booking") || periodValue[i].equals("After Completion")) {
				driver.findElement(By.xpath("//android.widget.EditText[@index='5']")).sendKeys(monthValue[monthIndex]);
				monthIndex++;
				driver.findElement(By.xpath("//android.widget.EditText[@index='9']")).sendKeys(shareValue[i]);
			} else {
				driver.findElement(By.xpath("//android.widget.EditText[@index='7']")).sendKeys(shareValue[i]);
			}
			driver.findElement(By.xpath("//android.widget.TextView[@text='Add Schedule']")).click();
		}
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Save\"));"
			));
		return saveButton;
	}

	public void selectBookingCompletionDate(String bookingDateString, String completionDateString)
			throws InterruptedException {
		String[] bookingDateParts = bookingDateString.split("-"); // Split date string (e.g. "2024-07-12")
		String bookingYear = bookingDateParts[0];
		String bookingMonth = bookingDateParts[1];
		String bookingDate = bookingDateParts[2];

		bookingDateField.click();
		selectDate(bookingYear, bookingMonth, bookingDate);

		// Handle completion date
		String[] completionDateParts = completionDateString.split("-");
		String completionYear = completionDateParts[0];
		String completionMonth = completionDateParts[1];
		String completionDate = completionDateParts[2];

		completionDateField.click();
		selectDate(completionYear, completionMonth, completionDate);
	}

	public void addPaymentPlan(String scheduleCount, String bookingDateString, String completionDateString,
			String scheduleParticular, String periodList, String monthList, String shareList)
			throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add Payment Plan (optional)']")).click();
		selectBookingCompletionDate(bookingDateString, completionDateString);
		//addPaymentSchedule(scheduleCount, scheduleParticular, periodList, monthList, shareList);
		WebElement saveButton = addPaymentSchedule(scheduleCount, scheduleParticular, periodList, monthList, shareList);
		saveButton.click();
	}

	/*
	 * Select Mortgage as Yes and Skip The Fields
	 */
	public void selectMortgagedSkip() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			// Thread.sleep(2000);
			if (wait.until(ExpectedConditions.visibilityOf(addMortgageButton)) != null) {
				// System.out.println("Text");
				addMortgageButton.click();
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Details\"));"));
				driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
			} else {
				System.out.println("Next Opened");
				driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
			}
		} catch (NoSuchElementException e) {
			// If addMortgageButton is not found, proceed to click Next
			// System.out.println("next click");
			driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
		}
	}

	/*
	 * Select Mortgage And Tenure Is Only with Year Value
	 */
	public void selectMortgagedTenureYear(String mortgageAmount, String tenureYear, String mortgageStartDate,
			String financeRate) throws InterruptedException {
		if (addMortgageButton.isDisplayed()) {
			addMortgageButton.click();
			mortgageAmountField.sendKeys(financeRate);
			tenureYearField.sendKeys(tenureYear);
			mortgageStartDateField.sendKeys(mortgageStartDate);
			finaceRateField.sendKeys(financeRate);
			AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Details\"));");
			driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
		}
	}

	/*
	 * Select Mortgage And Tenure Is Only With Month Value
	 */
	public void selectMortgagedTenureMonth(String mortgage_amount, String tenure_month, String mortgage_start_date,
			String finance_rate) throws InterruptedException {
		if (addMortgageButton.isDisplayed()) {
			addMortgageButton.click();
			mortgageAmountField.sendKeys(mortgage_amount);
			tenureMonthField.sendKeys(tenure_month);
			mortgageStartDateField.sendKeys(mortgage_start_date);
			finaceRateField.sendKeys(finance_rate);
			AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Details\"));");
			driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
		}
	}

	/*
	 * Select Mortgage And Tenure As Year And Month With Offer Letter
	 */
	public void selectMortgagedTenureYearMonthOfferLetter(String mortgage_amount, String tenure_year,
			String tenure_month, String mortgage_start_date, String finance_rate) throws InterruptedException {
		if (addMortgageButton.isDisplayed()) {
			addMortgageButton.click();
			mortgageAmountField.sendKeys(mortgage_amount);
			tenureYearField.sendKeys(tenure_year);
			tenureMonthField.sendKeys(tenure_month);
			mortgageStartDateField.sendKeys(mortgage_start_date);
			finaceRateField.sendKeys(finance_rate);
			AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Details\"));");
			driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
		}

	}

	/*
	 * Select Bedroom/Cabin Count
	 */
	public void selectBedroomCabinCount(String bedroom_cabin_count) throws InterruptedException {
		try {
			// Correct the XPath to match the element correctly
			if (driver.findElement(By.xpath("//android.widget.TextView[@text='Number of Bedrooms (Required)']"))
					.isDisplayed()) {
				driver.findElement(By.xpath("(//android.widget.TextView[@text='4+'])[1]")).click();
				driver.findElement(By.className("android.widget.EditText")).sendKeys(bedroom_cabin_count);
				click_done();
			} else {
				System.out.println("Bedroom field not entered!");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Bedroom field not found!");
		}
	}

	/*
	 * Enter Bathroom Count
	 */
	public void selectBathroomCount(String bathroom_count, String bedroom_cabin_count) throws InterruptedException {
		if (Integer.parseInt(bedroom_cabin_count) < 5) {
			driver.findElement(By.xpath("(//android.widget.TextView[@text='4+'])[2]")).click();
			driver.findElement(By.className("android.widget.EditText")).sendKeys(bathroom_count);
		} else {
			driver.findElement(By.xpath("(//android.widget.TextView[@text='4+'])[1]")).click();
			driver.findElement(By.className("android.widget.EditText")).sendKeys(bathroom_count);
		}
		click_done();
	}

	/*
	 * Enter Kitchen/Pantry count
	 */
	public void selectKitchenPantryCount(String kitchen_pantry_count) throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='2+'])[1]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(kitchen_pantry_count);
		click_done();
	}

	public void selectBalconyCount(String balcony_count, String kitchen_pantry_count) throws InterruptedException {
		if (Integer.parseInt(kitchen_pantry_count) < 2) {
			driver.findElement(By.xpath("(//android.widget.TextView[@text='2+'])[2]")).click();
			driver.findElement(By.className("android.widget.EditText")).sendKeys(balcony_count);
		} else {
			driver.findElement(By.xpath("(//android.widget.TextView[@text='2+'])[1]")).click();
			driver.findElement(By.className("android.widget.EditText")).sendKeys(balcony_count);
		}
		click_done();
	}

	public void selectMapLocation() throws InterruptedException {
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

	/*
	 * Select Furnishing status
	 */
	public void selectFurnishingStatus(String furnishing_status) {
		if (driver.findElement(By.xpath("//android.widget.TextView[@text='" + furnishing_status + "']"))
				.isDisplayed()) {
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + furnishing_status + "']")).click();
		} else {

		}
	}

	public void propertySaveAction(String propertyStatus, String presentUse) throws InterruptedException {
		if (propertyStatus.equals("Ready") && presentUse.equals("Rented")) {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Property\"));"));
			savePropertyButton.click();
			skipRentButton.click();
			Thread.sleep(2000);
		} else if (propertyStatus.equals("") && presentUse.equals("")) {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Property\"));"));
			savePropertyButton.click();
			Thread.sleep(2000);
			goToPropertiesButton.click();
		} else {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Property\"));"));
			savePropertyButton.click();
			Thread.sleep(2000);
			goToPropertiesButton.click();
		}
	}

	/*
	 * Click save button in property add flow
	 */
	public void clickSave() {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Property\"));"));
		savePropertyButton.click();
	}

	/*
	 * Scroll upto next button
	 */
	public void scrollToNext() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
	}

	/*
	 * Click skip for Rent adding after property add
	 */
	public void skipRent() throws InterruptedException {
		skipRentButton.click();
		Thread.sleep(2000);
	}

	/*
	 * Add rental button after property created as Ready property status
	 */
	public AddRental addRentalAropertyAdd() throws InterruptedException {
		clickAddRent.click();
		Thread.sleep(20000);
		return new AddRental(driver);
	}

	/*
	 * Button For Click Go to properties
	 */
	public void goToProperties() throws InterruptedException {
		Thread.sleep(2000);
		goToPropertiesButton.click();

	}

}
