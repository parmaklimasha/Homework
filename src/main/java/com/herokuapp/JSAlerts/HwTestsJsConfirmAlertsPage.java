package com.herokuapp.JSAlerts;

import com.herokuapp.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HwTestsJsConfirmAlertsPage extends BasePage {
    public HwTestsJsConfirmAlertsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement secondJsAlertButton;
    @FindBy(xpath = "//p[@id='result']")
    private WebElement result;

    public HwTestsJsConfirmAlertsPage okAlertTest() {
        return clickOnTheSecondAlert()
                .submitSecondAlert()
                ;

    }

    public HwTestsJsConfirmAlertsPage cancelAlertTest() {
        return clickOnTheSecondAlert()
                .cancelSecondAlert()
                ;
    }


    HwTestsJsConfirmAlertsPage clickOnTheSecondAlert() {
        secondJsAlertButton.click();
        return this;
    }

    HwTestsJsConfirmAlertsPage submitSecondAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    HwTestsJsConfirmAlertsPage cancelSecondAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public String getTextResult() {
        return result.getText();
    }

}
