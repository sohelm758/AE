package com.steps.ui;

import com.pages.homePage.HomePage;
import com.utilities.webDriver.DriverFactory;

public class HomePageSteps extends DriverFactory {

    private HomePage homepage;
    public HomePageSteps()
    {
        homepage = new HomePage(driver);
    }


//    @Given("^I navigate to the Firmex home page$")
//        public void iNavigateToTheFirmexHomePage() {
//            driver.get("https://www.saucedemo.com/index.html");
//    }

//    @And("^I verify the login page title$")
//    public void iVerifyHomePageTitle() {
//        Assert.assertTrue("User is not on home page",homepage.verifyTitle());
//    }

}
