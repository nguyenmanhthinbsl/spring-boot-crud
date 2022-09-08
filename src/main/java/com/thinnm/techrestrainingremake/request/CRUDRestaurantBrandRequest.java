package com.thinnm.techrestrainingremake.request;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class CRUDRestaurantBrandRequest extends BaseRequest {

	@NotBlank(message = "Tên không được để trống và không được chỉ để khoảng trắng!")
	@JsonProperty("name")
	private String name;

	@JsonProperty("logoUrl")
	private String logoUrl;

	@JsonProperty("banner")
	private String banner;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@JsonProperty("status")
	@Range(min = 0, max = 1, message = "Status chỉ được là 0 hoặc 1!")
	private int status;

	@JsonProperty("description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	
	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
