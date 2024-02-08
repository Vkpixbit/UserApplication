package useractions;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import globalfiles.AndroidGlobalData;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.SplashScreen;

public class SignUpUser extends AndroidGlobalData{
	
	@BeforeClass
	public void openSignUpSection() throws InterruptedException {
		SplashScreen SplashScreen=new SplashScreen(driver);
		SplashScreen.clickSkipButton();
		Thread.sleep(2000);
	}

	@Test(dataProvider = "userCreationData")
	public void createUser(HashMap<String, String>input) throws InterruptedException {
		LoginPage LoginPage= new LoginPage(driver);
		LoginPage.userSignUp(input.get("emailId"),input.get("phoneNumber"),input.get("userName"),input.get("password"));
		HomePage HomePage=LoginPage.skipVerification();
		approvePermission();
		Thread.sleep(3000);
	}
	
	
	@DataProvider
	public Object[][] userCreationData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/UserDetails.json");
		return new Object[][] {{ value.get(2) },{ value.get(3) }};
	}
	
}
