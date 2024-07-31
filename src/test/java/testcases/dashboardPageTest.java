package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import base.testbase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.dashboardPageFactory;
import pages.loginPageFactory;

public class dashboardPageTest extends testbase{
    public WebDriver driver;

//    @Parameters
    @BeforeTest
    public void openBrowser() {
        this.driver=initialization();
        System.out.println(this.driver);
        loginPageFactory loginPage = new loginPageFactory(driver);
        loginPage.login();
        log.info("Loging in...");
    }

//    @Test(priority = 1)
//    public void testEmployeeMenuClick() {
//        dashboardPageFactory db = new dashboardPageFactory(driver);
//        db.clickEmployees();
//        log.info("Employees Menu is clicked");
//    }

//    @Test(priority = 2)
//    public void testClassesMenuClick(){
//        dashboardPageFactory db = new dashboardPageFactory(driver);
//        db.clickClasses();
//        log.info("Classes Menu is clicked");
//    }

//    @Test(priority = 3)
//    public void testGeneralMenuClick(){
//        dashboardPageFactory db = new dashboardPageFactory(driver);
//        db.gnrlClick();
//        log.info("General Menu is clicked");
//    }

    @Test(priority = 1)
    public void testAttendanceMenuClick(){
        dashboardPageFactory db = new dashboardPageFactory(driver);
        db.AttendanceClick();
        log.info("Attendance Menu is Clicked");
    }

    @Test(priority = 2)
    public void ClickingOnCard1(){
        dashboardPageFactory db = new dashboardPageFactory(driver);
        db.ClickCard1();
        log.info("Card 1 is clicked");
    }


//    @Test(priority = 2)
//    public void testCertificatesMenuClick(){
//        dashboardPageFactory db = new dashboardPageFactory(driver);
//        db.CertificateClick();
//        log.info("Certificate Menu is clicked");
//    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        log.info("Closing the browser");
    }
}


