package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.thinnm.techrestrainingremake.entity.Restaurant;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.enums.StoreProcedureStatusCodeEnum;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;

@Transactional
@Repository("restaurantDAO")
public class RestaurantDAOImpl extends AbstractDAO<Integer, Restaurant> implements RestaurantDAO {

	@SuppressWarnings("deprecation")
	@Override
	public Restaurant findById(int id) {
		// TODO Auto-generated method stub
		return (Restaurant) this.getSession().createCriteria(Restaurant.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		CriteriaQuery<Restaurant> criteriaQuery = this.getBuilder().createQuery(Restaurant.class);
		Root<Restaurant> root = criteriaQuery.from(Restaurant.class);
		criteriaQuery.select(root);
		return this.getSession().createQuery(criteriaQuery).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<Restaurant> spGlRestaurant(int status, String keySearch) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_list_restaurant", Restaurant.class)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_keySearch", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		query.setParameter("_status", status);
		query.setParameter("_keySearch", keySearch);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Restaurant>(statusCode, messageError, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Restaurant spGDetailRestaurant(int id) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_detail_restaurant", Restaurant.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Restaurant) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Restaurant spUCreateRestaurant(String name, String email, String phone, String info, String address,
			int status, String logo) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_restaurant", Restaurant.class)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_email", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_info", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_address", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_logo", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_name", name);
		query.setParameter("_email", email);
		query.setParameter("_phone", phone);
		query.setParameter("_info", info);
		query.setParameter("_address", address);
		query.setParameter("_status", status);
		query.setParameter("_logo", logo);
		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Restaurant) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:	
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Restaurant spUUpdateRestaurant(int id, String name, String email, String phone, String info, String address,
			int status, String logoUrl) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_update_restaurant", Restaurant.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_email", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_info", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_address", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_logoUrl", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);
		query.setParameter("_name", name);
		query.setParameter("_email", email);
		query.setParameter("_phone", phone);
		query.setParameter("_info", info);
		query.setParameter("_address", address);
		query.setParameter("_status", status);
		query.setParameter("_logoUrl", logoUrl);
		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Restaurant) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<Restaurant> spUCreateRestaurants(String json) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_restaurants", Restaurant.class)
				.registerStoredProcedureParameter("_json", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_json", json);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Restaurant>(statusCode, messageError, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
	}

}
