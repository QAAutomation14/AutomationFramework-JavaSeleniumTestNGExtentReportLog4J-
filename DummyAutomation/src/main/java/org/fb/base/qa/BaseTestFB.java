package org.fb.base.qa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTestFB {

    protected static WebDriver driver;
    protected static Properties prop;

    public BaseTestFB() {
        try {
            prop = new Properties();
            FileInputStream fis =
                new FileInputStream("C:\\Self\\IT Trainer\\IT Vedanta\\Java\\git\\AutomationFramework\\DummyAutomation\\src\\test\\resources\\application.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")) {
        	driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }
}
