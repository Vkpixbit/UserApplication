package com.pixbit.userapp.test.marketplace;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MarketplaceDetailsPage;
import com.pixbit.appium.pageobject.MarketplacePage;
import com.pixbit.appium.pageobject.SplashScreen;

public class MarketplaceEnqueryMade extends AndroidGlobalData {

	
	@Test(dataProvider = "enquery_made_logineduser_data")
	public void sale_enquery_made_from_login(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		MarketplacePage MarketplacePage=HomePage.openSaleMarketplace();
		MarketplaceDetailsPage MarketplaceDetailsPage=MarketplacePage.openPropertyFromMarketplace(input.get("property_name"));
		MarketplaceDetailsPage.enqueryMadeLoginedUser();
	}
	
	@DataProvider
	public Object[][] enquery_made_logineduser_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/userapp/test/marketplace/EnqueryMadeLoginedUser.json");
		return new Object[][] { { value.get(0) } };
	}
}
 