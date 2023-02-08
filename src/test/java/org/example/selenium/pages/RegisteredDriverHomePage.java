package org.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisteredDriverHomePage {
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Driver Rides')]")
    private WebElement formHeader;
    @FindBy(css = ".driverContainer app-driver-home > *:first-child button")
    WebElement startRideButton;
    public RegisteredDriverHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isPageOpened(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(formHeader, "Driver Rides"));
    }
    public void startRide(){
        startRideButton.click();
    }
}
