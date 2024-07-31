package pages;

import base.testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dashboardPageFactory extends testbase {
    WebDriver driver;

    public static Logger log = LogManager.getLogger(dashboardPageFactory.class);

    public dashboardPageFactory(WebDriver driver) {
        super();
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[contains(@class,'m-b-5 m-orange')]" )
    static WebElement DashboardTitlePage;

    @FindBy(xpath = "//h3[@class='text-center w-100 m-orange']")
    static WebElement EmployeeTitlePage;

    @FindBy(xpath = "//span[text()='General Settings']")
    static WebElement GnrlBtn;

    @FindBy(xpath = "//span[text()='Classes']")
    static WebElement classesBtn;

    @FindBy(xpath = "//span[text()='Subjects']")
    static WebElement SubBtn;

    @FindBy(xpath = "//span[text()='Students']")
    static WebElement StuBtn;

    @FindBy(xpath = "//span[text()='Employees']")
    static  WebElement EmpBtn;

    @FindBy(xpath = "//span[text()='Salary']")
    static WebElement SalBtn;

    @FindBy(xpath = "//span[text()='Accounts']")
    static WebElement IncBtn;

    @FindBy(xpath = "//span[text()='Attendance']")
    static WebElement AtnBtn;

    @FindBy(xpath = "//span[text()='Certificates']")
    static WebElement CertificateBtn;

    @FindBy(xpath = "//*[@id='pcoded']/div[2]/div[2]/div/div/div/div/div/div/div/div[1]/a/div/div/h6")
    static WebElement Card1;

    public void gnrlClick(){
        GnrlBtn.click();
    }
    public void clickClasses(){
        classesBtn.click();
    }
    public void clickEmployees(){
         EmpBtn.click();
    }
    public void ClickCard1(){
        Card1.click();
    }

    public void CertificateClick(){
        CertificateBtn.click();
    }

    public void AttendanceClick(){
        AtnBtn.click();
        driver.findElement(By.xpath("//i[@class='ti-fullscreen']")).click();
    }

    public static void clickSubjects(){
        SubBtn.click();
    }
    public static void clickStudents(){
        StuBtn.click();
    }

    public static void SalaryClick(){
        SalBtn.click();
    }
    public static void AccountsClick(){
        IncBtn.click();
    }
}
