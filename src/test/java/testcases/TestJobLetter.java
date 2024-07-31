package testcases;

import base.testbase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmployeesMenu;
import pages.JobLetter;
import pages.dashboardPageFactory;
import pages.loginPageFactory;

import java.io.IOException;

public class TestJobLetter extends testbase {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(JobLetter.class);

    @BeforeMethod
    public void openBrowser() {
        this.driver=initialization();
        System.out.println(this.driver);
        log.info("Browser Opened");
        loginPageFactory loginPage = new loginPageFactory(driver);
        loginPage.login();
        log.info("Logging In");
        dashboardPageFactory dd = new dashboardPageFactory(driver);
        dd.clickEmployees();
        log.info("Clicked on Employee Menu");
        EmployeesMenu EmpMenu = new EmployeesMenu(driver);
        EmpMenu.clickOnJobLetter();
    }

    @Test
    public void DowloadingLetter() throws InterruptedException {
        JobLetter Jl = new JobLetter(driver);
        Jl.cLickOnSearchEmpBar();
    }

    @AfterMethod
    public void closeBrowser()
    {
        log.info("Browser closed...");
        driver.close();
    }
}
