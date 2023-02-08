package org.example.selenium.tests;
import org.example.selenium.pages.LoginPage;
import org.example.selenium.pages.RegisteredDriverHomePage;
import org.example.selenium.pages.RegisteredPassengerHomePage;
import org.example.selenium.pages.UnregisteredHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    public static final String EMAIL_PASSENGER = "passe";
    public static final String EMAIL_DRIVER = "drive";
    public static final String PASSWORD = "123";
    @Test
    public void loginInvalid() {
        UnregisteredHomePage unregisteredHomePage = new UnregisteredHomePage(driver, "4200");
        Assert.assertTrue(unregisteredHomePage.isPageOpened());
        unregisteredHomePage.openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.setEmail("sahgisag");
        loginPage.setPassword(PASSWORD);
        loginPage.login();
        Assert.assertTrue(loginPage.checkLoginError());
    }
    @Test
    public static void loginPassenger() throws InterruptedException {
        UnregisteredHomePage unregisteredHomePage = new UnregisteredHomePage(driver, "4200");
        Assert.assertTrue(unregisteredHomePage.isPageOpened());
        unregisteredHomePage.openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.setEmail(EMAIL_PASSENGER);
        loginPage.setPassword(PASSWORD);
        loginPage.login();
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());

    }
    @Test
    public static void loginDriver() throws InterruptedException {
        UnregisteredHomePage unregisteredHomePage = new UnregisteredHomePage(driver, "4200");
        Assert.assertTrue(unregisteredHomePage.isPageOpened());
        unregisteredHomePage.openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.setEmail(EMAIL_DRIVER);
        loginPage.setPassword(PASSWORD);
        loginPage.login();
        RegisteredDriverHomePage registeredDriverHomePage = new RegisteredDriverHomePage(driver);
        Assert.assertTrue(registeredDriverHomePage.isPageOpened());

    }
}
