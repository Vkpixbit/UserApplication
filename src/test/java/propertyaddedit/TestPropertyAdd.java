package propertyaddedit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import globalfiles.GlobalData;
import pageobject.AddProperty;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyProperties;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

public class TestPropertyAdd extends GlobalData {

	@BeforeClass
	public void openMyPropertyPage() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("sarath@pixbitsolutions.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openMyProperties();
	}
	

	// 2 owners are in the prosper
	// joint Property,property type not add service apartment,Office,Apartment
	@Test(dataProvider = "TownhousepropertyData_1")
	public void addJointProperty_1(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty=Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"),input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"), input.get("owner_2_phone_number"),
				input.get("owner_2_percentage"));
		AddProperty.propertyAdd(input.get("property_name"), input.get("property_category"), input.get("property_type"),
				input.get("property_status"), input.get("age_of_property"), input.get("present_use"),
				input.get("area_region"), input.get("property_value"), input.get("unit_number"),
				input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"), input.get("buildup_area"),
				input.get("furnishing_status"));
	}
	
	@DataProvider
	public Object[][] TownhousepropertyData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D://Eclipse_Automation//UserApp//src//test//java//data//PropertyAddDetails.json");
		return new Object[][] { { value.get(0) } };
	}

	// select 3 owners add 2 owners from prosper and skip 1
	// joint Property,property type not add service apartment,Office,Apartment
	@Test(dataProvider = "TownhousepropertyData_1",enabled = false)
	public void addJointProperty_2(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty=Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.threeOwnerCountSelectionAndSkipOne(input.get("owner_1_percentage"),
				input.get("owner_2_phone_number"), input.get("owner_2_percentage"));
		AddProperty.propertyAdd(input.get("property_name"), input.get("property_category"), input.get("property_type"),
				input.get("property_status"), input.get("age_of_property"), input.get("present_use"),
				input.get("area_region"), input.get("property_value"), input.get("unit_number"),
				input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"), input.get("buildup_area"),
				input.get("furnishing_status"));

	}

	// select 4 owners add 2 owners from prosper 1 guest and skip 1
	// joint Property,property type not add service apartment,Office,Apartment
	@Test(dataProvider ="TownhousepropertyData_2",enabled = false)
	public void addJointProperty_3(HashMap<String, String> input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty=Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.fourOwnerAddThreeSkipOne(input.get("owner_1_percentage"),
				input.get("owner_2_phone_number"), input.get("owner_2_percentage"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"));
		AddProperty.propertyAdd(input.get("property_name"), input.get("property_category"), input.get("property_type"),
				input.get("property_status"), input.get("age_of_property"), input.get("present_use"),
				input.get("area_region"), input.get("property_value"), input.get("unit_number"),
				input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"), input.get("buildup_area"),
				input.get("furnishing_status"));

	}
	
	@Test(dataProvider = "VillapropertyData_1",enabled = false)
	public void addJointProperty_4(HashMap<String, String>input) throws InterruptedException {
		MyProperties Myproperties = new MyProperties(driver);
		AddProperty AddProperty=Myproperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectJointOwnership();
		AddProperty.addOneOwnerAndSkipOne(input.get("owner_1_percentage"));
		AddProperty.propertyAdd(input.get("property_name"), input.get("property_category"), input.get("property_type"),
				input.get("property_status"), input.get("age_of_property"), input.get("present_use"),
				input.get("area_region"), input.get("property_value"), input.get("unit_number"),
				input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"), input.get("buildup_area"),
				input.get("furnishing_status"));
	}
	
	@DataProvider
	public Object[][] VillapropertyData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D://Eclipse_Automation//UserApp//src//test//java//data//PropertyAddDetails.json");
		return new Object[][] { { value.get(5) }};
	}
	
	

	@DataProvider
	public Object[][] TownhousepropertyData_2() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D://Eclipse_Automation//UserApp//src//test//java//data//PropertyAddDetails.json");
		return new Object[][] { { value.get(2) },{value.get(3)} };
	}

}
