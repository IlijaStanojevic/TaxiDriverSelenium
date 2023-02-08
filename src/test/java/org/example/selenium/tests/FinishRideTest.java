package org.example.selenium.tests;

import org.example.selenium.pages.CurrentRideDriverPage;
import org.example.selenium.pages.RegisteredDriverHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FinishRideTest extends TestBase{
    @Test
    public void finishRide() throws InterruptedException {
        LoginTest.loginDriver();
        RegisteredDriverHomePage registeredDriverHomePage = new RegisteredDriverHomePage(driver);
        Assert.assertTrue(registeredDriverHomePage.isPageOpened());
        registeredDriverHomePage.startRide();
        CurrentRideDriverPage currentRideDriverPage = new CurrentRideDriverPage(driver);
        Assert.assertTrue(currentRideDriverPage.isPageOpened());
        currentRideDriverPage.finishRide();
        Assert.assertTrue(registeredDriverHomePage.isPageOpened());
    }
}
