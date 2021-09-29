package com.emse.spring.faircorp.hello;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {
	
//	 private FriendRepository friendRepository;
//	    private IntegerComputer integerComputer;
//
//	    public FriendServiceImpl(FriendRepository friendRepository,
//	                             IntegerComputer integerComputer) {
//	        this.friendRepository = friendRepository;
//	        this.integerComputer = integerComputer;
//	    }


	
    @Override
    public int computeFriendAge(Friend friend) {
        if(friend == null){
            throw new IllegalArgumentException("Friend is required");
        }
        return LocalDate.now().getYear() - friend.getBirthYear();
    }

    @Override
    public double computeFriendAgeAverage() {
        List<Friend> friends = null; //friendRepository.findAll()
        int sumAge = 0;
        for(Friend friend : friends){
            sumAge += computeFriendAge(friend);
        }
        return (double) sumAge * 1.0 / friends.size();
    }
}