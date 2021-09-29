package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FaircorpApplicationConfig {

	
	@Autowired
	GreetingService service; //= new ConsoleGreetingService()
	
	  @Bean
	  public CommandLineRunner greetingCommandLine() { 
	      return new CommandLineRunner() {
	        @Override
	        public void run(String... args) throws Exception {
	            service.greet("Spring");
	        }
	      };
	  }
	}
