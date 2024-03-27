package rental;

import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.AddRental;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.RentedPropertiesList;
import com.pixbit.appium.pageobject.SplashScreen;

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OwnerRentalAddInList extends AndroidGlobalData{

	@BeforeClass
	public void openPropertyRentList() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("neethu@pixbitsolutions.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.openRentedProperties();
	}
	
	@Test(dataProvider = "ownerRentAddData_1")
	public void AddRentalAsOwner(HashMap<String, String>input) throws InterruptedException {
		RentedPropertiesList RentedPropertiesList=new RentedPropertiesList(driver);
		//Given user open rented properties page then select upload rent and select I'm property owner
		AddRental AddRental=RentedPropertiesList.openRentAsOwner();
		//Then user select property
		AddRental.selectProperty(input.get("rent_property"));
		//Then user upload ejari document
		AddRental.uploadEjariRentalFlow(input.get("ejari_document"));
		//Then upload tenancy document
		AddRental.uploadTenancy(input.get("tenancy_document"));
		//Then user click next button
		AddRental.nextButtonClick();
		//Then user enter ejari contract number
		AddRental.enterEjari(input.get("ejari_number"));
		//Then user add rental details like change the end date
		AddRental.enterRentalDetailsOwner(input.get("end_date"));
	}
	
	@DataProvider
	public Object[][] ownerRentAddData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/RentData.json");
		return new Object[][] { {value.get(2)} };
		}
}
