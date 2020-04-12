package com.herokuapp.Frames;

import com.herokuapp.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/frames']")
    private WebElement framePage;
    @FindBy(xpath = "//a[@href='/iframe']")
    private WebElement chooseFrameType;
    @FindBy(id = "mce_0_ifr")
    private WebElement frame;
    @FindBy(id = "tinymce")
    private WebElement inputFrame;
    String inputText = "I did it!";


    public FramesPage wholeFrameTest() {
        return goToFramePage()
                .clickOnFrameType()
                .actionsWithFrame()
                .enterText()
                ;

    }

    FramesPage goToFramePage() {
        framePage.click();
        return this;
    }

    FramesPage clickOnFrameType() {
        chooseFrameType.click();
        return this;
    }

    FramesPage actionsWithFrame() {
        driver.switchTo().frame(frame);
        return this;
    }

    FramesPage enterText() {
        inputFrame.clear();
        inputFrame.sendKeys(inputText);
        return this;
    }

    public String getResult(){
        return inputFrame.getText();
    }

    public String getMySentence(){
        return this.inputText;
    }



}
