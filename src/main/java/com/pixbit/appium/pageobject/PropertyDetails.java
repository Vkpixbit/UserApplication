package com.pixbit.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Publish Now']")
	private WebElement publishNow;
	
	@AndroidFindBy(xpath = "//android.view.View[@index='2']")
	private WebElement menuBarButton;
	
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
	
	public void clickMarkAsSold(String titledeedDocument ) throws InterruptedException {
		Thread.sleep(2000);
		menuBarButton.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mark as sold']")).click();
		driver.findElement(AppiumBy.accessibilityId("ic_add_document")).click();
		approvePermission();
		AddOwnerShipDetails.open_title_deed_section(titledeedDocument);
		
	}

}
