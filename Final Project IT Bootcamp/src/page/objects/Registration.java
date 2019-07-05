package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {

	// static fields for registration on a home page
	public static final String URL = "http://localhost/izlet/";
	private static final String FirstName = "//input[@name='firstname']";
	private static final String LastName = "//input[@name='lastname']";
	private static final String UserName = "//div[@class='register_form']//input[@name='username']";
	private static final String Email = "//input[@name='email']";
	private static final String Password = "//div[@class='register_form']//input[@name='password']";
	private static final String Register = "//input[@id='blue_btn']";

	// method for opening a home page
	public static void openHomePage(WebDriver driver) {
		driver.get(URL);
	}

	// method for navigating to a home page
	public static void goToHomePage(WebDriver driver) {
		driver.navigate().to(URL);
	}

	// locate first name element on a page
	public static WebElement getFirstName(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(FirstName));
		return wb;
	}

	// click on element first name
	public static void clickFirstName(WebDriver dr) {
		getFirstName(dr).click();
	}

	// input data in the element
	public static void sendKeysFirstName(WebDriver dr, String firstname) {
		getFirstName(dr).sendKeys(firstname);
	}

	// locate last name element on a page
	public static WebElement getLastName(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LastName));
		return wb;
	}

	// click on element last name
	public static void clickLastName(WebDriver dr) {
		getLastName(dr).click();
	}

	// input data in the element
	public static void sendKeysLastName(WebDriver dr, String lastname) {
		getLastName(dr).sendKeys(lastname);
	}

	// locate username element on a page
	public static WebElement getUserName(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(UserName));
		return wb;
	}

	// click on element username
	public static void clickUserName(WebDriver dr) {
		getUserName(dr).click();
	}

	// input data in the element
	public static void sendKeysUserName(WebDriver dr, String username) {
		getUserName(dr).sendKeys(username);
	}

	// locate email element on a page
	public static WebElement getEmail(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(Email));
		return wb;
	}

	// click on element Email
	public static void clickEmail(WebDriver dr) {
		getEmail(dr).click();
	}

	// input data in the element
	public static void sendKeysEmail(WebDriver dr, String email) {
		getEmail(dr).sendKeys(email);
	}

	// locate password element on a page
	public static WebElement getPassword(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(Password));
		return wb;
	}

	// click on element Email
	public static void clickPassword(WebDriver dr) {
		getPassword(dr).click();
	}

	// input data in the element
	public static void sendPassword(WebDriver dr, String password) {
		getPassword(dr).sendKeys(password);
	}

	// register button
	public static WebElement getRegister(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(Register));
		return wb;
	}
 
	// click on register button
	public static void clickRegister(WebDriver dr) {
		getRegister(dr).click();
	}

}
