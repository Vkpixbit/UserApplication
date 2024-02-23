package useractions;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import globalfiles.AndroidGlobalData;
import pageobject.LoginPage;
import pageobject.SplashScreen;

public class SignUpUser extends AndroidGlobalData{
	

	@Test(dataProvider = "userCreationData")
	public void createUser(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen=new SplashScreen(driver);
		LoginPage LoginPage=SplashScreen.clickSkipButton();
		Thread.sleep(2000);
		LoginPage.userSignUp(input.get("emailId"),input.get("phoneNumber"),input.get("userName"),input.get("password"));
		LoginPage.skipVerification();
		approvePermission();
		Thread.sleep(3000);
	}
	
	
	@DataProvider
	public Object[][] userCreationData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"/Users/vk14/git/UserApplication/src/test/java/data/UserDetails.json");
		return new Object[][] {{ value.get(0) }};
	}
	
}
