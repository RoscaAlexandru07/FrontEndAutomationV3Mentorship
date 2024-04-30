package Tests.Mentorship;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlertInterraction {

    WebDriver driver;

    @Test
    public void AlertTests(){

        driver = new ChromeDriver();

        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        List<WebElement> alertFrameWindowList = driver.findElements(By.xpath("//*[@class='element-list collapse show']//*[@class='btn btn-light ']"));
        alertFrameWindowList.get(1).click();

        WebElement alertElement = driver.findElement(By.id("alertButton"));
        alertElement.click();
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        WebElement alert5SecondElement = driver.findElement(By.id("timerAlertButton"));
        alert5SecondElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertOk5Second = driver.switchTo().alert();
        alertOk5Second.accept();

        WebElement alertConfirm = driver.findElement(By.id("confirmButton"));
        alertConfirm.click();
        Alert alertCancel = driver.switchTo().alert();
        alertCancel.dismiss();

        WebElement promptAlert = driver.findElement(By.id("promtButton"));
        promptAlert.click();
        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("alex");
        alertPrompt.accept();
    }
}
