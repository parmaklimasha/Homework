package com.herokuapp.Tests;

import com.herokuapp.Frames.FramesPage;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class FramesTest extends BaseTest {
    FramesPage framesPage;

    @Test
    public void testFrame() {
        log.info("Test frame and assert that text we wanted equals with the entered text");
        framesPage = new FramesPage(driver);
        framesPage.wholeFrameTest();
        Assert.assertEquals(framesPage.getResult(), framesPage.getMySentence());

    }
}
