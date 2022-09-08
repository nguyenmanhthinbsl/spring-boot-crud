package com.thinnm.techrestrainingremake.serviceImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinnm.techrestrainingremake.dao.RestaurantBrandDAO;
import com.thinnm.techrestrainingremake.entity.RestaurantBrand;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.service.RestaurantBrandService;

@Service
@Transactional
public class RestaurantBrandServiceImpl implements RestaurantBrandService {

	@Autowired
	RestaurantBrandDAO dao;

	@Override
	public RestaurantBrand create(RestaurantBrand entity) {
		// TODO Auto-generated method stub
		return dao.create(entity);
	}

	@Override
	public void update(RestaurantBrand entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Override
	public RestaurantBrand findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<RestaurantBrand> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public StoreProcedureListResult<RestaurantBrand> spGlRestaurantBrand(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlRestaurantBrandByRestaurantId(id);
	}

	@Override
	public StoreProcedureListResult<RestaurantBrand> spGAllRestaurantBrand() throws Exception {
		// TODO Auto-generated method stub
		return dao.spGAllRestaurantBrand();
	}

	@Override
	public RestaurantBrand spUUpdateRestaurantBrand(int brandId, String name, String logoUrl, String banner, int status,
			String description) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUUpdateRestaurantBrand(brandId, name, logoUrl, banner, status, description);
	}

	@Override
	public RestaurantBrand spGDetailRestaurantBrand(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGDetailRestaurantBrand(id);
	}

	@Override
	public RestaurantBrand spUCreateRestaurantBrand(int restaurantId, String name, String logoUrl, String banner,
			String description) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateRestaurantBrand(restaurantId, name, logoUrl, banner,description);
	}

	

}
