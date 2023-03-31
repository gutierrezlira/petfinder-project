package petfinder.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetfinderAPITest {
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
    @DisplayName("Test getting dogs in a specific location")
    public void testGetDogsInSpecificLocation() {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("type", "dog")
                .queryParam("location", "90210")
                .when()
                .get("/v2/animals")
                .then()
                .statusCode(200);
    }
}
