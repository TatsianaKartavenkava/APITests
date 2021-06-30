import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetFilms {
    private static String baseUrl = "https://swapi.dev/api/planets/";

    @Test
    public static void getFilms() {
        List<Object> title = given().log().everything()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().everything()
                .assertThat()
                .statusCode(200)
                .extract().jsonPath().getList("results.title");
    }

}
