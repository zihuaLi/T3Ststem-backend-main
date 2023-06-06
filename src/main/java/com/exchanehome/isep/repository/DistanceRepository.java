package com.exchanehome.isep.repository;

import com.exchanehome.isep.entity.Distance;
import com.exchanehome.isep.entity.Site;
import org.hibernate.graph.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
