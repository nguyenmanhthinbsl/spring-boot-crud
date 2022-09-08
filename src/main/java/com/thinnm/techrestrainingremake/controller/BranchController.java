package com.thinnm.techrestrainingremake.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinnm.techrestrainingremake.entity.Branch;
import com.thinnm.techrestrainingremake.entity.RestaurantBrand;
import com.thinnm.techrestrainingremake.entity.StoreProcedureListResult;
import com.thinnm.techrestrainingremake.enums.StoreProcedureStatusCodeEnum;
import com.thinnm.techrestrainingremake.request.CRUDBranchRequest;
import com.thinnm.techrestrainingremake.response.BaseResponse;
import com.thinnm.techrestrainingremake.response.BranchResponse;
import com.thinnm.techrestrainingremake.service.BranchService;
import com.thinnm.techrestrainingremake.service.RestaurantBrandService;

@RestController
@RequestMapping("/api/branches")
public class BranchController extends BaseController {

	@Autowired
	BranchService branchService;
	@Autowired
	RestaurantBrandService restaurantBrandService;

	@RequestMapping( value = "",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<BaseResponse> getAllBranch() throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Branch> branches = branchService.spGAllBranch();
			if (branches.getResult().size() == 0) {
				response.setStatus(HttpStatus.OK);
				response.setMessage(HttpStatus.NO_CONTENT);
			} else {
				response.setData(new BranchResponse().mapToList(branches.getResult()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/list_by_restaurant/{id}",method=RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getListByRestaurant(@Valid @PathVariable("id") int id) {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Branch> branches = branchService.spGlBranchByRestaurant(id);
			if (StoreProcedureStatusCodeEnum.valueOf(branches.getStatusCode()).equals(StoreProcedureStatusCodeEnum.INPUT_INVALID)) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			} else {
				response.setData(new BranchResponse().mapToList(branches.getResult()));
			}
		} catch (Exception e) {
			// TODO: handle exception\
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/list_by_restaurantv2/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getListByRestaurantv2(@Valid @PathVariable("id") int id) {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Branch> branches = branchService.spGlBranchByRestaurant(id);
			if (StoreProcedureStatusCodeEnum
					.valueOf(branches.getStatusCode()) == StoreProcedureStatusCodeEnum.SUCCESS) {
				response.setStatus(HttpStatus.OK);
				if (branches.getResult().size() == 0) {
					response.setMessage(HttpStatus.NO_CONTENT);
				} else {
					response.setData(new BranchResponse().mapToList(branches.getResult()));
				}
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception\
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/list_by_brand/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getListByBrand(@Valid @PathVariable("id") int id) {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Branch> branches = branchService.spGlBranchByRestaurantBrandId(id);
			if(StoreProcedureStatusCodeEnum.valueOf(branches.getStatusCode())==StoreProcedureStatusCodeEnum.INPUT_INVALID) {
//			if (branches.getStatusCode() == 1) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			} else {
				if(branches.getResult().size()==0) {
					return new ResponseEntity<BaseResponse>(response,HttpStatus.NO_CONTENT);
				}
				response.setData(new BranchResponse().mapToList(branches.getResult()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/detail/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getDetail(@Valid @PathVariable("id") int id) {
		BaseResponse response = new BaseResponse();
		try {
			Branch branch = branchService.spGDetail(id);
			if (branch == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			} else {
				response.setData(new BranchResponse(branch));
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/{restaurantBrandId}/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @PathVariable("restaurantBrandId") int restaurantBrandId,
			@RequestBody CRUDBranchRequest wrappers) {
		BaseResponse response = new BaseResponse();
		try {
			// tìm theo mã thương hiệu -> nếu có lấy mã cửa hàng
			RestaurantBrand brand = restaurantBrandService.spGDetailRestaurantBrand(restaurantBrandId);
			if (brand == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			} else {
				Branch branch = branchService.spUCreate(brand.getRestaurantId(), restaurantBrandId, wrappers.getName(),
						wrappers.getStreetName(), wrappers.getAddressFullText(), wrappers.getPhoneNumber());
				if (branch == null) {
					response.setStatus(HttpStatus.BAD_REQUEST);
					response.setMessage(HttpStatus.BAD_REQUEST);
				}
				response.setData(new BranchResponse(branch));
			}

		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/update/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateById(@Valid @PathVariable("id") int id,
			@RequestBody CRUDBranchRequest wrapper) {
		BaseResponse response = new BaseResponse();
		try {
			Branch branch = branchService.spUUpdate(id, wrapper.getName(), wrapper.getStreetName(),
					wrapper.getAddressFullText(), wrapper.getPhoneNumber(), wrapper.getStatus());
			if (branch == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			} else {
				response.setData(new BranchResponse(branch));
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
