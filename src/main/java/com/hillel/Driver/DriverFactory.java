package com.hillel.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };


    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    private static final Supplier<WebDriver> operaDriverSupplier = () -> {
        WebDriverManager.operadriver().setup();
        return new FirefoxDriver();
    };
    private static final Supplier<WebDriver> ieDriverSupplier = () -> {
        WebDriverManager.iedriver().setup();
        return new FirefoxDriver();
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(DriverType.OPERA, operaDriverSupplier);
        driverMap.put(DriverType.IE, ieDriverSupplier);
    }


    public static final WebDriver getDriver(DriverType type) {
        return driverMap.get(type).get();
    }

}

