package com.pixbit.appium.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class HomePage extends AndroidActions {

	AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"category_image\"])[1]")
	private WebElement saleMarketplaceBtn;
	
	@AndroidFindBy(xpath = "//android.widget.View[@index='1']")
	public WebElement intrestButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
	public WebElement intrestBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	public WebElement assignedPSNameField;

	@AndroidFindBy(accessibility = "ic_phone")
	public WebElement requestAndCallBack;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
	public WebElement successTxt;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
	public WebElement okButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]")
	public WebElement profile;
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"category_image\"])[1]")
	private WebElement SaleMarketplaceButton;
	
	public void userSaleEnqueryMade(String propertyName) throws InterruptedException {
		approvePermission();
		saleMarketplaceBtn.click();
		Thread.sleep(2000);
		scrollToElementByText(propertyName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+propertyName+"']")).click();
		intrestBtn.click();
		String assignedPsName = assignedPSNameField.getText();
		requestAndCallBack.click();
		Thread.sleep(5000);
		if(successTxt.getText().equalsIgnoreCase("Success")) {
			System.out.println("Enquery Created Successfully and assigned to '"+assignedPsName+"'");
		}
		else {
			System.out.println("Enquery not created!'");
		}
	}

	public ProfilePage openProfile() {
		profile.click();
		return new ProfilePage(driver);
	}
	
	public HomePage openSaleMarketplace() {
		SaleMarketplaceButton.click();
		return new HomePage(driver);
	}
	
}
