package com.aluminati.hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DonateActivity extends AppCompatActivity {
    @BindView(R.id.edit_recipient)
        EditText editRecipient;

    private int campaignID = 0;
    private String campaignTitle = "Unknown Title";

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
            editRecipient.setText(campaignTitle);
        }

    }
}
