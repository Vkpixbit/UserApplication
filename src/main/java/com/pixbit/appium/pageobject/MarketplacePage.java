package com.pixbit.appium.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import utilites.AndroidActions;

public class MarketplacePage extends AndroidActions {
	
	AndroidDriver driver;
	
	public MarketplacePage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public MarketplaceDetailsPage openProperty(String property_name) {
		openPropertyFromMarketplace(property_name);
		return new MarketplaceDetailsPage(driver);
	}

}
