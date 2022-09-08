package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.Area;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;

public interface AreaDAO {

	Area findById(int ID);

	List<Area> findAll();

	public StoreProcedureListResult<Area> spGlAreas(String name) throws Exception;

	public StoreProcedureListResult<Area> spGAllAreas() throws Exception;

	public Area spUCreateArea(int restaurantId, int restaurantBrandId, int BranchId, String name, String description)
			throws Exception;

	public void spUUpdateArea(int areaId, String name, String description) throws Exception;

	// get list area in 1 restaurant by restaurantId
	public StoreProcedureListResult<Area> spGlAreasByRestaurantId(int restaurantId) throws Exception;

	// get list area in 1 restaurant Brand by restaurantBrandId
	public StoreProcedureListResult<Area> spGlAreasByRestaurantBrandId(int restaurantBrandId) throws Exception;

	// get list area in 1 restaurant by branchId
	public StoreProcedureListResult<Area> spGlAreasByBranchId(int branchId) throws Exception;

//	public void spUDeleteArea(int areaId) throws Exception;
}
