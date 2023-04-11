package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.SearchWithFilterPage;
import by.itacademy.alinadarenskikh.petfinder.ui.steps.SearchWithFilterStep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchWithFilterPageTest {
    WebDriver driver;
    SearchWithFilterStep searchStep;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        searchStep = new SearchWithFilterStep(new SearchWithFilterPage(driver));
        driver.get(searchStep.URL);
    }

   @Test
    public void findPerfectPetMatchTest()  {
       searchStep.searchForKittenWithLongHairAndFemaleGender();
       assertTrue(searchStep.getSearchResultText().endsWith(searchStep.expectedText),
               "Search result does not end with expected text: " + searchStep.expectedText);
    }

    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
