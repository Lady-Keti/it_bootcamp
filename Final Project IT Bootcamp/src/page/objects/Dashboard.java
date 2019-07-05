package page.objects;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.support.ui.Select;

import utility.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {

	// paths for post block
	public static final String URL = "http://localhost/izlet/dashboard.php";
	private static final String MakePost = "//a[contains(text(),'Make a post')]";
	private static final String Naziv = "//input[@placeholder='Naziv']";
	private static final String Lokacija = "//input[@placeholder='Lokacija']";
	private static final String Browse = "//input[@id='image']";
	private static final String Transport = "//div[@class='popupPost']//select[@name='transport']";
	private static final String Opis = "//textarea[@placeholder='Opis']";
	private static final String PostButton = "//div[@class='popupPost']//input[@name='postSubmit']";
	// paths for options
	private static final String PostOptions = "fa-ellipsis-v";
	private static final String DeletePost = "fa-trash-alt";
	private static final String EditPost = "fa-edit";
	// paths for edit block
	private static final String EditNaziv = "//input[@id='title']";
	private static final String EditLokacija = "//input[@id='location']";
	private static final String EditImage = "//input[@id='editImage']";
	private static final String EditTransport = "//select[@id='transport']";
	private static final String EditOpis = "//textarea[@id='description']";
	private static final String PostSubmit = "//div[@class='popupEdit']//input[@name='postSubmit']";

	// method for navigating to a home page
	public static void goToHomePage(WebDriver driver) {
		driver.navigate().to(URL);
	}

	// click on Make Post button
	public static WebElement getMakePost(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(MakePost));
		return wb;
	}
 
	public static void clickMakePost(WebDriver driver) {
		getMakePost(driver).click();
	}

	// locate, click and make input in Naziv field
	public static WebElement getNaziv(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(Naziv));
		return wb;
	}

	public static void clickNaziv(WebDriver driver) {
		getNaziv(driver).click();
	}

	public static void sendKeysNaziv(WebDriver driver, String naziv) {
		getNaziv(driver).sendKeys(naziv);
	}

	// locate, click and make input in Lokacija field
	public static WebElement getLokacija(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(Lokacija));
		return wb;
	}

	public static void clickLokacija(WebDriver driver) {
		getLokacija(driver).click();
	}

	public static void sendKeysLokacija(WebDriver driver, String lokacija) {
		getLokacija(driver).sendKeys(lokacija);
	}

	// locate, click and browse image
	public static WebElement getImage(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(Browse));
		return wb;
	}

	public static void clickImage(WebDriver driver) {
		getImage(driver).click();
	}

	public static void sendKeysImage(WebDriver driver) {
		getImage(driver).sendKeys(Constant.Image1);
	}

	// select from drop down menu
	public static WebElement getSelect(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(Transport));
		return wb;
	}

	public static void selectTransport(WebDriver driver, String transport) {
		Select sel = new Select(getSelect(driver));
		sel.selectByVisibleText(transport);
	}

	// description input
	public static WebElement getOpis(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(Opis));
		return wb;
	}

	public static void clickOpis(WebDriver driver) {
		getOpis(driver).click();
	}

	public static void sendKeysOpis(WebDriver driver, String opis) {
		getOpis(driver).sendKeys(opis);
	}

	// submit a post
	public static WebElement sendPost(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(PostButton));
		return wb;
	}

	public static void clickPost(WebDriver driver) {
		sendPost(driver).click();
	}

	// click on post menu (3 dots)
	public static void clickPostOptions(WebDriver driver) {
		WebElement wb = driver.findElement(By.className(PostOptions));
		wb.click();
	}

	// click on Edit post icon
	public static void clickPostEdit(WebDriver driver) {
		WebElement wb = driver.findElement(By.className(EditPost));
		wb.click();
	}

	// click on Delete post icon
	public static void PostDelete(WebDriver driver) {
		WebElement wb = driver.findElement(By.className(DeletePost));
		wb.click();
	}

	// locate, click, clear and change Naziv
	public static WebElement getEditNaziv(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(EditNaziv));
		return wb;
	}

	public static void clickEditNaziv(WebDriver driver) {
		getEditNaziv(driver).click();
	}

	public static void clearEditNaziv(WebDriver driver) {
		getEditNaziv(driver).clear();
	}

	public static void sendKeysEditNaziv(WebDriver driver, String naziv) {
		getEditNaziv(driver).sendKeys(naziv);
	}

	// locate, click, clear and change Lokacija
	public static WebElement getEditLokacija(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(EditLokacija));
		return wb;
	}

	public static void clickEditLokacija(WebDriver driver) {
		getEditLokacija(driver).click();
	}

	public static void clearEditLokacija(WebDriver driver) {
		getEditLokacija(driver).clear();
	}

	public static void sendKeysEditLokacija(WebDriver driver, String lokacija) {
		getEditLokacija(driver).sendKeys(lokacija);
	}

	// locate, click and change image
	public static WebElement getEditImage(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(EditImage));
		return wb;
	}

	public static void clickEditImage(WebDriver driver) {
		getEditImage(driver).click();
	}

	public static void sendKeysEditImage(WebDriver driver) {
		getEditImage(driver).sendKeys(Constant.Image2);
	}

	// select from drop down menu
	public static WebElement getTSelect(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(EditTransport));
		return wb;
	}

	public static void selectEditTransport(WebDriver driver, String transport) {
		Select sel = new Select(getSelect(driver));
		sel.selectByVisibleText(transport);
	}

	// locate, click, clear and change Opis
	public static WebElement getEditOpis(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(EditOpis));
		return wb;
	}

	public static void clickEditOpis(WebDriver driver) {
		getEditOpis(driver).click();
	}

	public static void clearEditOpis(WebDriver driver) {
		getEditOpis(driver).clear();
	}

	public static void sendKeysEditOpis(WebDriver driver, String opis) {
		getEditOpis(driver).sendKeys(opis);
	}

	// submit changes to a post
	public static WebElement sendEditedPost(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(PostSubmit));
		return wb;
	}

	public static void clickEditedPost(WebDriver driver) {
		sendEditedPost(driver).click();
	}

	// method for deleting post
	public static void clickDeletePost(WebDriver driver) {
		Dashboard.clickPostOptions(driver);
		Dashboard.PostDelete(driver);
	}

	// method for changing the post
	public static void EditPost(WebDriver driver) {
		clickPostOptions(driver);
		clickPostEdit(driver);
		Scanner sc = new Scanner(System.in);
		try {
			getEditNaziv(driver);
			clickEditNaziv(driver);
			clearEditNaziv(driver);
			System.out.println("Naziv:"); // user manual input of Naziv
			String naziv = sc.nextLine(); // variable for saving user's input
			sendKeysEditNaziv(driver, naziv); // sends user input to Naziv

			getEditLokacija(driver);
			clickEditLokacija(driver);
			clearEditLokacija(driver);
			System.out.println("Lokacija:"); // user manual input of Lokacija
			String lokacija = sc.nextLine(); // variable for saving user's input
			sendKeysEditLokacija(driver, lokacija); // sends user input to Lokacija

			getEditImage(driver);
			//clickEditImage(driver);
			sendKeysEditImage(driver);

			getTSelect(driver);
			System.out.println("Transport (Walk, Car, Motobike, Bicycle or Bus):"); // user manual select of Transport
			String transport = sc.nextLine(); // variable for saving user's input
			selectEditTransport(driver, transport); // sends user input Transport drop down menu

			getEditOpis(driver);
			clickEditOpis(driver);
			clearEditOpis(driver);
			System.out.println("Opis"); // user manual input of the Opis
			String opis = sc.nextLine(); // variable for saving user's input
			sendKeysEditOpis(driver, opis); // sends user input to Opis

			clickEditedPost(driver);

		} catch (Exception e) { // catching exception in case of an error or invalid input
			e.printStackTrace();
		}
	}

}
