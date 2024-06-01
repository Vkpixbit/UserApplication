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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;

public class JointPropertyAdd extends AndroidGlobalData {

	/*
	 * Two owner property skip owners adding office property with shell & Core if
	 * mortgage then add mortgage details
	 */
	@Test(dataProvider = "two_owners_skipall_joint_office_shellandcore_property_data",groups = "joint_property", enabled = true)
	public void two_owners_skip_all_office_shellandcore_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnersSkipAll();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_office();
		AddProperty.select_shellandcore_status(input.get("age_of_property"), input.get("present_use"));
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
	public Object[][] two_owners_skipall_joint_office_shellandcore_property_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyOfficeData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owners joint property and we one owner and skip one Service apartment
	 * property with under construction property status add payment plan
	 */
	@Test(dataProvider = "two_owner_add_one_serviceapartment_underconstruction_data",groups = "joint_property", enabled = true)
	public void two_owners__oneaddoneskip_serviceapartment_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.addOneOwnerAndSkipOne(input.get("owner_1_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_apartment();
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
	public Object[][] two_owner_add_one_serviceapartment_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyServiceApartmentData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owner joint property and we add two owner service apartment property
	 * Enter mortgage details
	 */
	@Test(dataProvider = "two_owners_joint_apartment_property_ready_data",groups = "joint_property", enabled = true)
	public void two_owners_apartment_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_service_apartment();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		scrollToNext();
		AddProperty.select_mortgaged_tenure_year_month_offer_letter(input.get("mortgage_amount"),
				input.get("tenure_year"), input.get("tenure_month"), input.get("mortgage_start_date"),
				input.get("finance_rate"));
		scrollToNext();
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
	public Object[][] two_owners_joint_apartment_property_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyApartmentData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Three owners are in the prosper Property type is townhouse property
	 * underconstruction Add payment plan
	 */
	@Test(dataProvider = "three_owners_townhouseunderconstruction_data",groups = "joint_property", enabled = true)
	public void three_owners_townhouse_underconstruction_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnersSelectAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_townhouse();
		AddProperty.select_under_construction_status();
		scrollToNext();
		AddProperty.add_payment_plan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		scrollToNext();
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
	public Object[][] three_owners_townhouseunderconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyTownhouseData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owners property one prosper and one guest
	 * villa property
	 * Ready and enter mortgage details
	 */
	@Test(dataProvider = "twoowners_oneguest_office_underconstruction_data",groups = "joint_property", enabled = true)
	public void two_owners_one_guest_office_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_villa();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		AddProperty.scroll_to_next();
		AddProperty.select_mortgaged_tenure_year_month_offer_letter(input.get("mortgage_amount"),
				input.get("tenure_year"), input.get("tenure_month"), input.get("mortgage_start_date"),
				input.get("finance_rate"));
		scrollToNext();
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
	public Object[][] twoowners_oneguest_office_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyOfficeData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * Select Three owners add Three owners from prosper townhouse property with
	 * underconstruction property status
	 * add payment plan and mortgage details
	 */
	@Test(dataProvider = "threeowners_threeadd_townhouse_undercontruction_data",groups = "joint_property", enabled = true)
	public void threee_owners_townhouse_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnersSelectAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_townhouse();
		AddProperty.select_under_construction_status();
		AddProperty.add_payment_plan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		scrollToNext();
		AddProperty.select_mortgaged_tenure_year_month_offer_letter(input.get("mortgage_amount"),
				input.get("tenure_year"), input.get("tenure_month"), input.get("mortgage_start_date"),
				input.get("finance_rate"));
		scrollToNext();
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
	public Object[][] threeowners_threeadd_townhouse_undercontruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getenv("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyTownhouseData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * Three owner add two owner owner and skip anothe one
	 * Apartment property
	 * ready status
	 */
	@Test(dataProvider = "threeowners_twoadd_skipone_apartment_ready_data",groups = "joint_property", enabled = true)
	public void three_owners_addtwo_skipone_apartment_ready_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnerCountSelectionAndSkipOne(
				input.get("owner_1_percentage"), input.get("country_code"), input.get("owner_2_phone_number"),
				input.get("owner_2_email"), input.get("owner_2_name"), input.get("owner_2_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_apartment();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
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
	public Object[][] threeowners_twoadd_skipone_apartment_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyApartmentData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * four owners and add all villa property 
	 * underconstruction and payment plan
	 */
	@Test(dataProvider = "fourowners_fouradd_villa_undeconstruction_data",enabled = true)
	public void fourowner_add_villa_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.fourOwnerAddFour(input.get("owner_1_percentage"),
				input.get("country_code_2"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("country_code_3"),
				input.get("owner_3_phone_number"), input.get("owner_3_email"), input.get("owner_3_name"),
				input.get("owner_3_percentage"), input.get("country_code_4"), input.get("owner_4_phone_number"),
				input.get("owner_4_email"), input.get("owner_4_name"), input.get("owner_4_percentage"));
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_villa();
		AddProperty.select_under_construction_status();
		scrollToNext();
		AddProperty.add_payment_plan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
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
	public Object[][] fourowners_fouradd_villa_undeconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyVillaData.json");
		return new Object[][] { { value.get(1) } };
	}

}
