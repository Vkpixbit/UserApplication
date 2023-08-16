package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilites.AndroidActions;

public class SplashScreen extends AndroidActions {
	
	AndroidDriver driver;

	public SplashScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
	private WebElement skipButton;
	
	
	public LoginPage clickSkipButton() {
		skipButton.click();
		return new LoginPage(driver);
	}
}
