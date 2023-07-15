package com.zebrunner.carina.demo.gui.pages.KirylGSMArena;

import com.zebrunner.carina.demo.gui.components.ModelItem;
import com.zebrunner.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GSMArenaHomePage extends AbstractPage {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    @FindBy(css = ".clever_65609_pushdown div:nth-child(3)")
    private ExtendedWebElement closeAd;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(css =".icon-login")
    private ExtendedWebElement loginButton;

    @FindBy(css =".icon-signout")
    private ExtendedWebElement logOutButton;

    @FindBy(css ="#login-popup2")
    private LoginComponent loginComponent;

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

    public boolean isLogOutButtonDisplayed() {
        return logOutButton.isPresent();
    }

}
