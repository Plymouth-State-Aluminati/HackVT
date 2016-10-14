package com.example;

import java.util.List;

public class DonationFeedResponse {
	List<DonationFeed> feedList;
	
	public DonationFeedResponse(List<DonationFeed> feedList){
		this.feedList = feedList;
	}
}
