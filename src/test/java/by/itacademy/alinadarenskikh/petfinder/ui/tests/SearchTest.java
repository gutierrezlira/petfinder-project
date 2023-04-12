package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderSearchPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest extends BaseTest {
    PetfinderSearchPage searchPage = new PetfinderSearchPage();

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
}
