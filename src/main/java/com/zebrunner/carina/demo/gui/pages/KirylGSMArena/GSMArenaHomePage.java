package com.zebrunner.carina.demo.gui.pages.KirylGSMArena;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.HeaderComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.LoginComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GSMArenaHomePage extends AbstractPage {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    @FindBy(css = ".clever_65609_pushdown div:nth-child(3)")
    private ExtendedWebElement closeAd;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(css =".icon-login")
    private ExtendedWebElement loginButton;

    @FindBy(css ="#login-popup2")
    private LoginComponent loginComponent;

    @FindBy(css =".top-bar")
    private HeaderComponent headerComponent;

    public GSMArenaHomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(newsColumn);
    }

    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent(3);
        closeAd.clickIfPresent(3);
    }

    public LoginComponent getLoginComponent() {
        loginButton.click();
        return loginComponent;
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public boolean isGSMArenaHomePageOpened() {
        return this.isPageOpened();
    }
}
