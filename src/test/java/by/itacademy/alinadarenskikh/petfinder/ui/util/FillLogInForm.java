package by.itacademy.alinadarenskikh.petfinder.ui.util;

import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillLogInForm {
    public WebDriver driver;

    public FillLogInForm(WebDriver driver) {
        this.driver = driver;
    }
    public void fillLoginForm(String email, String password) {
        Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_FORM)).click();

        WebElement emailField = driver.findElement(By.id("Login_Page_username"));
        WebElement passwordField = driver.findElement(By.id("Login_Page_password"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }
}
