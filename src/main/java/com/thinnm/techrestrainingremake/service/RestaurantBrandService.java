package com.thinnm.techrestrainingremake.service;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.RestaurantBrand;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;

public interface RestaurantBrandService {
	RestaurantBrand create(RestaurantBrand entity);
	
	void update(RestaurantBrand entity) throws Exception;
	
	RestaurantBrand findById(int id) throws Exception;

	
	List<RestaurantBrand> findAll() throws Exception;
	
	// lấy thương hiệu của 1 cửa hàng 
	public StoreProcedureListResult<RestaurantBrand> spGlRestaurantBrand(int id) throws Exception;
	
	// sửa thương hiệu theo id
	public RestaurantBrand spUUpdateRestaurantBrand(int brandId, String name,String logoUrl,String banner,int status,String description) throws Exception;
	
	//lấy chi tiết 1 thương hiệu 
	public RestaurantBrand spGDetailRestaurantBrand(int id) throws Exception;
	
	// lấy thương hiệu của tất cả bảng
	public StoreProcedureListResult<RestaurantBrand> spGAllRestaurantBrand() throws Exception;
	
	// tạo 1 thương hiệu
	public RestaurantBrand spUCreateRestaurantBrand(int restaurantId, String name,String logoUrl,String banner,String description) throws Exception;
}
