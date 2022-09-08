package com.thinnm.techrestrainingremake.serviceImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinnm.techrestrainingremake.dao.RestaurantDAO;
import com.thinnm.techrestrainingremake.entity.Restaurant;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;
import com.thinnm.techrestrainingremake.service.RestaurantService;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDAO dao;

	@Override
	public Restaurant create(Restaurant entity) {
		// TODO Auto-generated method stub
		return dao.create(entity);
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Restaurant spUCreateRestaurant(String name, String email, String phone, String info, String address,
			int status, String logo) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateRestaurant(name, email, phone, info, address, status, logo);
	}

	@Override
	public StoreProcedureListResult<Restaurant> spGlRestaurant(int status, String keySearch) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlRestaurant(status, keySearch);
	}

	@Override
	public Restaurant spUUpdateRestaurant(int id, String name, String email, String phone, String info, String address,
			int status, String logoUrl) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUUpdateRestaurant(id, name, email, phone, info, address, status, logoUrl);
	}

	@Override
	public Restaurant spGDetailRestaurant(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGDetailRestaurant(id);
	}

	@Override
	public Restaurant findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public StoreProcedureListResult<Restaurant> spUCreateRestaurants(String jsonData) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateRestaurants(jsonData);
	}

}
