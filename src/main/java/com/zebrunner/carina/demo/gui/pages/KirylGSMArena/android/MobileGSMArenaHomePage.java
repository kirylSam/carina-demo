package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.android;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.GSMArenaHomePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GSMArenaHomePage.class)
public class MobileGSMArenaHomePage extends GSMArenaHomePage {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    @FindBy(css = ".clever_65609_pushdown div:nth-child(3)")
    private ExtendedWebElement closeAd;

    @FindBy(css = ".menu")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(css =".header-top-bar")
    private MobileHeaderComponent headerComponent;


    public MobileGSMArenaHomePage(WebDriver driver) {
        super(driver);
        setPageURL("m.gsmarena.com");
        setUiLoadedMarker(hamburgerMenu);
    }

    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent(3);
        closeAd.clickIfPresent(3);
    }

    @Override
    public MobileHeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public boolean isGSMArenaHomePageOpened() {
        return this.isPageOpened();
    }
}
