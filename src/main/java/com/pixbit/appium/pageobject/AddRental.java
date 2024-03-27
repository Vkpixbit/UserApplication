package com.pixbit.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class AddRental extends AndroidActions {

	AndroidDriver driver;

	public AddRental(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='I’m Property Owner']")
	private WebElement propertyOwnerJourny;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"ic_add_document\"])[1]")
	private WebElement ejariUploadClick;

	@AndroidFindBy(accessibility = "ic_add_document")
	private WebElement tenancyUploadClick;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement clickNext;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3")
	private WebElement ejariField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
	private WebElement titleDeedField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement titleDeedYearField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
	private WebElement clickVerify;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement endDateField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save without cheque']")
	private WebElement savewithoutCheque;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Done']")
	private WebElement clickDone;
	

	public void selectProperty(String rent_property) throws InterruptedException {
		Thread.sleep(2000);
		scrollToElementByText(rent_property);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + rent_property + "']")).click();
	}

	public void uploadEjariRentalFlow(String ejari_document) throws InterruptedException {
		ejariUploadClick.click();
		approvePermission();
		Thread.sleep(3000);
		scrollToElementByText(ejari_document);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + ejari_document + "']")).click();
	}
	
	public void uploadEjari(String ejari_document) throws InterruptedException {
		ejariUploadClick.click();
		Thread.sleep(3000);
		scrollToElementByText(ejari_document);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + ejari_document + "']")).click();
	}

	public void uploadTenancy(String tenancy_document) throws InterruptedException {
		tenancyUploadClick.click();
		Thread.sleep(2000);
		scrollToElementByText(tenancy_document);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + tenancy_document + "']")).click();
	}

	public void clickNext() throws InterruptedException {
		clickNext.click();
		Thread.sleep(3000);
	}

	public void enterEjari(String ejari_number) throws InterruptedException {
		Thread.sleep(2000);
		ejariField.sendKeys(ejari_number);
		clickVerify.click();
		Thread.sleep(3000);
	}
	
	public void enterRentalDetailsOwner(String end_date) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"End Date (Required)\"));"));
		endDateField.sendKeys(end_date);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
		clickNext.click();
		savewithoutCheque.click();
		clickDone.click();
	}
	
	public void enterRentalDetailsTenant() {
		
	}

	public void eneterTitleDeedNumber(String title_deed_number) throws InterruptedException {
		Thread.sleep(2000);
		ejariField.sendKeys(title_deed_number);
	}
	
	

}
