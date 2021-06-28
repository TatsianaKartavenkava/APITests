package YandexDiskApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.mortbay.util.ajax.JSON;
import org.testng.annotations.Test;

import static io.restassured.authentication.FormAuthConfig.springSecurity;

public class RestApiManager {

    public void createFolder() {

        RestAssured.given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth().oauth2("AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .when().get()
                .then().log().everything().assertThat().statusCode(200);

    }
}
