package rental;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalfiles.AndroidGlobalData;
import pageobject.AddRental;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import pageobject.RentedPropertiesList;
import pageobject.SplashScreen;

public class TenantRentalAddInList extends AndroidGlobalData{

	@BeforeClass
	public void openPropertyRentList() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("neethu@pixbitsolutions.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openRentedProperties();
	}
	
	
	//Add rental as tenant with out adading title deed number
	@Test(dataProvider = "tenantRentAddData_1")
	public void addRentalAsTenant_1(HashMap<String, String>input) throws InterruptedException {
		RentedPropertiesList RentedPropertiesList=new RentedPropertiesList(driver);
		//Given user select rental adding as tenant
		AddRental AddRental=RentedPropertiesList.openRentAsTenant();
		//Then user upload ejari document
		AddRental.uploadEjariRentalFlow(input.get("ejari_document"));
		//Then user upload tenancy document
		AddRental.uploadTenancy(input.get("tenancy_document"));
		//Then user click next button
		AddRental.nextButtonClick();
		//Then user enter ejari number not enter title deed number
		AddRental.enterEjari(input.get("ejari_number"));
		//Then enter rental data like enter contract end date
		AddRental.enterRentalDetailsOwner(input.get("end_date"));
	}
	@DataProvider
	public Object[][] tenantRentAddData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/RentData.json");
		return new Object[][] { {value.get(2)} };
	}

	
	//Add rental as tenant with ejari number and title deed number
	@Test(dataProvider = "tenantRentData_2")
	public void addRentalAsTenant_2(HashMap<String, String>input) throws InterruptedException {
		RentedPropertiesList RentedPropertiesList=new RentedPropertiesList(driver);
		//Given user select rental adading as tenant
		AddRental AddRental=RentedPropertiesList.openRentAsTenant();
		//user uploaad ejari document
		AddRental.uploadEjariRentalFlow(input.get("ejari_document"));
		//user upload tennacy document
		AddRental.uploadTenancy(input.get("tenancay_document"));
		//click next button
		AddRental.nextButtonClick();
		//enter ejari number 
		AddRental.enterEjari(input.get("ejari_number"));
		//user enter title deed number
		AddRental.eneterTitleDeedNumber(input.get("title_deed_number"));
	}
	@DataProvider
	public Object[][] tenantRentData_2() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/RentData.json");
		return new Object[][] { {value.get(4)}};
	}
}
