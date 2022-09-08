package com.thinnm.techrestrainingremake.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinnm.techrestrainingremake.entity.Restaurant;


public class RestaurantResponse {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("info")
	private String info;

	@JsonProperty("address")
	private String address;

	@JsonProperty("logo_url")
	private String logo_url;

	@JsonProperty("create_at")
	private Date create_at;
	
	@JsonProperty("status")
	private int status;
	
//	private RestaurantBrandResponseAll restaurantBrandsResponse;
	
	public RestaurantResponse() {
	}

	public RestaurantResponse(Restaurant entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.info = entity.getInfo();
		this.address = entity.getAddress();
		this.logo_url = entity.getLogo();
		this.status=entity.getStatus();
		this.create_at = entity.getCreatedAt();
	}

	public List<RestaurantResponse> mapToList(List<Restaurant> entiies) {
		return entiies.stream().map(x -> new RestaurantResponse(x)).collect(Collectors.toList());
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
