package com.thinnm.techrestrainingremake.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class CRUDBranchRequest extends BaseRequest{
	
	@NotEmpty(message="Tên không được để trống")
	@JsonProperty("name")
	private String name;
	
	
	@NotBlank(message ="địa chỉ không được để trống, không được chỉ để khoảng trắng!")
	@JsonProperty("streetName")
	private String streetName;
	
	@NotBlank(message="chi tiết địa chỉ không được để trống, không được chỉ để khoảng trắng!")
	@JsonProperty("addressFullText")
	private String addressFullText;
	
	@NotBlank(message ="Số điện thoại không được để trống")
	@JsonProperty("phoneNumber")
	private String phoneNumber;

	@JsonProperty("status")
	@Range(min=0, max=1,message = "Status chỉ 0 hoặc 1!")
	private int status;
	
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

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAddressFullText() {
		return addressFullText;
	}

	public void setAddressFullText(String addressFullText) {
		this.addressFullText = addressFullText;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
