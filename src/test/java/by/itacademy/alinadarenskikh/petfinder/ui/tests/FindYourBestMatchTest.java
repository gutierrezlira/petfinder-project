package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.SearchWithConditions;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindYourBestMatchTest {
    WebDriver driver;
    SearchWithConditions searchPage;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        searchPage = new SearchWithConditions(driver);
        driver.get("https://www.petfinder.com");

    }

   @Test
    public void findPerfectPetMatchTest()  {
       searchPage
        .clickSearchIcon()
       .clickCatsOption()
       .selectAge()
       .clickLongHairOption()
       .clickGenderSelectButton()
       .clickSomeCat();

       String expectedText = "Long Hair Kitten Female";
       assertTrue(searchPage.getSearchResultText().endsWith(expectedText), "Search result does not end with expected text: " + expectedText);

    }

    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
