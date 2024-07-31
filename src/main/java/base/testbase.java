package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testbase
{
    //Global variables
    public static WebDriver driver;
    public static Properties prop;
    //constructor
    public static Logger log =  LogManager.getLogger(testbase.class);
    public testbase()
    {
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public WebDriver initialization(){
        String browsername = prop.getProperty("browser");
        if (browsername.equals("chrome")){
            driver= new ChromeDriver();
        } else if (browsername.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browsername.equals("edge")) {
            driver= new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //launch url
        String url = prop.getProperty("url");
        driver.get(url);
        return driver;
    }
}
