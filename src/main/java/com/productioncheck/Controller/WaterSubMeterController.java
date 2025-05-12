package com.productioncheck.Controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productioncheck.beans.WaterSubMeter;
import com.productioncheck.dtos.RequestDTO;
import com.productioncheck.repository.WaterSubMeterAggregationRepository;
import com.productioncheck.service.MeterDataService;

@Controller
@RequestMapping("/watersubmeter-data")
public class WaterSubMeterController {
	 @Autowired
	    private MeterDataService meterService;

	    @Autowired
	    private WaterSubMeterAggregationRepository repo;

	    @PostMapping("")
	    public ResponseEntity<Page<WaterSubMeter>> fetchData(
	            @RequestBody RequestDTO service,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "5") int size) {

	       
	        Long startDate = service.getStartDate();
	        Long endDate = service.getEnddate();

	        Timestamp startTimestamp = new Timestamp(startDate * 1000); 
	        Timestamp endTimestamp = new Timestamp(endDate * 1000); 
	        
	        System.out.println("Start Timestamp: " + startTimestamp);
	        System.out.println("End Timestamp: " + endTimestamp);

	      
	        Pageable pageable = PageRequest.of(page, size, Sort.by("datetime").descending());

	       
	        Page<WaterSubMeter> result = repo.findFilteredData(
	                service.getColony(),
	                service.getCommunity(),
	                service.getSubcommunity(),
	                service.getSite(),
	                startTimestamp, 
	                endTimestamp, 
	                pageable
	        );
	        if (result.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }

	        return ResponseEntity.ok(result);
	    }

}
