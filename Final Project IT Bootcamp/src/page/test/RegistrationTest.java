package page.test;

import org.openqa.selenium.*;

import page.objects.Registration;
import utility.Constant;
import utility.ExcelUtils;

public class RegistrationTest {

	public static void fillForm(WebDriver dr, int i) throws Exception {
		String data;
		// connect to file with data
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, Constant.Registracija);

		// get data and fill first name field
		Registration.clickFirstName(dr);
		data = ExcelUtils.getCellData(i, 0);
		Registration.sendKeysFirstName(dr, data);

		// get data and fill last name field
		Registration.clickLastName(dr);
		data = ExcelUtils.getCellData(i, 1);
		Registration.sendKeysLastName(dr, data);

		// get data and fill username field
		Registration.clickUserName(dr);
		data = ExcelUtils.getCellData(i, 2);
		Registration.sendKeysUserName(dr, data);

		// get data and fill email field
		Registration.clickEmail(dr);
		data = ExcelUtils.getCellData(i, 3);
		Registration.sendKeysEmail(dr, data);

		// get data and fill password field
		Registration.clickPassword(dr);
		data = ExcelUtils.getCellData(i, 4);
		Registration.sendPassword(dr, data);

		// register users
		Registration.clickRegister(dr);
	}

	// method that register all users in a time
	public static void testWithAllData(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, Constant.Registracija);
		for (int i = 0; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillForm(driver, i);
			Registration.goToHomePage(driver);
		}
	}
}
