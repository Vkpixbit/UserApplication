package com.pixbit.appium.usercreation;

import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.SplashScreen;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;

public class SignUpUser extends AndroidGlobalData {

	@Test(dataProvider = "userCreationData", groups = "Sign Up", enabled = true)
	public void createUser(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		Thread.sleep(2000);
		LoginPage.userSignUp(input.get("emailId"), input.get("phoneNumber"), input.get("userName"),
				input.get("password"), input.get("prefred_language"));
		Boolean loginStatus = LoginPage.verifySignUp().contains("Thank you for signing up");
		if (loginStatus) {
			LoginPage.skipVerification();
			approvePermission();
			Thread.sleep(3000);
		}
	}

	@DataProvider
	public Object[][] userCreationData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/usercreation/UserDetails.json");
		return new Object[][] {{value.get(0)}};
	}

	@Test(dataProvider = "userCreationWithoutLanguage", groups = "Sign Up", enabled = false, priority = 1)
	public void checkPreferredLanguageValidation(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		Thread.sleep(2000);
		LoginPage.userSignUpWithOutLanguage(input.get("emailId"), input.get("phoneNumber"), input.get("userName"),
				input.get("password"));

	}

	@DataProvider
	public Object[][] userCreationWithoutLanguage() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/usercreation/actions/UserDetails.json");
		return new Object[][] { { value.get(4) } };
	}

}
