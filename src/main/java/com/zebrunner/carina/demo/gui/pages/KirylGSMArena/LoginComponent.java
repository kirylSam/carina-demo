package com.zebrunner.carina.demo.gui.pages.KirylGSMArena;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(css ="input#email")
    private ExtendedWebElement emailInputField;

    @FindBy(css ="input#upass")
    private ExtendedWebElement passwordInputField;

    @FindBy(css ="input#nick-submit")
    private ExtendedWebElement logInButton;

    public LoginComponent(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public LoginComponent(WebDriver driver) {
        super(driver);
    }


    public LoginComponent enterLogin(String loginString) {
        emailInputField.type(loginString);
        return this;
    }

    public LoginComponent enterPassword(String passwordString) {
        passwordInputField.type(passwordString);
        return this;
    }

    public GSMArenaHomePage submitCredentials(){
        logInButton.click();
        return new GSMArenaHomePage(driver);
    }
}
