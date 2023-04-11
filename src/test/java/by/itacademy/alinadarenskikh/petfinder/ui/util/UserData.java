package by.itacademy.alinadarenskikh.petfinder.ui.util;

import com.github.javafaker.Faker;

public class UserData {
    static Faker faker = new Faker();
    public static final String VALID_PASSWORD = "hs6BmLKIgVrZuFmnV7bM";
    public static final String INVALID_PASSWORD = faker.internet().password(4, 10);
    public static final String VALID_LOGIN = "dawmond@mail.ru";
    public static final String INVALID_LOGIN = faker.internet().emailAddress();
    public static final String EXPECTED_USER_NAME = "Ali Na";
}
