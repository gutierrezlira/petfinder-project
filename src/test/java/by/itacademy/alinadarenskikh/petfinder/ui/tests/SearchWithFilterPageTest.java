package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.pages.SearchWithFilterPage;
import by.itacademy.alinadarenskikh.petfinder.ui.steps.SearchWithFilterStep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests for Search With Filter Page")
public class SearchWithFilterPageTest extends BaseTest {
    SearchWithFilterStep searchStep = new SearchWithFilterStep(new SearchWithFilterPage(driver));

   @Test
   @DisplayName("Find perfect pet match with parameters")
    public void findPerfectPetMatchTest()  {
       searchStep.searchForKittenWithLongHairAndFemaleGender();
       assertTrue(searchStep.getSearchResultText().endsWith(searchStep.expectedText),
               "Search result does not end with expected text: " + searchStep.expectedText);
    }
}
