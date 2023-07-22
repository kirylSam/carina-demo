
package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other;

import com.zebrunner.carina.demo.gui.components.NewsItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GSMArenaNewsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='search-band']")
    private ExtendedWebElement searchDiv;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@type='text']")
    private ExtendedWebElement searchTextField;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='news-item']")
    private List<NewsItem> news;
    
    public GSMArenaNewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
        setUiLoadedMarker(searchTextField);
    }


    public boolean isGSMArenaNewsPageOpened() {
        return searchTextField.isPresent();
    }
    
}
