package com.pixbit.appium.test.rentalcontract.add;

import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.AddOwnerShipDetails;
import com.pixbit.appium.pageobject.AddProperty;
import com.pixbit.appium.pageobject.AddRental;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.SplashScreen;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;

public class RentAddAfterPropertyAdd extends AndroidGlobalData {

	/*
	 * Verify Rental adding when Propety present use in Rented
	 */
	@Test(dataProvider = "rentalAddInPropertyData", groups = "rental_add", enabled = true)
	public void rentAddForSinglePropertyAddingFlow(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_office();
		AddProperty.select_ready_status(input.get("age_of_property"), input.get("present_use"));
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"), input.get("bedroom_cabin_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"), input.get("kitchen_pantry_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddRental AddRental = AddProperty.addRental_propertyAdd();
		AddRental.uploadEjariRentalFlow(input.get("ejari_document"));
		AddRental.uploadTenancy(input.get("tenancy_document"));
		AddRental.nextButtonClick();
		AddRental.enter_cheque_details(input.get("cheque_count"), input.get("cheque_document"), input.get("bank_name"));
	}

	@DataProvider
	public Object[][] rentalAddInPropertyData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/rental/RentAsOwnerInPropertyAdd.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Verify if we add pre title deed property then rental adding in property add
	 * is working or not
	 */
	@Test(dataProvider = "rentalPreventionPropertyData", groups = "rental_add", enabled = true)
	public void rentalAddSinglePropertyPretitledeedFlow(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.enter_property_name(input.get("property_name"));
		AddProperty.select_property_category(input.get("property_category"));
		AddProperty.select_villa();
		AddProperty.select_under_construction_status();
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"), input.get("bedroom_cabin_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"), input.get("kitchen_pantry_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddProperty.goToProperties();
		System.out.println("Property is Underconstruction we can't add rental contract!");
	}

	@DataProvider
	public Object[][] rentalPreventionPropertyData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/rental/RentAsOwnerInPropertyAdd.json");
		return new Object[][] { { value.get(1) } };
	}

}
