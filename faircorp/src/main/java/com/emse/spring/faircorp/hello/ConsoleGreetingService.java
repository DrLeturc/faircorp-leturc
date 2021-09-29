package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
//@Qualifier("consoleGreetingService")
public class ConsoleGreetingService implements GreetingService {

  private final CycleService cycleService;
  
  //@Autowired
  public ConsoleGreetingService() {
	this.cycleService = null;
  }

 @Autowired
  public ConsoleGreetingService(CycleService cycleService) {
    this.cycleService = cycleService;
  }

  @Override
  public void greet(String name) {
    System.out.println("Hello, " + name + "!");
  }
}
