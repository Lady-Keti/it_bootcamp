package page.test;

import org.openqa.selenium.WebDriver;

import page.objects.Dashboard;
import utility.Constant;
import utility.ExcelUtils;

public class DashboardTest {
	
	// method for filling a post with single data from a table
	public static void fillPost(WebDriver dr, int i) throws Exception {
		String data;
		Dashboard.clickMakePost(dr);
		// connect to file with data
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, Constant.Tekst);
 
		// fill Naziv
		Dashboard.clickNaziv(dr);                    
		data = ExcelUtils.getCellData(i, 1);            
		Dashboard.sendKeysNaziv(dr, data);          

		// fill Lokacija
		Dashboard.clickLokacija(dr);
		data = ExcelUtils.getCellData(i, 2);
		Dashboard.sendKeysLokacija(dr, data);

		// fill Opis
		Dashboard.clickOpis(dr);
		data = ExcelUtils.getCellData(i, 0);
		Dashboard.sendKeysOpis(dr, data);

		// submit post
		Dashboard.clickPost(dr);
	}

	// method that posts in all in a time
	public static void testWithAllData(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, Constant.Tekst);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillPost(driver, i);
			Dashboard.goToHomePage(driver);
		}
	}
}
