package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.entity.Table;
import com.thinnm.techrestrainingremake.enums.StoreProcedureStatusCodeEnum;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;

@Repository("tableDAO")
public class TableDAOImpl extends AbstractDAO<Integer, Table> implements TableDAO {

	@SuppressWarnings("deprecation")
	@Override
	public Table findById(int id) {
		// TODO Auto-generated method stub
		return (Table) this.getSession().createCriteria(Table.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Table> findAll() {
		// TODO Auto-generated method stub
		CriteriaQuery<Table> criteriaQuery = this.getBuilder().createQuery(Table.class);
		Root<Table> root = criteriaQuery.from(Table.class);
		criteriaQuery.select(root);

		return this.getSession().createQuery(criteriaQuery).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<Table> spGlTable() throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createNamedStoredProcedureQuery("sp_gl_table")
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		int status_code = (int) query.getOutputParameterValue("status_code");
		String message_error = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(status_code)) {
		case SUCCESS:
			return new StoreProcedureListResult<Table>(status_code, message_error, query.getResultList());
		case INPUT_INVALID:
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, message_error);
		default:
			throw new Exception(message_error);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Table spUCreateTable(int restaurantId, int restaurantBrandId, int branchId, int areaId, String name,
			int totalSlot) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_table")
				.registerStoredProcedureParameter("restaurantId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("restaurantBrandId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("branchId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("areaId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_total_slot", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Table) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}
