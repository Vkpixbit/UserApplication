package com.pixbit.appium.property;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.AddOwnerShipDetails;
import com.pixbit.appium.pageobject.AddProperty;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.SplashScreen;

public class SinglePropertyAdd extends AndroidGlobalData {

	/*
	 * We are uploading title deed document for property adding
	 * Property status as Ready & Present use Vacant
	 * Not mortgaged case
	 */
	@Test(dataProvider = "singlePropertyData1", groups = "Single Property", enabled = true)
	public void singlePropertyProcess(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		if(Boolean.parseBoolean(input.get("isFirstProperty"))) {
			System.out.println("It Is The First Property Of This User Added!");
			AddOwnerShipDetails AddOwnerShipDetails = ProfilePage.openPropertyAddPage();
			AddOwnerShipDetails.deedSelection(input.get("isTitleDeed"),input.get("titledeedDocument"));
			if(input.get("isTitleDeed")=="true") {
				System.out.println("The Property Is Added Using Title Deed and Name is "
						+ "'"+input.get("titledeedDocument")+"'");
			}
			else {
				System.out.println("The Property Is Added Using Pre Title Deed/Inital Contract  Name is \"\n"
						+ "						'"+input.get("titledeedDocument")+"'");
			}
			AddOwnerShipDetails.selectSingleOwnership();
			System.out.println("The Property Is Added as Single Property");
		}else {
			MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
			AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
			AddOwnerShipDetails.deedSelection(input.get("isTitleDeed"),input.get("titledeedDocument"));
			if(input.get("isTitleDeed")=="true") {
				System.out.println("The Property Is Added Using Title Deed and Name is "
						+ "'"+input.get("titledeedDocument")+"'");
			}
			else {
				System.out.println("The Property Is Added Using Pre Title Deed/Inital Contract  Name is"
						+ "						'"+input.get("titledeedDocument")+"'");
			}
			AddOwnerShipDetails.selectSingleOwnership();
		}
		AddProperty AddProperty = new AddProperty(driver);
		AddProperty.selectPropertyStatus(input.get("propertyStatus"),input.get("presentUse"));
		if(input.get("propertyStatus")=="Ready" || input.get("propertyStatus")=="Shell & Core"){
			System.out.println("The Property Status Is '"+input.get("propertyStatus")+"' And Present Use Is"
					+ "'"+input.get("presentUse")+"'");
		}if (input.get("propertyStatus")=="Under construction") {
			System.out.println("The Property Status Is '"+input.get("propertyStatus")+"' ");
		}
		AddProperty.scrollToNext();
		if(input.get("propertyStatus").equals("Under construction") && Boolean.parseBoolean(input.get("isPaymentPlan"))) {
			AddProperty.addPaymentPlan(input.get("scheduleCount"), input.get("bookingDateString"),input.get("completionDateString"),
					input.get("scheduleParticulars"),input.get("periodList"),input.get("monthList"),input.get("shareList"));
		}
		if(Boolean.parseBoolean(input.get("isMortgaged"))) {
			AddProperty.selectMortgagedTenureYear(input.get("mortgageAmount"),input.get("tenureYear"),
					input.get("mortgageStartDate"),input.get("financeRate"));
		}
		AddProperty.nextButtonClick();
		AddProperty.selectBedroomCabinCount(input.get("bedroomCabinCount"));
		System.out.println("User Select Bedroom count As "+ "'"+input.get("bedroomCabinCount")+"'");
		AddProperty.selectBathroomCount(input.get("bathroomCount"), input.get("bedroomCabinCount"));
		System.out.println("User Select Bathroom count As "+ "'"+input.get("bathroomCount")+"'");
		AddProperty.selectKitchenPantryCount(input.get("kitchenPantryCount"));
		AddProperty.selectBalconyCount(input.get("balconyCount"), input.get("kitchenPantryCount"));
		System.out.println("User Select Balcony count As "+ "'"+input.get("balconyCount")+"'");
		AddProperty.selectMapLocation();
		AddProperty.selectFurnishingStatus(input.get("furnishingStatus"));
		System.out.println("User Select Furnishing Status"+"'"+input.get("furnishingStatus")+"'");
		AddProperty.propertySaveAction(input.get("propertyStatus"),input.get("presentUse"));;
	}

