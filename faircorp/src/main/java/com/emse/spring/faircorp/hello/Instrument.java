package com.emse.spring.faircorp.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instrument {
    @Id
    private Long id;
    private String name;

     // ...
}
