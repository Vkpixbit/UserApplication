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

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RentAddAfterPropertyAdd  extends AndroidGlobalData {
	
	
	//Rental Add as Owner in property Add Flow
	//property type villa/townhouse
	@Test(dataProvider = "rentAddingData_1")
	public void rentAddForSinglePropertyAddingFlow(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("lalu@gmail.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties=ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails=MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty AddProperty= AddOwnerShipDetails.selectSingleOwnership();
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
		AddProperty.enter_suite_area(input.get("suite_area"));
		AddProperty.enter_balcony_area(input.get("balcony_area"));
		AddProperty.enter_total_area_sqm(input.get("total_area_sqm"));
		AddProperty.enter_total_area_sqft(input.get("total_area_sqft"));
		AddProperty.enter_common_area(input.get("common_area"));
		AddProperty.enter_parking(input.get("parking"));
		scrollToNext();
		AddProperty.nextButtonClick();
		AddProperty.select_bedroom_cabin_count(input.get("bedroom_cabin_count"));
		AddProperty.select_bathroom_count(input.get("bathroom_count"),input.get("bedroom_cabin_count"));
		AddProperty.select_kitchen_pantry_count(input.get("kitchen_pantry_count"));
		AddProperty.select_balcony_count(input.get("balcony_count"),input.get("kitchen_pantry_count"));
		AddProperty.select_map_location();
		AddProperty.select_furnishing_status(input.get("furnishing_status"));
		AddProperty.click_save();
		AddRental AddRental=AddProperty.addRental_propertyAdd();
		AddRental.uploadEjari(input.get("ejari_document"));
		AddRental.uploadTenancy(input.get("tenancy_document"));
		AddRental.clickNext();
		AddRental.enterEjari(input.get("ejari_number"));
		//Add rental we only change end date as expired case
		AddRental.enterRentalDetailsOwner(input.get("end_date"));
		
	}
	
	@DataProvider
	public Object[][] rentAddingData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/com/pixbit/appium/test/data/rental/RentData.json");
		return new Object[][] { {value.get(0)} };
	}

}
