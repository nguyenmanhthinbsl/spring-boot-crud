package com.thinnm.techrestrainingremake.controller;

import javax.servlet.http.HttpServletRequest;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinnm.techrestrainingremake.entity.Area;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.response.AreaResponse;
import com.thinnm.techrestrainingremake.response.BaseResponse;
import com.thinnm.techrestrainingremake.service.AreaService;

@RestController
@RequestMapping("/api/area")
public class AreaController extends BaseController {

	@Autowired
	AreaService areaService;

	// get All Area in db
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getAll() throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Area> areas = areaService.spGAllAreas();
			if (areas.getResult().size() == 0) {
				response.setData(HttpStatus.OK);
				response.setMessage(HttpStatus.NO_CONTENT);
			} else {
				response.setData(new AreaResponse().mapToList(areas.getResult()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// Get all area in 1 restaurant
	@RequestMapping(value = "/list_by_restaurant/{restaurantId}", method = RequestMethod.GET)
	public ResponseEntity<BaseResponse> getAreaListByRestaurantId(HttpServletRequest request,
			@PathVariable(name = "restaurantId") int restaurantId) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Area> areas = areaService.spGlAreasByRestaurantId(restaurantId);
			if (areas.getResult().size() == 0) {
				response.setStatus(HttpStatus.OK);
				response.setMessage(HttpStatus.NO_CONTENT);
			} else {
				response.setData(new AreaResponse().mapToList(areas.getResult()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// get all area in 1 brand
	@RequestMapping(value = "/list_by_brand/{restaurantBrandId}", method = RequestMethod.GET)
	public ResponseEntity<BaseResponse> getListByBrand(@PathVariable(name = "restaurantBrandId") int restaurantBrandId)
			throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Area> areas = areaService.spGlAreasByRestaurantBrandId(restaurantBrandId);
			if (areas.getResult().size() == 0) {
				response.setStatus(HttpStatus.OK);
				response.setMessage(HttpStatus.NO_CONTENT);
			} else {
				response.setData(new AreaResponse().mapToList(areas.getResult()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// get area in 1 branch
	@RequestMapping(value = "/listByBranch/{branchId}", method = RequestMethod.GET)
	public ResponseEntity<BaseResponse> getListByBranch(@PathVariable(name = "branchId") int branchId)
			throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Area> areas = areaService.spGlAreasByBranchId(branchId);
			if (areas.getResult().size() == 0) {
				response.setStatus(HttpStatus.OK);
				response.setMessage(HttpStatus.NO_CONTENT);
			} else {
				response.setData(new AreaResponse().mapToList(areas.getResult()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
