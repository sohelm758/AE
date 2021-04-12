package com.pages.loginPage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage<LoginPage> {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }


    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    WebElement login;

    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    WebElement errorMsg;

    public void login(String val)
    {
        String uname = "";
        String pass = "";

        switch(val){
        case ("standard"):
            uname = "standard_user";
            pass = "secret_sauce";
            break;
        case ("problem"):
                uname = "problem_user";
                pass = "secret_sauce";
                break;
            case ("locked_out"):
                uname = "locked_out_user";
                pass = "secret_sauce";
                break;
            case ("performance_glitch_user"):
                uname = "performance_glitch_user";
                pass = "secret_sauce";
                break;
        case ("invalid"):
            uname = "test@gmail.com";
            pass = "test@123";
            break;

        default:
            System.out.println("not a valid input ");
                   }
        try {
            username.clear();
            username.sendKeys(uname);
            password.clear();
            password.sendKeys(pass);
            login.click();
        }catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Boolean verifyTitle(){
        System.out.println(driver.getTitle());
        return driver.getTitle().contains("Swag Labs");
    }

    public Boolean errorMsgExists(){

        try{
            return waitUtils.getElementAfterMediumWait(errorMsg).isDisplayed();

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean userLockedOut(){
       String te = errorMsg.getText();
       return waitUtils.getElementAfterShortWait(errorMsg).getText().contains("Sorry, this user has been locked out.");
    }



    @Override
    protected void load() {
    driver.get("https://www.saucedemo.com/index.html");
    }

    @Override
    protected void isLoaded() throws Error {
    if(driver.getCurrentUrl().contains("https://www.saucedemo.com/index.html"))
    {
        System.out.println("login page loaded");
    }
    else
    {
        System.out.println("not loaded");
    }
    }
}
