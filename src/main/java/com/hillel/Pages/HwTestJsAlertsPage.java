package com.hillel.Pages;

import com.hillel.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HwTestJsAlertsPage extends BasePage {
    public HwTestJsAlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/javascript_alerts']")
    private WebElement alertExercisesPage;
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement firstJsAlertButton;
    @FindBy(xpath = "//p[@id='result']")
    private WebElement result;
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement secondJsAlertButton;
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement thirdJsAlertButton;


    public HwTestJsAlertsPage clickOnTheFirstAlert() {
        firstJsAlertButton.click();
        return this;
    }

    public HwTestJsAlertsPage submitFirstAlert() {
        driver.switchTo().alert().accept();
        return this;
    }


    public HwTestJsAlertsPage clickOnTheSecondAlert() {
        secondJsAlertButton.click();
        return this;
    }

    public HwTestJsAlertsPage submitSecondAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public HwTestJsAlertsPage cancelSecondAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }


    public HwTestJsAlertsPage clickOnTheThirdAlert() {
        thirdJsAlertButton.click();
        return this;
    }

    public HwTestJsAlertsPage enterFullData(String text) {
        driver.switchTo().alert().sendKeys(String.valueOf(text));
        return this;
    }

    public HwTestJsAlertsPage submitThirdAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public String getTextResult() {
        return result.getText();
    }

    public HwTestJsAlertsPage cancelThirdAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

}



