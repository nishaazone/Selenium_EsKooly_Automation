package testcases;

import base.testbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EmployeesMenu;
import pages.dashboardPageFactory;
import pages.loginPageFactory;
import utils.ScreenshotUtils;

import java.io.IOException;

public class TestEmployeeMenu extends testbase {

    public WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        this.driver=initialization();
        loginPageFactory ll=new loginPageFactory(driver);
        ll.login();
        dashboardPageFactory dd= new dashboardPageFactory(driver);
        dd.clickEmployees();
        System.out.println(this.driver);
    }

    @Test(priority = 1)
    public void TestAllEmployeesButton() throws IOException, InterruptedException {
        EmployeesMenu EmpMenu = new EmployeesMenu(driver);
        EmpMenu.clickOnAllEmployees();
    }

    @Test(priority = 3)
    public void TestAddNewButton() throws InterruptedException, IOException {
        EmployeesMenu EmpMenu = new EmployeesMenu(driver);
        EmpMenu.clickOnAddEmployee();
    }

    @Test(priority = 2)
    public void TestJobLetterButton(){
        EmployeesMenu EmpMenu = new EmployeesMenu(driver);
        EmpMenu.clickOnJobLetter();
    }

    @AfterTest
    public void closingBrowser() {
        driver.close();
    }

}
