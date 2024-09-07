package com.pixbit.appium.marketplace;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.SplashScreen;

public class MarketplaceEnqueryMade extends AndroidGlobalData {

	
	@Test(dataProvider = "userSaleEnqueryMadeData1")
	public void userSaleEnqueryMade(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage homepage = LoginPage.loginToApp(input.get("email"),input.get("password"));
		homepage.userSaleEnqueryMade(input.get("propertyName"));
	}
	
	@DataProvider
	public Object[][] userSaleEnqueryMadeData1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/userapp/test/marketplace/EnqueryMadeLoginedUser.json");
		return new Object[][] { { value.get(0) } };
	}
}
 