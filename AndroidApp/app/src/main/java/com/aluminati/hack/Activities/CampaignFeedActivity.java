package com.aluminati.hack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.aluminati.hack.Adapters.CampaignAdapter;
import com.aluminati.hack.DonateActivity;
import com.aluminati.hack.Interfaces.DonationsApiInterface;
import com.aluminati.hack.Objects.Campaign;
import com.aluminati.hack.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CampaignFeedActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Bind the main_activity_recyclerview to the variable rv
    //@BindView(R.id.main_activity_recycler)
    //RecyclerView rv;

    CampaignAdapter rvAdapter;
    List<Campaign> campaignList;
    RecyclerView rv;

    //BASE_URL must end in '/'
    String BASE_URL = "http://107.170.47.159/";
    //String BASE_URL = "http://www.mocky.io/v2/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_campaign_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_campaign);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        initializeCampaignList();
        initializeRV();
    }

    private void initializeRV() {
        rv = (RecyclerView)findViewById(R.id.campaign_activity_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        //rv.setAdapter(new CampaignAdapter(campaignList, new CampaignAdapter.OnItemClickListener() {
        //    @Override
         //   public void onItemClick(Campaign campaign) {
         //       openCampaign(campaign.getId());
         //   }
        //}));
        //rv.setHasFixedSize(true);
    }

    private void openCampaign(String id) {
        int ID = Integer.parseInt(id);
        Intent intent = new Intent(this, CampaignDetails.class);
        intent.putExtra("CampaignID", ID);
        startActivity(intent);
    }

    private void initializeCampaignList() {
        campaignList = new ArrayList<>();

        DonationsApiInterface donationsApiInterface = retrofit.create(DonationsApiInterface.class);

        Call<List<Campaign>> call = donationsApiInterface.getCampaigns();
        call.enqueue(new Callback<List<Campaign>>() {
            @Override
            public void onResponse(Call<List<Campaign>> call, Response<List<Campaign>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", "Successful");
                    for (Campaign campaign :
                            response.body()) {
                        campaignList.add(campaign);
                        rv.setAdapter(new CampaignAdapter(campaignList, new CampaignAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(Campaign campaign) {
                                openCampaign(campaign.getId());
                            }
                        }));
                        //rvAdapter.notifyDataSetChanged();
                        Log.d("Response", response.body().get(0).getTitle());
                    }
                } else {
                    // error response, no access to resource?
                    Log.d("Retrofit isSuccessful", "False");
                }
            }

            @Override
            public void onFailure(Call<List<Campaign>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_make_donation) {
            Intent intent = new Intent(this, DonateActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_donations) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_recent_donations) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_Campaigns) {
            Intent intent = new Intent(this, CampaignFeedActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_Settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_campaign);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
