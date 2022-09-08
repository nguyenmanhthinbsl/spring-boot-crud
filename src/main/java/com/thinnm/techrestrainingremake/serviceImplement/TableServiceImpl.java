package com.thinnm.techrestrainingremake.serviceImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinnm.techrestrainingremake.dao.TableDAO;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.entity.Table;
import com.thinnm.techrestrainingremake.service.TableService;

@Service
@Transactional
public class TableServiceImpl implements TableService{

	@Autowired
	TableDAO dao;
	
	@Override
	public Table create(Table entity) {
		// TODO Auto-generated method stub
		return dao.create(entity);
	}

	@Override
	public void update(Table entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Override
	public Table findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Table> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public StoreProcedureListResult<Table> spGlTable(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGlTable();
	}

}
