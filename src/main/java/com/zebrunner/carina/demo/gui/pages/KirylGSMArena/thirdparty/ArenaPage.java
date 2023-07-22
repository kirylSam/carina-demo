package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArenaPage extends AbstractPage {

    @FindBy(linkText = "TESLA")
    private ExtendedWebElement tesla;

    public ArenaPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(tesla);
    }

    public boolean isArenaPageOpened() {
        return tesla.isPresent();
    }
}
