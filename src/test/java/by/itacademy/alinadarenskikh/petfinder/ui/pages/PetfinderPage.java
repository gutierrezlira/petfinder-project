package by.itacademy.alinadarenskikh.petfinder.ui.pages;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PetfinderPage {

    public static WebDriver driver = Driver.getDriver();
    public PetfinderPage(WebDriver driver){
        this.driver = driver;
    }


    public  final String URL="https://www.petfinder.com";
    public final String FOOTER_TEXT = "©2023 Petfinder.com";
    private String LOGIN_FORM = "//*[@id='react_menu-profile']/ul/li[2]/a";
    //"//div[@class='mobileMenu-footer']//a[contains(text(),'Log In')]"; #react_menu-profile  a[href$="/"]
    private String PROFILE_VERIFICATION_BUTTON = "//button[@class='header-inner-profile-accountBtn']";
    private String FOOTER_XPATH = "//*[contains(text(),'©2023 Petfinder')]";
    private String LOGIN_AND_PASSWORD_ERROR_MESSAGE ="//div[@data-test='Login_Error_Message']";
    public final String ERROR_MESSAGE_TEXT = "There was an error logging you into your account. Please try again. If you continue to have trouble logging in, your account may be locked. Your account is locked for 30 minutes after 5 incorrect login attempts. Recover your password.";


    public  String getFooterText(){

        return driver.findElement(By.xpath(FOOTER_XPATH)).getText();
    }
    public  PetfinderPage fillLoginForm(String email, String password) {
        Util.waitForElementLocatedBy(driver, By.xpath(LOGIN_FORM)).click();

                driver.findElement(By.id("Login_Page_username")).sendKeys(email);
                driver.findElement(By.id("Login_Page_password")).sendKeys(password);
    return this;
    }

    public PetfinderPage clickSubmitLogInForm(){
        driver.findElement(By.id("Login_Page_submit")).click();
        return this;
    }

    public String getActualLogInProfileName() {
       String actualName = Util.waitForElementLocatedBy(driver, By.xpath(PROFILE_VERIFICATION_BUTTON)).getText();
        return actualName;
    }

    public String getErrorMassage(){
        String errorEntranceText = Util.waitForElementLocatedBy(driver, By.xpath(LOGIN_AND_PASSWORD_ERROR_MESSAGE)).getText();
        return errorEntranceText;
    }

    public String fillEmptyFields(){

        fillLoginForm("", "");

        WebElement inputElement = driver.findElement(By.id("Login_Page_username"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isRequired = (Boolean)js.executeScript("return arguments[0].required;", inputElement);
        if(isRequired)
        {
            return "Element is required";
        }
        return "Fields are filled";
    }
}
