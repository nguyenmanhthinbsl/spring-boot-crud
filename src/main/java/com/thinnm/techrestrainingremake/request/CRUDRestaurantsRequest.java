package com.thinnm.techrestrainingremake.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDRestaurantsRequest {

	@JsonProperty("list")
	@NotNull
	@Valid
	private List<CRUDRestaurantRequest> list = new ArrayList<CRUDRestaurantRequest>();

	public List<CRUDRestaurantRequest> getList() {
		return list;
	}

	public void setList(List<CRUDRestaurantRequest> list) {
		this.list = list;
	}

}
