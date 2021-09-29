package com.emse.spring.faircorp.hello;

import java.util.List;

public interface SensorCustomDao {
    List<Sensor> findBySiteText(String searchText);
}