package com.hillel.Tests;

import com.hillel.Pages.MainPage;
import com.hillel.TextPrompt;
import com.hillel.DataProviders;
import com.hillel.Utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class HwAlertsTest extends BaseTest {


    @Test
    public void test0() {
        log.info("Test  first JS Alert and assert result");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToAlertsPage()
                        .clickOnTheFirstAlert()
                        .submitFirstAlert()
                        .getTextResult(), "You successfuly clicked an alert");
    }

    @Test
    public void test1() {
        log.info("Test second JS alert with clicking OK");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToAlertsPage()
                        .clickOnTheSecondAlert()
                        .submitSecondAlert()
                        .getTextResult(),
                "You clicked: Ok");
    }

    @Test
    public void test2() {
        log.info("Test second JS alert with clicking cancel");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToAlertsPage()
                        .clickOnTheSecondAlert()
                        .cancelSecondAlert()
                        .getTextResult(), "You clicked: Cancel");
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void test3(TextPrompt textPrompt) {
        log.info("Open third JS alert and enter data and Click on the OK");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToAlertsPage()
                        .clickOnTheThirdAlert()
                        .enterFullData(textPrompt.getText())
                        .submitThirdAlert()
                        .getTextResult(), "You entered: " + textPrompt.getText());
    }

    @Test(dataProvider = "getEmptyData", dataProviderClass = DataProviders.class)
    public void test4(TextPrompt textPrompt) {
        log.info("Open the third JS alert and enter nothing");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToAlertsPage()
                        .clickOnTheThirdAlert()
                        .enterFullData(textPrompt.getText())
                        .cancelThirdAlert()
                        .getTextResult(), "You entered: null");
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void test5(TextPrompt textPrompt) {
        log.info("Open the third JS alert, enter data and cancel");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToAlertsPage()
                        .clickOnTheThirdAlert()
                        .enterFullData(textPrompt.getText())
                        .cancelThirdAlert()
                        .getTextResult(), "You entered: null");
    }

    @Test(dataProvider = "getEmptyData", dataProviderClass = DataProviders.class)
    public void test6(TextPrompt textPrompt) {
        log.info("Open the third JS alert, enter nothing and cancel");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToAlertsPage()
                        .clickOnTheThirdAlert()
                        .enterFullData(textPrompt.getText())
                        .cancelThirdAlert()
                        .getTextResult(), "You entered: null");
    }
}
