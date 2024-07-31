package pages;

import base.testbase;
import org.apache.commons.io.FileUtils;
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

public class EmployeesMenu extends testbase {

    public WebDriver driver;
    public EmployeesMenu(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='All Employees']")
    static WebElement AllEmployeeList;

    @FindBy(id="addnewteacher")
    static WebElement AddNewEmployee;

    @FindBy(id="jobletter")
    static WebElement JobLetter;

    public void clickOnAllEmployees() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(AllEmployeeList));
        AllEmployeeList.click();
        Thread.sleep(2000);
        WebElement section = driver.findElement(By.xpath("//div[@class='page-wrapper']"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\Screenshot\\Employee_list.png");
        FileUtils.copyFile(src, trg);
        log.info("Clicked on AllEmployeesList");
    }

    public void clickOnAddEmployee() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(AddNewEmployee));
        AddNewEmployee.click();
        Thread.sleep(2000);
        WebElement section = driver.findElement(By.xpath("//div[@class='col-lg-4'][1]"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\Screenshot\\AddNewEmployee.png");
        FileUtils.copyFile(src, trg);
        log.info("Clicked on AddNewEmployee");
      }

      public void clickOnJobLetter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(JobLetter));
        JobLetter.click();
        log.info("Clicked on JobLetter");
      }
    }


