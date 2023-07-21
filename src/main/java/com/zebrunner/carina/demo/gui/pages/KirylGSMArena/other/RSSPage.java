package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RSSPage extends AbstractPage {

    public RSSPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRSSPageOpened() {
        return getPageSource().contains("This feed contains");
    }
}
