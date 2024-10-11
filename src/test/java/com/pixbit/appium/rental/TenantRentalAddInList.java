package com.pixbit.appium.rental;

import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.AddOwnerShipDetails;
import com.pixbit.appium.pageobject.AddRental;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.RentedPropertiesList;
import com.pixbit.appium.pageobject.SplashScreen;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;

public class TenantRentalAddInList extends AndroidGlobalData {

	/*
	 * Add Rental as Teannt from Rental page
	 */
	@Test(dataProvider = "rentalAddAsTenantWithTitledeedData", groups = "rental_add", enabled = true)
	public void rentalAddAsTenantWithTitledeed(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"),input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		RentedPropertiesList RentedPropertiesList = ProfilePage.openRentedProperties();
		AddRental AddRental = RentedPropertiesList.openRentAsTenant(input.get("isFirstAdd"));
		AddRental.uploadEjariRentalFlow(input.get("ejari_document"));
		AddRental.uploadTenancy(input.get("tenancy_document"));
		AddOwnerShipDetails AddOwnerShipDetails = new AddOwnerShipDetails(driver);
		AddOwnerShipDetails.deedSelectionForRent(input.get("isTitleDeed"),input.get("titledeedDocument"));
		AddRental.verifyAndContinue();
		AddRental.enterChequeDetails(input.get("cheque_count"), input.get("cheque_document"), input.get("bank_name"));
		AddRental.clickSave();
	}

	@DataProvider
	public Object[][] rentalAddAsTenantWithTitledeedData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/rental/RentalAsTenantList.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Add rental as tenant without title deed
	 */
	@Test(dataProvider = "rentalAddTenantWithoutTitledeedData", groups = "rental_add", enabled = false)
	public void rentalAddAsTenantWithoutTitledeed(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"),input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		RentedPropertiesList RentedPropertiesList = ProfilePage.openRentedProperties();
		AddRental AddRental = RentedPropertiesList.openRentAsTenant(input.get("isFirstAdd"));
		AddRental.uploadEjariRentalFlow(input.get("ejari_document"));
		AddRental.uploadTenancy(input.get("tenancy_document"));
		Thread.sleep(10000);	
		AddRental.verifyAndContinue();
		Thread.sleep(2000);
		AddRental.saveWithOutCheque();
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] rentalAddTenantWithoutTitledeedData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/rental/RentalAsTenantList.json");
		return new Object[][] { { value.get(1) } };
	}
}
