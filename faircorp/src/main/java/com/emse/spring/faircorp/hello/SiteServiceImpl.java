package com.emse.spring.faircorp.hello;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {

    public Site addSite(String name){
        Site site = new Site(name);
//        site.addSensor(new Sensor("default", site)
//                               .withPowerSource(PowerSource.FIXED)
//                               .withDefaultPowerInWatt(1_000_000));
//        siteDao.save(site);
        return site;
    }
}