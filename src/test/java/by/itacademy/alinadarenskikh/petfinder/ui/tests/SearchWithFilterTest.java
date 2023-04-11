package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.SearchWithFilterConditionsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchWithFilterTest {
    WebDriver driver;
    SearchWithFilterConditionsPage searchPage;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        searchPage = new SearchWithFilterConditionsPage(driver);
        driver.get(searchPage.URL);
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

       assertTrue(searchPage.getSearchResultText().endsWith(searchPage.expectedText),
               "Search result does not end with expected text: " + searchPage.expectedText);
    }

    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
