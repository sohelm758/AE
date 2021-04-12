package com.utilities.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class SelectDriver {

    static  String browser;
    static WebDriver driver;
    static{
        browser = getBrowser();
    }

    public static String getBrowser()
    {
        return "chrome";
    }

    public static WebDriver getDriver() throws Exception {
        if (browser.toLowerCase().equals("chrome")) {
            return getChromeDriver();
        }
        else if(browser.toLowerCase().equals("firefox")){
            return getGeckoDriver();
        }
        else
        {
            throw new Exception("browser not defined");
        }
    }

    public static WebDriver getChromeDriver()
    {
        File resourcesDirectory = new File("src/test/resources");
        String path = resourcesDirectory.getAbsolutePath() + "/drivers/chromedriver";
        //setting relative path
        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver();

        return driver;
    }

    public static WebDriver getGeckoDriver(){
        File resourcesDirectory = new File("src/test/resources");
        String path = resourcesDirectory.getAbsolutePath() + "/drivers/geckodriver";
        //setting relative path
        System.setProperty("webdriver.gecko.driver",path);
        driver = new FirefoxDriver();

        return driver;
    }

}
