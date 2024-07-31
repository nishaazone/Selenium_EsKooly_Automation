package testcases;

import base.testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CertificatesMenu;
import pages.dashboardPageFactory;
import pages.loginPageFactory;

public class TestCertificatesMenu extends testbase {

    public WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        this.driver=initialization();
        loginPageFactory ll=new loginPageFactory(driver);
        ll.login();
        dashboardPageFactory dd= new dashboardPageFactory(driver);
        dd.CertificateClick();
        System.out.println(this.driver);
    }

    @Test(priority = 1)
    public void TestLeaveCertificateButton(){
        CertificatesMenu Cm = new CertificatesMenu(driver);
        Cm.clickOnLeaveCertificate();
    }

    @Test(priority = 2)
    public void TestCharacterCertificateButton(){
        CertificatesMenu Cm = new CertificatesMenu(driver);
        Cm.clickOnCharacterCertificate();
    }

    @AfterTest
    public void closingBrowser() {
        driver.close();
    }
}
