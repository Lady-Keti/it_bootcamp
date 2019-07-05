package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	public static final String URL = "http://localhost/izlet/";
	private static final String Username = "//input[@placeholder='username']";
	private static final String Password = "//input[@placeholder='password']";
	private static final String LogIn = "//input[@name='login']";

	// locate URL of page
	public static WebElement getURL(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(URL));
		return wb;
	}

	// locate username element on a page
	public static WebElement getUsername(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(Username));
		return wb;
	}

	// click on element username
	public static void clickUsername(WebDriver dr) {
		getUsername(dr).click();
	}

	// input data in the element
	public static void sendKeysUsername(WebDriver dr, String username) {
		getUsername(dr).sendKeys(username);
	}

	// locate username element on a page
	public static WebElement getPassword(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(Password));
		return wb;
	}

	// click on element username
	public static void clickPassword(WebDriver dr) {
		getPassword(dr).click();
	}

	// input data in the element
	public static void sendPassword(WebDriver dr, String password) {
		getPassword(dr).sendKeys(password);
	}

	// login button
	public static WebElement getLogIn(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LogIn));
		return wb;
	}

	public static void clickLogin(WebDriver dr) {
		getLogIn(dr).click();
	}

}
