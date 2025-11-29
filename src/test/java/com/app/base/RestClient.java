package com.app.base;

import com.app.utils.OAuthTokenManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient {

    static {
        // Base URI configured once
        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }

    // ---------- POST with OAuth Token ----------
    public static Response postWithOAuth(String endpoint, Object body) {
        String token = OAuthTokenManager.getAccessToken();

        return RestAssured
                .given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(body)
                .when()
                    .post(endpoint);
    }
    // Common reusable POST method
    public static Response postRequest(String endpoint, Object body, String queryParamKey, String queryParamValue) {
        return RestAssured
                .given()
                    .queryParam(queryParamKey, queryParamValue)
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(endpoint);
    }

    // Common reusable GET method
    public static Response getRequest(String endpoint, String queryParamKey, String queryParamValue) {
        return RestAssured
                .given()
                    .queryParam(queryParamKey, queryParamValue)
                    .contentType(ContentType.JSON)
                .when()
                    .get(endpoint);
    }
}
