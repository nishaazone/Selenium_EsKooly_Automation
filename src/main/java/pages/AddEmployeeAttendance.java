package pages;

import base.testbase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeAttendance extends testbase {
    static WebDriver driver;

    public static Logger log = LogManager.getLogger(AddEmployeeAttendance.class);

    public AddEmployeeAttendance(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "date")
    static WebElement DatePick;

    @FindBy(xpath = "//button[contains(text(),'Mark Manual Attendance')]")
    WebElement ManualBtn;


//    public void clickOnDate(){
//        DatePick.sendKeys("03-11-2023");
//    }

    public void clickManualBtn() {
        ManualBtn.click();

    }

    public void markAttendanceForEmployee() {
        // Provide your excel sheet containing Employee names and their attendence. For Example - Nisha Dubey    P
        ExcelReader excelReader = new ExcelReader("src/main/java/testdata/Radiotest.xlsx", "Sheet1");

        List<Map<String, String>> excelData;
        try {
            excelData = excelReader.readExcelData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> EMPnames = driver.findElements(By.xpath("//form[@id='myform']//tbody//tr//td[2]//input"));
        System.out.println(EMPnames.size());
        for (Map<String, String> row : excelData) {
            String employeeName = row.get("Name");
            String status = row.get("Status");
            System.out.println("Marked Attendence "+status+" for Employee "+employeeName);
            for (int i = 1; i < EMPnames.size(); i++) {
                if (EMPnames.get(i).getAttribute("value").equals(employeeName)) {

                    System.out.println(EMPnames.get(i).getAttribute("value"));
                    String xpathText = "//label[@for='" +status+i+ "']";
                    driver.findElement(By.xpath(xpathText)).click();
                    break;
                }
            }
        }
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
        System.out.println("Button Clicked");
        log.info("Button Clicked");
    }
}


//    JavascriptExecutor jse = (JavascriptExecutor)driver;
//    jse.executeScript("scroll(0, 300)"); // if the element is on bottom.