package utilites;

import java.awt.Dimension;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.pixbit.appium.pageobject.MarketplaceDetailsPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidActions {

	AndroidDriver driver;
	public AndroidActions actions;

	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), driver);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']")
	private WebElement cancelButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes']")
	private WebElement cancelYes;

	@AndroidFindBy(accessibility = "Add")
	private WebElement addOwner;

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
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_all_button")).click();
	}

	public void alwaysGivePermission() {
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
				.click();
	}

	public void scrollToNext() {
		String uiAutomatorExpression = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Next\"));";
		driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression));
	}

	public void nextButtonClick() {
		By nextButtonLocator = By.xpath("//android.widget.TextView[@text='Next']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
		nextButton.click();
	}

	public void scrollToElementByText(String text) {
		String uiAutomatorExpression = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""
				+ text + "\"));";
		driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression));
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, String value,
			int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(locator.toString(), value))));
	}

	public void click_done() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
	}

	public void cancelActivity() {
		cancelButton.click();
		cancelYes.click();
	}

	public void horizontalScroll() {
		driver.findElement(By.className("android.widget.ImageView")).click();
	}

	public boolean scrollManually(WebElement element) {
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "direction", "down", "speed", 500));
		return canScrollMore;
	}

	public MarketplaceDetailsPage openPropertyFromMarketplace(String propertyName) {
	    try {
	        // Locate the element
	        WebElement propertyElement = driver.findElement(By.xpath("//android.widget.TextView[@text='" + propertyName + "']"));
	        
	        // Check if the element is displayed, if not, scroll to it
	        if (propertyElement.isDisplayed()) {
	            propertyElement.click();
	        } else {
	            System.out.println("Scroll to the property!");
	            scrollToElementByText(propertyName);
	            propertyElement.click();
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Property not found: " + propertyName);
	        // Handle exception as needed (e.g., throw an exception, return a different page object, etc.)
	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	        // Handle other exceptions
	    }
	    
	    return new MarketplaceDetailsPage(driver);
	}


}
