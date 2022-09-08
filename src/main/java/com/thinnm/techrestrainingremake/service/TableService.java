package com.thinnm.techrestrainingremake.service;

import java.util.List;

import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.entity.Table;

public interface TableService {
	Table create(Table entity);
	
	void update(Table entity);
	
	Table findById(int id);
	
	List<Table> findAll();
	
	public StoreProcedureListResult<Table> spGlTable(String name) throws Exception;
}
