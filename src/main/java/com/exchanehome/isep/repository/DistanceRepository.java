package com.exchanehome.isep.repository;

import com.exchanehome.isep.entity.Distance;
import com.exchanehome.isep.entity.Site;
import org.hibernate.graph.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistanceRepository extends JpaRepository<Distance, Long> {
    @Query(value = "select sitetoid from distance where site_siteid=?1",nativeQuery = true)
    long findsiteToId(long siteid) ;
    @Query(value = "select distance from distance where site_siteid=?1",nativeQuery = true)
    long findsiteDistanceById(long siteid);

}
