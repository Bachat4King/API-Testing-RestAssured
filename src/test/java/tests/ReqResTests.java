package tests;

import data.factory.CreateUserDataFactory;
import data.factory.UpdateUserDataFactory;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import model.CreateUserRequest;
import model.CreateUserResponse;
import model.UpdateUserRequest;
import model.UpdateUserResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.path.json.JsonPath.from;

/**
 * Author: Bastian Silva
 */
@Listeners(listeners.TestNGListeners.class)
public class ReqResTests extends BaseTest {


    @Test
    public void getSingleUser() {

        given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

    @Test
    public void deleteUserTest() {
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);

    }

    @Test
    public void patchUserTest() {

        UpdateUserRequest updateUserRequest = UpdateUserDataFactory.onlyName();

        UpdateUserResponse updateUserResponse = given()
                .when()
                .body(updateUserRequest)
                .when()
                .patch("/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(UpdateUserResponse.class);

        assertThat(updateUserResponse.getName(), equalTo(updateUserRequest.getName()));
        assertThat(updateUserResponse.getJob(), equalTo(updateUserRequest.getJob()));

    }

    @Test
    public void putUserTest() {

        UpdateUserRequest updateUserRequest = UpdateUserDataFactory.validUser();

        UpdateUserResponse updateUserResponse = given()
                .when()
                .body(updateUserRequest)
                .put("/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(UpdateUserResponse.class);

        assertThat(updateUserResponse.getJob(), equalTo(updateUserRequest.getJob()));
        assertThat(updateUserResponse.getName(), equalTo(updateUserRequest.getName()));

    }

    @Test
    public void getAllUsers() {
        Response response = given()
                .when()
                .get("/users?page=2");

        Headers headers = response.getHeaders();
        int statusCode = response.getStatusCode();

        assertThat(statusCode, equalTo(HttpStatus.SC_OK));
        assertThat(headers.getValue("Content-Type"), equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void VerifyDataOrder() {
        String response = given()
                .when()
                .get("/users?page=2")
                .then()
                .extract()
                .body()
                .asString();

        List<Map> data = from(response).get("data");

        List<Integer> ids = data.stream()
                .map(map -> (Integer) map.get("id"))
                .collect(Collectors.toList());

        List<Integer> sortedIds = ids.stream()
                .sorted()
                .collect(Collectors.toList());

        assertThat(ids, equalTo(sortedIds));

    }

    @Test
    public void registerUserSuccessfullyTest() {

        CreateUserRequest userRequest = CreateUserDataFactory.validUser();

        CreateUserResponse userResponse = given()
                .when()
                .body(userRequest)
                .post("/register")
                .then()
                .extract()
                .body()
                .as(CreateUserResponse.class);

        assertThat(userResponse.getToken(), notNullValue());
        assertThat(userResponse.getId(), instanceOf(Integer.class));

    }

    @Test
    public void registerUserUnSuccessfullyTest() {

        CreateUserRequest userRequest = CreateUserDataFactory.nullInformation();

        Response response = given()
                .when()
                .body(userRequest)
                .post("/register")
                .then()
                .extract().response();

        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
        String errorMessage = response.getBody().jsonPath().get("error");
        assertThat(errorMessage, equalTo("Missing email or username"));

    }

}
