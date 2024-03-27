package com.pixbit.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {

	AndroidDriver driver;

	public ProfilePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "my_property")
	private WebElement myPropertyClick;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.widget.TextView[1]")
	private WebElement rmname;

	@AndroidFindBy(accessibility = "rented_property")
	private WebElement rentedPropertiesClick;

	public AddOwnerShipDetails openPropertyAddPage() throws InterruptedException {
		myPropertyClick.click();
		Thread.sleep(2000);
		return new AddOwnerShipDetails(driver);
	}

	public MyProperties openMyPropertiesPage() throws InterruptedException {
		myPropertyClick.click();
		return new MyProperties(driver);
	
	}
	
	public void openPropertyFlow() throws InterruptedException {

		WebElement propertyExist = driver.findElement(By.xpath("//android.widget.TextView[text()='My Properties']"));
		if (propertyExist.isDisplayed()) {
			openMyPropertiesPage();
		} else {
			WebElement newUser = driver
					.findElement(By.xpath("//android.widget.TextView[text()='Upload Your Property']"));
			if (newUser.isDisplayed()) {
				openPropertyAddPage();
			}
		}

	}

	public RentedPropertiesList openRentedProperties() {
		rentedPropertiesClick.click();
		return new RentedPropertiesList(driver);
	}

	public String getRmName() {
		String userRmName = rmname.getAttribute("text");
		return userRmName;
	}

}
