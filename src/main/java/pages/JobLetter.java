package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class JobLetter {

    WebDriver driver;

    public JobLetter(WebDriver driver){
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='tags1']")
    static WebElement SearchJobLetterEmpName;

    @FindBy(xpath = "//*[@id='btn']")
    static WebElement printJobLetter;

    public static Logger log = LogManager.getLogger(JobLetter.class);

    public void cLickOnSearchEmpBar() throws InterruptedException {
       SearchJobLetterEmpName.sendKeys("73610");
       SearchJobLetterEmpName.sendKeys(ARROW_DOWN);
       SearchJobLetterEmpName.sendKeys(ENTER);
       SearchJobLetterEmpName.click();
       Thread.sleep(2000);
//       printJobLetter.click();
    }
}


