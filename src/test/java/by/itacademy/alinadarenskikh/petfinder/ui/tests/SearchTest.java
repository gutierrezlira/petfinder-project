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


import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    WebDriver driver;
    PetfinderSearchPage searchPage;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        searchPage = new PetfinderSearchPage(driver);
        driver.get(searchPage.URL);
    }

   @Test
    public void searchResultNotEmpty(){
       searchPage
               .sendKeys("cat", "New York");

        assertFalse(searchPage.isSEarchResultEmpty().isEmpty(), "Search results are empty");
    }

 /*  @Test
    public void searchResultIsLocationIsCorrect() throws InterruptedException {
        searchPage
                .sendKeys("", "Mexico");
        WebElement actualLocation = driver.findElement(By.xpath(searchPage.CURRENT_LOCATION));

        try {
            Thread.sleep(3000); // ожидание 1 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualLocationText = actualLocation.getText();

        assertEquals(searchPage.LOCATION_KEY, actualLocationText);

        assertEquals(searchPage.LOCATION_KEY, actualLocation);
    }*/

    @Test
    public void searchResultsContainCat() {
        searchPage
                .sendKeys("cat", "New York");

            assertTrue(searchPage.getListOfSearchResult(), "Search results contain a cat animal");
        }

    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
