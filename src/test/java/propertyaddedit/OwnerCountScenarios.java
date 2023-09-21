package propertyaddedit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalfiles.AndroidGlobalData;
import pageobject.AddProperty;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyProperties;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

public class OwnerCountScenarios extends AndroidGlobalData {

	@Test(dataProvider = "villapropertyData_2")
	public void ownerCountChangeAfterEnterDetails(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("emailId"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openMyProperties();
		MyProperties Myproperties = new MyProperties(driver);
		Myproperties.openAddPropertyPage();
		AddProperty AddProperty = new AddProperty(driver);
		/*AddProperty.after_owner_details_decrees_owner_count(input.get("titledeedDocument"), input.get("property_name"),
				input.get("property_category"), input.get("property_type"), input.get("property_status"),
				input.get("title_deed_number"), input.get("year"), input.get("owner_1_phone_number"),
				input.get("owner_1_email"), input.get("owner_1_name"), input.get("owner_1_percentage"),
				input.get("owner_2_phone_number"), input.get("owner_2_email"), input.get("owner_2_name"),
				input.get("owner_2_percentage"), input.get("owner_3_phone_number"), input.get("owner_3_email"),
				input.get("owner_3_name"), input.get("owner_3_percentage"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));*/
	}
	
	@DataProvider
	public Object[][] villapropertyData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D://Eclipse_Automation//UserApp//src//test//java//data//PropertyAddDetails.json");
		return new Object[][] { { value.get(0) } };
	}

	@DataProvider
	public Object[][] villapropertyData_2() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D://Eclipse_Automation//UserApp//src//test//java//data//PropertyAddDetails.json");
		return new Object[][] { { value.get(1) } };
	}
}
