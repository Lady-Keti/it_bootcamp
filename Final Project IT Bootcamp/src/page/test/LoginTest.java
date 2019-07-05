package page.test;

import org.openqa.selenium.*;

import page.objects.Dashboard;
import page.objects.Login;
import page.objects.Registration;
import utility.Constant;
import utility.ExcelUtils;

public class LoginTest {

	public static void fillForm(WebDriver dr, int i) throws Exception {
		String data;
		// connect to file with data
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, Constant.Registracija);

		// get data and fill username field
		Login.clickUsername(dr);
		data = ExcelUtils.getCellData(i, 2);
		Login.sendKeysUsername(dr, data);

		// get data and fill password field
		Login.clickPassword(dr);
		data = ExcelUtils.getCellData(i, 4);
		Login.sendPassword(dr, data);

		// log in user
		Login.clickLogin(dr);
	}

	// method which logs in only successfully registered users, then make posts, deletes first and second post
	public static void testWithAllData(WebDriver driver) throws Exception {

		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, Constant.Registracija);
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, Constant.Tekst);
		int yes = 0;
		int no = 0;
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillForm(driver, i);
			if (driver.getCurrentUrl().equals("http://localhost/izlet/dashboard.php")) {
				System.out.println("User from row " + i + " has been registered, logged and posted in successfully");
				yes += 1;
				DashboardTest.testWithAllData(driver);
				Dashboard.clickDeletePost(driver);
				Dashboard.clickDeletePost(driver);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@id='logoutBtn']")).click(); // logout button
			} 
			else {
				System.out.println("User from row " + i + " is not registered, log in wasn't successful");
				no += 1;
				Registration.goToHomePage(driver); // if registration fails rediect to home page
			}
		}
		System.out.println(
				"Log in was successful for " + yes + " users.\nLog in wasn't successful for " + no + " users.");
	} // summary
	
}
