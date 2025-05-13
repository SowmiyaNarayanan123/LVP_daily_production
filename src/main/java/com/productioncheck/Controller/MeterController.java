package com.productioncheck.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productioncheck.dtos.RequestDTO;
import com.productioncheck.service.MeterDataService;

@RestController
@RequestMapping("/meter-data")
public class MeterController {

	@Autowired
	private MeterDataService meterdataservice;
	@PostMapping("")
	public ResponseEntity<?> fetchMeterData(
	        @RequestBody RequestDTO requestDTO,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size) {
		if (requestDTO == null) {
	        return ResponseEntity.badRequest().body("Request DTO is missing.");
	    }
	    if (requestDTO.getStartDate() == null || requestDTO.getEnddate() == null) {
	        return ResponseEntity.badRequest().body("Start date or End date is missing.");
	    }
	    Pageable pageable = PageRequest.of(page, size, Sort.by("datetime").descending());

	    try {
	    	Object result = meterdataservice.fetchData(requestDTO, pageable);

	        return ResponseEntity.ok(result);
	    } catch (Exception e) { 
	        return ResponseEntity.status(500).body("An error occurred while fetching data: " + e.getMessage());
	    }
	}

}
