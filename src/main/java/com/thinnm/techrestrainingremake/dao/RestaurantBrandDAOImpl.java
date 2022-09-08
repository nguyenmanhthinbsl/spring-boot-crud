package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.thinnm.techrestrainingremake.entity.Branch;
import com.thinnm.techrestrainingremake.entity.RestaurantBrand;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.enums.StoreProcedureStatusCodeEnum;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;

@Repository("restaurantBrandDAO")
public class RestaurantBrandDAOImpl extends AbstractDAO<Integer, RestaurantBrand> implements RestaurantBrandDAO {

	@SuppressWarnings("deprecation")
	@Override
	public RestaurantBrand findById(int id) {
		// TODO Auto-generated method stub
		return (RestaurantBrand) this.getSession().createCriteria(Branch.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<RestaurantBrand> findAll() {
		// TODO Auto-generated method stub
		CriteriaQuery<RestaurantBrand> criteriaQuery = this.getBuilder().createQuery(RestaurantBrand.class);
		Root<RestaurantBrand> root = criteriaQuery.from(RestaurantBrand.class);
		// xác định metamodel mà criteria thao tác
		criteriaQuery.select(root);
		// query trả về danh sách : getResultList
		return this.getSession().createQuery(criteriaQuery).getResultList();
	}

	// sp get list restaurant brand by restaurant id
	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<RestaurantBrand> spGlRestaurantBrandByRestaurantId(int id)
			throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_list_brand_by_restaurant_id")
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		query.setParameter("_id", id);
		int status_code = (int) query.getOutputParameterValue("status_code");
		String message_error = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(status_code)) {
		case SUCCESS:
			// success but empty
			if (query.getResultList().isEmpty()) {
				return new StoreProcedureListResult<RestaurantBrand>(status_code, message_error, null);
			}

			return new StoreProcedureListResult<RestaurantBrand>(status_code, message_error, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, message_error);
		default:
			throw new Exception(message_error);
		}
	}
	// sp get all restaurant brand in db

	@SuppressWarnings("unchecked")
	@Override
	public RestaurantBrand spUCreateRestaurantBrand(int restaurantId,String name, String logo_url, String banner, String description)
			throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_restaurant_brand",RestaurantBrand.class)
				.registerStoredProcedureParameter("_restaurantId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_logo_url", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_banner", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_restaurantId", restaurantId);
		query.setParameter("_name", name);
		query.setParameter("_logo_url", logo_url);
		query.setParameter("_banner", banner);
		query.setParameter("_description", description);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (RestaurantBrand) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<RestaurantBrand> spGAllRestaurantBrand() throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_list_restaurant_brand", RestaurantBrand.class)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		int status_code = (int) query.getOutputParameterValue("status_code");
		String message_error = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(status_code)) {
		case SUCCESS:
			return new StoreProcedureListResult<RestaurantBrand>(status_code, message_error, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, message_error);
		default:
			throw new Exception(message_error);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public RestaurantBrand spUUpdateRestaurantBrand(int id, String name, String logo_url, String banner,
			int status,String description) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_update_restaurant_brand", RestaurantBrand.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_logoUrl", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_banner", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);
		query.setParameter("_name", name);
		query.setParameter("_logoUrl", logo_url);
		query.setParameter("_banner", banner);
		query.setParameter("_status", status);
		query.setParameter("_description", description);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode) ) {
		case SUCCESS:
			return  (RestaurantBrand) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST,messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public RestaurantBrand spGDetailRestaurantBrand(int id) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_detail_restaurant_brand", RestaurantBrand.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		query.setParameter("_id", id);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (RestaurantBrand) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}
