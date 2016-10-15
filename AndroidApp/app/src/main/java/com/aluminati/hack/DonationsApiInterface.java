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

    @GET("58018ce81200007d1632abd8")
    Call<List<DonationEvent>> getDonationEvents();
}
