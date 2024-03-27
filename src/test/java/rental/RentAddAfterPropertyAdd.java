package rental;

import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
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
	
	
	@BeforeClass
	public void openMyPropertyPage() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("neethu@pixbitsolutions.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openMyProperties();
	}
	
	//Rental Add as Owner in property Add Flow
	//property type villa/townhouse
	@Test(dataProvider = "rentAddingData_1")
	public void rentAddForSinglePropertyAddingFlow(HashMap<String, String>input) throws InterruptedException {
		MyProperties MyProperties=new MyProperties(driver);
		AddProperty AddProperty=MyProperties.openAddPropertyPage();
		AddProperty.titleDeedVerification(input.get("titledeedDocument"), input.get("title_deed_number"),
				input.get("year"));
		AddProperty.selectSingleOwnership();
		AddProperty.continueButton.click();
		AddProperty.propertyAdd_villa_townhouse(input.get("property_name"), input.get("property_category"), input.get("property_type"),
				input.get("property_status"), input.get("age_of_property"), input.get("present_use"),
				input.get("area_region"), input.get("property_value"), input.get("unit_number"),
				input.get("plot_area_sq_mt"), input.get("plot_area_sq_ft"), input.get("buildup_area"),
				input.get("furnishing_status"));
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
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/RentData.json");
		return new Object[][] { {value.get(0)} };
	}

}
