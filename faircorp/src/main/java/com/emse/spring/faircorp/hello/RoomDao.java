package com.emse.spring.faircorp.hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao  extends JpaRepository<Room, Long>{

	public Room getOne(Long id);
	
}
