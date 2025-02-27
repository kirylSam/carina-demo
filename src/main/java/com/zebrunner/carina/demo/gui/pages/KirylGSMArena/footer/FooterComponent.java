package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.footer;

import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaBlogPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaNewsPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaPhonePage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaReviewsPage;
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

    public GSMArenaNewsPage openNewsPage() {
        newsLink.scrollTo();
        newsLink.hover();
        newsLink.click();
        return new GSMArenaNewsPage(driver);
    }

    public GSMArenaReviewsPage openReviewsPage() {
        reviewsLink.scrollTo();
        reviewsLink.hover();
        reviewsLink.click();
        return new GSMArenaReviewsPage(driver);
    }

    public GSMArenaBlogPage openBlogPage() {
        blogLink.scrollTo();
        blogLink.hover();
        blogLink.click();
        return new GSMArenaBlogPage(driver);
    }

    public GSMArenaPhonePage openPhonePage() {
        phoneFinderLink.scrollTo();
        phoneFinderLink.hover();
        phoneFinderLink.click();
        return new GSMArenaPhonePage(driver);
    }
}
