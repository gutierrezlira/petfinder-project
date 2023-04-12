package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    WebDriver driver = Driver.getDriver();

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(HomePage.URL);
    }

 /*   @AfterEach
    public void tearDown() {
        Driver.close();
    }*/
}
