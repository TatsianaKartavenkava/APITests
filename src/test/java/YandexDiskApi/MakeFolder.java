package YandexDiskApi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.authentication.FormAuthConfig.springSecurity;

public class MakeFolder {
    @Test
    public void task2() {

        given()
                .baseUri("https://tech.yandex.ru/disk/")
                .auth().form("kartavenkava", "feodosia2012", springSecurity().sendCsrfTokenAsHeader())
                .when().get()
                .then().statusCode(200);


        given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/resources")
                .auth().form("kartavenkava", "feodosia2012", springSecurity().sendCsrfTokenAsHeader())
                .pathParam("/disk/", "/system_folders/")
                .when()
                .put("/Music")
                .then().log().everything();




        }

    }


