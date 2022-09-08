package com.thinnm.techrestrainingremake.service;

import com.thinnm.techrestrainingremake.entity.Branch;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;

public interface BranchService {
//	Branch create(Branch entity);
//	
//	void update(Branch entity);
//	
//	Branch findById(int id);
//	
//	List<Branch> findAll();
	
	public StoreProcedureListResult<Branch> spGlBranchByRestaurant(int restaurantId) throws Exception;
	
	public StoreProcedureListResult<Branch> spGAllBranch() throws Exception;
	
	public StoreProcedureListResult<Branch> spGlBranchByRestaurantBrandId( int restaurantBrandId) throws Exception;
	
//	public StoreProcedureListResult<Branch> spGlBranchByRestaurantBrandId( int restaurantBrandId) throws Exception;
	
	public Branch spUCreate(int restaurantId, int restaurantBrandId, String name,String address, String addressFullText, String phoneNumber) throws Exception;
	
	public Branch spUUpdate(int restaurantId, String name, String streetName,String addressFullText, String phoneNumber,int status) throws Exception;
	
	public Branch spGDetail(int restaurantId) throws Exception;
}
