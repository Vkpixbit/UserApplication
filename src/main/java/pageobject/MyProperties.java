package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class MyProperties extends AndroidActions{
	
	AndroidDriver driver;

	public MyProperties(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "img_property_add")
	private WebElement propertyAdd;
	
	public AddProperty openAddPropertyPage() {
		propertyAdd.click();
		return new AddProperty(driver);
	}
	
	public PropertyDetails selectProperty(String propertyName) {
		scrollToElementByText(propertyName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+propertyName+"']")).click();
		return new PropertyDetails(driver);
	}
}
