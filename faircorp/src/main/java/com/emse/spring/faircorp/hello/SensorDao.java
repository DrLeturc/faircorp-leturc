package com.emse.spring.faircorp.hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// JpaRepository is a Spring Data interface, which provides common methods such as findOne, save, delete and more. This example will handle Sensors entities, and those are identified by an Id of type Long (generics type used in JpaRepository).
// see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories

public interface SensorDao extends JpaRepository<Sensor, Long>{ //extends JpaRepository<Sensor, String>, SensorCustomDao{

	// see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	
    List<Sensor> findBySiteId(String siteId); // (1).

    @Query("select c from Sensor c where c.name=:name")  // (2)
    Sensor findByName(@Param("name") String name);

    @Modifying // (3)
    @Query("delete from Sensor c where c.name = ?1")
    void deleteByName(String name);
    
    
//    List<Sensor> findByNameAndSiteId(String name, String siteId);
//    List<Sensor> findByNameOrSiteId(String name, String siteId);
//    List<Sensor> findByNameIgnoreCase(String name);
//    List<Sensor> findByNameAndSiteIdAllIgnoreCase(String name, String siteId);
//    List<Sensor> findByNameOrderByNameAsc(String name);
//    List<Sensor> findByNameOrderByNameDesc(String name);
//    Sensor findByName(String name);
}