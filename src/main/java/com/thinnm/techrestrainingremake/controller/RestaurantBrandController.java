package com.thinnm.techrestrainingremake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinnm.techrestrainingremake.entity.RestaurantBrand;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.request.CRUDRestaurantBrandRequest;
import com.thinnm.techrestrainingremake.response.BaseResponse;
import com.thinnm.techrestrainingremake.response.RestaurantBrandResponse;
import com.thinnm.techrestrainingremake.service.RestaurantBrandService;

@RestController
@RequestMapping("/api/restaurant_brand")
public class RestaurantBrandController extends BaseController {

	@Autowired
	RestaurantBrandService restaurantBrandService;

	// get list restaurant brand by restaurant id
	// id: RestaurantId
//	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> getList(@PathVariable("id") int id) throws Exception {
//		BaseResponse response = new BaseResponse();
//		StoreProcedureListResult<RestaurantBrand> restaurantBrand = restaurantBrandService.spGlRestaurantBrand(id);
//		if (restaurantBrand.getTotalRecord() == 0L) {
//			response.setStatus(HttpStatus.OK);
//			response.setMessage(HttpStatus.NO_CONTENT);
//		} else {
//			response.setData(new RestaurantBrandResponse().mapToList(restaurantBrand.getResult()));
//		}
//		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
//	}

	// update
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateById(@PathVariable("id") int restauranBrandId,
			@Valid @RequestBody CRUDRestaurantBrandRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();
		RestaurantBrand restaurantBrand = restaurantBrandService.spUUpdateRestaurantBrand(restauranBrandId,
				wrapper.getName(), wrapper.getLogoUrl(), wrapper.getBanner(), wrapper.getStatus(),
				wrapper.getDescription());
		if (restaurantBrand == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage(HttpStatus.BAD_REQUEST);
		} else {
			response.setData(new RestaurantBrandResponse(restaurantBrand));
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// list
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getAll() throws Exception {
		BaseResponse response = new BaseResponse();
		StoreProcedureListResult<RestaurantBrand> restaurantBrands = restaurantBrandService.spGAllRestaurantBrand();
		if (restaurantBrands.getTotalRecord() == 0L) {
			response.setStatus(HttpStatus.OK);
			response.setMessage(HttpStatus.NO_CONTENT);
		} else {
			response.setData(new RestaurantBrandResponse().mapToList(restaurantBrands.getResult()));
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// create
	// param: id -> RestaurantId
	@RequestMapping(value = "", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@RequestParam("id") int id, HttpServletRequest request,
			@RequestBody CRUDRestaurantBrandRequest wrappers) throws Exception {
		BaseResponse response = new BaseResponse();
		RestaurantBrand restaurantBrand = restaurantBrandService.spUCreateRestaurantBrand(id,
				wrappers.getName(), wrappers.getLogoUrl(), wrappers.getBanner(), wrappers.getDescription());
		if (restaurantBrand == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage(HttpStatus.BAD_REQUEST);
		}
		response.setData(new RestaurantBrandResponse(restaurantBrand));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// detail
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getDetail(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		RestaurantBrand restaurantBrand = restaurantBrandService.spGDetailRestaurantBrand(id);
		if (restaurantBrand == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage(HttpStatus.BAD_REQUEST);
		} else {
			response.setData(new RestaurantBrandResponse(restaurantBrand));
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
