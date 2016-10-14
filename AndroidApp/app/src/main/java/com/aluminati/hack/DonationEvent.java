package com.aluminati.hack;

/**
 * Created by Devon on 10/14/2016.
 */
public class DonationEvent {
    String title;
    String time;

    public DonationEvent(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTime() {
        return this.time;
    }
}
