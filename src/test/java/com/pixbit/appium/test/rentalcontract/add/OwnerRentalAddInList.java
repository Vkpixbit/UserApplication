package com.pixbit.appium.test.rentalcontract.add;

import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
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

public class OwnerRentalAddInList extends AndroidGlobalData {

	@Test(dataProvider = "rental_add_owner_list_data", groups = "rental_add", enabled = true)
	public void add_rental_as_owner_from_property_list(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		RentedPropertiesList RentedPropertiesList = ProfilePage.openRentedProperties();
		AddRental AddRental = RentedPropertiesList.openRentAsOwner();
		AddRental.selectProperty(input.get("rent_property"));
		AddRental.uploadEjariRentalFlow(input.get("ejari_document"));
		AddRental.uploadTenancy(input.get("tenancy_document"));
		AddRental.nextButtonClick();
		AddRental.enter_cheque_details(input.get("cheque_count"), input.get("cheque_document"), input.get("bank_name"),
				input.get("cheque_date"));
	}

	@DataProvider
	public Object[][] rental_add_owner_list_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				System.getProperty("user.dir") + "/src/test/java/com/pixbit/appium/test/data/rental/RentAsOwnerInList.json");
		return new Object[][] { { value.get(0) } };
	}
	
}
