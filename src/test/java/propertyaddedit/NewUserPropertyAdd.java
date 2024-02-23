package propertyaddedit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalfiles.AndroidGlobalData;
import pageobject.AddOwnerShipDetails;
import pageobject.AddProperty;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

public class NewUserPropertyAdd extends AndroidGlobalData {

	/*
	 * New User Add property with different cases like
	 * Villa,Townhouse,apartment,service apartment and office Ready or Under
	 * Construction
	 */
	

	/*
	 * Single property add villa property type with ready status
	 */
	@Test(dataProvider = "single_villa_ready_property_data")
	public void single_villa_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("aishu@gmail.com","Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails=ProfilePage.openPropertyAddPage();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_villa();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		AddProperty.nextButtonClick();
		AddProperty.enter_plot_number(input.get("plot_number"));
		AddProperty.enter_municipality_number(input.get("municipality_number"));
		AddProperty.enter_community(input.get("community"));
		AddProperty.select_area_region(input.get("area_region"));
		AddProperty.enter_purchase_price(input.get("property_value"));
		AddProperty.select_not_mortgaged();
		scrollToNext();
		AddProperty.enter_unit_number(input.get("unit_number"));
		AddProperty.enter_plot_area_sqm(input.get("plot_area_sqm"));
		AddProperty.enter_plot_area_sqft(input.get("plot_area_sqft"));
		AddProperty.enter_build_up_area(input.get("build_up_area"));
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
	public Object[][] single_villa_ready_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				System.getProperty("user.dir" + "/src/test/java/data/single_property_villa_townhouse_data.json"));
		return new Object[][] { { value.get(0) } };
	}
	
	/*
	 * Single property add townhouse and under construction property status
	 */
	@Test(dataProvider = "single_townhouse_underconstruction_property_data")
	public void single_townhouse_underconstruction_property(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("aishu@gmail.com","Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails=ProfilePage.openPropertyAddPage();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_townhouse();
		AddProperty.select_under_construction_status();
		AddProperty.nextButtonClick();
		AddProperty.enter_plot_number(input.get("plot_number"));
		AddProperty.enter_municipality_number(input.get("municipality_number"));
		AddProperty.enter_community(input.get("community"));
		AddProperty.select_area_region(input.get("area_region"));
		AddProperty.enter_purchase_price(input.get("property_value"));
		AddProperty.select_not_mortgaged();
		scrollToNext();
		AddProperty.enter_unit_number(input.get("unit_number"));
		AddProperty.enter_plot_area_sqm(input.get("plot_area_sqm"));
		AddProperty.enter_plot_area_sqft(input.get("plot_area_sqft"));
		AddProperty.enter_build_up_area(input.get("build_up_area"));
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddProperty.goToProperties();
	}
	
	@DataProvider
	public Object[][] single_townhouse_underconstruction_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				System.getProperty("user.dir" + "/src/test/java/data/single_property_villa_townhouse_data.json"));
		return new Object[][] { { value.get(1) } };
	}
	
	

}
