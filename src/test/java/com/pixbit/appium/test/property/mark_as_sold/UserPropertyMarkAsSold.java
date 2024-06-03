package com.pixbit.appium.test.property.mark_as_sold;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.PropertyDetails;
import com.pixbit.appium.pageobject.SplashScreen;

public class UserPropertyMarkAsSold extends AndroidGlobalData {

	@Test(dataProvider = "userMarkAsSoldDetails", groups= "mark_as_sold_user")
	public void mark_as_sold_in_my_properties_list(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		PropertyDetails PropertyDetails = MyProperties.selectProperty(input.get("property_name"));
		PropertyDetails.clickMarkAsSold(input.get("titledeedDocument"));
		PropertyDetails.enterSoldDetails(input.get("sold_title_deed_number"), input.get("year"),
				input.get("sold_amount"), input.get("buyer_name"));
	}

	@DataProvider
	public Object[][] userMarkAsSoldDetails() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/markassold/PropertyMarkAsSold.json");
		return new Object[][] { { value.get(0) } };
	}

}
