package by.itacademy.alinadarenskikh.petfinder.ui.steps;

import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderPage;
import by.itacademy.alinadarenskikh.petfinder.ui.util.FillLogInForm;
import by.itacademy.alinadarenskikh.petfinder.ui.util.UserData;
import by.itacademy.alinadarenskikh.petfinder.ui.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



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

        PetfinderPage.fillLoginForm(UserData.VALID_LOGIN, UserData.VALID_PASSWORD);
        WebElement userNameLabel = driver.findElement(By.xpath(PetfinderPage.PROFILE_VERIFICATION_BUTTON));

        return userNameLabel.getText();
    }

    public String invalidLogin(){

        PetfinderPage.fillLoginForm(UserData.INVALID_LOGIN, UserData.VALID_PASSWORD);
        String actualUserName = Util.waitForElementLocatedBy(driver, By.xpath(PetfinderPage.LOGIN_AND_PASSWORD_ERROR_MESSAGE)).getText();

       return actualUserName;
    }

    public String invalidPassword(){

        PetfinderPage.fillLoginForm(UserData.VALID_LOGIN, UserData.INVALID_PASSWORD);

        WebElement userNameLabel = driver.findElement(By.xpath(PetfinderPage.LOGIN_AND_PASSWORD_ERROR_MESSAGE));
        String actualUserName = userNameLabel.getText();

        return actualUserName;
    }

    public String fillEmptyFields(){

        PetfinderPage.fillLoginForm("", "");

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
