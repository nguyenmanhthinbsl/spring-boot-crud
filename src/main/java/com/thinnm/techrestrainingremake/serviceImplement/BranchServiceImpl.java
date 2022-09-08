package com.thinnm.techrestrainingremake.serviceImplement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinnm.techrestrainingremake.dao.BranchDAO;
import com.thinnm.techrestrainingremake.entity.Branch;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.service.BranchService;

@Service
@Transactional
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchDAO dao;

	@Override
	public StoreProcedureListResult<Branch> spGlBranchByRestaurant(int restaurantId) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlBranchByRestaurant(restaurantId);
	}

	@Override
	public StoreProcedureListResult<Branch> spGAllBranch() throws Exception {
		// TODO Auto-generated method stub
		return dao.spGAllBranch();
	}

	@Override
	public StoreProcedureListResult<Branch> spGlBranchByRestaurantBrandId(int restaurantBrandId) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlBranchByBrandId(restaurantBrandId);
	}

	@Override
	public Branch spUCreate(int restaurantId, int restaurantBrandId, String name, String streetName,
			String addressFullText, String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreate(restaurantId, restaurantBrandId, name, streetName, addressFullText, phoneNumber);
	}

	@Override
	public Branch spGDetail(int restaurantId) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGDetail(restaurantId);
	}

	@Override
	public Branch spUUpdate(int restaurantId, String name, String streetName, String addressFullText,
			String phoneNumber, int status) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUUpdate(restaurantId, name, streetName, addressFullText, phoneNumber, status);
	}

	
	
	
	
}
