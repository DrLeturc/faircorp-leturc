package com.emse.spring.faircorp.hello;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity()
public class Musician {
    @Id
    private Long id;
    private String name;

    @ManyToMany
    private Set<Instrument> instruments;

    // ...
}