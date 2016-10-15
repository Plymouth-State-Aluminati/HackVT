package com.aluminati.hack.Interfaces;

import com.aluminati.hack.Objects.Campaign;
import com.aluminati.hack.Objects.Donation;
import com.aluminati.hack.Objects.DonationEvent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Devon on 10/14/2016.
 */

public interface DonationsApiInterface {
// Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("feed/")
    Call<List<DonationEvent>> getDonationEvents();

    @GET("campaigns/")
    Call<List<Campaign>> getCampaigns();

    @POST("donation/")
    Call<Donation> createDonation(@Body Donation donation);

    @GET("feed?")
    Call<List<DonationEvent>> getDonationHistory(@Query("userId") String userId);

    @GET("campaigns?")
    Call<Campaign> getCampaign(@Query("campaignId") String campaignId);
}
