package utils;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebBasePage {
    WebDriver driver;

    public  WebBasePage(WebDriver driver) {
       this.driver=driver;
    }
    public void click(By by, String name, int timeInMills){
        try{
           isVisible(by,timeInMills);
            driver.findElement(by).click();
        }catch (Throwable e){
            System.out.println(name +" isn't clicked");
            Assert.fail(e.getMessage());
        }
    }
    public boolean isVisible(By by,int timeInMills){
        try{
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeInMills));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return  true;
        }catch (Throwable e){
            return  false;
        }
    }
    public void enter(By by,String value,String name,int timeInMills ) {
        try {
            isVisible(by, timeInMills);
            driver.findElement(by).sendKeys(value);

        } catch (Throwable e) {
            System.out.println(name+" field isn't entered");
            Assert.fail(e.getMessage());

        }
    }
    public Alert findAlertPopUp(int TimeInSec)
    {
        try
        {
            return new WebDriverWait(driver, Duration.ofSeconds(TimeInSec)).until(ExpectedConditions.alertIsPresent());
        }
        catch (Throwable e)
        {
            return null;
        }
    }
    public Alert switchToAlertPopup()
    {
        try
        {
            return driver.switchTo().alert();
        }catch (Exception e)
        {
            System.out.println("Error switch to ALert popup "+e);
            return null;
        }
    }

}
