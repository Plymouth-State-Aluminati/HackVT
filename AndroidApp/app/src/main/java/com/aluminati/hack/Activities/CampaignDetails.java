package com.aluminati.hack.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aluminati.hack.DonateActivity;
import com.aluminati.hack.Interfaces.DonationsApiInterface;
import com.aluminati.hack.Objects.Campaign;
import com.aluminati.hack.Objects.DonationEvent;
import com.aluminati.hack.R;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CampaignDetails extends AppCompatActivity {
    int campaignID;
    String campaignTitle = "Backpacks for Alpacas";
    ActionBar ab;

    //BASE_URL must end in '/'
    String BASE_URL = "http://107.170.47.159/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.text_desc)
    TextView textDescription;

    @BindView(R.id.text_progress)
    TextView textProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_details_main);
        ButterKnife.bind(this);
        ab = getSupportActionBar();

        final Button donateButton = (Button)findViewById(R.id.btn_campaign_donate);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null) {
            campaignID = intent.getIntExtra("CampaignID", 1);
            campaignTitle = intent.getStringExtra("CampaignTitle");
        }


        //Toolbar toolbar = (Toolbar) findViewById(R.id.transparent_toolbar);
        //toolbar.setTitle(campaignTitle);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonateActivity.class);
                intent.putExtra("CampaignID", campaignID);
                intent.putExtra("CampaignTitle", campaignTitle);
                startActivity(intent);
            }
        });

        getDetails();
    }

    private void getDetails() {
        DonationsApiInterface donationsApiInterface = retrofit.create(DonationsApiInterface.class);

        Call<Campaign> call = donationsApiInterface.getCampaign(String.valueOf(campaignID));
        call.enqueue(new Callback<Campaign>() {
            @Override
            public void onResponse(Call<Campaign> call, Response<Campaign> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", response.body().getTitle());
                    campaignTitle = response.body().getTitle();
                    textDescription.setText(response.body().getDesc());
                    textProgress.setText("$" + response.body().getCurrent() + "/$" + response.body().getTarget());
                    progressBar.setMax(Integer.parseInt(response.body().getTarget()));
                    progressBar.setProgress(Integer.parseInt(response.body().getCurrent()));
                    ab.setTitle(campaignTitle);

                } else {
                    // error response, no access to resource?
                    Log.d("Retrofit isSuccessful", "False");
                }
            }

            @Override
            public void onFailure(Call<Campaign> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getDetails();
    }


}
