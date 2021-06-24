package YandexDiskApi;

import com.yandex.disk.rest.RestClient;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Task2 {
    RestClient restClient = new RestClient();
        @SneakyThrows
        @Test
        public void task2(){
            String accessToken = "AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA";
            given().log().everything()
                    .baseUri("https://tech.yandex.ru/disk/rest/")
                    .contentType(ContentType.JSON)
                    .auth().oauth2(accessToken)
                    .when().get()
                    .then().log().everything();
            restClient.makeFolder("disk/Социальные сети/Facebook");
        }





}
