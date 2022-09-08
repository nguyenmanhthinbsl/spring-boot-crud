package com.thinnm.techrestrainingremake.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThinhTest {
	@NotEmpty(message = "tên không được để trống")
	@JsonProperty("name")
	private String name;

	@NotNull(message = "Email không được null")
	@JsonProperty("email")
	private String email;

	@NotNull(message = "số điện thoại không được null")
	@JsonProperty("phone")
	private String phone;

	@JsonProperty("info")
	private String info;

//	@NotBlank(message = "Địa chỉ không được để trống và không được để ký tự khoảng trắng")
	@JsonProperty("address")
	private String address;

	@NotNull(message = "Status không được null")
//	@Range(min = 0, max = 1, message = "Status chỉ được là 0 hoặc 1")
	@JsonProperty("status")
	private int status;

//	@NotBlank(message = "logo không được để trống và không được để ký tự khoảng trắng")
	@JsonProperty("logo_url")
	private String logoUrl;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	
}
