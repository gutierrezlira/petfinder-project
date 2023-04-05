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

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    WebDriver driver;
    PetfinderSearchPage searchPage;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
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
    public void searchResultIsLocationIsCorrect() {
        PetfinderSearchPage.sendKeys(PetfinderSearchPage.TYPE_OF_ANIMAL, PetfinderSearchPage.LOCATION_KEY);

        WebElement actualLocation = driver.findElement(By.xpath(PetfinderSearchPage.CURRENT_LOCATION));

        assertEquals(PetfinderSearchPage.LOCATION_KEY, actualLocation.getText());
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
