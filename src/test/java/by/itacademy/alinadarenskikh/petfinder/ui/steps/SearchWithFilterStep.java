package by.itacademy.alinadarenskikh.petfinder.ui.steps;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderPage;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.SearchWithFilterPage;
import org.openqa.selenium.WebDriver;

public class SearchWithFilterStep extends SearchWithFilterPage {

    WebDriver driver;
    SearchWithFilterPage searchWithFilterPage;

    public SearchWithFilterStep(SearchWithFilterPage searchPage) {
        //super(driver);
        super(Driver.getDriver());
        this.searchWithFilterPage = searchPage;
    }

    public SearchWithFilterStep searchForKittenWithLongHairAndFemaleGender() {
        clickSearchIcon()
                .clickCatsOption()
                .selectAge()
                .clickLongHairOption()
                .clickGenderSelectButton()
                .clickSomeCat();

        return this;
    }

    public String getSearchResult() {
        return getSearchResultText();
    }
}
