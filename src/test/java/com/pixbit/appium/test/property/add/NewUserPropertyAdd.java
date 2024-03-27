package com.pixbit.appium.test.property.add;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.AddOwnerShipDetails;
import com.pixbit.appium.pageobject.AddProperty;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.SplashScreen;

public class NewUserPropertyAdd extends AndroidGlobalData {

	/*
	 * New User Add property with different cases like
	 * Villa,Townhouse,apartment,service apartment and office Ready or Under
	 * Construction
	 */

	/*
	 * Single property add villa property type with ready status
	 */
	@Test(dataProvider = "single_villa_ready_property_data", enabled = true)
	public void single_villa_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("moydeen123@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
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
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_villa_townhouse_data.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Single property add townhouse and under construction property status
	 */
	@Test(dataProvider = "single_townhouse_underconstruction_property_data", enabled = false)
	public void single_townhouse_underconstruction_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("surajpix@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
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
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_villa_townhouse_data.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * Single property add service apartment and ready property status
	 */
	@Test(dataProvider = "single_service_apartment_ready_property_data", enabled = false)
	public void single_service_apartment_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("aishu@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_service_apartment();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		AddProperty.nextButtonClick();
		AddProperty.enter_plot_number(input.get("plot_number"));
		AddProperty.enter_municipality_number(input.get("municipality_number"));
		AddProperty.enter_community(input.get("community"));
		AddProperty.select_area_region(input.get("area_region"));
		AddProperty.enter_purchase_price(input.get("property_value"));
		AddProperty.select_not_mortgaged();
		scrollToNext();
		AddProperty.enter_building_number(input.get("building_number"));
		AddProperty.enter_building_name(input.get("building_name"));
		AddProperty.enter_property_number(input.get("property_number"));
		AddProperty.enter_floor_number(input.get("floor_number"));
		AddProperty.enter_parking(input.get("parking"));
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
	public Object[][] single_service_apartment_ready_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/data/single_property_apartment_serviceapartment_office_data.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Single property add office and under construction property status
	 */
	@Test(dataProvider = "single_office_underconstruction_property_data", enabled = false)
	public void single_office_underconstruction_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("aishu@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_office();
		AddProperty.select_under_construction_status();
		AddProperty.nextButtonClick();
		AddProperty.enter_plot_number(input.get("plot_number"));
		AddProperty.enter_municipality_number(input.get("municipality_number"));
		AddProperty.enter_community(input.get("community"));
		AddProperty.select_area_region(input.get("area_region"));
		AddProperty.enter_purchase_price(input.get("property_value"));
		AddProperty.select_not_mortgaged();
		scrollToNext();
		AddProperty.enter_building_number(input.get("building_number"));
		AddProperty.enter_building_name(input.get("building_name"));
		AddProperty.enter_property_number(input.get("property_number"));
		AddProperty.enter_floor_number(input.get("floor_number"));
		AddProperty.enter_parking(input.get("parking"));
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
		AddProperty.goToProperties();
	}

	@DataProvider
	public Object[][] single_office_underconstruction_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/data/single_property_apartment_serviceapartment_office_data.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * Joint property with apartment and ready property status
	 */
	@Test(dataProvider = "joint_apartment_ready_property_data", enabled = false)
	public void joint_apartment_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("aishu@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"));
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
		AddProperty.enter_parking(input.get("parking"));
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
		AddProperty.goToProperties();
	}

	@DataProvider
	public Object[][] joint_apartment_ready_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/data/jointpropertydata/JointPropertyApartmentData.json");
		return new Object[][] { { value.get(0) } };
	}

}
