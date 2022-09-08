package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.entity.Table;

public interface TableDAO {
	
	Table create(Table entity);
	
	void update(Table entity);
	
	Table findById(int id);
	
	List<Table> findAll();
	
	public StoreProcedureListResult<Table> spGlTable() throws Exception;
	
	public Table spUCreateTable(int restaurantId, int restaurantBrandId, int BranchId, int areaId, String name, int totalSlot) throws Exception;

}
