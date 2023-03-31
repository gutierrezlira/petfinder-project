package petfinder.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import petfinder.ui.driver.Driver;
import petfinder.ui.pages.PetfinderSearchPage;
import petfinder.ui.util.Util;

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

        List<WebElement> petCards = driver.findElements(By.className("u-isVisuallyHidden"));

        System.out.println(petCards);

        for (WebElement petCard : petCards) {
           // Util.waitForElementLocatedBy(driver, By.className("u-isVisuallyHidden"));
            String animalType = petCard.findElement(By.className("u-isVisuallyHidden")).getText();
            assertTrue(animalType.contains("cat"), "Search results contain a non-cat animal");
        }
    }
    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
