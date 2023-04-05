package by.itacademy.alinadarenskikh.petfinder.ui.pages;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PetfinderSearchPage {
    static WebDriver driver;

    public PetfinderSearchPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.petfinder.com/");
    }

    final static public By  SEARCH_ANIMAL_TYPE = By.id("simpleSearchAnimalType");
    final static public By SEARCH_LOCATION = By.id("simpleSearchLocation");
    final static public By SEARCH_BUTTON = By.className("iconSearch");
    final static public String LOCATION_KEY = "New York";
    final static public String TYPE_OF_ANIMAL = "cat";
    final static public String CURRENT_LOCATION = "//*[@data-test ='Suggester_Current_Label']";

    public static void sendKeys(String animalType, String location) {
        driver.findElement(SEARCH_ANIMAL_TYPE).sendKeys(animalType);
        driver.findElement(SEARCH_LOCATION).sendKeys(location);
        driver.findElement(SEARCH_BUTTON).click();
    }

}
