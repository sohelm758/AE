package com.pages.basePage;

import com.utilities.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class BasePage <T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver){
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver,this);

    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
