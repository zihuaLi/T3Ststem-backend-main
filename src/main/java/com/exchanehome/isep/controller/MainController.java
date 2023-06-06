package com.exchanehome.isep.controller;
import com.exchanehome.isep.entity.Distance;
import com.exchanehome.isep.repository.DistanceRepository;
import com.exchanehome.isep.repository.MainRepository;
import com.exchanehome.isep.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.numberOfLeadingZeros;
import static java.lang.Integer.parseInt;

@Controller
public class MainController {

    @Autowired
    private MainRepository mainRepository;
    @Autowired
    private DistanceRepository distanceRepository;
    private Site site=new Site();

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    @RequestMapping(value="/search")
    public String SearchSiteSubmit(HttpServletRequest request,Model model){
        String SiteStart=request.getParameter("sitestart");
        String SiteEnd=request.getParameter("siteend");
        String Days=request.getParameter("days");
        String Period= request.getParameter("period");
        String Location=request.getParameter("ville");
        String TotalSites= request.getParameter("totalsite");
        String Budget= request.getParameter("budget");
        //int count=Integer.parseInt(TotalSites);
        //System.out.println("this+"+SiteStart+"+"+SiteEnd+"+"+Days+"+"+Period+"+"+Location+"+"+TotalSites+"+"+Budget);
        int type=1;
        //&&SiteEnd==null&&SiteStart==null&&Days==null&&TotalSites==null&&Budget==null
        if(Period!=null&&Location!=null&&"".equals(SiteEnd)&&"".equals(SiteStart)&&"".equals(Days)&&"".equals(TotalSites)&&"".equals(Budget)){
            //period&location
            type=1;
            List<Site> sites= mainRepository.findSiteBySearchAll(Location,Period);
            model.addAttribute("sites",sites);
            //model.addAttribute("type",type);
            System.out.println("type :"+type);
        }
        if(SiteStart!=null&&SiteEnd!=null&&"".equals(Period)&&"".equals(Location)&&"".equals(Days)&&"".equals(TotalSites)&&"".equals(Budget)) {
            type = 2;
            long startSite=mainRepository.findSiteIdByName(SiteStart);
            long endSite=mainRepository.findSiteIdByName(SiteEnd);
            List<Distance> distances = distanceRepository.findAll();
            model.addAttribute("distances", distances);
            System.out.println("type " + type);
            Graph graph = new Graph();
            for (Distance distance : distances) {
                Long source = distance.getSite_siteid();
                Long destination = distance.getSitetoid();
                Long weight = distance.getDistance();
                graph.addEdge(source, destination, weight);
            }
            PathFinder pathFinder = new PathFinder(graph);
            List<Long> path = pathFinder.findMaximumPath(startSite, endSite);
            System.out.println("Maximum path:");
            for (Long siteId : path) {
                // Print or process the site ID
                System.out.println(siteId);
            }
          List<Site> siteInfoList=mainRepository.getSiteByIds(path);
            model.addAttribute("siteInfoList",siteInfoList);
            return "index";
        }

        return "index";
    }

    @GetMapping("/sites")
    public String getSites(Model model) {
        List<Site> sites=mainRepository.findAll();
        model.addAttribute("sites",sites);
        System.out.println("total "+sites.size());
        return "sites";
    }
    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }
    @GetMapping("/admin/sites")
    public String getBankendSites(Model model) {

        List<Site> sites=mainRepository.findAll();
        model.addAttribute("sites",sites);
        int count=sites.size();
        model.addAttribute("count",count);
        return "bankendsites";
    }
    @GetMapping("/admin/addSite")
    public String getAddSite(Model model) {
        model.addAttribute("sites",new Site());
        return "addsite";
    }
    @RequestMapping(value="/admin/addSite")
    public String addSiteSubmit(HttpServletRequest request){
        String SiteName=request.getParameter("sitename");
        String SiteInfo=request.getParameter("info");
        String StartTime=request.getParameter("starttime");
        String EndTime=request.getParameter("endtime");
        String Period= request.getParameter("period");
        String Fee= request.getParameter("fee");
        String Location=request.getParameter("location");
        String SiteType=request.getParameter("sitetype");
       String BestTime= request.getParameter("besttime");
        String str="";
        if(SiteName!=null&&SiteInfo!=null&&StartTime!=null&&EndTime!=null&&Period!=null&&Fee!=null&&Location!=null&&SiteType!=null&&BestTime!=null){
          site=mainRepository.findBySiteName(SiteName);
          if(site==null){
              Site site=new Site();
              site.setSitename(SiteName);
              site.setInfo(SiteInfo);
              site.setStarttime(StartTime);
              site.setEndtime(EndTime);
              site.setPeriod( Period);
              site.setFee(Fee);
              site.setLocation(Location);
              site.setSitetype(SiteType);
              site.setBesttime(BestTime);
              mainRepository.save(site);
              str="bankendsites";
          }else {
              str="addsite";
              System.out.println("if if ");
          }
        }else {
            str="addsite";
            System.out.println("if" +SiteName+"+"+SiteInfo+"+"+StartTime+"+"+EndTime+"+"+Period+"+"+Fee+"+"+Location+"+"+SiteType+"+"+BestTime);

        }
        return str;
    }
    @GetMapping("/siteinfo")
    public  String getPage(@RequestParam("param") Long paramValue, Model model){
        model.addAttribute("param",paramValue);
        List<Site> l30 = mainRepository.getSiteInfo(paramValue);
        model.addAttribute("l30", l30);
        return "siteinfo";
    }


}
