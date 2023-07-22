package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MerchPage extends AbstractPage {

    @FindBy(css = ".header__logo-image")
    private ExtendedWebElement merchLogo;

    public MerchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(merchLogo);
    }

    public boolean isMerchPageOpened() {
        return merchLogo.isPresent();
    }
}
