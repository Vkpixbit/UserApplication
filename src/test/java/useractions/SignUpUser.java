package useractions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import globalfiles.AndroidGlobalData;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import pageobject.SplashScreen;

public class SignUpUser extends AndroidGlobalData{

	@Test(dataProvider = "userCreationData")
	public void createUser(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen=new SplashScreen(driver);
		LoginPage LoginPage=SplashScreen.clickSkipButton();
		Thread.sleep(2000);
		LoginPage.userSignUp(input.get("emailId"),input.get("phoneNumber"),input.get("userName"),input.get("password"));
		HomePage HomePage=LoginPage.skipVerification();
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		ProfilePage.getRmName();
	}
	
	
	@DataProvider
	public Object[][] userCreationData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D://Eclipse_Automation//UserApp//src//test//java//data//UserDetails.json");
		return new Object[][] { { value.get(6) }};
	}
	
}
