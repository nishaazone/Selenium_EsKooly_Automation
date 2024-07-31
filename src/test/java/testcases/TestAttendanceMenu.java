package testcases;

import base.testbase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AttendanceMenu;
import pages.dashboardPageFactory;
import pages.loginPageFactory;

public class TestAttendanceMenu extends testbase {

    public WebDriver driver;

    public static Logger log = LogManager.getLogger(TestAttendanceMenu.class);


    @BeforeTest
    public void openBrowser() {
        this.driver=initialization();
        loginPageFactory ll=new loginPageFactory(driver);
        ll.login();
        dashboardPageFactory dd= new dashboardPageFactory(driver);
        dd.AttendanceClick();
        System.out.println(this.driver);
    }

//    @Test(priority = 1)
//    public void testStudentAttendance(){
//        AttendanceMenu AtnMenu = new AttendanceMenu(driver);
//        AtnMenu.clickStudentAtn();
//    }

    @Test(priority = 1)
    public void testEmployeeAttendance(){
        AttendanceMenu AtnMenu = new AttendanceMenu(driver);
        AtnMenu.clickEmployeeAtn();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
