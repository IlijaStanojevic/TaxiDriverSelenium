package org.example.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() {
        System.setProperty("webdriver.opera.driver", "E:\\xyz\\TEST\\operadriver_win64\\operadriver.exe");
        driver = new OperaDriver();

        //TODO change driver if needed

        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}
