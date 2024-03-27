package com.pixbit.appium.test.property.add;

import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.AddOwnerShipDetails;
import com.pixbit.appium.pageobject.AddProperty;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.SplashScreen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;

public class JointPropertyAdd extends AndroidGlobalData {

	/*
	 * Two owner property skip owners adding office property with shell & Core
	 */
	@Test(dataProvider = "two_owners_skipall_joint_office_shellandcore_property_data")
	public void two_owners_skip_all_office_shellandcore_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnersSkipAll();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_office();
		AddProperty.select_shellandcore_status(input.get("age_of_property"), input.get("present_use"));
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
		AddProperty.skip_rent();
	}

	@DataProvider
	public Object[][] two_owners_skipall_joint_office_shellandcore_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyOfficeData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owners joint property and we one owner and skip one Service apartment
	 * property with under construction property status
	 */
	@Test(dataProvider = "two_owner_add_one_serviceapartment_underconstruction_data")
	public void two_owners__oneaddoneskip_serviceapartment_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.addOneOwnerAndSkipOne(input.get("owner_1_percentage"));
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
		AddProperty.skip_rent();
	}

	@DataProvider
	public Object[][] two_owner_add_one_serviceapartment_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyServiceApartmentData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owner joint property and we add two owner from prosper Aprtment/Service
	 * Apartment/Office Ready Property Status
	 */
	@Test(dataProvider = "two_owners_joint_apartment_property_ready_data")
	public void two_owners_apartment_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"),
				input.get("owner_2_phone_number"), input.get("owner_2_percentage"));
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
		AddProperty.skip_rent();
	}

	@DataProvider
	public Object[][] two_owners_joint_apartment_property_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/jointpropertydata/JointPropertyApartmentData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owners are in the prosper Property type is Villa/Townhouse
	 */
	@Test(dataProvider = "two_owners_villa_underconstruction_data")
	public void two_owners_villa_underconstruction_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_villa();
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
	public Object[][] two_owners_villa_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/JointPropertyTownhouseData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owners property one prosper and one guest office property with ready
	 * property status
	 */
	@Test(dataProvider = "twoowners_oneguest_office_underconstruction_data")
	public void two_owners_one_guest_office_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_office();
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
		AddProperty.skip_rent();
	}

	@DataProvider
	public Object[][] twoowners_oneguest_office_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyOfficeData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Select Three owners add Three owners from prosper townhouse property with
	 * underconstruction property status
	 */
	@Test(dataProvider = "threeowners_threeadd_townhouse_undercontruction_data", enabled = true)
	public void threee_owners_townhouse_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnersSelectAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"));
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
		AddProperty.skip_rent();

	}

	@DataProvider
	public Object[][] threeowners_threeadd_townhouse_undercontruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getenv("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyTownhouseData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * three owners property add two owners and skip one owner apartment property
	 * with ready property status
	 */
	@Test(dataProvider = "threeowners_twoadd_skipone_apartment_ready_data")
	public void three_owners_addtwo_skipone_apartment_ready_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnerCountSelectionAndSkipOne(
				input.get("owner_1_percentage"), input.get("country_code"), input.get("owner_2_phone_number"),
				input.get("owner_2_email"), input.get("owner_2_name"), input.get("owner_2_percentage"));
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
		AddProperty.skip_rent();

	}

	@DataProvider
	public Object[][] threeowners_twoadd_skipone_apartment_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getenv("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyApartmentData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * four owners and add all villa property with underconstruction property status
	 */
	@Test
	public void fourowner_add_villa_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sudarshan@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty=AddOwnerShipDetails.fourOwnerAddFour(input.get("owner_1_percentage"), input.get("country_code_2"),
				input.get("owner_2_phone_number"), input.get("owner_2_email"), input.get("owner_2_name"),
				input.get("owner_2_percentage"), input.get("country_code_3"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"),
				input.get("country_code_4"), input.get("owner_4_phone_number"), input.get("owner_4_email"),
				input.get("owner_4_name"), input.get("owner_4_percentage"));
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

}
