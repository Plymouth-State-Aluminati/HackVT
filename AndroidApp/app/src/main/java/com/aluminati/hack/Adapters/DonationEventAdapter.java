package com.aluminati.hack.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aluminati.hack.Objects.DonationEvent;
import com.aluminati.hack.R;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

/**
 * Created by Devon on 10/14/2016.
 */
public class DonationEventAdapter extends RecyclerView.Adapter<DonationEventAdapter.EventViewHolder>{

    private List<DonationEvent> donationEvents;

    public DonationEventAdapter(List<DonationEvent> donationEvents){
        this.donationEvents = donationEvents;
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView cardTitle;
        TextView cardTime;

        EventViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.main_activity_card);
            cardTitle = (TextView)itemView.findViewById(R.id.main_activity_card_title);
            cardTime = (TextView)itemView.findViewById(R.id.main_activity_card_time);
        }
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_card, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        String cardText =  donationEvents.get(position).getDonor() + ": " + donationEvents.get(position).getEvent();
        holder.cardTitle.setText(cardText);
        String timeStamp = donationEvents.get(position).getTimestamp();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime time = formatter.parseDateTime(timeStamp);
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MMM dd h:mm a");
        holder.cardTime.setText(dtfOut.print(time));
    }

    @Override
    public int getItemCount() {
        return donationEvents.size();
    }
}
