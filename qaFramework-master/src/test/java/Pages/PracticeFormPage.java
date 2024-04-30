package Pages;

import Logger.LoggerUtility;
import ObjectData.PracticeFormObject;
import ObjectData.WebTableObject;
import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.security.Key;
import java.util.HashMap;
import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstNameElement;

    @FindBy(id = "lastName")
    WebElement lastNameElement;

    @FindBy(id = "userEmail")
    WebElement emailElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderElement;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthElement;

    @FindBy(xpath = "//*[@class='react-datepicker__month-select']")
    WebElement monthElement;

    @FindBy(xpath = "//*[@class='react-datepicker__year-select']")
    WebElement yearElement;

    @FindBy(xpath = "//*[@class='react-datepicker__month']")
    WebElement dayElement;
    @FindBy(id = "userNumber")
    WebElement mobileNumber;

    @FindBy(xpath = "//*[@id='subjectsContainer']")
    WebElement subjectsElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportsElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicElement;

    @FindBy(id = "uploadPicture")
    WebElement uploadPhoto;
    @FindBy(id = "currentAddress")
    WebElement currentAddressElement;

    @FindBy(id = "state")
    WebElement stateElement;

    @FindBy(id = "city")
    WebElement cityElement;

    @FindBy(id = "submit")
    WebElement submitElement;

    @FindBy(className = "modal-body")
    WebElement table;



    public void completeFirstRegion(PracticeFormObject practiceFormObject) {
        elementMethods.fillElement(firstNameElement, practiceFormObject.getFirstName());
        elementMethods.fillElement(lastNameElement, practiceFormObject.getLastName());
        elementMethods.fillElement(emailElement, practiceFormObject.getEmail());
        elementMethods.fillElement(mobileNumber, practiceFormObject.getMobile());

    }

    public void clickOnGenderType(PracticeFormObject practiceFormObject) {

        switch (practiceFormObject.getGender()){
            case "Male":
                elementMethods.clickElement(maleGenderElement);
                break;
            case "Female":
                elementMethods.clickElement(femaleGenderElement);
                break;
            case "Other":
                elementMethods.clickElement(otherGenderElement);
                break;
        }
    }


    public void completeCalendar(PracticeFormObject practiceFormObject){

        elementMethods.clickElement(dateOfBirthElement);
        elementMethods.selectByText(monthElement,practiceFormObject.getMonth());
        elementMethods.selectByValue(yearElement, practiceFormObject.getYear());

        String value = practiceFormObject.getDate();
        WebElement date = driver.findElement(By.xpath("//div[@class='react-datepicker__week']/*[not(contains(@class,'outside-month'))][text()="+value+"]"));
        elementMethods.clickElement(date);
    }

    public void completeSecondRegion(PracticeFormObject practiceFormObject)  {
        elementMethods.clickElement(subjectsElement);
        elementMethods.fillUsingActions(subjectsElement, practiceFormObject.getSubjects());
        elementMethods.fillElement(currentAddressElement, practiceFormObject.getCurrentaddress());

    }

    public void hobbiesHandle(PracticeFormObject practiceFormObject){

        for(String hobbiesarray : practiceFormObject.getHobbies()){
            if(hobbiesarray.contains("Sports")) {
                elementMethods.clickElement(sportsElement);
            } else if (hobbiesarray.contains("Reading")) {
                elementMethods.clickElement(readingElement);
            } else if (hobbiesarray.contains("Music")) {
                elementMethods.clickElement(musicElement);
            }
        }
    }

    public void uploadPhotoMethod(){
        String filePath = "C:\\Users\\ovrosca\\Downloads\\practiceForm\\practiceform-main\\qaPracticeForm\\qaFramework-master\\qaFramework-master\\src\\test\\resources\\inputData\\photo.png";
        uploadPhoto.sendKeys(filePath);
    }

    public void completeStateAndCity(PracticeFormObject practiceFormObject){
        elementMethods.clickElement(stateElement);
        elementMethods.fillUsingActions(stateElement, practiceFormObject.getState());
        elementMethods.waitVisibleElement(cityElement);
        elementMethods.clickElement(cityElement);
        elementMethods.fillUsingActions(cityElement, practiceFormObject.getCity());

    }

    public void submmit(){
        submitElement.submit();
    }


    public void validateTableContent(PracticeFormObject practiceFormObject){


        String fullName = practiceFormObject.getFirstName() + " " + practiceFormObject.getLastName();
        String stateAndCity = practiceFormObject.getState() + " " + practiceFormObject.getCity();
        String date = practiceFormObject.getDate() + " " + practiceFormObject.getMonth() + "," + practiceFormObject.getYear();
        String photo = uploadPhoto.getText();

        Assert.assertTrue(table.isDisplayed());
        String rowContent = table.getText();

        Assert.assertTrue(rowContent.contains(fullName));
        Assert.assertTrue(rowContent.contains(practiceFormObject.getEmail()));
        Assert.assertTrue(rowContent.contains(practiceFormObject.getGender()));
        Assert.assertTrue(rowContent.contains(practiceFormObject.getMobile()));
        Assert.assertTrue(rowContent.contains(date));
        Assert.assertTrue(rowContent.contains(photo));
        Assert.assertTrue(rowContent.contains(practiceFormObject.getSubjects()));
       // Assert.assertTrue(rowContent.contains(practiceFormObject.getHobbies()));
        Assert.assertTrue(rowContent.contains(practiceFormObject.getCurrentaddress()));
        Assert.assertTrue(rowContent.contains(stateAndCity));









    }
}


