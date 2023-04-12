package by.itacademy.alinadarenskikh.petfinder.ui.pages;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchWithFilterPage {
    public static WebDriver driver = Driver.getDriver();
    Actions actions = new Actions(driver);


    public SearchWithFilterPage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public final String URL = "https://www.petfinder.com";
    public final String expectedText = "Long Hair Kitten Female";

    private final String GET_CAT_CARD = "//*[@class='petCard petCard_searchResult ']";
    private final String GENDER_SELECT_BUTTON = "//*[@class='filterList-list-chk-svg']";
    private final String COAT_SELECT_BUTTON = "//*[@class='filterList-list-qty u-hr7x']";
    private final By KITTEN_SELECT_BUTTON = By.cssSelector(".filterList-list-chk-label .filterList-list-chk-svg");
    private final By AGE_SELECT_BUTTON = By.xpath("//div[@id='age-select_List_Box_Btn']");

    @FindBy(className = "iconSearch")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[contains(text(),'Cats')]")
    private WebElement catsOption;

    @FindBy(xpath = "//button[contains(text(),'Find Pets!')]")
    private WebElement findPetsButton;

    @FindBy(id = "coat-select_List_Box_Btn")
    private WebElement coatSelectButton;

    @FindBy(xpath = "//*[@id='gender-select_List_Box_Btn']")
    private WebElement genderSelectButton;

    @FindBy(xpath = "//*[@class='hrArray hrArray_bulletDivided u-inlineBlock']")
    private WebElement searchResultText;

    public SearchWithFilterPage clickSearchIcon() {
        searchIcon.click();
        return this;
    }

    public SearchWithFilterPage clickCatsOption() {
        catsOption.click();
        findPetsButton.click();
        return this;
    }

    public SearchWithFilterPage selectAge() {

        Util.waitForElementLocatedBy(driver, AGE_SELECT_BUTTON).click();
        Util.waitForElementLocatedBy(driver, KITTEN_SELECT_BUTTON).click();

        return this;
    }

    public SearchWithFilterPage clickLongHairOption() {
        coatSelectButton.click();
        actions.pause(1000).perform();
        driver.findElements(By.xpath(COAT_SELECT_BUTTON)).get(3).click();
        return this;
    }

    public SearchWithFilterPage clickGenderSelectButton() {
        genderSelectButton.click();
        actions.pause(1000).perform();
        driver.findElements(By.xpath(GENDER_SELECT_BUTTON)).get(1).click();

        return this;
    }

    public SearchWithFilterPage clickSomeCat() {

        actions.pause(1000).perform();
        driver.findElements(By.xpath(GET_CAT_CARD)).get(3).click();
        actions.pause(1000).perform();
        return this;
    }

    public String getSearchResultText() {

        return searchResultText.getText();
    }
}
