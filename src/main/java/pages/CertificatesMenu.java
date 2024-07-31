package pages;


import base.testbase;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CertificatesMenu extends testbase {

    public WebDriver driver;

    public CertificatesMenu(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='lc']")
    static WebElement LeaveCertificate;

    @FindBy(xpath = "//*[@id='cc']")
    static WebElement CharacterCertificate;

    public static Logger log = LogManager.getLogger(CertificatesMenu.class);

    public void clickOnLeaveCertificate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(LeaveCertificate));
        LeaveCertificate.click();
        log.info("Clicked on Leave Certificate...");
    }

    public void clickOnCharacterCertificate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(CharacterCertificate));
        CharacterCertificate.click();
        log.info("Clicked on Leave Certificate...");
    }

}
