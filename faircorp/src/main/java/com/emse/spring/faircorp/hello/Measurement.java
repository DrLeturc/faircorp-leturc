package com.emse.spring.faircorp.hello;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Measurement {

    @Id
    private Long id;

    @ManyToOne(optional = false)
    private Sensor sensor;

    // ...
}