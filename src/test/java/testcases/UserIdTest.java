package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserIdTest {
    @Test
    public void GetUserID() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        ValidatableResponse response
                = RestAssured.
                given()
                .contentType(ContentType.JSON)
                .when().get("users/1")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("id", equalTo(1));
        String email = response.extract().jsonPath().getString("email");
        System.out.println("Email: " + email);

    }
}
