package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderPage;
import by.itacademy.alinadarenskikh.petfinder.ui.steps.PetfinderStep;
import by.itacademy.alinadarenskikh.petfinder.ui.util.UserData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTest {
    WebDriver  driver;
    private PetfinderStep petfinderStep;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("https://www.petfinder.com");
        petfinderStep = new PetfinderStep(driver);
    }

    @Test
    @DisplayName("Verify Petfinder is open")
    public void testPetfinderOpen(){
       assertEquals(PetfinderPage.FOOTER_TEXT, petfinderStep.getFooterText());
    }

     @Test
     @DisplayName("Verify valid login and password")
    public void testValidLoginValidPassword() {
        assertEquals(UserData.EXPECTED_USER_NAME, petfinderStep.checkValidLoginAndPassword());
    }

    @Test
    @DisplayName("Verify invalid login")
    public void testInvalidLogin() {
        assertEquals(PetfinderPage.LOGIN_ERROR_MESSAGE_TEXT, petfinderStep.invalidLogin());
    }

    @Test
    @DisplayName("Verify invalid password")
    public void testInvalidPassword() {
        assertEquals(PetfinderPage.PASSWORD_ERROR_MESSAGE_TEXT, petfinderStep.invalidPassword());
    }

  @Test
  @DisplayName("Verify empty fields")
  public void testEmptyFields() {
      assertEquals("Element is required", petfinderStep.fillEmptyFields());
  }

    @AfterEach
    public void tearDown() {
    Driver.close();
    }
}
