package com.productioncheck.Controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productioncheck.service.MeterDataService;
import com.productioncheck.beans.LVPMeter;
import com.productioncheck.dtos.RequestDTO;
import com.productioncheck.repository.AggregationBoundRepository;

@RestController
@RequestMapping("/meter-data")
public class MeterController {

    @Autowired
    private MeterDataService meterService;

    @Autowired
    private AggregationBoundRepository repo;

    @PostMapping("")
    public ResponseEntity<Page<LVPMeter>> fetchData(
            @RequestBody RequestDTO service,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        // Convert Unix timestamps to Timestamp
        Long startDate = service.getStartDate();
        Long endDate = service.getEnddate();

        Timestamp startTimestamp = new Timestamp(startDate * 1000); // Convert seconds to milliseconds
        Timestamp endTimestamp = new Timestamp(endDate * 1000); // Convert seconds to milliseconds

        // Print converted timestamps
        System.out.println("Start Timestamp: " + startTimestamp);
        System.out.println("End Timestamp: " + endTimestamp);

        // Pageable configuration for pagination
        Pageable pageable = PageRequest.of(page, size, Sort.by("datetime").descending());

        // Fetch filtered data from the repository
        Page<LVPMeter> result = repo.findFilteredData(
                service.getColony(),
                service.getCommunity(),
                service.getSubcommunity(),
                service.getSite(),
                startTimestamp, // Use converted start timestamp
                endTimestamp, // Use converted end timestamp
                pageable
        );

        // Check if the result is empty
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }
}
