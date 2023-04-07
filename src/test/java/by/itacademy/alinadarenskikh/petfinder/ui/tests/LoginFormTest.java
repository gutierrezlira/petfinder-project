package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderPage;
import by.itacademy.alinadarenskikh.petfinder.ui.util.UserData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTest {
    WebDriver  driver;
    PetfinderPage petPage;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        petPage = new PetfinderPage(driver);

        driver.get(petPage.URL);
    }

    @Test
    @DisplayName("Verify Petfinder is open")
    public void testPetfinderOpen(){

        assertEquals(petPage.FOOTER_TEXT, petPage.getFooterText());
    }

     @Test
     @DisplayName("Verify valid login and password")
    public void testValidLoginValidPassword() {
        petPage
                .fillLoginForm(UserData.VALID_LOGIN, UserData.VALID_PASSWORD)
                 .clickSubmitLogInForm()
                 .getActualLogInProfileName();
        assertEquals(UserData.EXPECTED_USER_NAME, petPage.getActualLogInProfileName());
    }

    @Test
    @DisplayName("Verify invalid login")
    public void testInvalidLogin() {
        petPage
                .fillLoginForm(UserData.INVALID_LOGIN, UserData.VALID_PASSWORD)
                .clickSubmitLogInForm();

        assertEquals(petPage.ERROR_MESSAGE_TEXT, petPage.getErrorMassage());
    }

    @Test
    @DisplayName("Verify invalid password")
    public void testInvalidPassword() {
        petPage
                .fillLoginForm(UserData.VALID_LOGIN, UserData.INVALID_PASSWORD)
                .clickSubmitLogInForm();

        assertEquals(petPage.ERROR_MESSAGE_TEXT, petPage.getErrorMassage());
    }

  @Test
  @DisplayName("Verify empty fields")
  public void testEmptyFields() {
      assertEquals("Element is required", petPage.fillEmptyFields());
  }


    @AfterEach
    public void tearDown() {
    Driver.close();
    }
}
