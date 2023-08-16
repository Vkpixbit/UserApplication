package globalfiles;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class GlobalData{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configuration() throws MalformedURLException {
		
		 service = new AppiumServiceBuilder()
	                .withAppiumJS(new File("C://Users//vishnudas//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
	                .withIPAddress("127.0.0.1").usingPort(4723).build();
	        //service.start();

	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setDeviceName("PixbitDevice");
	        options.setApp("D://Eclipse_Automation//UserApp//src//test//java//resources//user_app_staging.apk");
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	

	public void clickLongPress(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile:LongClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

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
        String uiAutomatorExpression = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + titledeedDocument + "\"));";
        driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression));
    }

	public void nextButtonClick() {
		By nextButtonLocator = By.xpath("//android.widget.TextView[@text='Next']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
		nextButton.click();
	}

	@AfterClass
	public void close() {
		driver.quit();
		service.close();
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
