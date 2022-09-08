package com.thinnm.techrestrainingremake.response;

import java.util.List;

public class RestaurantBrandResponseAll {
	private int total;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private List<RestaurantBrandResponse> brandResponses;

	public List<RestaurantBrandResponse> getBrandResponses() {
		return brandResponses;
	}

	public void setBrandResponses(List<RestaurantBrandResponse> brandResponses) {
		this.brandResponses = brandResponses;
	}

	public RestaurantBrandResponseAll(List<RestaurantBrandResponse> brandResponses) {
		super();
		this.brandResponses = brandResponses;
	}

	
	
}
