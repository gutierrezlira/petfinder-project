package by.itacademy.alinadarenskikh.petfinder.api.tests;

import by.itacademy.alinadarenskikh.petfinder.api.token.PetfinderGetToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetfinderAPITest {
    public static final String VALID_PASSWORD ="hs6BmLKIgVrZuFmnV7bM";
    public static final String VALID_LOGIN = "dawmond@mail.ru";
    private static String accessToken;

    @BeforeAll
    public static void setUp() throws Exception {
        accessToken = PetfinderGetToken.GetToken();
        RestAssured.baseURI = "https://api.petfinder.com";
    }

    @Test
    @DisplayName("Test if API key is valid")
    public void testAPIKeyIsValid() {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/v2/animals")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Test logging in")
    public void testLogIn() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", "dawmond@mail.ru")
                .formParam("Password", "hs6BmLKIgVrZuFmnV7bM")
                .when()
                .post("https://www.petfinder.com/user/login/")
                .then()
                .statusCode(200)
                .log().headers();
    }

    @Test
    @DisplayName("Test loggin with invalid data")
    public void testInvalidLogIn() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", "damond@mil.ru")
                .formParam("Password", "0000")
                .when()
                .post("https://www.petfinder.com/user/login/")
                .then()
                .statusCode(401)
                .log().headers();
    }

    @Test
    @DisplayName("Test getting pets")
    public void testGetPets() {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/v2/animals")
                .then()
                .statusCode(200)
                .body("animals.size()", greaterThan(0))
                .body("animals[0].name", notNullValue());
    }
    @Test
    @DisplayName("Test getting list of 5 pets")
    public void testGetPetsList() {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/v2/animals")
                .then()
                .statusCode(200)
                .body("animals.size()", greaterThan(0))
                .body("animals[0].name", notNullValue())
                .log().all();

        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/v2/animals");

        List<String> petNames = response.path("animals.name");
        int numPetsToPrint = 5;
        for (int i = 0; i < Math.min(numPetsToPrint, petNames.size()); i++) {
            System.out.println("Pet " + (i + 1) + ": " + petNames.get(i));
        }
    }

    @Test
    @DisplayName("Test getting dogs in a specific location")
    public void testGetDogsInSpecificLocation() {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("type", "dog")
                .queryParam("location", "90210")
                .when()
                .get("/v2/animals")
                .then()
                .statusCode(200)
                .log().body()
                .body("animals[0].type", equalTo("Dog"))
                .body("animals[1].type", equalTo("Dog"))
                .body("animals[2].type", equalTo("Dog"))
                .body("animals[3].type", equalTo("Dog"))
                .body("animals[4].type", equalTo("Dog"));
        //.body("animals[].type", everyItem(equalTo("Dog")))
    }

    @ParameterizedTest
    @CsvSource({
            "Young, bird, 10",
            "Adult, cat, 10",
            "Senior, dog, 10"
    })
    public void testQuery(String age, String animal, int count) {

        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("age", age)
                .queryParam("type", animal)
                .queryParam("limit", count)
                .get("/v2/animals");

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getBody().jsonPath().getList("animals"));
        Assertions.assertTrue(response.getBody().jsonPath().getList("animals").size() <= count);
    }

}
