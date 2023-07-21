package com.zebrunner.carina.demo.gui.pages.KirylGSMArena.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowHandler {

    public static String returnCurrentWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public static void waitForNewTabToOpen(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(numberOfWindowsToBe(2));
    }

    public static boolean isOnlyOneTabOpened(WebDriver driver) {
        return driver.getWindowHandles().size() == 1;
    }

    public static void switchToNewOpenedTab(WebDriver driver, String originalWindow) {
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void closeCurrentlyOpenedTab(WebDriver driver) {
        driver.close();
    }

    public static void returnToTab(WebDriver driver, String originalWindow) {
        driver.switchTo().window(originalWindow);
    }
}
