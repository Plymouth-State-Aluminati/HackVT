package com.aluminati.hack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //Bind the main_activity_recyclerview to the variable rv
    @BindView(R.id.main_activity_recycler)
        RecyclerView rv;

    RVAdapter rvAdapter;
    List<DonationEvent> donationEventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        donationEventList = new ArrayList<>();


        donationEventList.add(new DonationEvent("Mark's $5 was used to fund a new computer lab for BHS", "15 Minutes ago"));
        donationEventList.add(new DonationEvent("Mark Donated $5 to BHS", "15 Minutes ago"));
        donationEventList.add(new DonationEvent("Cat Donated $15 to PRHS", "20 Minutes ago"));
        donationEventList.add(new DonationEvent("Jefffff donated $4 towards Methuen's $500 match campaign.", "2 hours ago"));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rvAdapter = new RVAdapter(donationEventList);
        rv.setAdapter(rvAdapter);
        rv.setHasFixedSize(true);
    }
}
