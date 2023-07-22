package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.footer;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaNewsPage;
import com.zebrunner.carina.demo.gui.pages.desktop.CompareModelsPage;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.NewsPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class FooterComponent  extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    @FindBy(linkText = "Reviews")
    private ExtendedWebElement reviewsLink;

    @FindBy(linkText = "Blog")
    private ExtendedWebElement blogLink;

    @FindBy(linkText = "Phone Finder")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(linkText = "Tools")
    private ExtendedWebElement toolsLink;

    @FindBy(linkText = "Compare")
    private ExtendedWebElement compareLink;

    @FindBy(linkText = "Coverage")
    private ExtendedWebElement coverageLink;

    @FindBy(linkText = "Glossary")
    private ExtendedWebElement glossaryLink;

    @FindBy(linkText = "Contact us")
    private ExtendedWebElement contactusLink;

    @FindBy(css = ".footer-inner [href='team\\.php3']")
    private ExtendedWebElement teamLink;

    public FooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public FooterComponent(WebDriver driver) {
        super(driver);
    }

  /*  public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CompareModelsPage openComparePage() {
        compareLink.scrollTo();
        compareLink.hover();
        compareLink.click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.scrollTo();
        newsLink.hover();
        newsLink.click();
        return new NewsPage(driver);
    }*/

    public GSMArenaNewsPage openNewsPage() {
        newsLink.scrollTo();
        newsLink.hover();
        newsLink.click();
        return new GSMArenaNewsPage(driver);
    }

    public GSMArenaReviewsPage openReviewsPage() {
        newsLink.scrollTo();
        newsLink.hover();
        newsLink.click();
        return new GSMArenaReviewsPage(driver);
    }
}
