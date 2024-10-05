package com.pixbit.appium.pageobject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
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

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Add PDF File\"])[1]")
	private WebElement ejariUploadClick;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose Tenancy Contract File']")
	private WebElement tenancyUploadClick;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement clickNext;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	private WebElement ejariField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
	private WebElement titleDeedField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify & Continue']")
	public WebElement clickVerifyAndContinue;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip & Continue']")
	private WebElement savewithoutCheque;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Done']")
	private WebElement clickDone;
	
	@AndroidFindBy(accessibility = "Add")
	private WebElement addChequeButton;
	
	@AndroidFindBy(accessibility = "addChequeButton")
	private WebElement uploadClick;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
	private WebElement bankNameField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement chequeDateField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement amountField;
	
	@AndroidFindBy(id = "in.pixbit.proptech:id/month_navigation_fragment_toggle")
	private WebElement yearPicker;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	private WebElement saveBtn;
	
	
	public void openEjariDocumentFolder() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Ejary']")).click();
	}
	
	public void openTenancyDocumentFolder() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Tenancy_Contract']")).click();
	}
	

	public void selectProperty(String rent_property) throws InterruptedException {
		Thread.sleep(2000);
		scrollToElementByText(rent_property);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + rent_property + "']")).click();
	}

	public void uploadEjariRentalFlow(String ejari_document) throws InterruptedException {
		ejariUploadClick.click();
		approvePermission();
		Thread.sleep(3000);
		openEjariDocumentFolder();
		scrollToElementByText(ejari_document);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + ejari_document + "']")).click();
	}
	
	public void uploadEjari(String ejari_document) throws InterruptedException {
		ejariUploadClick.click();
		Thread.sleep(3000);
		openEjariDocumentFolder();
		scrollToElementByText(ejari_document);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + ejari_document + "']")).click();
	}

	public void uploadTenancy(String tenancy_document) throws InterruptedException {
		tenancyUploadClick.click();
		Thread.sleep(2000);
		openTenancyDocumentFolder();
		scrollToElementByText(tenancy_document);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + tenancy_document + "']")).click();
	}
	
	public void verifyAndContinue() throws InterruptedException {
		clickVerifyAndContinue.click();
		Thread.sleep(2000);
	}
	
	

	public void clickNext() throws InterruptedException {
		clickNext.click();
		Thread.sleep(3000);
	}

	
	public void uploadChequeDoc(String cheque_document) {
		uploadClick.click();
		System.out.println("Test");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Docs_for_testing']")).click();
		scrollToElementByText(cheque_document);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+cheque_document+"']")).click();
	}
	
	public void addChequeAmount() {
		 Random random = new Random();

	     // Define the range
	     int min = 10000;
	     int max = 100000;

	     // Generate a random integer between min (inclusive) and max (inclusive)
	     int chequeAmount = random.nextInt((max - min) + 1) + min;
	     amountField.sendKeys(String.valueOf(chequeAmount));
	}
	
	public LocalDate getRandomDateWithinRange(LocalDate startInclusive, LocalDate endExclusive) {
	    LocalDate maxDate = LocalDate.of(2024, 12, 31);  // Set the max date to the end of 2024
	    if (endExclusive.isAfter(maxDate)) {
	        endExclusive = maxDate;
	    }
	    long days = ChronoUnit.DAYS.between(startInclusive, endExclusive);
	    Random random = new Random();
	    long randomDays = random.nextInt((int) days + 1);
	    return startInclusive.plusDays(randomDays);
	}

	public void selectDate(String desiredYear, String desiredMonth, String desiredDate) {
		int year = Integer.parseInt(desiredYear);
		if (year > 2024) {
			throw new IllegalArgumentException("Year must not be greater than 2024");
		}

		driver.findElement(AppiumBy.accessibilityId("Calender")).click();
		yearPicker.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + desiredYear + "']")).click();
		
		String desiredMonthTitleCase = desiredMonth.charAt(0) + desiredMonth.substring(1).toLowerCase();
		
		while (!yearPicker.getAttribute("text").contains(desiredMonthTitleCase)) {
			driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Change to next month\"]")).click();
		}
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + desiredDate + "']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
	}
	
	public void datePicker() {
		LocalDate randomDate = getRandomDateWithinRange(LocalDate.now(), LocalDate.now().plusYears(1));
		String randomYear = String.valueOf(randomDate.getYear());
		String randomMonth = randomDate.getMonth().name();
		String randomDay = String.valueOf(randomDate.getDayOfMonth());
		//System.out.println(randomYear + randomMonth + randomDay);
		

		selectDate(randomYear, randomMonth, randomDay);
	}
	
	
	public void enterChequeDetails(String cheque_count,String cheque_document,String bank_name) throws InterruptedException {
		int count = Integer.parseInt(cheque_count);
		for (int i=0;i<count;i++) {
			Thread.sleep(2000);
			addChequeButton.click();
			//uploadChequeDoc(cheque_document);
			bankNameField.sendKeys(bank_name);
			datePicker();
			addChequeAmount();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
		}
		driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
	}

	
	public void eneterTitleDeedNumber(String title_deed_number) throws InterruptedException {
		Thread.sleep(2000);
		ejariField.sendKeys(title_deed_number);
	}
	
	public void saveWithOutCheque() throws InterruptedException {
		Thread.sleep(5000);
		savewithoutCheque.click();
	}
	
	public void clickSave() {
		clickDone.click();
	}
	

}
