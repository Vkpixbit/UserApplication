package rental;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import globalfiles.GlobalData;
import pageobject.AddRental;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

public class RentAddAfterPropertyAdd  extends GlobalData{
	
	@BeforeClass
	public void openMyPropertyPage() {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp("arshad@pixbitsolutions.com", "Qapixbit@14");
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		//ProfilePage.openMyRentalList();
	}

	@Test
	public void addRentalAsOwner(HashMap<String, String>input) throws InterruptedException {
		AddRental AddRental=new AddRental(driver);
		AddRental.roleAsOwner();
		AddRental.selectProperty(input.get("rentProperty"));
		AddRental.uploadEjari(null);
		AddRental.uploadTenancy(null);
		AddRental.clickNext();
		AddRental.enterEjari(null);
		
		
	}
}
