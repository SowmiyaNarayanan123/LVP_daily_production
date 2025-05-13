package com.productioncheck.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import com.productioncheck.beans.LVPMeter;
@Repository
public class LVPMeterDataRepository {
 @PersistenceContext
    private EntityManager entityManager;
   public Page<LVPMeter> findFilteredData(
            List<String> colony,
            List<String> community,
            List<String> subcommunity,
            List<String> site,
            Timestamp startTimestamp,
            Timestamp endTimestamp,
            Pageable pageable) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LVPMeter> cq = cb.createQuery(LVPMeter.class);
        Root<LVPMeter> root = cq.from(LVPMeter.class);

        List<Predicate> predicates = new ArrayList<>();

       
        if (startTimestamp != null && endTimestamp != null) {
            predicates.add(cb.between(root.get("datetime"), startTimestamp, endTimestamp));
        }

        
        if (!CollectionUtils.isEmpty(colony)) {
            predicates.add(root.get("colony").in(colony));
        }

        if (!CollectionUtils.isEmpty(community)) {
            predicates.add(root.get("community").in(community));
        }

        if (!CollectionUtils.isEmpty(subcommunity)) {
            predicates.add(root.get("subCommunity").in(subcommunity));
        }

        if (!CollectionUtils.isEmpty(site)) {
            predicates.add(root.get("site").in(site));
        }

        cq.select(root).where(predicates.toArray(new Predicate[0]));

       
        Query countQuery = entityManager.createQuery(cq);
        long totalRecords = countQuery.getResultList().size();

        
        Query query = entityManager.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<LVPMeter> resultList = query.getResultList();

        return new PageImpl<>(resultList, pageable, totalRecords);
    }
}
