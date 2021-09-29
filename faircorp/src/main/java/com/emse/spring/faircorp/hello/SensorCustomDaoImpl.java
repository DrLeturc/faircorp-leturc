package com.emse.spring.faircorp.hello;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class SensorCustomDaoImpl implements SensorCustomDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Sensor> findBySiteText(String searchText) {
        return em.createQuery("select c from Sensor c inner join c.site s where lover(s.name) like :searchText",
                              Sensor.class)
                 .setParameter("searchText", "%" + searchText.toLowerCase() + "%")
                 .getResultList();
    }
}