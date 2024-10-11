package com.pixbit.appium.propertypublish;

import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.PropertyDetails;
import com.pixbit.appium.pageobject.PublishProperty;
import com.pixbit.appium.pageobject.SplashScreen;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

public class PropertyPublishing extends AndroidGlobalData {
	
	/*
	 * This class is involving the publish for Sell and Rent test cases with different scenarios
	 */

	
	/*
	 * Publish the proeprty with out entering any details in publishing process
	 */
	@Test(dataProvider = "rmPdublishPropertyDetails")
	public void openMyPropertyPage(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"),input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties myproperties =ProfilePage.openMyPropertiesPage();
		PropertyDetails PropertyDetails=myproperties.selectProperty(input.get("property_name"));
		PublishProperty PublishProperty=PropertyDetails.clickPublish();
		PublishProperty.publishSaleWithoutAnyDetails(input.get("isVerified"));	
	}
	
	
	@DataProvider
	public Object[][] rmPdublishPropertyDetails() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/com/pixbit/appium/propertypublish/PropertyUserPublishDetails.json");
		return new Object[][] { { value.get(0) }};
	}

}
