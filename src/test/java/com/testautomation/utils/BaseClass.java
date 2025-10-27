package com.testautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    protected static WebDriver driver;
    protected ConfigReader config;

    public void init() {
        config = new ConfigReader();
        // Headless preference: system property -> environment variable -> config.properties
        String headlessProp = System.getProperty("headless");
        if (headlessProp == null || headlessProp.isEmpty()) {
            String envHeadless = System.getenv("HEADLESS");
            headlessProp = (envHeadless != null && !envHeadless.isEmpty()) ? envHeadless : config.get("headless");
        }
        boolean headless = Boolean.parseBoolean(headlessProp);

        // Use Selenium Manager (bundled with Selenium 4.x) to resolve the correct ChromeDriver
        // Removing explicit WebDriverManager usage avoids cached/chosen driver mismatches.

        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);
        int implicitWait = Integer.parseInt(config.get("implicit.wait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().window().maximize();

        driver.get(config.get("base.url"));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
