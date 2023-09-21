package rental;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import globalfiles.AndroidGlobalData;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

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
	
	@Test
	public void AddRentalAsOwner() {
		
	}
	
}
