package com.app.utils;

import java.time.Instant;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuthTokenManager {
	private static String accessToken;
    private static Instant expiryTime;

    /**
     * Returns a valid OAuth access token.
     * Generates a new one if expired or null.
     */
    public static String getAccessToken() {
        if (accessToken == null || Instant.now().isAfter(expiryTime)) {
            generateNewToken();
        }
        return accessToken;
    }

    /**
     * Generate OAuth token dynamically using client credentials
     */
    private static void generateNewToken() {
        // Set base URI (can also move to config.properties)
        RestAssured.baseURI = "https://example.com";  // Replace with your actual auth server

        Response response = RestAssured
                .given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.URLENC) // important for form-encoded body
                    .formParam("grant_type", "client_credentials")
                    .formParam("client_id", "your-client-id")
                    .formParam("client_secret", "your-client-secret")
                .when()
                    .post("/oauth/token")
                .then()
                    .extract().response();

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to get OAuth token: " + response.asString());
        }

        JsonPath js = new JsonPath(response.asString());
        accessToken = js.getString("access_token");
        int expiresIn = js.getInt("expires_in");

        // set token expiry timestamp
        expiryTime = Instant.now().plusSeconds(expiresIn - 60); // refresh 1 min early

        System.out.println("New OAuth Token Generated: " + accessToken);
    }
}
