package com.productioncheck.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.productioncheck.beans.LVPSubMeter;
import com.productioncheck.beans.WaterMeter;
@Repository
public class WaterMeterDataAggregationRepository {
	@PersistenceContext
    private EntityManager entityManager;
    public Page<WaterMeter> findFilteredData(
            List<String> colony, 
            List<String> community, 
            List<String> subcommunity, 
            List<String> site, 
            Timestamp startTimestamp, 
            Timestamp endTimestamp, 
            Pageable pageable) {
    	
    	 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<LVPSubMeter> cq = cb.createQuery(LVPSubMeter.class);
	        Root<LVPSubMeter> root = cq.from(LVPSubMeter.class);

	        
	        List<Predicate> predicates = new ArrayList<>();

	       
	        if (startTimestamp != null && endTimestamp != null) {
	            predicates.add(cb.between(root.get("datetime"), startTimestamp, endTimestamp));
	        }

	       
	        if (colony != null && !colony.isEmpty()) {
	            predicates.add(root.get("colony").in(colony));
	        }

	        if (community != null && !community.isEmpty()) {
	            predicates.add(root.get("community").in(community));
	        }

	     
	        if (subcommunity != null && !subcommunity.isEmpty()) {
	            predicates.add(root.get("subCommunity").in(subcommunity));
	        }

	      
	        if (site != null && !site.isEmpty()) {
	            predicates.add(root.get("site").in(site));
	        }

	        
	        cq.select(root).where(predicates.toArray(new Predicate[0]));

	       
	        javax.persistence.Query countQuery = entityManager.createQuery(cq);
	        long totalRecords = countQuery.getResultList().size();

	        
	        javax.persistence.Query query = entityManager.createQuery(cq);
	        query.setFirstResult((int) pageable.getOffset());
	        query.setMaxResults(pageable.getPageSize());

	        
	        List<WaterMeter> resultList = query.getResultList();

	       
	        return new org.springframework.data.domain.PageImpl<>(resultList, pageable, totalRecords);
	    
		


	        
	    }

    }

