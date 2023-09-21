package tutorial;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalfiles.AndroidGlobalData;
import io.appium.java_client.AppiumBy;

public class PropertyPublish extends AndroidGlobalData {

	@Test(dataProvider = "propertyPublishData")
	public void propertyPublishForSale(HashMap<String, String> input)
			throws MalformedURLException, InterruptedException {
		configuration();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//loginApp();
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]"))
				.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='My Properties']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""
				+ input.get("publishPropertyName") + "\"));"));
		List<WebElement> addedPropertyList = driver.findElements(By.xpath("//android.widget.TextView[@index='0']"));
		for (WebElement addedProperty : addedPropertyList) {
			String addedProperteyName = addedProperty.getText();
			// sSystem.out.println(addedProperteyName);
			if (addedProperteyName.equalsIgnoreCase(input.get("publishPropertyName"))) {
				addedProperty.click();
			}
		}
		driver.findElement(By.xpath("//android.widget.TextView[@text='Publish Now']")).click();
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Emirate (optional)\"));"));
		driver.findElement(AppiumBy.accessibilityId("Emirates Dropdown")).click();
		List<WebElement> emirateList = driver.findElements(By.xpath("//android.widget.TextView[@index='0']"));
		for (WebElement emirate : emirateList) {
			String emirateNames = emirate.getText();
			if (emirateNames.equalsIgnoreCase(input.get("nameOfEmirate"))) {
				emirate.click();
			}
		}
		driver.findElement(AppiumBy.accessibilityId("Tenure Dropdown")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='60 days']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.xpath("//android.widget.TextView[@text='Publish Property']")), "text",
				"Publish Property"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Video Tour Link (optional)\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Send for Approval']")).click();

	}

	@DataProvider
	public Object[][] propertyPublishData() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("publishPropertyName", "test mortgage 1");
		map1.put("nameOfEmirate", "Abu Dhabi");
		return new Object[][] { { map1 } };
	}
}
