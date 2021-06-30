import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Condition;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetResponseUrl {
    @Test
    public static void getResponseHeaders() {
        given().log().everything()
                .baseUri("https://swapi.dev/api/planets/")
                .contentType(ContentType.JSON)
                .when().get("/1/")
                .then().log().everything();

        given().log().everything()
                .when().get("https://swapi.dev/api/planets/1/")
                .then().log().everything()
                .assertThat()
                .statusCode(200);



    }
}