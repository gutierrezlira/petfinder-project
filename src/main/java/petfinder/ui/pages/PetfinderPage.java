package petfinder.ui.pages;

public class PetfinderPage {

    public static final String URL="https://www.petfinder.com";
    public static final String FOOTER_TEXT = "©2023 Petfinder.com";
    public static final String LOGIN_FORM = "//*[@id='react_menu-profile']/ul/li[2]/a";
    //"//div[@class='mobileMenu-footer']//a[contains(text(),'Log In')]"; #react_menu-profile  a[href$="/"]
    public static final String PROFILE_VERIFICATION_BUTTON = "//button[@class='header-inner-profile-accountBtn']";
    public static final String FOOTER_XPATH = "//*[contains(text(),'©2023 Petfinder')]";
    public static final String LOGIN_AND_PASSWORD_ERROR_MESSAGE ="//div[@data-test='Login_Error_Message']";
    public static final String LOGIN_ERROR_MESSAGE_TEXT = "There was an error logging you into your account. Please try again. If you continue to have trouble logging in, your account may be locked. Your account is locked for 30 minutes after 5 incorrect login attempts. Recover your password.";
    public static final String PASSWORD_ERROR_MESSAGE_TEXT = "There was an error logging you into your account. Please try again. If you continue to have trouble logging in, your account may be locked. Your account is locked for 30 minutes after 5 incorrect login attempts. Recover your password.";

}
