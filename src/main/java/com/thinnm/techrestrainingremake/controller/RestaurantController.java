package com.thinnm.techrestrainingremake.controller;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinnm.techrestrainingremake.entity.Restaurant;
import com.thinnm.techrestrainingremake.entity.RestaurantBrand;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.request.CRUDRestaurantRequest;
import com.thinnm.techrestrainingremake.request.CRUDRestaurantsRequest;
import com.thinnm.techrestrainingremake.response.BaseResponse;
import com.thinnm.techrestrainingremake.response.RestaurantBrandResponse;
import com.thinnm.techrestrainingremake.response.RestaurantBrandResponseAll;
import com.thinnm.techrestrainingremake.response.RestaurantResponse;
import com.thinnm.techrestrainingremake.service.RestaurantBrandService;
import com.thinnm.techrestrainingremake.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController extends BaseController {
	@Autowired
	private RestaurantService restaurantService;

//	@Autowired
//	private RestaurantBrandService restaurantBrandService;

	/*
	 * produces = MediaType. : Biểu diễn loại MIME media có thể tạo ra và trả về\
	 * 
	 * @Valid : tạo các ràng buộc giá trị các tham số request tới
	 */

	/*
	 * Tạo 1 đối tượng
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDRestaurantRequest wrappers) throws Exception {
		BaseResponse response = new BaseResponse();

		Restaurant restaurant = restaurantService.spUCreateRestaurant(wrappers.getName(), wrappers.getEmail(),
				wrappers.getPhone(), wrappers.getInfo(), wrappers.getAddress(), wrappers.getStatus(),
				wrappers.getLogoUrl());

		response.setData(new RestaurantResponse(restaurant));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/create-multi", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> creates(@Valid @RequestBody CRUDRestaurantsRequest listWrapper)
			throws Exception {
		BaseResponse response = new BaseResponse();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listWrapper.getList());
		
		StoreProcedureListResult<Restaurant> restaurants = restaurantService.spUCreateRestaurants(json);
		
		response.setData(new RestaurantResponse().mapToList(restaurants.getResult()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	/*
	 * update cửa hàng theo giá trị id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@RequestBody CRUDRestaurantRequest wrapper, @PathVariable("id") int id)
			throws Exception {
		BaseResponse response = new BaseResponse();
		Restaurant restaurant = restaurantService.findById(id);
		if (restaurant == null) { // không tìm thấy id
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}
		restaurant = restaurantService.spUUpdateRestaurant(id, wrapper.getName(), wrapper.getEmail(),
				wrapper.getPhone(), wrapper.getInfo(), wrapper.getAddress(), wrapper.getStatus(), wrapper.getLogoUrl());
		response.setData(new RestaurantResponse(restaurant));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	/*
	 * getlist by status + keySearch status -1: getAll 0: non-active 1: active
	 * keySearch : search by name
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> search(
			@RequestParam(name = "status", required = true, defaultValue = "-1") String status,
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch) throws Exception {
		BaseResponse response = new BaseResponse();
		StoreProcedureListResult<Restaurant> restaurants = restaurantService.spGlRestaurant(Integer.valueOf(status),
				keySearch);
		response.setData(new RestaurantResponse().mapToList(restaurants.getResult()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	/*
	 * detail by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getDetailById(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		Restaurant restaurants = restaurantService.findById(id);
		if (restaurants == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Nha hang khong ton tai!");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}
		response.setData(new RestaurantResponse(restaurants));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
