package org.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;


    @FindBy(css = "h1")
    private WebElement formHeader;
    @FindBy(css = "#form3Example3")
    private WebElement emailInput;

    @FindBy(css = "#form3Example4")
    WebElement passwordInput;

    @FindBy(css = "form button")
    WebElement loginButton;
    @FindBy(css = "div[role='alert']")
    WebElement alertMessage;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isPageOpened(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(formHeader, "Taxi Driver"));
    }
    public void setEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void setPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void login(){
        loginButton.click();
    }
    public boolean checkLoginError(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(alertMessage, "Wrong username or password!"));
    }
}
