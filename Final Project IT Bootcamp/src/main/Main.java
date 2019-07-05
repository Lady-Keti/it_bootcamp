package main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.Dashboard;
import page.objects.Registration;
import page.test.LoginTest;
import page.test.RegistrationTest;

import main.MainMethods;

public class Main {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// we put main code in try catch block if there is any mistake in our code
		try {
			Registration.openHomePage(driver); // opens browser and website
			Registration.goToHomePage(driver); // navigates to home page
			MainMethods.switchTesting(driver); // register, logs in and make posts for one or more user(s)
			System.out.println("Test was done successfully!");
		} catch (Exception e) { // catching exception in case of an error or invalid input
			e.printStackTrace();
		} finally {
			Thread.sleep(10000); // waits 10 seconds
			driver.close(); // and then shuts down}
		}
	}
}
