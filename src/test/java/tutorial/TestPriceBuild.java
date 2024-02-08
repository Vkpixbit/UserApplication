package tutorial;

import org.testng.annotations.Test;
import java.io.IOException;
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

public class TestPriceBuild extends AndroidGlobalData {

	@Test(dataProvider = "propertyData_1")
	public void getPriceBuildArea(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
		configuration();

		// Upload_Section
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//loginApp();
		approvePermission();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]"))
				.click();
		driver.findElement(AppiumBy.accessibilityId("my_property")).click();
		driver.findElement(AppiumBy.accessibilityId("img_property_add")).click();
		driver.findElement(AppiumBy.accessibilityId("ic_doc_upload_btn")).click();
		approvePermission();
		scrollToElementByText(input.get("titledeedDocument"));

		// Find the updated DocumentsList inside the loop to avoid stale element
		// reference
		List<WebElement> DocumentsList = driver.findElements(AppiumBy.id("android:id/title"));
		for (WebElement DocumentList : DocumentsList) {
			String DocumentName = DocumentList.getText();
			if (DocumentName.equals(input.get("titledeedDocument"))) {
				DocumentList.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//android.widget.TextView[@text='Continue']")).click();

				// Basic_Section
				driver.findElement(By.xpath("//android.widget.EditText[@index='1']"))
						.sendKeys(input.get("property_name"));
				driver.findElement(
						By.xpath("//android.widget.TextView[@text='" + input.get("property_category") + "']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='" + input.get("property_type") + "']"))
						.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement propertyStatus = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//android.widget.TextView[@text='" + input.get("property_status") + "']")));
				propertyStatus.click();
				scrollToNext();
				nextButtonClick();

				// Title_Deed_Section
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Purchase Amount (Required)\"));");
				WebElement propertyValueField = driver.findElement(By.xpath("//android.widget.EditText[@index='11']"));
				boolean isPropertyValuePlaceholderDisplayed = propertyValueField.getText()
						.contains("Enter purchase amount");
				if (isPropertyValuePlaceholderDisplayed) {
					System.out.println("Property Price Not fetched From OCR of " + input.get("titledeedDocument"));
				} else {
					System.out.println("Property Price Fetched From OCR of " + input.get("titledeedDocument"));
				}
				scrollToNext();

				WebElement buildUpArea = driver
						.findElement(By.xpath("//android.widget.TextView[@text='Enter built up area']"));
				boolean isBuildUpAreaPlaceholderDisplayed = buildUpArea.getText().contains("Enter built up area");
				if (isBuildUpAreaPlaceholderDisplayed) {
					System.out.println("Build Up Area is Not Fetched From OCR of " + input.get("titledeedDocument"));
				} else {
					System.out.println("Build Up Area is Fetched From OCR of " + input.get("titledeedDocument"));
				}
				break;
			}
		}
	}

	@DataProvider
	public Object[][] propertyData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D:\\Eclipse_Automation\\UserApp\\src\\test\\java\\data\\PropertyDetails.json");
		return new Object[][] { { value.get(0) }, { value.get(1) },{ value.get(2) },{ value.get(3) },{ value.get(4) },{ value.get(5) },{ value.get(6) },{ value.get(7) },{ value.get(8) },{ value.get(9) },{ value.get(10) } };
	}
}
