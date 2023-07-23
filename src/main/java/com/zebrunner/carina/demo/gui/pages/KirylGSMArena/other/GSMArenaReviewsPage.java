
package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GSMArenaReviewsPage extends AbstractPage {

    @FindBy(xpath = "/html//div[@id='body']/div/div[1]//form")
    private ExtendedWebElement searchDiv;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@name='sSearch']")
    private ExtendedWebElement searchTextField;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@value='Search']")
    private ExtendedWebElement searchButton;

    public GSMArenaReviewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/reviews.php3");
        setUiLoadedMarker(searchTextField);
    }

    public boolean isGSMArenaReviewsPageOpened() {
        return searchTextField.isPresent();
    }
}
