package com.thinnm.techrestrainingremake.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDRestaurantRequest {

	@NotEmpty(message = "tên không được để trống")
	@JsonProperty("name")
	private String name;

	@NotNull(message = "Email không được null")
	@JsonProperty("email")
	private String email;

	@NotNull(message = "số điện thoại không được null")
	@JsonProperty("phone")
	private String phone;
	
	@NotNull
	@JsonProperty("info")
	private String info;

	@NotEmpty(message = "Địa chỉ không được để trống và không được để chỉ ký tự khoảng trắng")
	@JsonProperty("address")
	private String address;

	@NotNull(message = "Status không được null")
	@Range(min = 0, max = 1, message = "Status chỉ được là 0 hoặc 1")
	@JsonProperty("status")
	private int status;
	
	@NotNull
	@JsonProperty("logo_url")
	private String logoUrl;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

}
