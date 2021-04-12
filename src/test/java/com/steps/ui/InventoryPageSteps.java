package com.steps.ui;

import com.pages.inventoryPage.InventoryPage;
import com.pages.loginPage.LoginPage;
import com.utilities.WaitUtils;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class InventoryPageSteps extends DriverFactory {
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    WaitUtils waitUtils;
    public InventoryPageSteps(){
        inventoryPage = new InventoryPage(driver);
        loginPage = new LoginPage(driver);
        waitUtils = new WaitUtils(driver);
    }


    @When("^I validate user is on the Inventory page$")
    public void i_navigate_to_the_Inventory_page(){
        if(!inventoryPage.userOnInventoryPage()){
            waitUtils.captureScreenshots("userNotonPage");
            Assert.fail("user is not on Inventory Page");
        }
    }

    @Then("^I validate add to cart functionality is working fine$")
    public void i_validate_add_to_cart_functionality_is_working_fine() throws IOException {
        inventoryPage.addItemsToCart();
        if(!inventoryPage.validateCartCount()){
            waitUtils.captureScreenshots("addToCart");
            Assert.fail("Added items not correctly added to the cart");
        }
    }

    @Then("^I validate the user is locked out$")
    public void iValidateTheUserIsLockedOut() {
        if(!loginPage.userLockedOut()){
            waitUtils.captureScreenshots("lockedOut");
            Assert.fail("User not locked out");

        }
    }

    @Then("^I validate add to cart functionality is not working fine$")
    public void iValidateAddToCartFunctionalityIsNotWorkingFine() {
        inventoryPage.addItemsToCart();
        if(!inventoryPage.addeditemsNotInCart()){
            waitUtils.captureScreenshots("addToCart");
            Assert.fail("problem user functionality failed");
        }
    }


    @Then("^I validate the pages are loading slowly$")
    public void iValidateThePagesAreLoadingSlowly() {
        long curreTim = System.currentTimeMillis();
        long elemappeared = inventoryPage.elementsNotVisibleAFterQuickLoad();
        System.out.println("time after elment loaded "+ (elemappeared-curreTim)+" milliseconds");
    }
}
