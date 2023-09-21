package propertyaddedit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import globalfiles.AndroidGlobalData;
import pageobject.AddProperty;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyProperties;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

public class TestpropertyAdd extends AndroidGlobalData {

	@BeforeClass
	public void openMyPropertyPage() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("neethu@pixbitsolutions.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openMyProperties();
	}

	// 2 owners are in the prosper
	// joint Property,property type is villa/townhouse
	@Test(dataProvider = "TownhousepropertyData_1",enabled = false)
	public void addJointProperty_1(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty = Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"), input.get("owner_2_phone_number"),
				input.get("owner_2_percentage"));
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));
		AddProperty.skip_rent();
	}

	@DataProvider
	public Object[][] TownhousepropertyData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/propertyAddDetails.json");
		return new Object[][] { { value.get(1) } };
	}

	
	//2 owners are in the prosper
	//joint property,property type is service apartment/apartment
	@Test(dataProvider = "apartmentServiceApartmentData_1",enabled = false)
	public void addJointProperty_7(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty = Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"), input.get("owner_2_phone_number"),
				input.get("owner_2_percentage"));
		AddProperty.propertyAdd_apartment_serviceApartment(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("building_number"), input.get("building_name"), input.get("property_number"),
				input.get("floor_number"), input.get("parking"), input.get("suite_area"), input.get("balcony_area"), input.get("total_area_sqm"),
				input.get("total_area_sqft"), input.get("common_area"),input.get("furnishing_status"));
		AddProperty.skip_rent();
	}
	
	@DataProvider
	public Object[][] apartmentServiceApartmentData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/ApartmentServiceAparmentDetails.json");
		return new Object[][] {{value.get(0)}, { value.get(1) } };
	}
	
	
	
	// select 3 owners add 2 owners from prosper and skip 1
	// joint Property,property type not add service apartment,Office,Apartment
	@Test(dataProvider = "TownhousepropertyData_1", enabled = false)
	public void addJointProperty_2(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty = Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.threeOwnerCountSelectionAndSkipOne(input.get("owner_1_percentage"),
				input.get("owner_2_phone_number"), input.get("owner_2_percentage"));
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));

	}

	// select 4 owners add 2 owners from prosper 1 guest and skip 1
	// joint Property,property type not add service apartment,Office,Apartment
	@Test(dataProvider = "TownhousepropertyData_2", enabled = false)
	public void addJointProperty_3(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty = Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.fourOwnerAddThreeSkipOne(input.get("owner_1_percentage"), input.get("owner_2_phone_number"),
				input.get("owner_2_percentage"), input.get("owner_3_phone_number"), input.get("owner_3_email"),
				input.get("owner_3_name"), input.get("owner_3_percentage"));
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));

	}

	// Select 2 owner add one and skip one
	// joint property type as villa
	@Test(dataProvider = "VillapropertyData_1", enabled = false)
	public void addJointProperty_4(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty = Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.addOneOwnerAndSkipOne(input.get("owner_1_percentage"));
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));
	}

	@DataProvider
	public Object[][] VillapropertyData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/propertyAddeDetails.json");
		return new Object[][] { { value.get(6) } };
	}

	// 5 owners, first added user,second is guest ,third and fourth are owner in
	// prosper skip fifth
	// property type is villa
	@Test(dataProvider = "VillapropertyData_2", enabled = false)
	public void addJointProperty_5(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty = Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.fiveOwnerAddFourSkipOne(input.get("owner_1_percentage"), input.get("owner_2_phone_number"),
				input.get("owner_2_email"), input.get("owner_2_name"), input.get("owner_2_percentage"),
				input.get("owner_3_phone_number"), input.get("owner_3_percentage"), input.get("owner_4_phone_number"),
				input.get("owner_4_percentage"));
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));
	}

	@DataProvider
	public Object[][] VillapropertyData_2() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/propertyAddDetails.json");
		return new Object[][] { { value.get(7) } };
	}

	// five owners and skip all owners for adding
	// property type is villa
	@Test(dataProvider = "VillapropertyData_3", enabled = false)
	public void addJointProperty_6(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty = Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.twoOwnersSkipAll();
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));
	}

	@DataProvider
	public Object[][] VillapropertyData_3() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/propertyAddDetails.json");
		return new Object[][] { { value.get(9) } };
	}

	// Single owned property
	//property type is villa/townhouse
	@Test(dataProvider = "VillapropertyData_3")
	public void addSingleProperty_1(HashMap<String, String> input) throws InterruptedException {
		MyProperties MyProperties = new MyProperties(driver);
		AddProperty AddProperty = MyProperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectSingleOwnership();
		AddProperty.continueButton.click();
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("unit_number"), input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"),
				input.get("buildup_area"), input.get("furnishing_status"));
		AddProperty.skip_rent();
	}
	
	//single owned property
	//property type is apartment/service apartment
	@Test(dataProvider = "apartmentServiceApartment_3")
	public void addSingleProperty_2(HashMap<String, String>input) throws InterruptedException {
		MyProperties MyProperties = new MyProperties(driver);
		AddProperty AddProperty = MyProperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectSingleOwnership();
		AddProperty.continueButton.click();
		AddProperty.propertyAdd_apartment_serviceApartment(input.get("property_name"), input.get("property_category"),
				input.get("property_type"), input.get("property_status"), input.get("age_of_property"),
				input.get("present_use"), input.get("area_region"), input.get("property_value"),
				input.get("building_number"), input.get("building_name"), input.get("property_number"),
				input.get("floor_number"), input.get("parking"), input.get("suite_area"), input.get("balcony_area"), input.get("total_area_sqm"),
				input.get("total_area_sqft"), input.get("common_area"),input.get("furnishing_status"));
		AddProperty.skip_rent();
	}
	
	@DataProvider
	public Object[][] apartmentServiceApartmentData_2() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/ApartmentServiceAparmentDetails.json");
		return new Object[][] { { value.get(2) },{value.get(3) } };
	}

}
