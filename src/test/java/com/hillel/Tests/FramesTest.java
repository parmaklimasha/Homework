package com.hillel.Tests;

import com.hillel.DataProviders;
import com.hillel.Pages.FramesPage;
import com.hillel.Pages.MainPage;
import com.hillel.TextPrompt;
import com.hillel.Utils.Constants;
import io.github.sskorol.core.DataSupplier;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class FramesTest extends BaseTest {

    @Test(dataProvider = "getTextForFrame", dataProviderClass = DataProviders.class)
    public void testFrame(TextPrompt textPrompt) {
        log.info("Test frame and assert that text we wanted equals with the entered text");
        driver.get(Constants.HEROKUAPP_URL);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToFramePage()
                        .clickOnFrameType()
                        .actionsWithFrame()
                        .enterText(textPrompt.getText())
                        .getResult(), "I did it!");

    }
}
