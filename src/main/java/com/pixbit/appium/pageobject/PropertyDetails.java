package com.pixbit.appium.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class PropertyDetails extends AndroidActions {

	AndroidDriver driver;
	AddOwnerShipDetails AddOwnerShipDetails;

	public PropertyDetails(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Publish Now']")
	private WebElement publishNow;

	@AndroidFindBy(xpath = "//android.view.View[@index='2']")
	private WebElement menuBarButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement titleDeedNumberFieldSold;

	@AndroidFindBy(accessibility = "Calender")
	private WebElement calender;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Year Picker']")
	private WebElement yearPicker;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='10']")
	private WebElement soldAmountField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='12']")
	private WebElement buyerName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	private WebElement saveButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your property has been successfully marked as sold']")
	private WebElement soldMessage;

	public PublishProperty clickPublish() {
		publishNow.click();
		return new PublishProperty(driver);
	}

	public void select_form_f() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
		scrollToElementByText("Listing Form.pdf");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Listing Form.pdf']")).click();
	}

	public void fill_sold_details() {
		driver.findElement(AppiumBy.accessibilityId("Upload")).click();
		select_form_f();
	}

	public void clickMarkAsSold(String titledeedDocument) throws InterruptedException {
		Thread.sleep(2000);
		menuBarButton.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mark as sold']")).click();
		driver.findElement(AppiumBy.accessibilityId("ic_add_document")).click();
		approvePermission();
		AddOwnerShipDetails.open_title_deed_section(titledeedDocument);
		nextButtonClick();
		Thread.sleep(3000);
	}

	public void verifyMarkAsSold() {
		Assert.assertEquals(soldMessage.getText(), "Your property has been successfully marked as sold",
				"Mark As Sold Successfully!");
	}

	public void enterSoldDetails(String sold_title_deed_number, String year, String sold_amount, String buyer_name)
			throws InterruptedException {
		fill_sold_details();
		titleDeedNumberFieldSold.sendKeys(sold_title_deed_number);
		calender.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(yearPicker));
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + year + "\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + year + "']")).click();
		soldAmountField.clear();
		Thread.sleep(2000);
		soldAmountField.sendKeys(sold_amount);
		buyerName.clear();
		Thread.sleep(2000);
		buyerName.sendKeys(buyer_name);
		saveButton.click();
		Thread.sleep(3000);
		verifyMarkAsSold();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Go to sold properties']")).click();
		Thread.sleep(2000);
	}

}
