package Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsItem{
	private String path;
	private String deleted;
	private String originPath;
	private String created;
	private String name;
	private String modified;
	private String resourceId;
	private String type;
	private CommentIds commentIds;
	private Exif exif;
	private long revision;

}
