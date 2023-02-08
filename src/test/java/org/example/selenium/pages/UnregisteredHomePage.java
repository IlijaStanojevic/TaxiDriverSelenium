package org.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnregisteredHomePage {

    private WebDriver driver;
    private static final String URL = "http:/localhost:";

    @FindBy(css = "h1")
    private WebElement formHeader;


    @FindBy(css = ".right button:nth-child(2)")
    WebElement loginButton;


    public UnregisteredHomePage(WebDriver driver,String port) {
        this.driver = driver;
        driver.get(URL + port );
        PageFactory.initElements(driver, this);
    }
    public void openLoginPage(){
        loginButton.click();
    }
    public boolean isPageOpened(){

        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(formHeader, "Estimate ride"));
    }


}


