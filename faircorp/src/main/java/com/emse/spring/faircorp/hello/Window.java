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
@Table(name = "RWINDOW")
public class Window {
 // (3)
@Id
@GeneratedValue
 private Long id;

 // (4)
@Column(nullable=false, length=255) 
 private String name;

 // (5) // STRING
@Enumerated(EnumType.STRING)
 private WindowStatus windowStatus;

@ManyToOne
private Room room;

 public Window() {
 }

 public Window(String name, WindowStatus status, Room room) {
     this.windowStatus = status;
     this.name = name;
     this.room = room;
 }

 public Window(Room room2, String name2, WindowStatus windowStatus2) {
	// TODO Auto-generated constructor stub
	 this.windowStatus = windowStatus2;
     this.name = name2;
     this.room = room2;
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

 public WindowStatus getWindowStatus() {
     return windowStatus;
 }

 public void setWindowStatus(WindowStatus windowStatus) {
     this.windowStatus = windowStatus;
 }

public Room getRoom() {
	// TODO Auto-generated method stub
	return this.room;
}
}