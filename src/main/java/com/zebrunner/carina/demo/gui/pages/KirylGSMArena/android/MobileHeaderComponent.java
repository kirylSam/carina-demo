package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.android;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.HeaderComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeaderComponent.class)
public class MobileHeaderComponent extends HeaderComponent implements ICustomTypePageFactory {

    @FindBy(css =".icon-sign-in")
    private ExtendedWebElement signIcon;

    @FindBy(css = ".menu")
    private ExtendedWebElement hamburgerMenu;


    public MobileHeaderComponent(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public MobileHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public MobileHeaderComponent clickHamburgerMenu() {
        hamburgerMenu.click();
        return this;
    }
}
