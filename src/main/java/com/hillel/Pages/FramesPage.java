package com.hillel.Pages;

import com.hillel.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@href='/iframe']")
    private WebElement chooseFrameType;
    @FindBy(id = "mce_0_ifr")
    private WebElement frame;
    @FindBy(id = "tinymce")
    private WebElement inputFrame;


    public FramesPage clickOnFrameType() {
        chooseFrameType.click();
        return this;
    }

    public FramesPage actionsWithFrame() {
        driver.switchTo().frame(frame);
        return this;
    }

    public FramesPage enterText(String text) {
        inputFrame.clear();
        inputFrame.sendKeys(String.valueOf(text));
        return this;
    }

    public String getResult() {
        return inputFrame.getText();
    }


}
