package utilites;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class AppiumUtiles {
	
	AppiumDriver driver;
	
	public AppiumUtiles(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void startAppiumServer() {
		
	}
}
