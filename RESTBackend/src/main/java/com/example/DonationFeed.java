package com.example;

public class DonationFeed {
	String id;
	String donor;
	String event;
	String timestamp;
	
	public DonationFeed(String id, String donor, String event, String timestamp){
		this.id = id;
		this.donor = donor;
		this.event = event;
		this.timestamp = timestamp;
	}
}
