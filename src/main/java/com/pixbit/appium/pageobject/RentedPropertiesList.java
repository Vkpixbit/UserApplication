package com.pixbit.appium.pageobject;

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
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload Rented Property']")
	private WebElement uploadRentedPropertyButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='I’m Property Owner']")
	private WebElement rentAsOwner;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='I’m Tenant']")
	private WebElement rentAsTenant;
	
	public AddRental openRentAsOwner() {
		uploadRentedPropertyButton.click();
		rentAsOwner.click();
		return new AddRental(driver);
	}
	
	public AddRental openRentAsTenant() {
		uploadRentedPropertyButton.click();
		rentAsTenant.click();
		return new AddRental(driver);
	}
	

}
