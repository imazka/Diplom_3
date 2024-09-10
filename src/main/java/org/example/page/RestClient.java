package org.example.page;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RestClient {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";

    protected static RequestSpecification getBaseSpec() {

        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    protected static RequestSpecification getBaseSpec(String jwt) {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .addHeader("Authorization" , jwt)
                .build();

    }

}
