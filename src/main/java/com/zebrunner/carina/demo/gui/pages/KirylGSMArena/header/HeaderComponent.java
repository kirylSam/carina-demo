package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.InstaPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.YouTubePage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath ="/html//div[@id='logo']")
    private ExtendedWebElement gsmArenaLogo;

    @FindBy(xpath ="/html//input[@id='topsearch-text']")
    private ExtendedWebElement searchInputField;

    @FindBy(css ="#quick-search-button [type]")
    private ExtendedWebElement searchButton;

    @FindBy(css =".icon-tip-us")
    private ExtendedWebElement tipUsIcon;

    @FindBy(css =".icon-soc-youtube")
    private ExtendedWebElement youtubeIcon;

    @FindBy(css =".icon-instagram")
    private ExtendedWebElement instaIcon;

    @FindBy(css =".icon-soc-rss2")
    private ExtendedWebElement rssIcon;

    @FindBy(css =".icon-specs-car")
    private ExtendedWebElement carIcon;

    @FindBy(css =".icon-cart")
    private ExtendedWebElement merchIcon;

    @FindBy(css =".icon-user-plus")
    private ExtendedWebElement signUpIcon;

    @FindBy(css =".advanced")
    private ExtendedWebElement advancedSearchIcon;

    @FindBy(css =".icon-signout")
    private ExtendedWebElement logOutButton;

    public HeaderComponent(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent clickGSMArenaLogo() {
        gsmArenaLogo.click();
        return this;
    }

    public HeaderComponent clickSearchField() {
        searchInputField.click();
        return this;
    }

    public HeaderComponent clickTipUsIcon() {
        tipUsIcon.click();
        return this;
    }

    public YouTubePage clickYoutubeIcon() {
        youtubeIcon.click();
        return new YouTubePage(getDriver());
    }

    public InstaPage clickInstaIcon() {
        instaIcon.click();
        return new InstaPage(getDriver());
    }

    public HeaderComponent clickRSSIcon() {
        rssIcon.click();
        return this;
    }

    public HeaderComponent clickCarIcon() {
        carIcon.click();
        return this;
    }

    public HeaderComponent clickCartIcon() {
        merchIcon.click();
        return this;
    }

    public HeaderComponent clickSignUpIcon() {
        signUpIcon.click();
        return this;
    }

    public boolean isAdvancedSearchIconDisplayed() {
        return advancedSearchIcon.isElementPresent();
    }
}
