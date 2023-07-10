package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SauceDemoLoginPage extends AbstractPage {

    @FindBy(css = "[name='user-name']")
    private ExtendedWebElement loginField;

    @FindBy(css = "[name='password']")
    private ExtendedWebElement passwordField;

    @FindBy(css = "input#login-button")
    private ExtendedWebElement loginButton;

    public SauceDemoLoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginField);
        setPageAbsoluteURL("https://www.saucedemo.com/v1/");
    }

    public SauceDemoLoginPage openSauceDemoLoginPage(){
        openURL("https://www.saucedemo.com/v1/");
        return this;
    }

    public void enterLogin(String loginString) {
        loginField.type(loginString);
    }

    public void enterPassword(String passwordString) {
        passwordField.type(passwordString);
    }

    public void submitCredentials(){
        loginButton.click();
    }
}
