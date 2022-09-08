package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.thinnm.techrestrainingremake.entity.Branch;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.enums.StoreProcedureStatusCodeEnum;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;

@Repository("branchDAO")
@SuppressWarnings("unchecked")
public class BranchDAOImpl extends AbstractDAO<Integer, Branch> implements BranchDAO {

	
	@Override
	public StoreProcedureListResult<Branch> spGlBranchByRestaurant(int restaurantId) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_list_branch_by_restaurantId", Branch.class)
				.registerStoredProcedureParameter("_restaurantId", Integer.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("_restaurantId", restaurantId);
		int statusCode=(int) query.getOutputParameterValue("status_code");
		String messageError =(String) query.getOutputParameterValue("message_error");
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Branch>(statusCode,messageError,query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST,messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public StoreProcedureListResult<Branch> spGlBranchByBrandId(int restaurantBrandId) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_list_branch_by_restaurant_brand_id", Branch.class)
				.registerStoredProcedureParameter("_restaurantBrandID", Integer.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("_restaurantBrandID", restaurantBrandId);
		int statusCode=(int) query.getOutputParameterValue("status_code");
		String messageError =(String) query.getOutputParameterValue("message_error");
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Branch>(statusCode,messageError,query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST,messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public Branch spGDetail(int id) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_detail_branch", Branch.class)
				.registerStoredProcedureParameter("_branchId", Integer.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("_branchId", id);
		int statusCode=(int) query.getOutputParameterValue("status_code");
		String messageError =(String) query.getOutputParameterValue("message_error");
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Branch) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST,messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public Branch spUCreate(int restaurantId, int restaurantBrandId, String name, String streetName, String addressFullText,
			String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_branch",Branch.class)
				.registerStoredProcedureParameter("_restaurantId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_restaurantBrandId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_street", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_addressFullText", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phoneNumber", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_restaurantId", restaurantId);
		query.setParameter("_restaurantBrandId", restaurantBrandId);
		query.setParameter("_name", name);
		query.setParameter("_street", streetName);
		query.setParameter("_addressFullText", addressFullText);
		query.setParameter("_phoneNumber", phoneNumber);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Branch) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public Branch spUUpdate(int id,String name,String streetName,String addressFullText,String phoneNumber,int status) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_update_branch", Branch.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_streetName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_addressFullText", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phoneNumber", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);
		query.setParameter("_name", name);
		query.setParameter("_streetName", streetName);
		query.setParameter("_addressFullText", addressFullText);
		query.setParameter("_phoneNumber", phoneNumber);
		query.setParameter("_status", status);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode) ) {
		case SUCCESS:
			return  (Branch) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST,messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public StoreProcedureListResult<Branch> spGAllBranch() throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_list_branch", Branch.class)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		int statusCode=(int) query.getOutputParameterValue("status_code");
		String messageError =(String) query.getOutputParameterValue("message_error");
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Branch>(statusCode,messageError,query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST,messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public Branch findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
