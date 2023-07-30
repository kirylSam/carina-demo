package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.GSMArenaHomePage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.GSMArenaLoginErrorPage;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.HeaderComponent;
import com.zebrunner.carina.demo.gui.pages.KirylGSMArena.header.LoginComponent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KirylDataProviderTest implements IAbstractTest, IAbstractDataProvider {
    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "kiryl")
    @XlsDataSourceParameters(path = "data_source/kiryllogin.xlsx", sheet = "GSMArena", dsUid = "TUID", dsArgs = "email,password")
    public void testLogin(String email, String password) {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();
        LoginComponent loginComponent = gsmArenaHomePage.getLoginComponent();
        loginComponent.enterLogin(email)
                .enterPassword(password);
        gsmArenaHomePage = loginComponent.submitCredentials();
        Assert.assertTrue(gsmArenaHomePage.isPageOpened(), "Home Page is not opened!");
        HeaderComponent headerComponent = gsmArenaHomePage.getHeaderComponent();
        headerComponent.clickLogOutButton();
    }


    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "kiryl")
    @XlsDataSourceParameters(path = "data_source/kiryllogin.xlsx", sheet = "Test1", dsUid = "TUID", dsArgs = "email,password")
    public void testLoginCorrectEmailIncorrectPass(String email, String password) {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();
        LoginComponent loginComponent = gsmArenaHomePage.getLoginComponent();
        loginComponent.enterLogin(email)
                .enterPassword(password)
                .submitCredentials();
        GSMArenaLoginErrorPage gsmArenaLoginErrorPage = new GSMArenaLoginErrorPage(getDriver());
        Assert.assertTrue(gsmArenaLoginErrorPage.isGSMArenaLoginErrorPageOpened(), "Login error page is not opened!");
        Assert.assertTrue(gsmArenaLoginErrorPage.getErrorReason().contains("Wrong password"));
    }


    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "kiryl")
    @XlsDataSourceParameters(path = "data_source/kiryllogin.xlsx", sheet = "Test2", dsUid = "TUID", dsArgs = "email,password")
    public void testLoginIncorrectEmailCorrectPass(String email, String password) {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();
        LoginComponent loginComponent = gsmArenaHomePage.getLoginComponent();
        loginComponent.enterLogin(email)
                .enterPassword(password)
                .submitCredentials();
        GSMArenaLoginErrorPage gsmArenaLoginErrorPage = new GSMArenaLoginErrorPage(getDriver());
        Assert.assertTrue(gsmArenaLoginErrorPage.isGSMArenaLoginErrorPageOpened(), "Login error page is not opened!");
        Assert.assertTrue(gsmArenaLoginErrorPage.getErrorReason().contains("User record not found"));
    }

    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "kiryl")
    @XlsDataSourceParameters(path = "data_source/kiryllogin.xlsx", sheet = "Test3", dsUid = "TUID", dsArgs = "email,password")
    public void testLoginCorrectEmailEmptyPass(String email, String password) {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();
        LoginComponent loginComponent = gsmArenaHomePage.getLoginComponent();
        loginComponent.enterLogin(email)
                .enterPassword(password)
                .submitCredentials();
        Assert.assertTrue(loginComponent.getPasswordFieldValidationMessage().contains("Please fill out this field"));
    }

    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "kiryl")
    @XlsDataSourceParameters(path = "data_source/kiryllogin.xlsx", sheet = "Test4", dsUid = "TUID", dsArgs = "email,password")
    public void testLoginEmptyEmailCorrectPass(String email, String password) {
        GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
        gsmArenaHomePage.open();
        LoginComponent loginComponent = gsmArenaHomePage.getLoginComponent();
        loginComponent.enterLogin(email)
                .enterPassword(password)
                .submitCredentials();
        Assert.assertTrue(loginComponent.getEmailFieldValidationMessage().contains("Please fill out this field"));
    }
}


