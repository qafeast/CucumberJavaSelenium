package StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public static void setUp(){
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
            driver.manage().window().maximize();
        }catch (Throwable e){

        }
    }
    @After
    public static void close(){
        driver.close();
    }

}
