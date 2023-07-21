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
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.LoginComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.HeaderComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.InstaPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.other.YouTubePage;
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
   /* @Test
    @MethodOwner(owner = "kiryl")
    @Parameters({"login", "password"})
    public void testLogin(String login, String password) {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();
        LoginComponent loginComponent = gsmArenaHomePage.getLoginComponent();
        loginComponent.enterLogin(login)
                .enterPassword(password);
        gsmArenaHomePage = loginComponent.submitCredentials();
        Assert.assertTrue(gsmArenaHomePage.isPageOpened(), "Home Page is not opened!");
        Assert.assertTrue(gsmArenaHomePage.isLogOutButtonDisplayed(), "Log out button is not displayed!");
    }*/


    @Test
    @MethodOwner(owner = "kiryl")
    public void testHeader() {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();

        HeaderComponent headerComponent = gsmArenaHomePage.getHeaderComponent();
        headerComponent.clickGSMArenaLogo();
        Assert.assertTrue(getDriver().getTitle().equals("GSMArena.com - mobile phone reviews, news, " +
                "specifications and more..."), "`Home page is not opened");

        headerComponent.clickSearchField();
        Assert.assertTrue(headerComponent.isAdvancedSearchIconDisplayed(), "Advanced search icon is not displayed!");

        headerComponent.clickGSMArenaLogo();

        headerComponent.clickTipUsIcon();
        Assert.assertTrue(getDriver().getTitle().equals("Tip us - GSMArena.com"), "Tip us page is not opened!");

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



/*
        headerComponent.clickCarIcon();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue(getDriver().getCurrentUrl().contains("arenaev.com"));
        getDriver().close();
        getDriver().switchTo().window(originalWindow);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("gsmarena.com"));


        headerComponent.clickCartIcon();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue(getDriver().getCurrentUrl().contains("merch"));
        getDriver().close();
        getDriver().switchTo().window(originalWindow);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("gsmarena.com"));

        wait.until(numberOfWindowsToBe(1));
        headerComponent.clickSignUpIcon();
        Assert.assertTrue(getDriver().getPageSource().contains("Why register"));*/

    }
}
