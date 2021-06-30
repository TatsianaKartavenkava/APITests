package YandexDiskApi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.authentication.FormAuthConfig.springSecurity;

public class GetToken {
    @Test
    public void auth() {
        given()
                .baseUri("https://cloud-api.yandex.net/v1/disk/")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .when().get()
                .then().log().everything().assertThat().statusCode(200);

    }
}
