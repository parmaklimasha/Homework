package com.hillel.Pages;

import com.hillel.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/javascript_alerts']")
    private WebElement jsAlertsPage;
    @FindBy(xpath = "//a[@href='/frames']")
    private WebElement framePage;

    public HwTestJsAlertsPage goToAlertsPage() {
        jsAlertsPage.click();
        return new HwTestJsAlertsPage(driver);
    }

    public FramesPage goToFramePage() {
        framePage.click();
        return new FramesPage(driver);
    }


    public DragAndDropPage goToDragAndDropPage(){
        return new DragAndDropPage(driver);
    }
}

