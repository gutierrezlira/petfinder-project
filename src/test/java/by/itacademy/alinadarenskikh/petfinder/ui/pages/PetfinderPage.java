package by.itacademy.alinadarenskikh.petfinder.ui.pages;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PetfinderPage {

    public static WebDriver driver = Driver.getDriver();

    public static final String URL="https://www.petfinder.com";
    public static final String FOOTER_TEXT = "©2023 Petfinder.com";
    public static final String LOGIN_FORM = "//*[@id='react_menu-profile']/ul/li[2]/a";
    //"//div[@class='mobileMenu-footer']//a[contains(text(),'Log In')]"; #react_menu-profile  a[href$="/"]
    public static final String PROFILE_VERIFICATION_BUTTON = "//button[@class='header-inner-profile-accountBtn']";
    public static final String FOOTER_XPATH = "//*[contains(text(),'©2023 Petfinder')]";
    public static final String LOGIN_AND_PASSWORD_ERROR_MESSAGE ="//div[@data-test='Login_Error_Message']";
    public static final String LOGIN_ERROR_MESSAGE_TEXT = "There was an error logging you into your account. Please try again. If you continue to have trouble logging in, your account may be locked. Your account is locked for 30 minutes after 5 incorrect login attempts. Recover your password.";
    public static final String PASSWORD_ERROR_MESSAGE_TEXT = "There was an error logging you into your account. Please try again. If you continue to have trouble logging in, your account may be locked. Your account is locked for 30 minutes after 5 incorrect login attempts. Recover your password.";


    public static void fillLoginForm(String email, String password) {
        Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_FORM)).click();

        WebElement emailField = driver.findElement(By.id("Login_Page_username"));
        WebElement passwordField = driver.findElement(By.id("Login_Page_password"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        driver.findElement(By.id("Login_Page_submit")).click();
    }

    public static String getConfirmationData(WebDriver driver, By by) {
        String actualUserName = Util.waitForElementLocatedBy(driver, by).getText();
        return actualUserName;
    }

}
