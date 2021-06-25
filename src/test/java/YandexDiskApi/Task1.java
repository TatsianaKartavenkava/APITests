package YandexDiskApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.authentication.FormAuthConfig.springSecurity;

class Task1 {
    @Test
    public void task1() {
        given()
                .baseUri("https://tech.yandex.ru/disk/rest/")
                .auth().form("kartavenkava", "feodosia2012", springSecurity().sendCsrfTokenAsHeader())
                .when().get()
                .then().statusCode(200);

    }
}
