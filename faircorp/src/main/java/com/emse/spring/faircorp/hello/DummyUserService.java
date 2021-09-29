package com.emse.spring.faircorp.hello;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService{

//	List<String> list = new LinkedList<String>();
	
	GreetingService service = new ConsoleGreetingService();
	
	@Autowired
	public DummyUserService() {
//		this.list = new LinkedList<String>();
//		this.list.add("Elodie");
//		this.list.add("Charles");
	}
	
//	@Autowired
//	public DummyUserService(List<String> list) {
//		this.list = list;
//	}
	
	@Override
	public void greetAll() {
		
		List<String> list = new LinkedList<String>();
		list.add("Elodie");
		list.add("Charles");
		
		for(String e : list) {
			service.greet(e);
		}
		
//		System.out.println("Hello, Elodie!");
//    	System.out.println("Hello, Charles!");
		//System.out.println("Hello, Elodie! THello, Charles!");
	}

}
