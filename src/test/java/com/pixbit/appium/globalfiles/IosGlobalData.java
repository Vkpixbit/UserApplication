package com.pixbit.appium.globalfiles;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class IosGlobalData {

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
		//options.setApp("/Users/vk14/Downloads/Apps/User_App/user_app_staging.app");
		options.setPlatformName("17.0");
		options.setWdaLaunchTimeout(Duration.ofSeconds(30));
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		Map<String, String> parms=new HashMap<String, String>();
		parms.put("bundleId","in.pixbit.propech.rm");
		driver.executeScript("mobile:launchApp",parms);
		
	}
	


	/*@AfterClass
	public void close() {
		driver.quit();
		service.close();
	}*/

	

	public void scrollToEnd() {
		boolean scrollMore;
		do {
			scrollMore = (boolean) ((JavascriptExecutor) driver).executeScript("mobile:scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (scrollMore);
	}

	public void waitForAttributeContains(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(element, "text", "value"));
	}

	public void approvePermission() {
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
	}

	public void alwaysGivePermission() {
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
				.click();
	}

	public void scrollToNext() {
		String uiAutomatorExpression = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));";
		driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression));
	}

	public void scrollToElementByText(String titledeedDocument) {
		String uiAutomatorExpression = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""
				+ titledeedDocument + "\"));";
		driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression));
	}

	public void nextButtonClick() {
		By nextButtonLocator = By.xpath("//android.widget.TextView[@text='Next']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
		nextButton.click();
	}

	public List<HashMap<String, String>> getjsondata(String filepath) throws IOException {
		String jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String, String>> data = map.readValue(jsoncontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}
