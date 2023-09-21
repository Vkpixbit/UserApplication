package propertyaddedit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globalfiles.AndroidGlobalData;
import pageobject.AddProperty;

import pageobject.MyProperties;

public class VerifyBuildUpAreaPropertyPrice extends AndroidGlobalData {

	@BeforeMethod()
	public void openAddPropertyPage() {
		MyProperties Myproperties = new MyProperties(driver);
		Myproperties.openAddPropertyPage();
	}

	@Test(dataProvider = "propertyData_1", enabled = false)
	public void villaPropertyAdd(HashMap<String, String> input) throws InterruptedException, MalformedURLException {
		//AddProperty AddProperty = new AddProperty(driver);
		//AddProperty.checkBuildUpAreaPropertyPrice(input.get("titledeedDocument"), input.get("property_name"),
				//input.get("property_category"), input.get("property_type"), input.get("property_status"));
	}

	@Test(dataProvider = "propertyData_2", enabled = false)
	public void townhousePropertyAdd(HashMap<String, String> input) throws InterruptedException {
		//AddProperty AddProperty = new AddProperty(driver);
		//AddProperty.checkBuildUpAreaPropertyPrice(input.get("titledeedDocument"), input.get("property_name"),
				//input.get("property_category"), input.get("property_type"), input.get("property_status"));
	}

	

	@DataProvider
	public Object[][] propertyData_1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D:\\Eclipse_Automation\\UserApp\\src\\test\\java\\data\\PropertyDetails.json");
		return new Object[][] { { value.get(0) } };
	}

	@DataProvider
	public Object[][] propertyData_2() throws IOException {
		List<HashMap<String, String>> value = getjsondata(
				"D:\\Eclipse_Automation\\UserApp\\src\\test\\java\\data\\PropertyDetails.json");
		return new Object[][] { { value.get(1) } };
	}

	
}
