package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisteredPassengerHomePage {
    private WebDriver driver;

    @FindBy(css = "h1")
    private WebElement formHeader;


    @FindBy(css = "input[name='fromInput']")
    WebElement fromInput;

    @FindBy(css = "input[name='toInput']")
    WebElement toInput;

    @FindBy(css = "#fromPin")
    WebElement fromPin;

    @FindBy(css = "#toPin")
    WebElement toPin;

    @FindBy(css = "input[name='timePicker']")
    WebElement scheduleTimeInput;
    @FindBy(xpath = "//div[@fxLayout='row']/*[name()='mat-checkbox'][1]")
    WebElement petCheckBox;
    @FindBy(xpath = "//div[@fxLayout='row']/*[name()='mat-checkbox'][2]")
    WebElement kidCheckBox;
    @FindBy(css = "mat-select")
    WebElement vehicleTypeSelect;
    @FindBy(xpath = "//button/span[contains(text(),'ORDER')]/..")
    WebElement orderButton;
    @FindBy(xpath = "//button/span[contains(text(),'Yes')]/..")
    WebElement confirmOrder;
    @FindBy(xpath = "//form/*[1]")
    WebElement errorMessage;
    @FindBy(css = ".dropdown-toggle")
    WebElement optionsDropdown;
    @FindBy(xpath = "//ul/li[5]/*")
    WebElement logOutButton;
    @FindBy(css = ".loading-message")
    WebElement loadingMessage;

    public RegisteredPassengerHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(formHeader, "Order ride"));
    }
    public void setFrom(String from){
        fromInput.clear();
        fromInput.sendKeys(from);

    }
    public void fromPin(){
        fromPin.click();
    }
    public void setTo(String to){
        toInput.clear();
        toInput.sendKeys(to);
    }
    public void toPin(){
        toPin.click();
    }
    public void setKidCheckBox(){
        kidCheckBox.click();
    }
    public void setPetCheckBox(){
        petCheckBox.click();
    }
    public void setScheduleTime(String scheduleTime){
        scheduleTimeInput.clear();
        scheduleTimeInput.sendKeys(scheduleTime);
    }
    public void clickOnVehicleType(){
        vehicleTypeSelect.click();
    }
    public void chooseVehicleType(String vehicleType){
        String locator = String.format("//mat-option/span[contains(text(),'%s')]", vehicleType);
        vehicleTypeSelect.findElement(By.xpath(locator)).click();
    }

    public void order(){
        WebElement isReady = (new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(orderButton)
        ));
        orderButton.click();
    }
    public void confirmOrder() throws InterruptedException {
        WebElement isReady = (new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(confirmOrder)
        ));
        confirmOrder.click();
    }
    public boolean isOrderSuccessful(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(loadingMessage, "Assinging driver.."));
    }
    public boolean isOrderClickable(){
        return orderButton.isEnabled();
    }
    public boolean errorParemeter(String errorMessage){
        return (new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(this.errorMessage, errorMessage)
        ));
    }
    public boolean errorInvalidTime(){
        return (new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(errorMessage, "Scheduled time must be 5 hours from now")
        ));
    }
}
