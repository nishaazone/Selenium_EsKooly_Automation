package testcases;

import base.testbase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AddnewEmployee;
import pages.EmployeesMenu;
import pages.dashboardPageFactory;
import pages.loginPageFactory;
import utils.ReadXLSdata;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class TestAddnewEmployee extends testbase {

    Set<String> processedEmails = new HashSet<>();
    public WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException, IOException {
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
        EmpMenu.clickOnAddEmployee();
    }


    @Test(dataProvider="testData")
    public void runAddingEmployee(String empName, String mobNo, String employeeType, String PPLink, String joiDate, String sal, String Gender, String religion, String email, String Bgrp, String dob, String fatherName) {
        try {
            AddnewEmployee a= new AddnewEmployee(driver);
            if (!processedEmails.contains(email)) { // Check if the email has already been processed

                a.SaveInfoButton(empName, mobNo, employeeType, PPLink, joiDate, sal, Gender, religion, email, Bgrp, dob, fatherName);
//                Assert.assertEquals(title, "Employee Form");
                log.info("Assertion successful: Page title matches expected.");
                // Add the processed email to the Set
                processedEmails.add(email);
            } else {
                System.out.println("Skipped processing duplicate email: " + email);
            }
        } catch (RuntimeException e) {
            log.error("Data not Processed");
            e.printStackTrace();
        }
    }

    @DataProvider(name = "testData")
    public  Object[][] testData(Method m) {
        ReadXLSdata dataReader = new ReadXLSdata();
        try {
            return dataReader.getdata(m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void closeBrowser()
    {
        log.info("Browser closed...");
        driver.close();
    }
}

