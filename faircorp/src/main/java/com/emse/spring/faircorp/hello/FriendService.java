package com.emse.spring.faircorp.hello;

public interface FriendService {
   /**
     * Compute friend age from his birth year
     */
	int computeFriendAge(Friend friend);
	
	/**
	  * Compute the average age of your friends and round the result
	  */
	double computeFriendAgeAverage();
}
