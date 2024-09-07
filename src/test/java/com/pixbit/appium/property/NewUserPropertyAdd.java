package com.pixbit.appium.property;

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
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.select_under_construction_status();
		AddProperty.add_payment_plan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		AddProperty.scroll_to_next();
		// AddProperty.select_mortgaged_skip();
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"), input.get("bedroom_cabin_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"), input.get("kitchen_pantry_count"));
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
	 * Single property add service apartment and ready property status
	 */
	@Test(dataProvider = "single_service_apartment_ready_property_data", enabled = false)
	public void single_service_apartment_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.select_ready_status(input.get("present_use"));
		AddProperty.scroll_to_next();
		// AddProperty.select_mortgaged_skip();
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"), input.get("bedroom_cabin_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"), input.get("kitchen_pantry_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddProperty.skip_rent();
	}

	@DataProvider
	public Object[][] single_service_apartment_ready_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_apartment_serviceapartment_office_data.json");
		return new Object[][] { { value.get(0) } };
	}

}
