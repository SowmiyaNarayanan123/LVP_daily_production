package com.productioncheck.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.productioncheck.beans.LVPSubMeter;
import com.productioncheck.dtos.LVPMeterDTO;
import com.productioncheck.repository.*;

import com.productioncheck.repository.*;
import com.productioncheck.repository.*;
import com.productioncheck.repository.*;

@Service
public class MeterDataService {
    @Autowired
	private LvpMeterDataAggregationRepository lvpDataAggregationRepository;
	@Autowired
	private LVPSubMetersRepository lvpSubMetersRepository;
	@Autowired
	private WaterMetersRepository waterMetersRepository;
	@Autowired
	private WaterSubMetersRepository waterSubMetersRepository;
	
	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	private AggregationBoundRepository aggregationrepo;
	
	public Object fetchData(String meterType,Long StartDateEpoch,Long EndDateEpoch, List<String>community,List<String>subcommunity,List<String> colony,List<String> site ,Pageable pageable) {

		Timestamp startTimestamp = Timestamp.from(Instant.ofEpochSecond(StartDateEpoch));
        Timestamp endTimestamp = Timestamp.from(Instant.ofEpochSecond(EndDateEpoch));
		
		switch(meterType) {
		case "LVP_Meter":
			lvpDataAggregationRepository.findAll();
			return aggregationrepo.findFilteredData(colony, community, subcommunity, site, startTimestamp,  endTimestamp, pageable);

		
		case "LVP_SubMeter":
			return lvpSubMetersRepository.findAll();
			
		case "Water_Meter":
		    return waterMetersRepository.findAll();
		    
		case"Water_SubMeter":
			return waterSubMetersRepository.findAll();
			
		default:
			throw new IllegalArgumentException("Invalid-Type");
	}
		
	
}
	


	}
