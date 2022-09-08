package com.thinnm.techrestrainingremake.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinnm.techrestrainingremake.entity.RestaurantBrand;

public class RestaurantBrandResponse {
	private int id;

	@JsonProperty("restaurant_id")
	private int restaurant_id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("logo_url")
	private String logo_url;

	@JsonProperty("banner")
	private String banner;

	@JsonProperty("status")
	private int status;

	@JsonProperty("description")
	private String description;

	@JsonProperty("created_at")
	private Date createAt;

	@JsonProperty("update_at")
	private Date updateAt;

	private BranchResponse branch;
//	@JsonProperty("branchs")
//	private BranchResponse2 branch2;
//
//	public BranchResponse2 getBranch() {
//		return branch2;
//	}
//
//	public void setBranch(BranchResponse2 branch2) {
//		this.branch2 = branch2;
//	}

//	public RestaurantBrandResponse(RestaurantBrand restaurantBrand, BranchResponse branch) {
//		this.branch = branch;
//		this.id = restaurantBrand.getId();
//		this.restaurantId = restaurantBrand.getRestaurantId();
//		this.name = restaurantBrand.getName();
//		this.logoUrl = restaurantBrand.getLogoUrl();
//		this.status = restaurantBrand.getStatus();
//		this.banner = restaurantBrand.getBanner();
//		this.description = restaurantBrand.getDescription();
//		this.createdAt = restaurantBrand.getCreatedAt();
//	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public BranchResponse getBranch() {
		return branch;
	}

	public void setBranch(BranchResponse branch) {
		this.branch = branch;
	}

	public RestaurantBrandResponse(RestaurantBrand rb) {
		this.id = rb.getId();
		this.restaurant_id = rb.getRestaurantId();
		this.name = rb.getName();
		this.logo_url = rb.getLogoUrl();
		this.status = rb.getStatus();
		this.banner = rb.getBanner();
		this.description = rb.getDescription();
		this.createAt = rb.getCreatedAt();
		this.updateAt = rb.getUpdatedAt();
	}

//	public List<RestaurantBrandResponse> mapToListv2( List<RestaurantBrand> entity, List<BranchResponse> branch) {
//		return entity.stream().map(x -> {
//			List<BranchResponse> listBranch = branch.stream().filter(y -> x.getId() == y.getRestaurantBrandId()).collect(Collectors.toList());
//			return new RestaurantBrandResponse(x, new BranchResponse2(listBranch));
//		}).collect(Collectors.toList());
//	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RestaurantBrandResponse() {
	}

	public List<RestaurantBrandResponse> mapToList(List<RestaurantBrand> entity) {
		return entity.stream().map(x -> new RestaurantBrandResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestaurantId() {
		return restaurant_id;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurant_id = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logo_url;
	}

	public void setLogoUrl(String logoUrl) {
		this.logo_url = logoUrl;
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

	public Date getCreatedAt() {
		return createAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createAt = createdAt;
	}
}
