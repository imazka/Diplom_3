package org.example.page.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.page.RestClient;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    private final String USER_REGISTRATION_PATH = "auth/register";
    private final String USER_DELETE_AND_PATCH_PATH = "auth/user";

    @Step
    public ValidatableResponse createUser(User user) {

        ValidatableResponse response = given().spec(getBaseSpec()).body(user).when().post(USER_REGISTRATION_PATH).then();
        user.setJwt(response.extract().path("accessToken"));

        return response;

    }

    @Step
    public ValidatableResponse deleteUser(String jwt) {

        return given().spec(getBaseSpec(jwt)).when().delete(USER_DELETE_AND_PATCH_PATH).then();

    }

}
