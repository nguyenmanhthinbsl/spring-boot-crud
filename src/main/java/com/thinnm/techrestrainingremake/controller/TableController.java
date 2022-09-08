package com.thinnm.techrestrainingremake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinnm.techrestrainingremake.service.TableService;

@RestController
@RequestMapping("/api/table")
public class TableController extends BaseController{
	
	@Autowired
	TableService tableService;
	
}
