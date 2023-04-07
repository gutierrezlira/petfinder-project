package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.FindYourBestMatchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindYourBestMatchTest {
    WebDriver driver;
    FindYourBestMatchPage matchPage;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        matchPage = new FindYourBestMatchPage();
        driver.get("https://www.petfinder.com/user/profile/create/?experience=loginAtEnd");

    }

/*    @Test
    public void findPerfectPetMatchTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'More...')]")).click();
        driver.findElement(By.xpath("//button[@id='options-trigger-1']//span[@class='inputField_inputField-value__wbXN5']")).click();
        driver.findElement(By.xpath())

        driver.findElement(By.xpath("//div[contains(text(),'done')]"));

    }*/




    @AfterEach
    public void tearDown(){
        {
            Driver.close();
        }
    }
}
