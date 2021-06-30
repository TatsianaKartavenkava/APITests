package YandexDiskApi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.mortbay.util.ajax.JSON;
import org.testng.annotations.Test;

import static io.restassured.authentication.FormAuthConfig.springSecurity;
import static org.hamcrest.Matchers.*;

public class RestApiManager {
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://cloud-api.yandex.net/v1/disk/resources")
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .addHeader("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
            .build();

    public void getInfoAboutDiskUser() {
        RestAssured.given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .when().get()
                .then().log().everything().assertThat().statusCode(200);
    }

    public void createFolder() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "Test")
                .when().put()
                .then().log().everything().assertThat().statusCode(201);
    }

    public void createFolderInFolder() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "Test/foo")
                .when().put()
                .then().log().everything().assertThat().statusCode(201);
    }

    public void createFileInFolder() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "Test/foo/autotest.txt")
                .when().put()
                .then().log().everything().assertThat().statusCode(201);
    }

    public void deleteFolder() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "/Test")
                .when().delete()
                .then().log().everything().assertThat().statusCode(204);
    }

    public void getMetaInfoFolder() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "/Test")
                .when().get()
                .then().log().everything().assertThat().statusCode(200)
                .body("name", equalTo("Test"));
    }

    public void getFolder() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "disk/Test")
                .when().get()
                .then().log().everything().assertThat().statusCode(404);
    }

    public void makeFile1() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "Test/kill.png")
                .when().put()
                .then().log().everything().assertThat().statusCode(201);
    }

    public void deleteFile1() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "Test/kill.png")
                .when().delete()
                .then().log().everything().assertThat().statusCode(204);
    }

    public void makeFile2() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "Test/like.png")
                .when().put()
                .then().log().everything().assertThat().statusCode(201);

    }

    public void deleteFile2() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "Test/like.png")
                .when().delete()
                .then().log().everything().assertThat().statusCode(204);
    }

    public void getSumSizeFiles() {
        RestAssured.given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/trash/resources")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .queryParam("path", "/")
                .when().get()
                .then().log().everything().log();

    }

    public void trashRestore() {
        RestAssured.given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/trash/resources/restore")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .queryParam("path", "trash:/kill.png_f54b408d8f6826fcdb6a115554ea3c41bba1e15f")
                .when().put()
                .then().log().everything().assertThat().statusCode(201);
    }

    public void getTrashInfo() {
        RestAssured.given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/trash/resources")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .queryParam("path", "trash:/Test_74ab42bd100f9ff3f7166a0768f05a4ec4156769")
                .when().get()
                .then().log().everything().assertThat().statusCode(200)
                .body("name", is("Test"));
    }

    public void cleanTrash() {
        RestAssured.given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/trash/resources")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .queryParam("path", "/")
                .when().delete()
                .then().log().everything().assertThat().statusCode(202);
    }

    public void getCleanTrash() {
        RestAssured.given().log().everything()
                .baseUri("https://cloud-api.yandex.net/v1/disk/trash/resources")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
                .queryParam("path", "/")
                .when().get()
                .then().log().everything().assertThat().statusCode(200)
                .body("_embedded.total", equalTo(0));
    }
}