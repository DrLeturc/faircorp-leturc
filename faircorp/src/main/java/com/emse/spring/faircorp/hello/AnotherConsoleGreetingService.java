package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Primary
//@Service
@Component
//@Qualifier("anotherConsoleGreetingService")
public class AnotherConsoleGreetingService implements GreetingService {

  private final CycleService cycleService;
  
  @Autowired
  public AnotherConsoleGreetingService() {
	this.cycleService = null;
  }

//  @Autowired
  public AnotherConsoleGreetingService(CycleService cycleService) {
    this.cycleService = cycleService;
  }

  @Override
  public void greet(String name) {
    System.out.println("Bonjour, " + name + "!");
  }
}
