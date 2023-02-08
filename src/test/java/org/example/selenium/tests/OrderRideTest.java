package org.example.selenium.tests;

import org.example.selenium.pages.RegisteredDriverHomePage;
import org.example.selenium.pages.RegisteredPassengerHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderRideTest extends TestBase{
    public final String DEPARTURE = "Strazilovska 5";
    public final String DESTINATION = "Narodnog fronta 20";
    public final String SCHEDULED_TIME = "19:00";

    public final String INVALID_TIME = "23:00";
    public final boolean PET = false;
    public final boolean KID = false;
    public final String VEHICLE_TYPE = "Standard";
    @BeforeTest
    public void logInPassenger() throws InterruptedException {
        LoginTest.loginPassenger();
    }
    @BeforeEach
    public void refresh(){
        driver.navigate().refresh();
    }
    @Test
    public void orderRideInvalidAddress()  {
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());
        registeredPassengerHomePage.setFrom("");
        registeredPassengerHomePage.fromPin();
        registeredPassengerHomePage.setTo(DESTINATION);
        if (PET)
            registeredPassengerHomePage.setPetCheckBox();
        if (KID)
            registeredPassengerHomePage.setKidCheckBox();
        registeredPassengerHomePage.clickOnVehicleType();
        registeredPassengerHomePage.chooseVehicleType(VEHICLE_TYPE);
        registeredPassengerHomePage.setScheduleTime(SCHEDULED_TIME);
        Assert.assertFalse(registeredPassengerHomePage.isOrderClickable());
    }
    @Test
    public void orderRideDestinationNotPinned() throws InterruptedException {
//        LoginTest.loginPassenger();
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());
        registeredPassengerHomePage.setFrom(DEPARTURE);
        registeredPassengerHomePage.fromPin();
        registeredPassengerHomePage.setTo(DESTINATION);
        if (PET)
            registeredPassengerHomePage.setPetCheckBox();
        if (KID)
            registeredPassengerHomePage.setKidCheckBox();
        registeredPassengerHomePage.clickOnVehicleType();
        registeredPassengerHomePage.chooseVehicleType(VEHICLE_TYPE);
        registeredPassengerHomePage.setScheduleTime(SCHEDULED_TIME);
        Assert.assertFalse(registeredPassengerHomePage.isOrderClickable());
    }
    @Test
    public void orderRideDepartureNotPinned() throws InterruptedException {
//        LoginTest.loginPassenger();
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());
        registeredPassengerHomePage.setFrom(DEPARTURE);
        registeredPassengerHomePage.setTo(DESTINATION);
        registeredPassengerHomePage.toPin();
        if (PET)
            registeredPassengerHomePage.setPetCheckBox();
        if (KID)
            registeredPassengerHomePage.setKidCheckBox();
        registeredPassengerHomePage.clickOnVehicleType();
        registeredPassengerHomePage.chooseVehicleType(VEHICLE_TYPE);
        registeredPassengerHomePage.setScheduleTime(SCHEDULED_TIME);
        Assert.assertFalse(registeredPassengerHomePage.isOrderClickable());
    }
    @Test
    public void orderRideVehicleTypeNotSelected() throws InterruptedException {
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());
        registeredPassengerHomePage.setFrom(DEPARTURE);
        registeredPassengerHomePage.fromPin();
        registeredPassengerHomePage.setTo(DESTINATION);
        registeredPassengerHomePage.toPin();
        if (PET)
            registeredPassengerHomePage.setPetCheckBox();
        if (KID)
            registeredPassengerHomePage.setKidCheckBox();
        registeredPassengerHomePage.setScheduleTime(SCHEDULED_TIME);
        Assert.assertFalse(registeredPassengerHomePage.isOrderClickable());
    }
    @Test
    public void orderRideInvalidTime() throws InterruptedException {
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());
        registeredPassengerHomePage.setFrom(DEPARTURE);
        registeredPassengerHomePage.fromPin();
        registeredPassengerHomePage.setTo(DESTINATION);
        registeredPassengerHomePage.toPin();
        if (PET)
            registeredPassengerHomePage.setPetCheckBox();
        if (KID)
            registeredPassengerHomePage.setKidCheckBox();
        registeredPassengerHomePage.clickOnVehicleType();
        registeredPassengerHomePage.chooseVehicleType(VEHICLE_TYPE);
        registeredPassengerHomePage.setScheduleTime(INVALID_TIME);
        registeredPassengerHomePage.order();
        Assert.assertTrue(registeredPassengerHomePage.errorInvalidTime());
    }
    @Test
    public void orderRideNoDriversCurrentlyAvailable() throws InterruptedException {
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());
        registeredPassengerHomePage.setFrom(DEPARTURE);
        registeredPassengerHomePage.fromPin();
        registeredPassengerHomePage.setTo(DESTINATION);
        registeredPassengerHomePage.toPin();
        if (PET)
            registeredPassengerHomePage.setPetCheckBox();
        if (KID)
            registeredPassengerHomePage.setKidCheckBox();
        registeredPassengerHomePage.clickOnVehicleType();
        registeredPassengerHomePage.chooseVehicleType("Premium");
        registeredPassengerHomePage.setScheduleTime(SCHEDULED_TIME);
        registeredPassengerHomePage.order();
        registeredPassengerHomePage.confirmOrder();
        registeredPassengerHomePage.errorParemeter("No drivers currently available");
    }
    @Test
    public void orderRideSuccessful() throws InterruptedException {
        RegisteredPassengerHomePage registeredPassengerHomePage = new RegisteredPassengerHomePage(driver);
        Assert.assertTrue(registeredPassengerHomePage.isPageOpened());
        registeredPassengerHomePage.setFrom(DEPARTURE);
        registeredPassengerHomePage.fromPin();
        registeredPassengerHomePage.setTo(DESTINATION);
        registeredPassengerHomePage.toPin();
        if (PET)
            registeredPassengerHomePage.setPetCheckBox();
        if (KID)
            registeredPassengerHomePage.setKidCheckBox();
        registeredPassengerHomePage.clickOnVehicleType();
        registeredPassengerHomePage.chooseVehicleType(VEHICLE_TYPE);
        registeredPassengerHomePage.setScheduleTime(SCHEDULED_TIME);
        registeredPassengerHomePage.order();
        registeredPassengerHomePage.confirmOrder();
        Assert.assertTrue(registeredPassengerHomePage.isOrderSuccessful());
    }
}
