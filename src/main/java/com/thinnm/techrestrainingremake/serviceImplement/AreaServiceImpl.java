package com.thinnm.techrestrainingremake.serviceImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinnm.techrestrainingremake.dao.AreaDAO;
import com.thinnm.techrestrainingremake.entity.Area;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.service.AreaService;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	AreaDAO dao;
	
	@Override
	public Area findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreas(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlAreas(name);
	}

	@Override
	public void update(Area entity) throws Exception {
		// TODO Auto-generated method stub
		dao.spUUpdateArea(entity.getId(), entity.getName(), entity.getDescription());
	}

	@Override
	public Area create(Area entity) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateArea(entity.getRestaurantId(),entity.getRestaurantBrandId(), entity.getBranchId(), entity.getName(),entity.getDescription());
	}

	@Override
	public StoreProcedureListResult<Area> spGAllAreas() throws Exception {
		// TODO Auto-generated method stub
		return dao.spGAllAreas();
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreasByRestaurantId(int restaurantId) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlAreasByRestaurantId(restaurantId);
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreasByRestaurantBrandId(int restaurantBrandId) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlAreasByRestaurantBrandId(restaurantBrandId);
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreasByBranchId(int branchId) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlAreasByBranchId(branchId);
	}
	
	
	
	
}
