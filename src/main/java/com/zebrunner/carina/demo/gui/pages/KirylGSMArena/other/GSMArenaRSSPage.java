package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GSMArenaRSSPage extends AbstractPage {

    public GSMArenaRSSPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRSSPageOpened() {
        return getPageSource().contains("This feed contains");
    }
}
