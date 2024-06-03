package com.pixbit.appium.test.usercreation.actions;

import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.SplashScreen;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

public class SignUpUser extends AndroidGlobalData{
	

	@Test(dataProvider = "userCreationData",enabled = true,groups = "sign_up")
	public void createUser(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen=new SplashScreen(driver);
		LoginPage LoginPage=SplashScreen.clickSkipButton();
		Thread.sleep(2000);
		LoginPage.userSignUp(input.get("emailId"),input.get("phoneNumber"),input.get("userName"),input.get("password"),input.get("prefred_language"));
		LoginPage.skipVerification();
		approvePermission();
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] userCreationData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/com/pixbit/appium/test/usercreation/actions/UserDetails.json");
		return new Object[][] {{ value.get(0) }};
	}
	
	
	
	@Test(dataProvider = "user_creation_without_language",enabled = false )
	public void check_preferred_language_validation(HashMap<String, String>input) throws InterruptedException {
		SplashScreen SplashScreen=new SplashScreen(driver);
		LoginPage LoginPage=SplashScreen.clickSkipButton();
		Thread.sleep(2000);
		LoginPage.userSignUpWithOutLanguage(input.get("emailId"),input.get("phoneNumber"),input.get("userName"),input.get("password"));
		LoginPage.skipVerification();
	}
	
	@DataProvider
	public Object[][] user_creation_without_language() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/com/pixbit/appium/test/usercreation/actions/UserDetails.json");
		return new Object[][] {{ value.get(1) }};
	}
	
	
}
