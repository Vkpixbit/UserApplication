package com.pixbit.appium.property;

import org.testng.annotations.Test;

import com.pixbit.appium.globalfiles.AndroidGlobalData;
import com.pixbit.appium.pageobject.AddOwnerShipDetails;
import com.pixbit.appium.pageobject.AddProperty;
import com.pixbit.appium.pageobject.HomePage;
import com.pixbit.appium.pageobject.LoginPage;
import com.pixbit.appium.pageobject.MyProperties;
import com.pixbit.appium.pageobject.ProfilePage;
import com.pixbit.appium.pageobject.SplashScreen;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;

public class JointPropertyAdd extends AndroidGlobalData {

	/*
	 * Two owner and skip all add property
	 * Ready property status and Rented
	 * Not mortgaged
	 */
	@Test(dataProvider = "twoOwnersReadyRentedNotMortgagedData",groups = "joint Property", enabled = true)
	public void twoOwnersSkipReadyRentedNotMortgaged(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnersSkipAll();
		AddProperty.selectReadyStatus(input.get("presentUse"));
		AddProperty.scrollToNext();
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
	public Object[][] twoOwnersReadyRentedNotMortgagedData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/property/JointPropertyCreationData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two or more  owners add first owner and skip others
	 * Underconstruction with payment plan
	 * Enter mortgage details
	 */
	@Test(dataProvider = "oneOwnerAddOtherSkipUnderConstructionPaymentPlanMortgagedData",groups = "joint_property", enabled = true)
	public void oneOwnerAddOtherSkipUnderConstructionPaymentPlanMortgaged(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.addOwnerAndSkipOne(input.get("ownerName1"),input.get("ownerPercentage1"));
		AddProperty.selectUnderConstructionStatus();
		AddProperty.scrollToNext();
		AddProperty.addPaymentPlan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
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
	public Object[][] oneOwnerAddOtherSkipUnderConstructionPaymentPlanMortgagedData() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/property/JointPropertyCreationData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
		Three Owners add three
		Shell & Core property
		Morgaged and skip
	 */
	@Test(dataProvider = "two_owners_joint_apartment_property_ready_data",groups = "joint_property", enabled = true)
	public void two_owners_apartment_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnersSelectAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"));
		AddProperty.selectShellAndCoreStatus(input.get("presentUse"));
		scrollToNext();
		AddProperty.selectMortgagedSkip();
		scrollToNext();
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
	public Object[][] two_owners_joint_apartment_property_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyApartmentData.json");
		return new Object[][] { { value.get(0) } };
	}
	
	
	/*
	 * Three owners are in the prosper Property type is townhouse property
	 * underconstruction Add payment plan
	 */
	@Test(dataProvider = "three_owners_townhouseunderconstruction_data",groups = "joint_property", enabled = false)
	public void three_owners_townhouse_underconstruction_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnersSelectAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"));
		AddProperty.selectUnderConstructionStatus();
		scrollToNext();
		AddProperty.addPaymentPlan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		scrollToNext();
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
	public Object[][] three_owners_townhouseunderconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")+
				"/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyTownhouseData.json");
		return new Object[][] { { value.get(0) } };
	}

	/*
	 * Two owners property one prosper and one guest
	 * villa property
	 * Ready and enter mortgage details
	 */
	@Test(dataProvider = "twoowners_oneguest_office_underconstruction_data",groups = "joint_property", enabled = false)
	public void two_owners_one_guest_office_ready_property(HashMap<String, String> input) throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.twoOwnerCountSelectionAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"));
		AddProperty.selectShellAndCoreStatus(input.get("presentUse"));
		AddProperty.scrollToNext();
		AddProperty.selectMortgagedTenureYearMonthOfferLetter(input.get("mortgage_amount"),
				input.get("tenure_year"), input.get("tenure_month"), input.get("mortgage_start_date"),
				input.get("finance_rate"));
		scrollToNext();
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
	public Object[][] twoowners_oneguest_office_underconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyOfficeData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * Select Three owners add Three owners from prosper townhouse property with
	 * underconstruction property status
	 * add payment plan and mortgage details
	 */
	@Test(dataProvider = "threeowners_threeadd_townhouse_undercontruction_data",groups = "joint_property", enabled = true)
	public void threee_owners_townhouse_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnersSelectAndAdd(input.get("owner_1_percentage"),
				input.get("country_code"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("owner_3_phone_number"),
				input.get("owner_3_email"), input.get("owner_3_name"), input.get("owner_3_percentage"));
		AddProperty.selectUnderConstructionStatus();
		AddProperty.addPaymentPlan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
		scrollToNext();
		AddProperty.selectMortgagedTenureYearMonthOfferLetter(input.get("mortgage_amount"),
				input.get("tenure_year"), input.get("tenure_month"), input.get("mortgage_start_date"),
				input.get("finance_rate"));
		scrollToNext();
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
	public Object[][] threeowners_threeadd_townhouse_undercontruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getenv("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyTownhouseData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * Three owner add two owner owner and skip anothe one
	 * Apartment property
	 * ready status
	 */
	@Test(dataProvider = "threeowners_twoadd_skipone_apartment_ready_data",groups = "joint_property", enabled = false)
	public void three_owners_addtwo_skipone_apartment_ready_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.titleDeedVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.threeOwnerCountSelectionAndSkipOne(
				input.get("owner_1_percentage"), input.get("country_code"), input.get("owner_2_phone_number"),
				input.get("owner_2_email"), input.get("owner_2_name"), input.get("owner_2_percentage"));
		AddProperty.selectShellAndCoreStatus(input.get("presentUse"));
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
	public Object[][] threeowners_twoadd_skipone_apartment_ready_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyApartmentData.json");
		return new Object[][] { { value.get(1) } };
	}

	/*
	 * four owners and add all villa property 
	 * underconstruction and payment plan
	 */
	@Test(dataProvider = "fourowners_fouradd_villa_undeconstruction_data",enabled = true)
	public void fourowner_add_villa_underconstruction_property(HashMap<String, String> input)
			throws InterruptedException {
		SplashScreen SplashScreen = new SplashScreen(driver);
		LoginPage LoginPage = SplashScreen.clickSkipButton();
		HomePage HomePage = LoginPage.loginToApp(input.get("email"), input.get("password"));
		approvePermission();
		ProfilePage ProfilePage = HomePage.openProfile();
		MyProperties MyProperties = ProfilePage.openMyPropertiesPage();
		AddOwnerShipDetails AddOwnerShipDetails = MyProperties.openPropertyAdd();
		AddOwnerShipDetails.initialContractVerification(input.get("titledeedDocument"));
		AddOwnerShipDetails.selectJointOwnership();
		AddProperty AddProperty = AddOwnerShipDetails.fourOwnerAddFour(input.get("owner_1_percentage"),
				input.get("country_code_2"), input.get("owner_2_phone_number"), input.get("owner_2_email"),
				input.get("owner_2_name"), input.get("owner_2_percentage"), input.get("country_code_3"),
				input.get("owner_3_phone_number"), input.get("owner_3_email"), input.get("owner_3_name"),
				input.get("owner_3_percentage"), input.get("country_code_4"), input.get("owner_4_phone_number"),
				input.get("owner_4_email"), input.get("owner_4_name"), input.get("owner_4_percentage"));
		AddProperty.selectUnderConstructionStatus();
		scrollToNext();
		AddProperty.addPaymentPlan(input.get("schedule_count"), input.get("schedule_particulars"),
				input.get("schedule_period"));
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
	public Object[][] fourowners_fouradd_villa_undeconstruction_data() throws IOException {
		List<HashMap<String, String>> value = getjsondata(System.getProperty("user.dir")
				+ "/src/test/java/com/pixbit/appium/test/data/jointproperty/JointPropertyVillaData.json");
		return new Object[][] { { value.get(1) } };
	}

}
