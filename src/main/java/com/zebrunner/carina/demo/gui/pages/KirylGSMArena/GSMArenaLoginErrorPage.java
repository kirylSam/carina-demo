package com.zebrunner.carina.demo.gui.pages.KirylGSMArena;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GSMArenaLoginErrorPage extends AbstractPage {

    @FindBy(css = ".normal-text.res-error")
    private ExtendedWebElement errorMessage;

    @FindBy(css = ".normal-text.res-error > p")
    private ExtendedWebElement errorReason;


    public GSMArenaLoginErrorPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
        setUiLoadedMarker(errorMessage);
    }

    public boolean isGSMArenaLoginErrorPageOpened() {
        return this.isPageOpened();
    }

    public String getErrorReason() {
        return errorReason.getText();
    }
}
