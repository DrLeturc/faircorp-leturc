package com.emse.spring.faircorp.hello;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site {
	
	
	
	@Id
	private Long id;
    //private Long id;
    private String name;

    @OneToMany(mappedBy = "site")
    private Set<Sensor> sensors;

	public Site(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}

}
