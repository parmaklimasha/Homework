package com.hillel.Tests;

import com.hillel.Pages.MainPage;
import com.hillel.Utils.Constants;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class DragAndDropTest extends BaseTest {
    @Test
    public void testDragAndDrop() {
        log.info("Testing with dropping into square");
        driver.get(Constants.DRAG_AND_DROP);
        Assert.assertEquals(
                new MainPage(driver)
                        .goToDragAndDropPage()
                        .switchToFrame()
                        .dropInSquare()
                        .getTextResult(), "dropped!");
        log.info("Testing with dropping out of square");
        Assert.assertEquals(
                new MainPage(driver)
                        .goToDragAndDropPage()
                        .dropOutSquare()
                        .getTextResult(), "moving out!");
    }


}
