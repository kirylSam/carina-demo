package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class InstaPage extends AbstractPage {

    public InstaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInstaPageOpened() {
        return this.getPageSource().contains("instagram");
    }
}
