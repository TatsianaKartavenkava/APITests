
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RestTest {
    @Test
    public void getRequest() {
        given().log().everything()
                .baseUri("https://swapi.dev/api/planets/")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().everything()
                .assertThat()
                .statusCode(200)
                .body("count", is(61));


    }

}
