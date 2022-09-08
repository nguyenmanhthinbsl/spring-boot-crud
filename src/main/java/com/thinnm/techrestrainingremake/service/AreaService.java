package com.thinnm.techrestrainingremake.service;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.Area;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;

public interface AreaService {
	Area create(Area entity) throws Exception;
	
	void update(Area entity) throws Exception;
	
	Area findById(int id)throws Exception;
	
	List<Area> findAll()throws Exception;
	
	public StoreProcedureListResult<Area> spGlAreas(String name) throws Exception;
	
	public StoreProcedureListResult<Area> spGlAreasByRestaurantId(int restaurantId) throws Exception;

	public StoreProcedureListResult<Area> spGlAreasByRestaurantBrandId(int restaurantId) throws Exception;
	
	public StoreProcedureListResult<Area> spGlAreasByBranchId(int branchId) throws Exception;
	
	public StoreProcedureListResult<Area> spGAllAreas() throws Exception;
}
