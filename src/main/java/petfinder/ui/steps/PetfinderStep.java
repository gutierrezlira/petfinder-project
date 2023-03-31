package petfinder.ui.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import petfinder.ui.pages.PetfinderPage;
import petfinder.ui.util.Util;


public class PetfinderStep {
    public WebDriver driver;

   public PetfinderStep(WebDriver driver) {
        this.driver = driver;
    }

    public String getFooterText(){

        WebElement footer = driver.findElement(By.xpath(PetfinderPage.FOOTER_XPATH));
        return footer.getText();
    }

    public String checkValidLoginAndPassword() {

        // Fill in login and password fields
        WebElement loginForm = Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_FORM));
        loginForm.click();
        WebElement emailField = driver.findElement(By.id("Login_Page_username"));
        WebElement passwordField = driver.findElement(By.id("Login_Page_password"));

        emailField.sendKeys(PetfinderPage.VALID_LOGIN);
        passwordField.sendKeys(PetfinderPage.VALID_PASSWORD);

        // Click on the "Log In" button
        driver.findElement(By.id("Login_Page_submit")).click();

        // Check for successful login
        WebElement userNameLabel = driver.findElement(By.xpath(PetfinderPage.PROFILE_VERIFICATION_BUTTON));

        return userNameLabel.getText();
    }

    public String invalidLogin(){

        // Fill in login and password fields
        Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_FORM)).click();

        WebElement emailField = driver.findElement(By.id("Login_Page_username"));
        WebElement passwordField = driver.findElement(By.id("Login_Page_password"));
        emailField.sendKeys(PetfinderPage.INVALID_LOGIN);
        passwordField.sendKeys(PetfinderPage.VALID_PASSWORD);

        // Click on the "Log In" button
        driver.findElement(By.id("Login_Page_submit")).click();

        // Check for login error message
        String actualUserName = Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_AND_PASSWORD_ERROR_MESSAGE)).getText();

       return actualUserName;
    }

    public String invalidPassword(){

        // Fill in login and password fields
        Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_FORM)).click();

        WebElement emailField = driver.findElement(By.id("Login_Page_username"));
        WebElement passwordField = driver.findElement(By.id("Login_Page_password"));
        emailField.sendKeys("dawmond@mail.ru");
        passwordField.sendKeys("000000");

        // Click on the "Log In" button
        driver.findElement(By.id("Login_Page_submit")).click();

        // Check for password error message
        WebElement userNameLabel = driver.findElement(By.xpath(PetfinderPage.LOGIN_AND_PASSWORD_ERROR_MESSAGE));
        String actualUserName = userNameLabel.getText();

        return actualUserName;
    }

    public String fillEmptyFields(){
        Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_FORM)).click();

        WebElement emailField = driver.findElement(By.id("Login_Page_username"));
        WebElement passwordField = driver.findElement(By.id("Login_Page_password"));
        emailField.sendKeys("");
        passwordField.sendKeys("");

        // Нажатие кнопки "Войти"
        driver.findElement(By.id("Login_Page_submit")).click();

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
