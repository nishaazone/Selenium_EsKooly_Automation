package testcases;

import base.testbase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class TestAddEmployeeAttendance extends testbase {

    public WebDriver driver;
    AddEmployeeAttendance Ae;
    AttendanceMenu AtnMenu;
    dashboardPageFactory dd;
    public static Logger log = LogManager.getLogger(TestAddEmployeeAttendance.class);

    @BeforeMethod
    public void openBrowser(){
        this.driver=initialization();
        System.out.println(this.driver);
        log.info("Browser Opened");
        loginPageFactory loginPage = new loginPageFactory(driver);
        loginPage.login();
        log.info("Logging In");
        dd=new dashboardPageFactory(driver);
        dd.AttendanceClick();
        log.info("Clicked on Attendance Menu");
        AtnMenu =new AttendanceMenu(driver);
        AtnMenu.clickEmployeeAtn();
        log.info("Clicked on Add Employee Attendance");
    }

//    @Test(priority = 1)
//    public void TestAddDate(){
//        AddEmployeeAttendance Ae = new AddEmployeeAttendance(driver);
//        Ae.clickOnDate();
//    }

    @Test(priority = 1)
    public void TestBtnManual() {
        Ae = new AddEmployeeAttendance(driver);
        Ae.clickManualBtn();
//        Ae.clickPost();
        Ae.markAttendanceForEmployee();
        log.info("Attendance Marked For all Employees");
    }

    @AfterMethod
    public void closeBrowser()
    {
        log.info("Browser closed...");
        driver.close();
    }



}
