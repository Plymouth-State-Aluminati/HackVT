package com.aluminati.hack.Objects;

/**
 * Created by Devon on 10/15/2016.
 */
public class Donation {
    private int donorId;
    private int recipient;
    private int amount;
    private String inHonorOf;
    private String message;

    public Donation(int donorId, int amount, String inHonorOf, String message, int recipient) {
        this.donorId = donorId;
        this.amount = amount;
        this.inHonorOf = inHonorOf;
        this.message = message;
        this.recipient = recipient;
    }

    /**
     *
     * @return
     * The donorId
     */
    public int getDonorId() {
        return donorId;
    }

    /**
     *
     * @param donorId
     * The donorId
     */
    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    /**
     *
     * @return
     * The amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     * The amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     *
     * @return
     * The inHonorOf
     */
    public String getInHonorOf() {
        return inHonorOf;
    }

    /**
     *
     * @param inHonorOf
     * The inHonorOf
     */
    public void setInHonorOf(String inHonorOf) {
        this.inHonorOf = inHonorOf;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

}
