package com.thinnm.techrestrainingremake.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.thinnm.techrestrainingremake.entity.Area;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.enums.StoreProcedureStatusCodeEnum;
import com.thinnm.techrestrainingremake.exceptions.TechresHttpException;

@Repository("areaDao")
@SuppressWarnings("unchecked")
public class AreaDAOImpl extends AbstractDAO<Integer, Area> implements AreaDAO {

	@SuppressWarnings("deprecation")
	@Override
	public Area findById(int id) {
		// TODO Auto-generated method stub
		// trả về object Area với id là id
		return (Area) this.getSession().createCriteria(Area.class).add(Restrictions.eq("id", id)).uniqueResult(); // eq:
																													// equal
	}

	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		// tạo truy vấn trên lớp Areas
		CriteriaQuery<Area> criteria = this.getBuilder().createQuery(Area.class);

		Root<Area> root = criteria.from(Area.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}

	// get list area by area name
	@Override
	public StoreProcedureListResult<Area> spGlAreas(String name) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_gl_areas")
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("name", name);

		int status_code = (int) query.getOutputParameterValue("status_code");
		String message_error = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(status_code)) {
		case SUCCESS:
			return new StoreProcedureListResult<Area>(status_code, message_error, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, message_error);
		default:
			throw new Exception(message_error);
		}
	}

	@Override
	public Area spUCreateArea(int restaurantId, int restaurantBrandId, int branchId, String name, String decription)
			throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_area", Area.class)
				.registerStoredProcedureParameter("restaurantId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("restaurantBrandId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("branchId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("restaurantId", restaurantId);
		query.setParameter("restaurantBrandId", restaurantBrandId);
		query.setParameter("branchId", branchId);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Area) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}

	}

	// update area by area id
	@Override
	public void spUUpdateArea(int areaId, String name, String description) throws Exception {
		// TODO Auto-generated method stub

		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_update_area")
				.registerStoredProcedureParameter("areaId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		query.setParameter("areaId", areaId);
		query.setParameter("_name", name);
		query.setParameter("_description", description);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}

	}

	// get All Area in db
	@Override
	public StoreProcedureListResult<Area> spGAllAreas() throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_list_area", Area.class)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Area>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreasByRestaurantId(int restaurantId) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_list_area_by_restaurant_id", Area.class)
				.registerStoredProcedureParameter("restaurantId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		query.setParameter("restaurantId", restaurantId);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		/*
		 * SUCCESS 2 Case : 1. return data 2. empty
		 */
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Area>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreasByRestaurantBrandId(int restaurantBrandId) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_list_area_by_restaurant_brand_id", Area.class)
				.registerStoredProcedureParameter("restaurantBrandId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		query.setParameter("restaurantBrandId", restaurantBrandId);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Area>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreasByBranchId(int branchId) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_list_area_by_branch_id", Area.class)
				.registerStoredProcedureParameter("_branchId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		query.setParameter("_branchId", branchId);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = (String) query.getOutputParameterValue("message_error");

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Area>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}
