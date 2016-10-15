package com.aluminati.hack;


/**
 * Created by Devon on 10/14/2016.
 */

public class DonationEvent extends FeedCard{

    private String id;
    private String donor;
    private String event;
    private String timestamp;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The donor
     */
    public String getDonor() {
        return donor;
    }

    /**
     *
     * @param donor
     * The donor
     */
    public void setDonor(String donor) {
        this.donor = donor;
    }

    /**
     *
     * @return
     * The event
     */
    public String getEvent() {
        return event;
    }

    /**
     *
     * @param event
     * The event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     *
     * @return
     * The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     * The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}