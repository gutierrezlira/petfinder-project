package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderSearchPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest extends BaseTest {
    PetfinderSearchPage searchPage = new PetfinderSearchPage();


    @Test
    @DisplayName("Search results contain dog")

    public void searchResultsContainDog() {
        searchPage.sendKeys("Dog", "New York");
        searchPage.closeSearchConfirmationForm();

        boolean dogFound = searchPage.isAnimalTypeFound("Dog");
        assertTrue(dogFound, "Search results contain a dog animal");
    }
}
