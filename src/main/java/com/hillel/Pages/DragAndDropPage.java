package com.hillel.Pages;

import com.hillel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//iframe[@id='ExampleFrame-94']")
    private WebElement frameElement;
    @FindBy(xpath = "//div[@class='square ui-draggable']")
    private WebElement drageMe;
    @FindBy(id = "info")
    private WebElement textResult;
    Actions act = new Actions(driver);



    public DragAndDropPage switchToFrame() {
        driver.switchTo().frame(frameElement);
        return this;
    }

    public DragAndDropPage dropInSquare() {
        act.dragAndDropBy(drageMe, 157, -1).build().perform();
        return this;
    }

    public DragAndDropPage dropOutSquare() {
        act.dragAndDropBy(drageMe, 445, 43).build().perform();
        return this;
    }


    public String getTextResult() {
        return textResult.getText();
    }

}
