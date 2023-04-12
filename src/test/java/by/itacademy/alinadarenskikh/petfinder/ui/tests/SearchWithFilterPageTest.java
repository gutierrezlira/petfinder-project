package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.pages.SearchWithFilterPage;
import by.itacademy.alinadarenskikh.petfinder.ui.steps.SearchWithFilterStep;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchWithFilterPageTest extends BaseTest {
    SearchWithFilterStep searchStep =new SearchWithFilterStep(new SearchWithFilterPage(driver));

   @Test
    public void findPerfectPetMatchTest()  {
       searchStep.searchForKittenWithLongHairAndFemaleGender();
       assertTrue(searchStep.getSearchResultText().endsWith(searchStep.expectedText),
               "Search result does not end with expected text: " + searchStep.expectedText);
    }
}
