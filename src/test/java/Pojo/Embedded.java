package Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Embedded{
	private String path;
	private int total;
	private int offset;
	private int limit;
	private String sort;
	private List<ItemsItem> items;

}