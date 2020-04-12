package com.herokuapp.JSAlerts;

import com.herokuapp.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HwTestJsAlertsPage extends BasePage {
    public HwTestJsAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/javascript_alerts']")
    private WebElement alertExercisesPage;
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement firstJsAlertButton;
    @FindBy(xpath = "//p[@id='result']")
    private WebElement result;

    public HwTestJsAlertsPage wholeAlertOneTest() {
        return goToTheAlertPage()
                .clickOnTheFirstAlert()
                .submitFirstAlert()
                ;
    }


    HwTestJsAlertsPage goToTheAlertPage() {
        alertExercisesPage.click();
        return this;
    }

    HwTestJsAlertsPage clickOnTheFirstAlert() {
        firstJsAlertButton.click();
        return this;
    }

    HwTestJsAlertsPage submitFirstAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public String getTextResult() {
        return result.getText();
    }


}
