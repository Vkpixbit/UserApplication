package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyProperties {
	
	AndroidDriver driver;

	public MyProperties(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "my_property")
	private WebElement propertyAdd;
	
	public AddProperty openAddPropertyPage() {
		propertyAdd.click();
		return new AddProperty(driver);
			
	}
}
