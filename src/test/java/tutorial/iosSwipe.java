package tutorial;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Maps;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class iosSwipe {

	public IOSDriver driver;
	public AppiumDriverLocalService service;

	
	//This we fully pass the files of that application
	@Test
	public void configuration() throws MalformedURLException {
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
		AppiumServiceBuilder builder = new AppiumServiceBuilder();

		builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingDriverExecutable(new File("/usr/local/bin/node")).usingPort(4723).withEnvironment(environment)
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE).withLogFile(new File("AppiumLog.txt"));

		service = AppiumDriverLocalService.buildService(builder);

		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName("iPhone 15");
		//options.setApp("/Users/vk14/git/UserApplication/src/test/java/resources/user_app_staging.ipa");
		options.setPlatformName("17.0");
		options.setWdaLaunchTimeout(Duration.ofSeconds(30));
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		Map<String, String> params=new HashMap<String,String>();
		params.put("bundleId","in.pixbit.propech.rm");
		driver.executeScript("mobile:launchApp", params);  
	}
	

}
