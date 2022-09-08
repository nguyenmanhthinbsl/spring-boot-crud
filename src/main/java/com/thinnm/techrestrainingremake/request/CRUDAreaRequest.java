package com.thinnm.techrestrainingremake.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class CRUDAreaRequest extends BaseRequest{
	
	/**
	 * 
	 */

	@NotEmpty(message = "Tên không được để trống")
	private String name;

	@NotNull(message = "Chi tiết thông tin không được null")
	@JsonProperty("description")
	private String description;

	

	
}
