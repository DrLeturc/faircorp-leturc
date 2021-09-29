package com.emse.spring.faircorp.hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//(1)
//(2)
@Entity
@Table(name = "HEATER")
public class Heater {
 // (3)
@Id
@GeneratedValue
 private Long id;

 // (4)
@Column(nullable=false, length=255) 
 private String name;

 // (5) // STRING
@Enumerated(EnumType.STRING)
@Column(nullable=true) 
 private HeaterStatus heaterStatus;

@Column(nullable=true) 
private Long power;


//@Column(nullable=true) 
@ManyToOne
private Room room;

 public Heater() {
 }

 public Heater(String name, HeaterStatus status) {
     this.heaterStatus = status;
     this.name = name;
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

 public HeaterStatus getWindowStatus() {
     return heaterStatus;
 }

 public void setWindowStatus(HeaterStatus heaterStatus) {
     this.heaterStatus = heaterStatus;
 }
}