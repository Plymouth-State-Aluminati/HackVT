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
class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>{

    private List<Campaign> campaigns;

    CampaignAdapter(List<Campaign> campaigns){
        this.campaigns = campaigns;
    }

    static class CampaignViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView cardTitle;
        TextView cardDesc;

        CampaignViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.campaign_activity_card);
            cardTitle = (TextView)itemView.findViewById(R.id.campaign_activity_card_title);
            cardDesc = (TextView)itemView.findViewById(R.id.main_activity_card_time);
        }
    }

    @Override
    public CampaignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_activity_card, parent, false);
        return new CampaignViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CampaignViewHolder holder, int position) {
        String cardText =  campaigns.get(position).getTitle();
        holder.cardTitle.setText(cardText);
        holder.cardDesc.setText(campaigns.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }
}
