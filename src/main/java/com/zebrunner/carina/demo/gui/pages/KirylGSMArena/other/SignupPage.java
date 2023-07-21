package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends AbstractPage {

    @FindBy(css = "input#uname")
    private ExtendedWebElement usernameInput;

    public SignupPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(usernameInput);
    }

    public boolean isSignupPageOpened() {
        return usernameInput.isPresent();
    }
}
