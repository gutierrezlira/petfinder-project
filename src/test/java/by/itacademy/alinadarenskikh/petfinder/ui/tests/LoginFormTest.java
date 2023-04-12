package by.itacademy.alinadarenskikh.petfinder.ui.tests;

import by.itacademy.alinadarenskikh.petfinder.ui.steps.PetfinderPageSteps;
import org.junit.jupiter.api.*;
import by.itacademy.alinadarenskikh.petfinder.ui.util.UserData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTest extends BaseTest{
    PetfinderPageSteps pageSteps = new PetfinderPageSteps();;

    @Test
    @DisplayName("Verify Petfinder is open")
    public void testPetfinderOpen(){

        assertEquals(pageSteps.FOOTER_TEXT, pageSteps.getFooterText());
    }

     @Test
     @DisplayName("Verify valid login and password")
    public void testValidLoginValidPassword() {
        pageSteps
                 .fillLoginForm(UserData.VALID_LOGIN, UserData.VALID_PASSWORD)
                 .clickSubmitLogInForm()
                 .getActualLogInProfileName();
        assertEquals(UserData.EXPECTED_USER_NAME, pageSteps.getActualLogInProfileName());
    }

    @Test
    @DisplayName("Verify invalid login")
    public void testInvalidLogin() {
        pageSteps
                .fillLoginForm(UserData.INVALID_LOGIN, UserData.VALID_PASSWORD)
                .clickSubmitLogInForm();

        assertEquals(pageSteps.ERROR_MESSAGE_TEXT, pageSteps.getErrorMassage());
    }

    @Test
    @DisplayName("Verify invalid password")
    public void testInvalidPassword() {
        pageSteps
                .fillLoginForm(UserData.VALID_LOGIN, UserData.INVALID_PASSWORD)
                .clickSubmitLogInForm();

        assertEquals(pageSteps.ERROR_MESSAGE_TEXT, pageSteps.getErrorMassage());
    }

  @Test
  @DisplayName("Verify empty fields")
  public void testEmptyFields() {

        assertEquals("Element is required", pageSteps.fillEmptyFields());
  }

}
