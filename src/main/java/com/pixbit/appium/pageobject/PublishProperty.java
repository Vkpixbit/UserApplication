package com.pixbit.appium.pageobject;

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
	
	public void publishSaleWithoutAnyDetails() throws InterruptedException {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
		nextButtonClick();
		Thread.sleep(2000);
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
