package pages;

import base.testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static base.testbase.driver;
import static pages.dashboardPageFactory.DashboardTitlePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loginPageFactory extends testbase {
    WebDriver driver;

    public loginPageFactory(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement usernameInput;

    @FindBy(name = "password")
   WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
   WebElement submitButton;

    public static Logger log = LogManager.getLogger(loginPageFactory.class);

    public String login() {
        usernameInput.sendKeys(prop.getProperty("username"));
        log.info("Username added...");
        passwordInput.sendKeys(prop.getProperty("password"));
        log.info("Password added...");
        submitButton.click();
        log.info("Button clicked...");
        return "";
    }

    public String loginEmployee(String user, String pass){
        driver.findElement(By.xpath("//*[@id='signin-form']/div[1]/div/label[2]")).click();
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        submitButton.click();
        return "";
    }

}






