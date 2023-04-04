package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderSearchPage;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    WebDriver driver = Driver.getDriver();

    @BeforeEach
    public void setUp() {

        driver.get("https://www.petfinder.com");
       // petfinderStep = new PetfinderStep(driver);
    }

    @Test
    public void searchResultNotEmpty(){
   driver.findElement(PetfinderSearchPage.SEARCH_ANIMAL_TYPE).sendKeys("cat");
   driver.findElement(PetfinderSearchPage.SEARCH_LOCATION).sendKeys("New York");
   driver.findElement(PetfinderSearchPage.SEARCH_BUTTON).click();

   List<WebElement> petCards = Collections.singletonList(Util.waitForElementLocatedBy(driver, By.className("petCard-body")));
   assertFalse(petCards.isEmpty(), "Search results are empty");
    }

    @Test
    public void searchResultsContainCat() {
        driver.findElement(PetfinderSearchPage.SEARCH_ANIMAL_TYPE).sendKeys("cat");
        driver.findElement(PetfinderSearchPage.SEARCH_LOCATION).sendKeys("New York");
        driver.findElement(PetfinderSearchPage.SEARCH_BUTTON).click();

        List<WebElement> petCards = driver.findElements(By.cssSelector(".petCard-body-details-hdg .u-isVisuallyHidden"));

        for (WebElement petCard : petCards) {
            String animalType = petCard.getText();
            assertTrue(animalType.contains("Cat"), "Search results contain a cat animal");
        }
    }
    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
