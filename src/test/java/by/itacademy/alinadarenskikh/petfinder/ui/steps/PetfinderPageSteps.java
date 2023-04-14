package by.itacademy.alinadarenskikh.petfinder.ui.steps;

import by.itacademy.alinadarenskikh.petfinder.ui.driver.Driver;
import by.itacademy.alinadarenskikh.petfinder.ui.pages.PetfinderPage;


public class PetfinderPageSteps extends PetfinderPage {

       private final PetfinderPage petfinderPage;

        public PetfinderPageSteps() {
            super(Driver.getDriver());
            this.petfinderPage = new PetfinderPage(driver);
        }


    public String getFooterText() {
        return petfinderPage.getFooterText();
    }

    public PetfinderPageSteps fillLoginForm(String email, String password) {
        petfinderPage.fillLoginForm(email, password);

        return this;
    }

    public PetfinderPageSteps clickSubmitLogInForm() {
        petfinderPage.clickSubmitLogInForm();
        return this;
    }

    public String getActualLogInProfileName() {
        return petfinderPage.getActualLogInProfileName();
    }

    public String getErrorMassage() {
        return petfinderPage.getErrorMassage();
    }

    public String fillEmptyFields() {
        return petfinderPage.fillEmptyFields();
    }

}
