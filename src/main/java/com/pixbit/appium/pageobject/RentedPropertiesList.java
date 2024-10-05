package com.pixbit.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class RentedPropertiesList extends AndroidActions {

	AndroidDriver driver;

	public RentedPropertiesList(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload Rented Property']")
	private WebElement uploadRentedPropertyButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='I’m Property Owner']")
	private WebElement rentAsOwner;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='I’m Tenant']")
	private WebElement rentAsTenant;

	public AddRental openRentAsOwner() throws InterruptedException {

		if (driver.findElement(By.xpath("//android.widget.TextView[@text='Add Rental Details']")).isDisplayed()) // Removed
																													// semicolon
		{

			Thread.sleep(2000);
			rentAsOwner.click();
		}

		else {
			if (driver.findElement(By.xpath("//android.widget.TextView[@text='Rented Properties']")).isDisplayed()) {
				uploadRentedPropertyButton.click();
				Thread.sleep(2000);
				rentAsOwner.click();
			}
		}
		return new AddRental(driver);
	}

	public AddRental openRentAsTenant(String isFirstAdd) throws InterruptedException {
		boolean isFirst = Boolean.parseBoolean(isFirstAdd);
		if(isFirst) {
			Thread.sleep(2000);
			rentAsTenant.click();
		}
		else {
			uploadRentedPropertyButton.click();
			Thread.sleep(2000);
			rentAsTenant.click();
		}
		return new AddRental(driver);
	}

}
