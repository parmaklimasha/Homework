package com.hillel;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;


public abstract class BasePage {

    protected final WebDriver driver;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        initElements(this.driver, this);
    }
}