package petfinder.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Base64;

public class PetfinderGetToken {

    public static String GetToken() throws Exception {
        String clientId = "0crepFnFT1BMzVC0jmsK1uILgAQBlgMhQzR4xy6rMPGtdHYgVY";
        String clientSecret = "Wa6itRlnnNnk2nBih4kSp98FrmN6pZfkc22DdpQn";

        String authString = clientId + ":" + clientSecret;
        String base64AuthString = Base64.getEncoder().encodeToString(authString.getBytes());

        Response response = RestAssured.given()
                .header("Authorization", "Basic " + base64AuthString)
                .formParam("grant_type", "client_credentials")
                .post("https://api.petfinder.com/v2/oauth2/token");

        String responseBody = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(responseBody);
        String accessToken = (String) json.get("access_token");

        //System.out.println("Access token: " + accessToken);

        return accessToken;
    }
}