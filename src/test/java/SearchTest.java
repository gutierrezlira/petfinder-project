import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import petfinder.ui.driver.Driver;
import petfinder.ui.pages.PetfinderSearchPage;
import petfinder.ui.steps.PetfinderStep;
import petfinder.ui.waits.Util;

import java.util.List;

public class SearchTest {
    WebDriver driver = Driver.getDriver();

    @BeforeEach
    public void setUp() {

        driver.get("https://www.petfinder.com");
       // petfinderStep = new PetfinderStep(driver);
    }

    @Test
    public void searchResultNotEmpty(){
   driver.findElement(PetfinderSearchPage.SEARCH_ANIMAL_TYPE).sendKeys("cat");
   driver.findElement(PetfinderSearchPage.SEARCH_LOCATION).sendKeys("New York");
   driver.findElement(PetfinderSearchPage.SEARCH_BUTTON).click();

        Util.waitForElementLocatedBy(driver, By.className("petCard-body"));





    }
}
