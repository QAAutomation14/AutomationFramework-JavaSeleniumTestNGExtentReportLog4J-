package org.fb.base.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initialization() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        tlDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}
