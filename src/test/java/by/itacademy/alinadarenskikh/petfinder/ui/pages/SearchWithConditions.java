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

public class SearchWithConditions {
    public static WebDriver driver = Driver.getDriver();
    Actions actions = new Actions(driver);


    public SearchWithConditions(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public final String URL = "https://www.petfinder.com";
    public final String expectedText = "Long Hair Kitten Female";

    @FindBy(className = "iconSearch")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[contains(text(),'Cats')]")
    private WebElement catsOption;

    @FindBy(xpath = "//button[contains(text(),'Find Pets!')]")
    private WebElement findPetsButton;

    @FindBy(id = "age-select_List_Box_Btn")
    private WebElement ageSelectButton;

    @FindBy(css = ".filterList-list-chk-label .filterList-list-chk-svg")
    private WebElement longHairOption;

    @FindBy(id = "coat-select_List_Box_Btn")
    private WebElement coatSelectButton;

    @FindBy(xpath = "//*[@class='filterList-list-qty u-hr7x'][4]")
    private WebElement kittenOption;

    @FindBy(xpath = "//*[@id='gender-select_List_Box_Btn']")
    private WebElement genderSelectButton;

    @FindBy(xpath = "//*[@class='filterList-list-chk-svg'][2]")
    private WebElement femaleOption;

    @FindBy(xpath = "//*[@class='petCard petCard_searchResult '][4]")
    private WebElement fourthPet;

    @FindBy(xpath = "//*[@class='hrArray hrArray_bulletDivided u-inlineBlock']")
    private WebElement searchResultText;

    public SearchWithConditions clickSearchIcon() {
        searchIcon.click();
        return this;
    }
    public SearchWithConditions clickCatsOption() {
       catsOption.click();
       findPetsButton.click();
        return this;
    }

    public SearchWithConditions selectAge() {

        Util.waitForElementLocatedBy(driver, By.xpath("//div[@id='age-select_List_Box_Btn']")).click();
        Util.waitForElementLocatedBy(driver, By.cssSelector(".filterList-list-chk-label .filterList-list-chk-svg")).click();

        return this;
    }


    public SearchWithConditions clickLongHairOption() {
        Util.waitForElementLocatedBy(driver, By.id("coat-select_List_Box_Btn")).click();

        actions.pause(1000).perform();
        driver.findElements(By.xpath("//*[@class='filterList-list-qty u-hr7x']")).get(3).click();
        return this;
    }

    public SearchWithConditions clickGenderSelectButton() {
        Util.waitForElementLocatedBy(driver, By.xpath("//*[@id='gender-select_List_Box_Btn']")).click();

        actions.pause(1000).perform();
        driver.findElements(By.xpath("//*[@class='filterList-list-chk-svg']")).get(1).click();
        return this;
    }

    public SearchWithConditions clickSomeCat(){

        actions.pause(1000).perform();
        driver.findElements(By.xpath("//*[@class='petCard petCard_searchResult ']")).get(3).click();
        actions.pause(1000).perform();
        return this;
    }
    public String getSearchResultText() {
        WebElement searchResultText = driver.findElement(By.xpath("//*[@class='hrArray hrArray_bulletDivided u-inlineBlock']"));

        return searchResultText.getText();
    }
}
