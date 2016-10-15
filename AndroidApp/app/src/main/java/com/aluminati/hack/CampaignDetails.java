package com.aluminati.hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CampaignDetails extends AppCompatActivity {
    int campaignID;
    String campaignTitle = "Backpacks for Alpacas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_details);

        final Button donateButton = (Button)findViewById(R.id.btn_campaign_donate);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null) {
            campaignID = intent.getIntExtra("CampaignID", 1);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.transparent_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonateActivity.class);
                intent.putExtra("CampaignID", campaignID);
                intent.putExtra("CampaignTitle", campaignTitle);
                startActivity(intent);
            }
        });
    }


}
