package by.itacademy.alinadarenskikh.petfinder.ui.pages;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetfinderSearchPage {

    public static WebDriver driver = Driver.getDriver();

    public final String URL = "https://www.petfinder.com";
    final public By SEARCH_ANIMAL_TYPE = By.id("simpleSearchAnimalType");
    final public By SEARCH_LOCATION = By.id("simpleSearchLocation");
    final public By SEARCH_BUTTON = By.className("iconSearch");
    final public String LOCATION_KEY = "New York";
    final public String TYPE_OF_ANIMAL = "cat";
    final public String CURRENT_LOCATION = "//span[@data-test='Suggester_Current_Label']";
    public final String SEARCH_FORM_LOCATION_INPUT = "//input[@id='Interceptor_Form_Location']";

    public PetfinderSearchPage sendKeys(String animalType, String location) {
        driver.findElement(SEARCH_ANIMAL_TYPE).sendKeys(animalType);
        driver.findElement(SEARCH_LOCATION).sendKeys(location);
        driver.findElement(SEARCH_BUTTON).click();
        return this;
    }

    public boolean isAnimalTypeFound(String animalType) {
        List<WebElement> petCards = driver.findElements(By.cssSelector(".petCard-body-details-hdg .u-isVisuallyHidden"));
        for (WebElement petCard : petCards) {
            String currentAnimalType = petCard.getText();
            if (currentAnimalType.contains(animalType)) {
                return true;
            }
        }
        return false;
    }

    public PetfinderSearchPage closeSearchConfirmationForm(){

        driver.findElement(By.className("checkboxCard-bd-icon")).click();
        driver.findElement(By.xpath("//button[@data-test='Interceptor_Submit_Button']")).click();

        return this;
    }

    public PetfinderSearchPage getActualLocation(){
        driver.findElement(By.xpath(CURRENT_LOCATION));
        return this;
    }

    public List<WebElement> isSEarchResultEmpty(){
        return driver.findElements(By.className("petCard-body"));
    }
}
