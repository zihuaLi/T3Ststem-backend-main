package com.exchanehome.isep.entity;
import javax.persistence.*;


@Entity
@Table(name = "distance")
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long distanceid;
    //private Long sitetoid;
   private Long sitetoid;
    private Long distance;
    private Long site_siteid;
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_siteid")
    private Site site;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sitetoid")
    private Site targetSite;
    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Site getTargetSite() {
        return targetSite;
    }

    public void setTargetSite(Site targetSite) {
        this.targetSite = targetSite;
    }
*/
    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Long getSitetoid() {
        return sitetoid;
    }

    public void setSitetoid(Long sitetoid) {
        this.sitetoid = sitetoid;
    }
    public Long getSite_siteid() {
        return site_siteid;
    }

    public void setSite_siteid(Long site_siteid) {
        this.site_siteid = site_siteid;
    }
    public Long getDistanceid() {
        return distanceid;
    }

    public void setDistanceid(Long distanceid) {
        this.distanceid = distanceid;
    }
}
