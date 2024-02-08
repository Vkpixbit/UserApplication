package propertyaddedit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalfiles.AndroidGlobalData;
import pageobject.AddOwnerShipDetails;
import pageobject.AddProperty;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyProperties;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

public class SinglePropertyAdd extends AndroidGlobalData {

	@BeforeSuite
	public void openMyPropertyPage() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("ajithkumar@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openMyProperties();
	}

	/*
	 * Single owned property property type is Apartment Ready property status
	 */
	@Test(dataProvider = "single_property_apartment", enabled = true)
	public void single_property_with_apartment_ready_status(HashMap<String, String> input) throws InterruptedException {
		MyProperties MyProperties = new MyProperties(driver);
		Thread.sleep(2000);
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openAddSinglePropertyPage();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_apartment();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		AddProperty.nextButtonClick();
		AddProperty.enter_plot_number(input.get("plot_number"));
		AddProperty.enter_municipality_number(input.get("municipality_number"));
		AddProperty.enter_community(input.get("community"));
		AddProperty.select_area_region(input.get("area_region"));
		AddProperty.enter_purchase_price(input.get("property_value"));
		AddProperty.select_not_mortgaged();
		AddProperty.enter_building_number(input.get("building_number"));
		AddProperty.enter_building_name(input.get("building_name"));
		AddProperty.enter_property_number(input.get("property_number"));
		AddProperty.enter_floor_number(input.get("floor_number"));
		//AddProperty.enter_parking(input.get("parking"));
		AddProperty.enter_suite_area(input.get("suite_area"));
		AddProperty.enter_balcony_area(input.get("balcony_area"));
		AddProperty.enter_total_area_sqm(input.get("total_area_sqm"));
		AddProperty.enter_total_area_sqft(input.get("total_area_sqft"));
		AddProperty.enter_common_area(input.get("common_area"));
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddProperty.skip_rent();
	}

	@DataProvider
	public Object[][] single_property_apartment() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				System.getProperty("user.dir") + "/src/test/java/data/single_property_data.json");
		return new Object[][] { { value.get(0) } };
	}

}
