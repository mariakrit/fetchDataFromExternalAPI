package com.maria.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maria.springproject.business.service.AreaDataService;




@RestController
public class AreaDataWebController {
	
	@Autowired
    AreaDataService areaDataService;
	
	@GetMapping(value = "/data")
	public ResponseEntity getTotalData() {		
		areaDataService.fetchAreas();		
		return ResponseEntity.status(HttpStatus.OK).body("Data Printed");	
	}
}

