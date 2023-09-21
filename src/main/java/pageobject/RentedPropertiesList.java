package pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class RentedPropertiesList extends AndroidActions {
	
	AndroidDriver driver;
	
	public RentedPropertiesList(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	

}
