
package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GSMArenaPhonePage extends AbstractPage {

    @FindBy(css = "#tabs")
    private ExtendedWebElement phoneSearchDiv;

    @FindBy(linkText = "PHONES")
    private ExtendedWebElement phonesSwitch;

    @FindBy(linkText = "TABLETS")
    private ExtendedWebElement tabletsSwitch;

    public GSMArenaPhonePage(WebDriver driver) {
        super(driver);
        setPageURL("/search.php3?");
        setUiLoadedMarker(phonesSwitch);
    }

    public boolean isGSMArenaPhonePageOpened() {
        return tabletsSwitch.isPresent();
    }
}
