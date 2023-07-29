package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.ArenaPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.InstaPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.MerchPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaRSSPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaSignupPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaTipusPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.YouTubePage;
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

    public GSMArenaTipusPage clickTipUsIcon() {
        tipUsIcon.click();
        return new GSMArenaTipusPage(getDriver());
    }

    public YouTubePage clickYoutubeIcon() {
        youtubeIcon.click();
        return new YouTubePage(getDriver());
    }

    public InstaPage clickInstaIcon() {
        instaIcon.click();
        return new InstaPage(getDriver());
    }

    public GSMArenaRSSPage clickRSSIcon() {
        rssIcon.click();
        return new GSMArenaRSSPage(getDriver());
    }

    public ArenaPage clickCarIcon() {
        carIcon.click();
        return new ArenaPage(getDriver());
    }

    public MerchPage clickMerchIcon() {
        merchIcon.click();
        return new MerchPage(getDriver());
    }

    public GSMArenaSignupPage clickSignUpIcon() {
        signUpIcon.click();
        return new GSMArenaSignupPage(getDriver());
    }

    public boolean isAdvancedSearchIconDisplayed() {
        return advancedSearchIcon.isElementPresent();
    }
}
