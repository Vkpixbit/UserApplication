package com.pixbit.appium.test.property.publish;

import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.PropertyDetails;
import com.pixbit.appium.pageobject.PublishProperty;
import com.pixbit.appium.pageobject.SplashScreen;

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

public class PropertyPublishing extends AndroidGlobalData {
	
	/*
	 * This class is involving the publish for Sell and Rent test cases with different scenarios
	 */

	
	/*
	 * Before class open the my properties page for the publishing actions
	 */
	@BeforeClass
	public void openMyPropertyPage() throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("shivaraj@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openMyPropertiesPage();
	}
	
	/*
	 * Publish property for Rent without entering any details and without upload files
	 */
	@Test(dataProvider = "rmPdublishPropertyDetails")
	public void publishPropertySaleWithoutAddDetails(HashMap<String, String>input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		PropertyDetails PropertyDetails=Myproperties.selectProperty(input.get("property_name"));
		PublishProperty PublishProperty=PropertyDetails.clickPublish();
		PublishProperty.publishSaleWithoutAnyDetails();	
	}
	
	@DataProvider
	public Object[][] rmPdublishPropertyDetails() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/data/PropertyUserPublishDetails.json");
		return new Object[][] { { value.get(0) },{value.get(1)} };
	}

}
