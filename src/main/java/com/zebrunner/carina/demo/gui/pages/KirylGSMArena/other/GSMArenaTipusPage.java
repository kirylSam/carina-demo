package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GSMArenaTipusPage extends AbstractPage {

    @FindBy(css = "input#usubject")
    private ExtendedWebElement subjectInput;

    public GSMArenaTipusPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(subjectInput);
    }

    public boolean isTipusPageOpened() {
        return subjectInput.isPresent();
    }
}
