package com.aluminati.hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DonateActivity extends AppCompatActivity {
    @BindView(R.id.edit_recipient)
        EditText editRecipient;
    @BindView(R.id.edit_amt)
        EditText editAmount;
    @BindView(R.id.edit_behalf)
        EditText editBehalf;
    @BindView(R.id.edit_comments)
        EditText editComments;

    private int campaignID = 0;
    private String campaignTitle = "Unknown Title";

    String BASE_URL = "http://107.170.47.159/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    DonationsApiInterface donationsApiInterface = retrofit.create(DonationsApiInterface.class);
    private int donorID = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        if(extra!=null) {
            campaignID = intent.getIntExtra("CampaignID", 0);
            campaignTitle = intent.getStringExtra("CampaignTitle");
        }

        if(campaignID!=0) {
            editRecipient.setText(campaignID + " " + campaignTitle);
        }

    }

    @OnClick(R.id.btn_donate)
    public void donate() {
        int amount = Integer.parseInt(editAmount.getText().toString());
        String behalfOf = editBehalf.getText().toString();
        String comment = editComments.getText().toString();
        campaignTitle = editRecipient.getText().toString();
        Call<Donation> call = donationsApiInterface.createDonation(new Donation(donorID, amount, behalfOf, comment, campaignID));
        call.enqueue(new Callback<Donation>() {
            @Override
            public void onResponse(Call<Donation> call, Response<Donation> response) {
                if (response.isSuccessful()) {
                    Log.d("POST", "Successful");
                    finish();
                } else {
                    // error response, no access to resource?
                    Log.d("Retrofit isSuccessful", "False");
                }
            }

            @Override
            public void onFailure(Call<Donation> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }
}
