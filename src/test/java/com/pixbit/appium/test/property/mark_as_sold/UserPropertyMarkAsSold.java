package com.pixbit.appium.test.property.mark_as_sold;

import java.util.HashMap;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.PropertyDetails;
import com.pixbit.appium.pageobject.SplashScreen;

public class UserPropertyMarkAsSold extends AndroidGlobalData {

	public void mark_as_sold_in_my_properties_list(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		PropertyDetails PropertyDetails = MyProperties.selectProperty(input.get("property_name"));

	}
}
