package com.herokuapp.JSAlerts;

import com.herokuapp.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HwTestsJsPromptAlertsPage extends BasePage {
    public HwTestsJsPromptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement thirdJsAlertButton;
    @FindBy(xpath = "//p[@id='result']")
    private WebElement result;


    public HwTestsJsPromptAlertsPage dataEntering(String textPrompt) {
        return clickOnTheThirdAlert()
                .enterFullData(textPrompt)
                ;

    }

    HwTestsJsPromptAlertsPage clickOnTheThirdAlert() {
        thirdJsAlertButton.click();
        return this;
    }

    HwTestsJsPromptAlertsPage enterFullData(String text) {
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public HwTestsJsPromptAlertsPage submitThirdAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public String getTextResult() {
        return result.getText();
    }

    public HwTestsJsPromptAlertsPage cancelThirdAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

}
