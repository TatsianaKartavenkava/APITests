package Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.http.ContentType;
import lombok.Data;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseTrash{
	public String path;
	private Object originPath;
	private Embedded embedded;
	private String created;
	private String name;
	private String resourceId;
	private String modified;
	private String type;
	private CommentIds commentIds;
	private Exif exif;
	private long revision;

	/*@Test
	public void getPathInTrash() {
		List<ResponseTrash> getPathTrash =
				given().log().everything()
						.baseUri("https://cloud-api.yandex.net/v1/disk/trash/resources?path=%2F")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("Authorization", "OAuth AQAAAABJI-t8AADLW7V6UElizkOIq5LZGXXbeCA")
						.when().get()
						.then().log().everything()
						.assertThat().statusCode(200)
						.extract().jsonPath().getList("_embedded.items", ResponseTrash.class);
	}*/

}