	@DataProvider
	public Object[][] singlePropertyData1() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/property/SinglePropertyCreationData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * We are uploading titl deed document for property adding
	 * propperty status as Under construction and adding payment plans
	 * Upload mortgaged and enter details
	 */
	@Test(dataProvider = "underConstructionPaymentPlanMortgagedPropertyData", groups = "Single Property", enabled = false)
	public void underConstructionPaymentPlanMortgagedProperty(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.deedSelection(input.get("isTitleDeed"),input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.selectUnderConstructionStatus();
		AddProperty.scrollToNext();
		AddProperty.addPaymentPlan(input.get("scheduleCount"), input.get("scheduleParticulars"),
				input.get("schedulePeriod"));
		//AddProperty.selectMortgagedTenureYear(input.get("mortgageAmount"), input.get("tenureYear"),
				//input.get("mortgageStartDate"), input.get("financeRate"));
		AddProperty.scrollToNext();
		AddProperty.nextButtonClick();
		AddProperty.selectBedroomCabinCount(input.get("bedroomCabinCount"));
		AddProperty.selectBathroomCount(input.get("bathroomCount"), input.get("bedroomCabinCount"));
		AddProperty.selectKitchenPantryCount(input.get("kitchenPantryCount"));
		AddProperty.selectBalconyCount(input.get("balconyCount"), input.get("kitchenPantryCount"));
		AddProperty.selectMapLocation();
		AddProperty.selectFurnishingStatus(input.get("furnishingStatus"));
		AddProperty.propertySaveAction(input.get("propertyStatus"),input.get("presentUse"));
	}

	@DataProvider
	public Object[][] underConstructionPaymentPlanMortgagedPropertyData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/property/SinglePropertyCreationData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * Uploading inital contract for property adding
	 * property statsus as Under construction and Upload payment plan
	 * Not mortgaged case
	 */
	@Test(dataProvider = "underConstructionPaymentPlanNotMortgagedData",groups = "Single Property", enabled = false)
	public void underConstructionPaymentPlanNotMortgaged(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.selectUnderConstructionStatus();
		AddProperty.scrollToNext();
		AddProperty.addPaymentPlan(input.get("scheduleCount"), input.get("scheduleParticulars"),
				input.get("schedulePeriod"));
		AddProperty.scrollToNext();
		AddProperty.nextButtonClick();
		AddProperty.selectBedroomCabinCount(input.get("bedroomCabinCount"));
		AddProperty.selectBathroomCount(input.get("bathroomCount"), input.get("bedroomCabinCount"));
		AddProperty.selectKitchenPantryCount(input.get("kitchenPantryCount"));
		AddProperty.selectBalconyCount(input.get("balconyCount"), input.get("kitchenPantryCount"));
		AddProperty.selectMapLocation();
		AddProperty.selectFurnishingStatus(input.get("furnishingStatus"));
		AddProperty.clickSave();
		AddProperty.goToProperties();

	}

	@DataProvider
	public Object[][] underConstructionPaymentPlanNotMortgagedData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/property/SinglePropertyCreationData.json");
		return new Object[][] { { value.get(2) } };
	}

	/*
	 * Uploading title deed for property add
	 * select property status as Shell & Core 
	 * Select mortgaged and skip
	 */
	@Test(dataProvider = "shellAndCoreNotMortgagedData",enabled = true)
	public void shellAndCoreNotMortgaged(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.selectShellAndCoreStatus(input.get("presentUse"));
		AddProperty.scrollToNext();
		//AddProperty.selectMortgagedSkip();
		AddProperty.nextButtonClick();
		AddProperty.selectBedroomCabinCount(input.get("bedroomCabinCount"));
		AddProperty.selectBathroomCount(input.get("bathroomCount"), input.get("bedroomCabinCount"));
		AddProperty.selectKitchenPantryCount(input.get("kitchenPantryCount"));
		AddProperty.selectBalconyCount(input.get("balconyCount"), input.get("kitchenPantryCount"));
		AddProperty.selectMapLocation();
		AddProperty.selectFurnishingStatus(input.get("furnishingStatus"));
		AddProperty.clickSave();
		AddProperty.skipRent();
	}

	@DataProvider
	public Object[][] shellAndCoreNotMortgagedData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/property/SinglePropertyCreationData.json");
		return new Object[][] { { value.get(3) } };
	}

	/*
	 * Inital contract document
	 * property status as ready & preent use as Rented
	 * Enter mortgage details
	 */
	@Test(dataProvider = "readyRentedMortgagedData",groups = "Single Property", enabled = true)
	public void readyRentedMortgaged(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.deedSelection(input.get("isTitleDeed"),input.get("titledeedDocument"));
		AddProperty AddProperty = AddOwnerShipDetails.selectSingleOwnership();
		AddProperty.selectPropertyStatus(input.get("propertyStatus"),input.get("presentUse"));
		AddProperty.scrollToNext();
		AddProperty.selectMortgagedTenureYearMonthOfferLetter(input.get("mortgageAmount"),
				input.get("tenureYear"), input.get("tenure_month"), input.get("mortgageStartDate"),
				input.get("financeRate"));
		AddProperty.scrollToNext();
		AddProperty.nextButtonClick();
		AddProperty.selectBedroomCabinCount(input.get("bedroomCabinCount"));
		AddProperty.selectBathroomCount(input.get("bathroomCount"), input.get("bedroomCabinCount"));
		AddProperty.selectKitchenPantryCount(input.get("kitchenPantryCount"));
		AddProperty.selectBalconyCount(input.get("balconyCount"), input.get("kitchenPantryCount"));
		AddProperty.selectMapLocation();
		AddProperty.selectFurnishingStatus(input.get("furnishingStatus"));
		AddProperty.clickSave();
		AddProperty.goToProperties();
	}

	@DataProvider
	public Object[][] readyRentedMortgagedData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/property/SinglePropertyCreationData.json");
		return new Object[][] { { value.get(4) } };
	}

}
