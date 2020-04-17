package com.hillel.Tests;

import com.hillel.Driver.DriverFactory;
import com.hillel.Driver.DriverType;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;



    @BeforeClass
    public void setUpDriver() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}