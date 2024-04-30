package Tests.Mentorship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StructuriAlternativeInAutomation {

    WebDriver driver;

    @Test
    public void metodaTest(){
        driver = new ChromeDriver();

        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        WebElement formElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceformElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceformElement.click();


        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String gender = "Male";

//        if (gender.equals("Male")) {
//            maleElement.click();
//        } else if (gender.equals("Female")) {
//            femaleElement.click();
//        } else if (gender.equals("Other")) {
//            otherElement.click();
//        }

        switch (gender){
            case "Male":
                maleElement.click();
                break;
            case "Female":
                femaleElement.click();
                break;
            case "Other":
                otherElement.click();
                break;
        }


    }
}
