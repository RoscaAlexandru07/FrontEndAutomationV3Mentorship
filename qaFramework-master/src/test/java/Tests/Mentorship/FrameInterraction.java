package Tests.Mentorship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class FrameInterraction {

    WebDriver driver;

    @Test
    public void FrameInterractionTest(){
        driver = new ChromeDriver();

        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        //List<WebElement> alertFrameWindowList = driver.findElements(By.xpath("//*[@class='element-list collapse show']//*[@class='btn btn-light ']"));
        //alertFrameWindowList.get(2).click();

        js.executeScript("window.scrollBy(0,400)");
        WebElement framesWindowsElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        framesWindowsElement.click();

        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);

        WebElement textFromFrame1Element = driver.findElement(By.id("sampleHeading"));
        String textFromFrame1 = textFromFrame1Element.getText();
        System.out.println("textul din iFrame1 este " + textFromFrame1);

        driver.switchTo().defaultContent();

        WebElement frame2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2);
        js.executeScript("window.scrollBy(200,200)");

        driver.switchTo().defaultContent();


        //js.executeScript("window.scrollBy(0,400)");
        //alertFrameWindowList.get(3).click();

        /*
        WebElement nestedFrame1 = driver.findElement(By.xpath("//iframe[@src=\"/sampleiframe\"]"));
        driver.switchTo().frame(nestedFrame1);

        WebElement nestedFrame2 = driver.findElement(By.xpath("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]"));
        driver.switchTo().frame(nestedFrame2);
        */

    }
}
