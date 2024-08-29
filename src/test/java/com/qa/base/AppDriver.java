package com.qa.base;

import org.openqa.selenium.WebDriver;

public class AppDriver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver()
    {
        return driver.get();
    }
    public static void setDriver(WebDriver _driver){
        driver.set(_driver);
        System.out.println("Driver is Up");
    }
}
