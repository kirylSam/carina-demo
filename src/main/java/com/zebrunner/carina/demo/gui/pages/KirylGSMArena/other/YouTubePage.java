package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.HeaderComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.LoginComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YouTubePage extends AbstractPage {

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    public boolean isYoutubePageOpened() {
        return this.getPageSource().contains("youtube");
    }
}
