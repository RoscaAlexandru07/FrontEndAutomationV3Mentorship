package Tests.Mentorship;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindowTabInterraction {

    WebDriver driver;
    @Test
    public void testsFramesWindowTabAlertWaits() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        //List<WebElement> alertFrameWindowList = driver.findElements(By.xpath("//*[@class='element-list collapse show']//*[@class='btn btn-light ']"));
        //alertFrameWindowList.get(0).click();

        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        //new tab
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        WebElement newTabTextElement = driver.findElement(By.id("sampleHeading"));
        String newTabText = newTabTextElement.getText();
        System.out.println("Textul din new tab este " + newTabText);
        driver.close();
        driver.switchTo().window(tabsList.get(0));

        //new window
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        WebElement newWindowTextElement = driver.findElement(By.id("sampleHeading"));
        String newWindowText = newWindowTextElement.getText();
        System.out.println("Textul din new window este " + newWindowText);
        driver.close();
        driver.switchTo().window(windowList.get(0));

        //new window message
        /*WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        newWindowMessage.click();
        List<String> windowMessageList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowMessageList.get(1));
        WebElement body = driver.findElement(By.tagName("body"));
        String message = body.getText();
        System.out.println(message);
        driver.close();
        driver.switchTo().window(windowMessageList.get(0));
*/
    }
}
