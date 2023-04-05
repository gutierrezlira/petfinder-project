package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.FindYourBestMatchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class FindYourBestMatchTest {
    WebDriver driver;
   // private PetfinderStep petfinderStep;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("https://www.petfinder.com");
       // petfinderStep = new PetfinderStep(driver);
    }

    @Test
    public static void findPerfectPetMatchTest(){



    }




    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
