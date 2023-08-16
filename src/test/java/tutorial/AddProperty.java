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
import globalfiles.GlobalData;
import io.appium.java_client.AppiumBy;

public class AddProperty extends GlobalData {

	@Test(dataProvider = "propertyAddData")
	public void Add_Property(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

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
		List<WebElement> DocumentsList = driver.findElements(AppiumBy.id("android:id/title"));
		for (int i = 0; i < DocumentsList.size(); i++) {
			WebElement DocumentList = DocumentsList.get(i);
			String DocumentName = DocumentList.getText();
			if (DocumentName.equals(input.get("titledeedDocument"))) {
				Thread.sleep(2000);
				DocumentList.click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Continue']")).click();

				// Basic_Section
				driver.findElement(By.xpath("//android.widget.EditText[@index='1']"))
						.sendKeys(input.get("property_name"));
				driver.findElement(
						By.xpath("//android.widget.TextView[@text='" + input.get("property_category") + "']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='" + input.get("property_type") + "']"))
						.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement propertyStatus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='" + input.get("property_status") + "']")));
				propertyStatus.click();
				if (propertyStatus.isSelected() && input.get("property_status").equals("Under construction")) {
					driver.findElement(By.xpath("//android.widget.EditText[@index='15']"))
							.sendKeys(input.get("title_deed_number"));
					driver.findElement(AppiumBy.accessibilityId("Calender")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Year Picker']")));
					driver.findElement(AppiumBy.androidUIAutomator(
							"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + input.get("year") + "\"));"));
					driver.findElement(By.xpath("//android.widget.TextView[@text='" + input.get("year") + "']"))
							.click();
					nextButtonClick();
				} else {
					driver.findElement(
							By.xpath("//android.widget.TextView[@text='" + input.get("age_of_property") + "']"))
							.click();
					driver.findElement(By.xpath("//android.widget.TextView[@text='" + input.get("present_use") + "']"))
							.click();
					Thread.sleep(2000);
					driver.findElement(AppiumBy
							.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));"));
					driver.findElement(By.xpath("//android.widget.EditText[@index='15']"))
							.sendKeys(input.get("title_deed_number"));
					driver.findElement(AppiumBy.accessibilityId("Calender")).click();
					driver.findElement(AppiumBy.androidUIAutomator(
							"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""
									+ input.get("year") + "\"));"));
					driver.findElement(By.xpath("//android.widget.TextView[@text='" + input.get("year") + "']"))
							.click();
					nextButtonClick();
				}

				// Title_Deed_Section
				WebElement area_region_click = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Select One']")));
				area_region_click.click();
				//Thread.sleep(2000);
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + input.get("area_region") + "\"));"));
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+input.get("area_region")+"']")).click();
				driver.findElement(By.xpath("//android.widget.EditText[@index='11']"))
						.sendKeys(input.get("property_value"));
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Built up Area (optional)\"));"));
				
				driver.findElement(By.xpath("//android.widget.EditText[@index='10']"))
						.sendKeys(input.get("build_Up_area"));
				nextButtonClick();

				// Details_Portion
				driver.findElement(AppiumBy.accessibilityId("My Location")).click();
				Thread.sleep(2000);
				alwaysGivePermission();
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.attributeContains(
						driver.findElement(By.xpath("//android.widget.TextView[@text='Select Location']")), "text",
						"Select Location"));

				driver.findElement(By.xpath("//android.widget.TextView[@text='Select Location']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+input.get("furnishing_Status")+"']")).click();
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save Property\"));"));
				driver.findElement(By.xpath("//android.widget.TextView[@text='Save Property']")).click();

				driver.findElement(By.xpath("//android.widget.TextView[@text='Skip Now, I will add it later']"))
						.click();

				close();
			}
		}
	}

	@DataProvider
	public Object[][] propertyAddData() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("titledeedDocument", "ilyas pre title deed.pdf");
		map1.put("property_name", "Square Yards");
		map1.put("property_category", "Commercial");
		map1.put("property_type", "Townhouse");
		map1.put("property_status", "Ready");
		map1.put("age_of_property", "2");
		map1.put("present_use", "Rented");
		map1.put("title_deed_number", "6584087150");
		map1.put("year", "1978");
		map1.put("area_region","JOZ TOWER 1");
		map1.put("property_value", "645000");
		map1.put("build_Up_area", "585.5");
		map1.put("furnishing_Status","Fully Furnished");

		/*
		 * HashMap<String, String> map2=new HashMap<String,String>();
		 * map2.put("property_name","GRE Assets");
		 * map2.put("title_deed_number","9465276"); map2.put("year","1978");
		 * map2.put("property_value","76450"); map2.put("build_Up_area","9775.5");
		 */

		return new Object[][] { { map1 } };
	}

}
