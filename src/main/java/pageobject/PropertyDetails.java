package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PropertyDetails {
	
	AndroidDriver driver;

	public PropertyDetails(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Publish Now']")
	private WebElement publishNow;
	
	public PublishProperty clickPublish() {
		publishNow.click();
		return new PublishProperty(driver);
	}

}
