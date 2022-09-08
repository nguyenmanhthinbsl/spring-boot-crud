package com.thinnm.techrestrainingremake.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDTableRequest {
		
	@NotEmpty(message = "tên không được để trống")
	@JsonProperty("name")
	private String name;
	
	@NotNull(message = "description không được null")
	@JsonProperty("description")
	private String description;
	
	@NotNull(message = "totalSlot không được null")
	@JsonProperty("total_slot")
	private int total_slot;
	
	@JsonProperty("status")
	private int status;

}
