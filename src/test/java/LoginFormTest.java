import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import petfinder.ui.driver.Driver;
import petfinder.ui.pages.PetfinderPage;
import petfinder.ui.steps.PetfinderStep;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTest {
    WebDriver  driver = Driver.getDriver();
    private PetfinderStep petfinderStep;

    @BeforeEach
    public void setUp() {

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
        assertEquals(PetfinderPage.EXPECTED_USER_NAME, petfinderStep.checkValidLoginAndPassword());
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
