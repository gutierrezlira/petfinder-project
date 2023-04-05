package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderSearchPage;
import by.itacademy.alinadarenskikh.petfinder.ui.steps.PetfinderSearchStep;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    WebDriver driver = Driver.getDriver();
    PetfinderSearchPage searchPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://www.petfinder.com");
        searchPage = new PetfinderSearchPage(driver);
    }

    @Test
    public void searchResultNotEmpty(){
    PetfinderSearchPage.sendKeys(PetfinderSearchPage.TYPE_OF_ANIMAL, PetfinderSearchPage.LOCATION_KEY);

   List<WebElement> petCards = Collections.singletonList(Util.waitForElementLocatedBy(driver, By.className("petCard-body")));
   assertFalse(petCards.isEmpty(), "Search results are empty");
    }

    @Test
    public void searchResultIsLocationIsCorrect() throws InterruptedException {
        driver.findElement(PetfinderSearchPage.SEARCH_ANIMAL_TYPE).sendKeys("cat");
        driver.findElement(PetfinderSearchPage.SEARCH_LOCATION).sendKeys("New York");
        driver.findElement(PetfinderSearchPage.SEARCH_BUTTON).click();

        String actualLocation = Util.waitForElementLocatedBy(driver, By.xpath(PetfinderSearchPage.CURRENT_LOCATION)).getText();
  Thread.sleep(5000);
        assertEquals(PetfinderSearchPage.LOCATION_KEY, actualLocation);
    }

    @Test
    public void searchResultsContainCat() {
        PetfinderSearchPage.sendKeys(PetfinderSearchPage.TYPE_OF_ANIMAL, PetfinderSearchPage.LOCATION_KEY);

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
