package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.Restaurant;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;

public interface RestaurantDAO {
	Restaurant create(Restaurant entity);
	
	Restaurant findById(int id) throws Exception;
	
	List<Restaurant> findAll();
	
	public StoreProcedureListResult<Restaurant> spGlRestaurant(int status, String keySearch) throws Exception;
	
	public Restaurant spGDetailRestaurant(int id) throws Exception;
	
	public StoreProcedureListResult<Restaurant> spUCreateRestaurants(String jsonRawData) throws Exception;
	
	public Restaurant spUUpdateRestaurant(int restaurantId, String name, String email, String phone, String info, String address,int status, String logoUrl) throws Exception;
	
	public Restaurant spUCreateRestaurant(String name, String email, String phone, String info, String address,
			int status,String logo) throws Exception;
}
