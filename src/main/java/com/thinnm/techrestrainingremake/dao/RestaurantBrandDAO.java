package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.RestaurantBrand;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;

public interface RestaurantBrandDAO {
	RestaurantBrand create(RestaurantBrand entity);
	
	void update(RestaurantBrand entity);
	
	RestaurantBrand findById(int id);

	List<RestaurantBrand> findAll();
	
	// get list restaurant brand by restaurant id
	public StoreProcedureListResult<RestaurantBrand> spGlRestaurantBrandByRestaurantId(int restaurantId) throws Exception;
	
	RestaurantBrand spUCreateRestaurantBrand(int restaurantId, String name, String logo_url, String banner, String decription) throws Exception;
	
	public StoreProcedureListResult<RestaurantBrand> spGAllRestaurantBrand() throws Exception;
	
	public RestaurantBrand spUUpdateRestaurantBrand(int id,String name, String logo_url, String banner,int status, String description) throws Exception;
	
	public RestaurantBrand spGDetailRestaurantBrand(int id) throws Exception;
	
	
//	void spUDleteRestaurantBrand(int id) throws Exception;
}
