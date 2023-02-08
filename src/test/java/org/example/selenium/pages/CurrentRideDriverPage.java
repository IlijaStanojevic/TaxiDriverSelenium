package org.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrentRideDriverPage {
    WebDriver driver;

    @FindBy(css = ".mat-mdc-card-header-text mat-card-title")
    WebElement header;
    @FindBy(css = ".finish-button")
    WebElement finishButton;
    public CurrentRideDriverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isPageOpened(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(header, "Current Ride"));
    }
    public void finishRide(){
        finishButton.click();
    }
}
