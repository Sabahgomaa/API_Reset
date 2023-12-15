package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PostsTest {
    @Test
    public void GetPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

        String requestBody = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "  \"body\": \"quia et suscipit nsuscipit recusandae consequuntur expedita et cum nreprehenderit molestiae ut ut quas totam nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";

      ValidatableResponse response
              = RestAssured.
                given()
                .contentType(ContentType.JSON).body(requestBody)
                .when().get("posts/?userId=1")
                .then().log().body()
                .assertThat().statusCode(200)
                .assertThat()
               .body("id", everyItem(allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(100))));
    }
}
