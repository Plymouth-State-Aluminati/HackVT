package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonationFeedController {

	@RequestMapping(value = "/feed", method = RequestMethod.GET, produces = "application/json")
    public DonationFeedResponse sampleFeed() {
    	List<DonationFeed> feedList = new ArrayList<DonationFeed>();
    	
    	feedList.add(new DonationFeed("1","Catherine","Donated $5.00 to general funds","10-14-2016 10:00"));
    	feedList.add(new DonationFeed("2","Jeff","Donated $100.00 to Plymouth State University","10-14-2016 10:01"));
    	feedList.add(new DonationFeed("3","Devon","Donated $0.01 to general funds","10-14-2016 10:02"));
    	feedList.add(new DonationFeed("4","Mark","Donated $1.00 to general funds","10-14-2016 10:03"));
    	feedList.add(new DonationFeed("5","Catherine","$4.00 of her $5.00 went to Methuen Highschool","10-14-2016 10:04"));
    	feedList.add(new DonationFeed("6","Catherine","$1.00 of her $5.00 went to Lawrence elementary","10-14-2016 10:05"));
		
    	System.out.println("HELP");
    	
    	return new DonationFeedResponse(feedList);
    }
}