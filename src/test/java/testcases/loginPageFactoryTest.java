package testcases;

import base.testbase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.loginPageFactory;

public class loginPageFactoryTest extends testbase{
    public WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        this.driver=initialization();
        System.out.println(this.driver);
    }

    @Test(priority = 1)
    public void performLogin() {
        loginPageFactory loginPage = new loginPageFactory(driver);
        loginPage.login();
        log.info("Loging in...");
        String actualUrl = "https://eskooly.com/bb/dashboard.php";
        log.info("Getting the current URL..");
        String expectedUrl = driver.getCurrentUrl();
        log.info("Checking the expected and actual URL... ");
        Assert.assertEquals(expectedUrl, actualUrl);
    }

//    @Test(priority = 2)
//    @Parameters({"Username","Password"})
//    public void performlogin2(String Username, String Password){
//        loginPageFactory loginPage = new loginPageFactory(driver);
//        loginPage.loginEmployee(Username,Password);
//    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
