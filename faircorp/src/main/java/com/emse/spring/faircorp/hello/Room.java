package com.emse.spring.faircorp.hello;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//(1)
//(2)
@Entity
@Table(name = "ROOM")
public class Room {
 // (3)
@Id
@GeneratedValue
 private Long id;

 // (4)
@Column(nullable=false, length=255) 
 private String name;

@Column(nullable=false) 
private Integer floor;

@Column(nullable=false)
private Double currentTemperature;

@Column(nullable=false)
private Double targetTemperature;

@OneToMany(mappedBy="room")
private Set<Heater> heaters;

@OneToMany
private Set<Window> windows;

 public Room() {
 }

 public Room(String name, Set<Heater> heaters,Set<Window> windows) {
     this.heaters = heaters;
     this.name = name;
     this.windows = windows;
 }

 public Long getId() {
     return this.id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

public Set<Window> getWindows() {
	// TODO Auto-generated method stub
	return this.windows;
}

}