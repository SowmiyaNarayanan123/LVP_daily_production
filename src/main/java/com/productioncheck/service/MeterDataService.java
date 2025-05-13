package com.productioncheck.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.productioncheck.dtos.RequestDTO;
import com.productioncheck.repository.*;

@Service
public class MeterDataService {
	
	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	private LVPMeterDataRepository aggregationrepository;
	
	@Autowired
	private LVPSubmetersRespository submeterrepository;
	@Autowired
	private WaterMeterDataAggregationRepository watermeterrepository;
	@Autowired
	private WaterSubMeterAggregationRepository watersubmeterrepository;
	
	public Object fetchData(RequestDTO requestDTO, Pageable pageable) {
	    String meterType = requestDTO.getMeterType();
	    Long startDateEpoch = requestDTO.getStartDate();
	    Long endDateEpoch = requestDTO.getEnddate();

	    List<String> community = requestDTO.getCommunity();
	    List<String> subcommunity = requestDTO.getSubcommunity();
	    List<String> colony = requestDTO.getColony();
	    List<String> site = requestDTO.getSite();

	    Timestamp startTimestamp = Timestamp.from(Instant.ofEpochSecond(startDateEpoch));
	    Timestamp endTimestamp = Timestamp.from(Instant.ofEpochSecond(endDateEpoch));
        switch(meterType) {
		case "LVP_Meter":
			
			return aggregationrepository.findFilteredData(colony, community, subcommunity, site, startTimestamp,  endTimestamp, pageable);

		
		case "LVP_SubMeter":
			 
			return submeterrepository.findFilteredData(colony, community, subcommunity, site, startTimestamp,  endTimestamp, pageable);
			
		case "Water_Meter":
		    
		    return watermeterrepository.findFilteredData(colony, community, subcommunity, site, startTimestamp,  endTimestamp, pageable);
		    
		case"Water_SubMeter":
			 
			 return watersubmeterrepository.findFilteredData(colony, community, subcommunity, site, startTimestamp,  endTimestamp, pageable);
			
		default:
			throw new IllegalArgumentException("Invalid-Type");
	}
		
	
}
	


	}
