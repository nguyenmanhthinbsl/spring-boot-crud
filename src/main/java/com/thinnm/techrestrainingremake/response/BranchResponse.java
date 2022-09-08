package com.thinnm.techrestrainingremake.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinnm.techrestrainingremake.entity.Branch;

public class BranchResponse {
	private int id;

	private String name;

	@JsonProperty("restaurantId")
	private int restaurantId;

	@JsonProperty("restaurantBrandId")
	private int restaurantBrandId;

	@JsonProperty("streetName")
	private String streetName;

	@JsonProperty("addressFullText")
	private String addressFullText;

	@JsonProperty("phoneNumber")
	private String phoneNumber;

	@JsonProperty("status")
	private int status;

	@JsonProperty("create_at")
	private Date createdAt;

	@JsonProperty("updateAt")
	private Date updateAt;

	private AreaResponse area;

	public BranchResponse(Branch entity) {
		this.id = entity.getId();
		this.restaurantId = entity.getRestaurantId();
		this.restaurantBrandId = entity.getRestaurantBrandId();
		this.name = entity.getName();
		this.streetName = entity.getStreetName();
		this.addressFullText = entity.getAddressFullText();
		this.phoneNumber = entity.getPhoneNumber();
		this.createdAt = entity.getCreatedAt();
	}

	public BranchResponse() {
	}

	public BranchResponse(Branch branchEntity, AreaResponse areaEntity) {
		this.id = branchEntity.getId();
		this.restaurantId = branchEntity.getRestaurantId();
		this.restaurantBrandId = branchEntity.getRestaurantBrandId();
		this.name = branchEntity.getName();
		this.streetName = branchEntity.getStreetName();
		this.addressFullText = branchEntity.getAddressFullText();
		this.phoneNumber = branchEntity.getPhoneNumber();
		this.createdAt = branchEntity.getCreatedAt();
		this.area = areaEntity;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public AreaResponse getArea() {
		return area;
	}

	public void setArea(AreaResponse area) {
		this.area = area;
	}

	public List<BranchResponse> mapToList(List<Branch> entities) {
		return entities.stream().map(x -> new BranchResponse(x)).collect(Collectors.toList());
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getRestaurantBrandId() {
		return restaurantBrandId;
	}

	public void setRestaurantBrandId(int restaurantBrandId) {
		this.restaurantBrandId = restaurantBrandId;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
