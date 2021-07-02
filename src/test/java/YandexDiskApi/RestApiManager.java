package YandexDiskApi;

import Pojo.ResponseTrash;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestApiManager {
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://cloud-api.yandex.net/v1/disk/resources")
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .addHeader("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
            .build();

    RequestSpecification requestSpecificationTrash = new RequestSpecBuilder()
            .setBaseUri("https://cloud-api.yandex.net/v1/disk/trash/resources")
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

    public void deleteFolderWithFiles() {
        RestAssured.given().log().everything()
                .spec(requestSpecification)
                .queryParam("path", "/Test")
                .when().delete()
                .then().log().everything().assertThat().statusCode(202);
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
                .spec(requestSpecificationTrash)
                .queryParam("path", "/")
                .when().get()
                .then().log().everything().log();

    }

    public void trashRestoreFolderWithFile() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .basePath("/restore")
                .queryParam("path", getPathTrash())
                .when().put()
                .then().log().everything().assertThat().statusCode(202);
    }

    public void trashRestoreFile() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .basePath("/restore").queryParam("path", getPathTrash())
                .when().put()
                .then().log().everything().assertThat().statusCode(201);
    }


    public void getTrashInfo() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .queryParam("path", getPathTrash())
                .when().get()
                .then().log().everything().assertThat().statusCode(200)
                .body("name", is("Test"));
    }

    public void getTrashCleanInfo() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .queryParam("path", "/")
                .when().get()
                .then().log().everything().assertThat().statusCode(200);
    }

    public void cleanTrashIfEmpty() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .queryParam("path", "/")
                .when().delete()
                .then().log().everything().assertThat().statusCode(204);
    }

    public void cleanTrashIfNotEmpty() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .queryParam("path", "/")
                .when().delete()
                .then().log().everything().assertThat().statusCode(202);
    }

    public void getCleanTrash() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .queryParam("path", "/")
                .when().get()
                .then().log().everything().assertThat().statusCode(200)
                .body("_embedded.total", equalTo(0));
    }

    public void countTotalInTrashEmpty() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .queryParam("path", "/")
                .when().get()
                .then().log().everything().assertThat().statusCode(200)
                .body("_embedded.total", equalTo(0));
    }

    public void countTotalInTrashNotEmpty() {
        RestAssured.given().log().everything()
                .spec(requestSpecificationTrash)
                .queryParam("path", "/")
                .when().get()
                .then().log().everything().assertThat().statusCode(200)
                .body("_embedded.total", equalTo(2));

    }

    public String getPathTrash() {
        List<ResponseTrash> getPathTrash =
                given().log().everything()
                        .spec(requestSpecificationTrash)
                        .when().get()
                        .then().log().everything()
                        .assertThat().statusCode(200)
                        .extract().jsonPath().getList("_embedded.items",ResponseTrash.class);
        return getPathTrash.get(0).path;

    }

}





