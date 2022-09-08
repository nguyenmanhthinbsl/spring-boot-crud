package com.thinnm.techrestrainingremake.service;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.Restaurant;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;

public interface RestaurantService {
	
	Restaurant create(Restaurant entity);
	
//	void update(Restaurant entity);
	
	Restaurant findById(int id) throws Exception;
	
	List<Restaurant> findAll();
	
	public StoreProcedureListResult<Restaurant> spGlRestaurant(int status,String keySearch) throws Exception;
	
	public StoreProcedureListResult<Restaurant> spUCreateRestaurants(String jsonData) throws Exception;
	
	public Restaurant spUUpdateRestaurant(int id,String name, String email, String phone, String info, String address,
			int status,String logoUrl) throws Exception;
	
//	public StoreProcedureListResult<Restaurant> spUCreateRestaurant(Restaurant entity) throws Exception;
	
	public Restaurant spUCreateRestaurant(String name, String email, String phone, String info, String address,int status,
			String logo) throws Exception;
	
	public Restaurant spGDetailRestaurant(int id) throws Exception;
}
