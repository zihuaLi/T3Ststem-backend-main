package com.exchanehome.isep.repository;

import com.exchanehome.isep.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainRepository extends JpaRepository<Site, Long> {
    @Query(value = "select * from site where location=?1",nativeQuery = true)
    List<Site> getSiteByLocation(String location);
    @Query(value = "select * from site where siteid=?1",nativeQuery = true)
    List<Site> getSiteInfo(Long siteid);

    @Query(value = "select * from site where siteid in (?1)",nativeQuery = true)
    List<Site> getSiteByIds(List<Long> siteIds);
    @Query(value = "select * from site where sitename=?1",nativeQuery = true)
   Site findBySiteName(String SiteName);
    @Query(value = "select * from site where location=?1 and period=?2",nativeQuery = true)
    List<Site> findSiteBySearchAll(String Location,String Period);
    @Query(value = "select siteid from site where sitename=?1",nativeQuery = true)
    long findSiteIdByName(String SiteName);
    @Query(value = "select * from site where sitename=?1",nativeQuery = true)
    Site findSiteByName(String SiteName);
    @Query(value = "select * from site where sitetype=?1 and period=?2",nativeQuery = true)
    List<Site> finnBytypeAndPeriod(String SiteType,String Period);


}
