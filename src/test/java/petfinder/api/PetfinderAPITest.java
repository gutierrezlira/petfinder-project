package petfinder.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.List;

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
                .statusCode(200);
    }
}
