package propertypublish;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalfiles.GlobalData;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyProperties;
import pageobject.ProfilePage;
import pageobject.PropertyDetails;
import pageobject.PublishProperty;
import pageobject.SplashScreen;

public class PropertyPublishing extends GlobalData {

	@BeforeClass
	public void openMyPropertyPage() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sarath@pixbitsolutions.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openMyProperties();
	}
	
	@Test(dataProvider = "rmPdublishPropertyDetails")
	public void publishForSale(HashMap<String, String>input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		PropertyDetails PropertyDetails=Myproperties.selectProperty(input.get("property_name"));
		PublishProperty PublishProperty=PropertyDetails.clickPublish();
		PublishProperty.normalPublishForSale();	
	}
	
	@DataProvider
	public Object[][] rmPdublishPropertyDetails() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D://Eclipse_Automation//rmapp//src//test//java//data//PublishPropertyDetails.json");
		return new Object[][] { { value.get(0) } };
	}

}
