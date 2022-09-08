package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.Branch;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;

public interface BranchDAO {
	Branch create(Branch entity);
	
	void update(Branch entity);
	
	Branch findById(int id);
	
	List<Branch> findAll();
	
	
	// get list
	public StoreProcedureListResult<Branch> spGAllBranch() throws Exception;
	
	public StoreProcedureListResult<Branch> spGlBranchByRestaurant(int restaurantId) throws Exception;
	
	public StoreProcedureListResult<Branch> spGlBranchByBrandId(int restaurantBrandId) throws Exception;
	
	// detail
	
	public Branch spGDetail(int id) throws Exception;
	
	// create
	
	public Branch spUCreate(int restaurantId, int brandId, String name, String streetName, String addressFullText,String phoneNumber) throws Exception;
	
	// update
	
	public Branch spUUpdate(int id,String name,String streetName,String addressFullText,String phoneNumber,int status) throws Exception;
	
//	public Branch spUCreateBranch(int restaurantId, int restaurantBrandId, String name,String streetName,String addressFullName,String phoneNumber )throws Exception;
}
