package pages;

import base.testbase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class AddnewEmployee extends testbase {

    WebDriver driver;

    public AddnewEmployee(WebDriver driver){
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@class='text-center w-100 m-orange']")
    static WebElement EmployeeTitle;

    @FindBy(xpath = "//input[@name='studentname']")
    static WebElement Name;

    @FindBy(xpath = "//input[@placeholder='Mobile No.']")
    static WebElement MobileNo;

    @FindBy(xpath = "//select[@name='class']")
    static WebElement EmpTypeDropdown;

    @FindBy(id = "fileToUpload")
    static WebElement ProfilePhotoLink;

    @FindBy(xpath = "//input[@name='doa']")
    static WebElement JoinDate;

    @FindBy(xpath = "//input[@placeholder='Monthly Salary']")
    static WebElement MonthSalary;

    @FindBy(xpath = "//select[@name='gender']")
    static WebElement GenderDropDown;

    @FindBy(xpath = "//select[@name='religion']")
    static WebElement ReligionDropDown;

    @FindBy(name = "email")
    static WebElement Email;

    @FindBy(xpath = "//select[@name='blood']")
    static WebElement BloodGroupDropDown;

    @FindBy(xpath = "//input[@name='dob']")
    static WebElement BirthDate;

    @FindBy(xpath = "//input[@name='fathername']")
    static WebElement FatherName;

    @FindBy(id = "submitBtn")
    static WebElement SubmitButton;

    public static Logger log = LogManager.getLogger(AddnewEmployee.class);
    public static String SaveInfoButton(String empName, String mobNo, String employeeType, String ProLink, String joiDate, String sal, String PGender, String PReligion, String PEmail, String BloodGrp, String DOB, String Fname){
        try{
//            String title = EmployeeTitle.getText();
            log.info("Starting to add Employee...");
            Name.sendKeys(empName);
            log.info("Added Employee Name...");
            MobileNo.sendKeys(mobNo);
            Select s1 = new Select(EmpTypeDropdown);
            s1.selectByVisibleText(employeeType);
            ProfilePhotoLink.sendKeys(System.getProperty("user.dir") + ProLink);
            JoinDate.sendKeys(joiDate);
            MonthSalary.sendKeys(sal);
            Select g1 = new Select(GenderDropDown);
            g1.selectByVisibleText(PGender);
            Select r1 = new Select(ReligionDropDown);
            r1.selectByVisibleText(PReligion);
            Email.sendKeys(PEmail);
            Select b1 = new Select(BloodGroupDropDown);
            b1.selectByVisibleText(BloodGrp);
            BirthDate.sendKeys(DOB);
            Thread.sleep(2000);
            FatherName.sendKeys(Fname);
            log.info("Added Father Name...");
            SubmitButton.click();
            log.info("Employee Added");

//            return title;
            return "";


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
