package pageobject;

import java.util.List;

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

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"ic_add_document\"])[2]")
	private WebElement tenancyUploadClick;

	@AndroidFindBy(id = "android:id/title")
	private List<WebElement> DocumentsList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement clickNext;

	@AndroidFindBy(xpath = "//android.widget.EditText(@index='3']")
	private WebElement ejariField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
	private WebElement clickVerify;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement endDateField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save without cheque']")
	private WebElement savewithoutCheque;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Done']")
	private WebElement clickDone;
	
	public void roleAsOwner() {
		propertyOwnerJourny.click();
	}

	public void selectProperty(String rentProperty) throws InterruptedException {
		scrollToElementByText(rentProperty);
		driver.findElement(By.xpath("//android.widget.TextView['" + rentProperty + "']")).click();
		Thread.sleep(2000);
	}

	public void uploadEjariRentalFlow(String ejariDocument) throws InterruptedException {
		ejariUploadClick.click();
		approvePermission();
		Thread.sleep(3000);
		for (WebElement DocumentList : DocumentsList) {
			String DocumentName = DocumentList.getText();
			if (DocumentName.equals(ejariDocument)) {
				DocumentList.click();
			}
		}
	}
	
	public void uploadEjari(String ejariDocument) throws InterruptedException {
		ejariUploadClick.click();
		Thread.sleep(3000);
		for (WebElement DocumentList : DocumentsList) {
			String DocumentName = DocumentList.getText();
			if (DocumentName.equals(ejariDocument)) {
				DocumentList.click();
			}
		}
	}

	public void uploadTenancy(String tenancyDocument) throws InterruptedException {
		tenancyUploadClick.click();
		Thread.sleep(2000);
		for (WebElement DocumentList : DocumentsList) {
			String DocumentName = DocumentList.getText();
			if (DocumentName.equals(tenancyDocument)) {
				DocumentList.click();
			}
		}
	}

	public void clickNext() throws InterruptedException {
		clickNext.click();
		Thread.sleep(2000);
	}

	public void enterEjari(String ejariNumber) throws InterruptedException {
		ejariField.sendKeys(ejariNumber);
		clickVerify.click();
		Thread.sleep(3000);
	}
	
	public void enterRentalDetailsOwner(String end_date) throws InterruptedException {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"End Date (Required)\"));"));
		endDateField.sendKeys(end_date);
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
		clickNext.click();
		savewithoutCheque.click();
		clickDone.click();
	}

}
