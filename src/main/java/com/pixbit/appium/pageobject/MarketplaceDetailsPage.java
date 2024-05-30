package com.pixbit.appium.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilites.AndroidActions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MarketplaceDetailsPage extends AndroidActions {

	AndroidDriver driver;

	public MarketplaceDetailsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@AndroidFindBy(xpath = "//android.widget.View[@index='1']")
	public WebElement intrestButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	public WebElement assignedPSNameField;

	@AndroidFindBy(accessibility = "ic_phone")
	public WebElement requestAndCallBack;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
	public WebElement okButton;

	public String enqueryMadeLoginedUser() {
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(intrestButton)).click();
		//System.out.println("Text");

		String enqueryAssignedPs = wait.until(ExpectedConditions.visibilityOf(assignedPSNameField)).getText();

		wait.until(ExpectedConditions.elementToBeClickable(requestAndCallBack)).click();

		WebElement okElement = wait.until(ExpectedConditions.elementToBeClickable(okButton));
		okElement.click();

		return enqueryAssignedPs;
	}
}
