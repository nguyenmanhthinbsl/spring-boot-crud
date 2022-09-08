package com.thinnm.techrestrainingremake.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinnm.techrestrainingremake.entity.Area;

public class AreaResponse {
	private int id;

	private int restaurantId;

	private int restaurantBrandId;

	private int branchId;

	private TableResponse table;

	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("created_at")
	private Date createAt;

	public AreaResponse() {
	}

	public AreaResponse(Area entity) {
		this.id = entity.getId();
		this.restaurantId = entity.getRestaurantId();
		this.restaurantBrandId = entity.getRestaurantBrandId();
		this.branchId = entity.getBranchId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.createAt = entity.getCreatedAt();
	}

	public AreaResponse(Area entity, TableResponse tableEntity) {
		this.table = tableEntity;
		this.id = entity.getId();
		this.restaurantId = entity.getRestaurantId();
		this.restaurantBrandId = entity.getRestaurantBrandId();
		this.branchId = entity.getBranchId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.createAt = entity.getCreatedAt();
	}

	public TableResponse getTable() {
		return table;
	}

	public void setTable(TableResponse table) {
		this.table = table;
	}

	public List<AreaResponse> mapToList(List<Area> entiies) {
		return entiies.stream().map(x -> new AreaResponse(x)).collect(Collectors.toList());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

}
