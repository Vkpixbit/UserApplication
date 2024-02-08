package tutorial;

import org.testng.annotations.Test;
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

public class Addrental extends AndroidGlobalData {

	@Test(dataProvider = "PropertyOwnerRentalData")
	public void addRentalForSpecificProperty(HashMap<String, String> input)
			throws MalformedURLException, InterruptedException {
		configuration();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//loginApp();
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]"))
				.click();
		driver.findElement(AppiumBy.accessibilityId("rented_property")).click();
		driver.findElement(AppiumBy.accessibilityId("Rent Property")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='I’m Property Owner']")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + input.get("rentPropertyName") + "\"));"));
		List<WebElement> propertyElements = driver.findElements(By.xpath("//android.widget.TextView[@index='0']"));

		for (WebElement propertyElement : propertyElements) {
			String propertyName = propertyElement.getText();
			if (propertyName.equalsIgnoreCase(input.get("rentPropertyName"))) {
				propertyElement.click();

				driver.findElement(By.xpath("//android.widget.TextView[@text='Choose Ejari Contract File']")).click();
				driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
				List<WebElement> ejariDocumentsList = driver.findElements(AppiumBy.id("android:id/title"));
				for (int i = 0; i < ejariDocumentsList.size(); i++) {
					WebElement DocumentList = ejariDocumentsList.get(i);
					String DocumentName = DocumentList.getText();
					if (DocumentName.equals(input.get("ejariDocumentName"))) {
						Thread.sleep(2000);
						DocumentList.click();

					}
				}
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.attributeContains(
						driver.findElement(By.xpath("//android.widget.TextView[@text='Add Rental Details']")), "text",
						"Add Rental Details"));

				driver.findElement(By.xpath("//android.widget.TextView[@text='Choose Tenancy Contract File']")).click();
				List<WebElement> tenancyDocumentsList = driver.findElements(AppiumBy.id("android:id/title"));
				for (int i = 0; i < tenancyDocumentsList.size(); i++) {
					WebElement DocumentList = tenancyDocumentsList.get(i);
					String DocumentName = DocumentList.getText();
					if (DocumentName.equals(input.get("tenancyDocumentName"))) {
						Thread.sleep(2000);
						DocumentList.click();
					}
				}
				driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
				driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).clear();
				driver.findElement(By.xpath("//android.widget.EditText[@index='3']"))
						.sendKeys(input.get("ejariNumber"));
				// driver.pressKey(new KeyEvent(AndroidKey.BACK));
				driver.findElement(By.xpath("//android.widget.TextView[@text='Verify']")).click();
				// Thread.sleep(20000);
				// driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();

				wait.until(ExpectedConditions.attributeContains(
						driver.findElement(By.xpath("//android.widget.TextView[@text='Ejari Contract Number']")),
						"text", "Ejari Contract Number"));

				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"End Date (Required)\"));"));
				driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Calender\"])[2]")).click();

				wait.until(ExpectedConditions.attributeContains(
						driver.findElement(AppiumBy.id("in.pixbit.proptech:id/mtrl_picker_title_text")), "text",
						"Select Date"));
				driver.findElement(AppiumBy.id("in.pixbit.proptech:id/month_navigation_fragment_toggle")).click();

				By yearLocator = By.xpath("//android.widget.TextView[@text='" + input.get("endYear") + "']");
				driver.findElement(yearLocator).click();

				for (int i = 0; i < 12; i++) {

					WebElement showingMonthElement = driver.findElement(
							AppiumBy.accessibilityId("in.pixbit.proptech:id/month_navigation_fragment_toggle"));
					String getMonthName = showingMonthElement.getText();
					String[] words = getMonthName.split(" ");
					String monthText = words[0];
					driver.findElement(AppiumBy.accessibilityId("Change to next month")).click();
					if (monthText.equals("endMonth")) {
						driver.findElement(By.xpath("//android.widget.TextView[@text='" + input.get("endDate") + "'"))
								.click();
						driver.findElement(AppiumBy.accessibilityId("in.pixbit.proptech:id/confirm_button")).click();
					}
				}

				wait.until(ExpectedConditions.attributeContains(
						driver.findElement(By.xpath("//android.widget.TextView[@text='Add Rental Details']")), "text",
						"Add Rental Details"));

				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Number of Cheques (optional)\"));"));
				driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();

				wait.until(ExpectedConditions.attributeContains(
						driver.findElement(By.xpath("//android.widget.TextView[@text='Continue without cheque']")),
						"text", "Continue without cheque"));

				driver.findElement(By.xpath("//android.widget.TextView[@text='Save without cheque']")).click();
			}
		}
	}

	@DataProvider
	public Object[][] PropertyOwnerRentalData() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("rentPropertyName", "Credo invest");
		map1.put("ejariDocumentName", "Ejari 22 23 (1) (1).pdf");
		map1.put("tenancyDocumentName", "Tenancy contract (1).pdf");
		map1.put("ejariNumber", "6504059v344");
		map1.put("endYear", "2023");
		map1.put("endMonth", "November");
		map1.put("endDate", "21");
		return new Object[][] { { map1 } };
	}
}
