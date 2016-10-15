package com.aluminati.hack;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Devon on 10/14/2016.
 */

public interface DonationsApiInterface {
// Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("feed/")
    Call<List<DonationEvent>> getDonationEvents();

    @GET("5801cf0d120000ce1c32abee/")
    Call<List<Campaign>> getCampaigns();
}