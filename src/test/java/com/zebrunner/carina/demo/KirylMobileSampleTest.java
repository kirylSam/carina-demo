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

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.GSMArenaHomePage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.android.MobileGSMArenaHomePage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.android.MobileHeaderComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.HeaderComponent;
import com.zebrunner.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.demo.utils.MobileContextUtils.View;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KirylMobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "kiryl")
    @TestLabel(name = "feature", value = {"mobile"})
    public void testLoginUser() {
       MobileGSMArenaHomePage mobileGSMArenaHomePage = new MobileGSMArenaHomePage(getDriver());
       // MobileGSMArenaHomePage mobileGSMArenaHomePage = initPage(getDriver(), MobileGSMArenaHomePage.class);
        mobileGSMArenaHomePage.open();

        MobileHeaderComponent mobileHeaderComponent = mobileGSMArenaHomePage.getHeaderComponent();
        mobileHeaderComponent.clickHamburgerMenu();
        pause(20);

    }

}
