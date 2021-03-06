package com.aluminati.hack;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Devon on 10/14/2016.
 */
class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder>{

    private List<DonationEvent> donationEvents;

    RVAdapter(List<DonationEvent> donationEvents){
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
        holder.cardTitle.setText(donationEvents.get(position).getTitle());
        holder.cardTime.setText(donationEvents.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return donationEvents.size();
    }
}
