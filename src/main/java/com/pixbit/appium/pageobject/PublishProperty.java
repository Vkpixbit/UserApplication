package com.pixbit.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class PublishProperty extends AndroidActions {
	
	AndroidDriver driver;

	public PublishProperty(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Send for Approval']")
	private WebElement clickSendApproval;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Go to my properties']")
	private WebElement clickGoToMyProperties;
	
	@AndroidFindBy(xpath = "(//android.view.TextView[text()='My Properties'])[2]")
	private WebElement myPropertiesTab;
	
	@AndroidFindBy(accessibility = "Upload Document")
	private WebElement uploadDocumentIcon;
	
	
	
	public void skipDocumentVerification() {
		if(uploadDocumentIcon.isDisplayed()) {
			driver.findElement(By.xpath("//android.widget.TextView[@text='Skip, I will verify later']")).click();
		}
	}
	
	
	public void publishSaleWithoutAnyDetails(String isVerified) throws InterruptedException {
		if(!Boolean.parseBoolean(isVerified)) {
			skipDocumentVerification();
		}
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
		nextButtonClick();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Send for Approval\"));"));
		clickSendApproval.click();
		Thread.sleep(2000);
		clickGoToMyProperties.click();
		Thread.sleep(2000);
		myPropertiesTab.click();
	}

}
