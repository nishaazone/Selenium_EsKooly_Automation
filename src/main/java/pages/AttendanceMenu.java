package pages;

import base.testbase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendanceMenu extends testbase {

    public WebDriver driver;

    public AttendanceMenu(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static Logger log = LogManager.getLogger(AttendanceMenu.class);

    @FindBy(id = "studentsattandance")
    static WebElement StudentAttendanceBtn;

    @FindBy(id = "employeesattandance")
    static  WebElement EmployeeAttendanceBtn;

    public void clickStudentAtn(){
        StudentAttendanceBtn.click();
    }

    public void clickEmployeeAtn(){
        EmployeeAttendanceBtn.click();
    }
}
