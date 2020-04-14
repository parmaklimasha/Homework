package com.herokuapp.Tests;

import com.herokuapp.JSAlerts.HwTestJsAlertsPage;
import com.herokuapp.JSAlerts.HwTestsJsConfirmAlertsPage;
import com.herokuapp.JSAlerts.HwTestsJsPromptAlertsPage;
import com.herokuapp.TextPrompt;
import com.herokuapp.DataProviders;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class HwAlertsTest extends BaseTest {


    HwTestJsAlertsPage hwTestAlertsPage;
    HwTestsJsConfirmAlertsPage hwTestsJsConfirmAlertsPage;
    HwTestsJsPromptAlertsPage hwTestsJsPromptAlertsPage;


    @Test
    public void test0() {
        log.info("Test  first JS Alert and assert result");
        hwTestAlertsPage = new HwTestJsAlertsPage(driver);
        hwTestAlertsPage.wholeAlertOneTest();
        Assert.assertEquals(hwTestAlertsPage.getTextResult(), "You successfuly clicked an alert");
    }

    @Test
    public void test1() {
        log.info("Test second JS alert with clicking OK");
        hwTestsJsConfirmAlertsPage = new HwTestsJsConfirmAlertsPage(driver);
        hwTestsJsConfirmAlertsPage.okAlertTest();
        Assert.assertEquals(hwTestAlertsPage.getTextResult(), "You clicked: Ok");
    }

    @Test
    public void test2() {
        log.info("Test second JS alert with clicking cancel");
        hwTestsJsConfirmAlertsPage.cancelAlertTest();
        Assert.assertEquals(hwTestsJsConfirmAlertsPage.getTextResult(), "You clicked: Cancel");
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void test3(TextPrompt textPrompt) {
        log.info("Open third JS alert and enter data");
        hwTestsJsPromptAlertsPage = new HwTestsJsPromptAlertsPage(driver);
        hwTestsJsPromptAlertsPage.dataEntering(textPrompt.getText());
        log.info("Click on the OK");
        hwTestsJsPromptAlertsPage.submitThirdAlert();
        Assert.assertEquals(hwTestsJsPromptAlertsPage.getTextResult(), "You entered: " + textPrompt.getText());
    }

    @Test(dataProvider = "getEmptyData", dataProviderClass = DataProviders.class)
    public void test4(TextPrompt textPrompt) {
        log.info("Open the third JS alert and enter nothing");
        hwTestsJsPromptAlertsPage.dataEntering(textPrompt.getText());
        log.info("Click on the OK");
        hwTestsJsPromptAlertsPage.submitThirdAlert();
        Assert.assertEquals(hwTestsJsPromptAlertsPage.getTextResult(), "You entered:" + textPrompt.getText());
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void test5(TextPrompt textPrompt) {
        log.info("Open the third JS alert and enter data");
        hwTestsJsPromptAlertsPage.dataEntering(textPrompt.getText());
        log.info("Click on the cancel");
        hwTestsJsPromptAlertsPage.cancelThirdAlert();
        Assert.assertEquals(hwTestsJsPromptAlertsPage.getTextResult(), "You entered: null");
    }

    @Test(dataProvider = "getEmptyData", dataProviderClass = DataProviders.class)
    public void test6(TextPrompt textPrompt) {
        log.info("Open the third JS alert and enter nothing");
        hwTestsJsPromptAlertsPage.dataEntering(textPrompt.getText());
        log.info("Click on the cancel");
        hwTestsJsPromptAlertsPage.cancelThirdAlert();
        Assert.assertEquals(hwTestsJsPromptAlertsPage.getTextResult(), "You entered: null");
    }
}
