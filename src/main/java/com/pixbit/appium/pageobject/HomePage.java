package com.pixbit.appium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]")
	public WebElement profile;
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"category_image\"])[1]")
	private WebElement SaleMarketplaceButton;

	public ProfilePage openProfile() {
		profile.click();
		return new ProfilePage(driver);
	}
	
	public MarketplacePage openSaleMarketplace() {
		SaleMarketplaceButton.click();
		return new MarketplacePage(driver);
	}
	
}
