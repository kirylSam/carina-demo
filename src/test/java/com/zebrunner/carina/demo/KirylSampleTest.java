/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.GSMArenaHomePage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.footer.FooterComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.HeaderComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.LoginComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaBlogPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaNewsPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaPhonePage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaReviewsPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.ArenaPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.InstaPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.MerchPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaRSSPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaSignupPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.GSMArenaTipusPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.thirdparty.YouTubePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import static com.zebrunner.carina.demo.gui.pages.KirylGSMArena.utils.WindowHandler.*;

/**
 * Sample web test
 *
 * @author kiryl
 */
public class KirylSampleTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "kiryl")
    public void testHeader() {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();

        HeaderComponent headerComponent = gsmArenaHomePage.getHeaderComponent();
        //Logo
        headerComponent.clickGSMArenaLogo();
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened(), "Home page is not opened");

        //Search
        headerComponent.clickSearchField();
        Assert.assertTrue(headerComponent.isAdvancedSearchIconDisplayed(), "Advanced search icon is not displayed!");
        headerComponent.clickGSMArenaLogo();

        //Tip us
        headerComponent.clickTipUsIcon();
        GSMArenaTipusPage tipus = headerComponent.clickTipUsIcon();
        Assert.assertTrue(tipus.isTipusPageOpened());
        getDriver().navigate().back();
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened());

        //Youtube
        Assert.assertTrue(isOnlyOneTabOpened(getDriver()), "Another tab is opened!");
        String originalWindow = returnCurrentWindowHandle(getDriver());
        YouTubePage youTubePage = headerComponent.clickYoutubeIcon();
        waitForNewTabToOpen(getDriver());
        switchToNewOpenedTab(getDriver(), originalWindow);
        Assert.assertTrue(youTubePage.isYoutubePageOpened(),"Youtube was page is not opened!");
        closeCurrentlyOpenedTab(getDriver());
        returnToTab(getDriver(), originalWindow);
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened(), "GSMHomePage is not opened!");

        //Insta
        Assert.assertTrue(isOnlyOneTabOpened(getDriver()), "Another tab is opened!");
        originalWindow = returnCurrentWindowHandle(getDriver());
        InstaPage instaPage = headerComponent.clickInstaIcon();
        waitForNewTabToOpen(getDriver());
        switchToNewOpenedTab(getDriver(), originalWindow);
        Assert.assertTrue(instaPage.isInstaPageOpened());
        closeCurrentlyOpenedTab(getDriver());
        returnToTab(getDriver(), originalWindow);
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened());

        //RSS
        GSMArenaRSSPage rssPage = headerComponent.clickRSSIcon();
        Assert.assertTrue(rssPage.isRSSPageOpened());
        getDriver().navigate().back();
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened());

        //Car
        Assert.assertTrue(isOnlyOneTabOpened(getDriver()), "Another tab is opened!");
        originalWindow = returnCurrentWindowHandle(getDriver());
        ArenaPage arenaPage = headerComponent.clickCarIcon();
        waitForNewTabToOpen(getDriver());
        switchToNewOpenedTab(getDriver(), originalWindow);
        Assert.assertTrue(arenaPage.isArenaPageOpened());
        closeCurrentlyOpenedTab(getDriver());
        returnToTab(getDriver(), originalWindow);
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened());

        //Merch
        Assert.assertTrue(isOnlyOneTabOpened(getDriver()), "Another tab is opened!");
        originalWindow = returnCurrentWindowHandle(getDriver());
        MerchPage merchPage = headerComponent.clickMerchIcon();
        waitForNewTabToOpen(getDriver());
        switchToNewOpenedTab(getDriver(), originalWindow);
        Assert.assertTrue(merchPage.isMerchPageOpened());
        closeCurrentlyOpenedTab(getDriver());
        returnToTab(getDriver(), originalWindow);
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened());

        //Sign up
        headerComponent.clickSignUpIcon();
        GSMArenaSignupPage signupPage = headerComponent.clickSignUpIcon();
        Assert.assertTrue(signupPage.isSignupPageOpened());
        getDriver().navigate().back();
        Assert.assertTrue(gsmArenaHomePage.isGSMArenaHomePageOpened());
    }


    @Test
    @MethodOwner(owner = "kiryl")
    public void testFooter() {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();

        FooterComponent footerComponent = gsmArenaHomePage.getFooterComponent();

        //News link
        GSMArenaNewsPage gsmArenaNewsPage = footerComponent.openNewsPage();
        Assert.assertTrue(gsmArenaNewsPage.isGSMArenaNewsPageOpened(), "GSMArena News Page is not opened!");

        //Reviews Link
        GSMArenaReviewsPage gsmArenaReviewsPage = footerComponent.openReviewsPage();
        Assert.assertTrue(gsmArenaReviewsPage.isGSMArenaReviewsPageOpened(), "GSMArena Reviews Page is not opened!");
        gsmArenaHomePage.getHeaderComponent().clickGSMArenaLogo();

        //Blog Link
        GSMArenaBlogPage gsmArenaBlogPage = footerComponent.openBlogPage();
        Assert.assertTrue(gsmArenaBlogPage.isGSMArenaBlogPageOpened(), "GSMArena Blog Page is not opened!");
        gsmArenaHomePage.getHeaderComponent().clickGSMArenaLogo();

        //PhoneFinder Link
        GSMArenaPhonePage gsmArenaPhonePage = footerComponent.openPhonePage();
        Assert.assertTrue(gsmArenaPhonePage.isGSMArenaPhonePageOpened(), "GSMArena Phone Page is not opened!");
        gsmArenaHomePage.getHeaderComponent().clickGSMArenaLogo();
    }
}
