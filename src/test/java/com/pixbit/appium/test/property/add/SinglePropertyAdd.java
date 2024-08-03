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
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.SplashScreen;

public class SinglePropertyAdd extends AndroidGlobalData {

	/*
	 * Apartment
	 * Ready 
	 * Mortgaged and skip
	 */
	@Test(dataProvider = "property_apartment_ready_data", groups = "single_property", enabled = true)
	public void property_apartment_ready(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		//System.out.println("Basic Details section showing");
		//AddProperty.enter_property_name(input.get("property_name"));
		//AddProperty.select_property_category(input.get("property_category"));
		//AddProperty.select_apartment();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		AddProperty.scroll_to_next();
		//AddProperty.select_mortgaged_skip();
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
	public Object[][] property_apartment_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_apartment_serviceapartment_office_data.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * townhouse 
	 * undeconstruction 
	 * Enter Mortgage Details
	 * Add payment plan
	 */
	@Test(dataProvider = "property_townhouse_underconstruction_data", groups = "single_property", enabled = true)
	public void property_townhouse_underconstruction(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		//System.out.println("Basic Details section showing");
		AddProperty.enter_property_name(input.get("property_name"));
		//AddProperty.select_property_category(input.get("property_category"));
		//AddProperty.select_townhouse();
		AddProperty.select_under_construction_status();
		AddProperty.scroll_to_next();
		AddProperty.add_payment_plan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		AddProperty.select_mortgaged_tenure_year(input.get("mortgage_amount"), input.get("tenure_year"),
				input.get("mortgage_start_date"), input.get("finance_rate"));
		AddProperty.scroll_to_next();
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"), input.get("bedroom_cabin_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"), input.get("kitchen_pantry_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddProperty.goToProperties();
	}

	@DataProvider
	public Object[][] property_townhouse_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_villa_townhouse_data.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Office
	 * underconstruction
	 * Enter Payment plan details
	 */
	@Test(dataProvider = "property_office_underconstruction_data",groups = "single_property", enabled = true)
	public void property_office_underconstruction(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		System.out.println("Basic Details section showing");
		AddProperty.enter_property_name(input.get("propert_name"));
		//AddProperty.select_property_category(input.get("property_category"));
		//AddProperty.select_office();
		AddProperty.select_under_construction_status();
		AddProperty.scroll_to_next();
		AddProperty.add_payment_plan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		AddProperty.scroll_to_next();
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
	public Object[][] property_office_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_apartment_serviceapartment_office_data.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * villa
	 * ready
	 * enter mortgage details
	 */
	@Test(dataProvider = "property_villa_ready_data",groups = "single_property", enabled = true)
	public void property_villa_ready(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		System.out.println("Basic Details section showing");
		AddProperty.enter_property_name(input.get("property_name"));
		//AddProperty.select_property_category(input.get("property_category"));
		//AddProperty.select_villa();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		AddProperty.scroll_to_next();
		AddProperty.select_mortgaged_tenure_year_month_offer_letter(input.get("mortgage_amount"),
				input.get("tenure_year"), input.get("tenure_month"), input.get("mortgage_start_date"),
				input.get("finance_rate"));
		AddProperty.scroll_to_next();
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
	public Object[][] property_villa_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_villa_townhouse_data.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * service apartment
	 * underconstruction
	 * add payment plan
	 * add mortgage details
	 */
	@Test(dataProvider = "property_serviceapartment_underconstruction_paymentplan_data",groups = "single_property", enabled = true)
	public void property_underconstruction_paymentplan(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		System.out.println("Basic Details section showing");
		AddProperty.enter_property_name(input.get("property_name"));
		//AddProperty.select_property_category(input.get("property_category"));
		//AddProperty.select_service_apartment();
		AddProperty.select_under_construction_status();
		AddProperty.scroll_to_next();
		AddProperty.add_payment_plan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		AddProperty.scroll_to_next();
		AddProperty.select_mortgaged_tenure_year_month_offer_letter(input.get("mortgage_amount"),
				input.get("tenure_year"), input.get("tenure_month"), input.get("mortgage_start_date"),
				input.get("finance_rate"));
		AddProperty.scroll_to_next();
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"), input.get("bedroom_cabin_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"), input.get("kitchen_pantry_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddProperty.goToProperties();
	}

	@DataProvider
	public Object[][] property_serviceapartment_underconstruction_paymentplan_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/singleproperty/single_property_apartment_serviceapartment_office_data.json");
		return new Object[][] { { value.get(2) } };
	}

}
