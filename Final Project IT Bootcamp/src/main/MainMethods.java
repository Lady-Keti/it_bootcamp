package main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.Dashboard;
import page.objects.Login;
import page.objects.Registration;
import page.test.DashboardTest;
import page.test.LoginTest;
import page.test.RegistrationTest;

public class MainMethods { // method which sends input to registration fields

	// static fields which we use in few methods
	static String username;
	static String password;

	// method for user's input through console
	public static void ManualRegInput(WebDriver driver) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		try {
			System.out.println("First name:"); // user manual input of the first name
			String firstname = sc.nextLine(); // variable for saving user's input
			Registration.sendKeysFirstName(driver, firstname); // sends user input to registration field

			System.out.println("Last name:"); // user manual input of the last name
			String lastname = sc.nextLine(); // variable for saving user's input
			Registration.sendKeysLastName(driver, lastname); // sends user input to registration field

			System.out.println("Username:"); // user manual input of the username
			username = sc.nextLine(); // variable for saving user's input
			Registration.sendKeysUserName(driver, username); // sends user input to registration field

			System.out.println("Email"); // user manual input of the email
			String email = sc.nextLine(); // variable for saving user's input
			Registration.sendKeysEmail(driver, email); // sends user input to registration field

			System.out.println("Password:"); // user manual input of the password
			password = sc.nextLine(); // variable for saving user's input
			Registration.sendPassword(driver, password); // sends user input to registration field

			Registration.clickRegister(driver);

		} catch (Exception e) { // catching exception in case of an error or invalid input
			e.printStackTrace();
		}
	}

	// method for manual user login using input from manual registration
	public static void LoginUser(WebDriver driver) {
		WebElement loginUsername = Login.getUsername(driver);
		loginUsername.click();
		loginUsername.sendKeys(username); // uses static username field
		WebElement loginPassword = Login.getPassword(driver);
		loginPassword.click();
		loginPassword.sendKeys(password); // uses static password field
		Login.clickLogin(driver);
	}

	// method for manual posting
	public static void makePost(WebDriver driver) throws Exception {
		Scanner sc = new Scanner(System.in);
		Dashboard.clickMakePost(driver);
		try {
			System.out.println("Naziv:"); // user manual input of Naziv
			String naziv = sc.nextLine(); // variable for saving user's input
			Dashboard.sendKeysNaziv(driver, naziv); // sends user input to Naziv

			System.out.println("Lokacija:"); // user manual input of Lokacija
			String lokacija = sc.nextLine(); // variable for saving user's input
			Dashboard.sendKeysLokacija(driver, lokacija); // sends user input to Lokacija

			Dashboard.sendKeysImage(driver);

			System.out.println("Transport (Walk, Car, Motobike, Bicycle or Bus):"); // user manual select of Transport
			String transport = sc.nextLine(); // variable for saving user's input
			Dashboard.selectTransport(driver, transport); // sends user input Transport drop down menu

			System.out.println("Opis"); // user manual input of the Opis
			String opis = sc.nextLine(); // variable for saving user's input
			Dashboard.sendKeysOpis(driver, opis); // sends user input to Opis

			Dashboard.clickPost(driver);

		} catch (Exception e) { // catching exception in case of an error or invalid input
			e.printStackTrace();
		}
	}

	// method of making a choice of registration way
	public static void switchTesting(WebDriver driver) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to do manual testing (press 1),"
				+ "\nautomation testing with some data (press 2)" + "\nor automation testing with all data (press 3)?");
		
		// user chose either manual or automatic testing
		switch (sc.nextInt()) {
		case 1:
			MainMethods.ManualRegInput(driver); // manual registration from console
			Thread.sleep(2000); // wait 2 seconds
			MainMethods.LoginUser(driver); // manual log in
			Thread.sleep(2000); // wait 2 seconds
			MainMethods.makePost(driver); // manual posting
			Dashboard.EditPost(driver); // editing of manual post
			Thread.sleep(3000); // wait 3 seconds
			break;
		case 2:
			RegistrationTest.fillForm(driver, 5); // automatic registration with single data from table
			LoginTest.fillForm(driver, 5); // automatic login with single data from table
			Thread.sleep(2000); // wait 2 seconds
			DashboardTest.fillPost(driver, 7); // automatic posting with single data from table
			break;
		case 3:
			RegistrationTest.testWithAllData(driver); // automatic registration of all users from table
			LoginTest.testWithAllData(driver); // login, posting, deleting posts from all users in table
			break;
		default:
			System.out.println("Error!"); // error message in case of wrong case input
			break;
		}
	}
}
