package com.aluminati.hack;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Devon on 10/14/2016.
 */
class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>{

    private List<Campaign> campaigns;
    OnItemClickListener listener;

    static class CampaignViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView cardTitle;
        TextView cardDesc;
        TextView cardProgress;
        TextView cardDeadline;

        CampaignViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.campaign_activity_card);
            cardTitle = (TextView)itemView.findViewById(R.id.campaign_activity_card_title);
            cardDesc = (TextView)itemView.findViewById(R.id.campaign_activity_card_desc);
            cardProgress = (TextView)itemView.findViewById(R.id.campaign_activity_card_progress);
            cardDeadline = (TextView)itemView.findViewById(R.id.campaign_activity_card_time);
        }

        void bind(final Campaign campaign, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(campaign);
                }
            });
        }
    }

    CampaignAdapter(List<Campaign> campaigns, OnItemClickListener listener){
        this.campaigns = campaigns;
        this.listener = listener;
    }

    interface OnItemClickListener {
        void onItemClick(Campaign campaign);
    }

    @Override
    public CampaignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_activity_card, parent, false);
        return new CampaignViewHolder(v);
    }



    @Override
    public void onBindViewHolder(CampaignViewHolder holder, int position) {
        holder.cardTitle.setText(campaigns.get(position).getTitle());
        holder.cardDesc.setText(campaigns.get(position).getDesc());
        String progress = "$" + campaigns.get(position).getCurrent() + "/$" + campaigns.get(position).getTarget();
        holder.cardProgress.setText(progress);
        holder.cardDeadline.setText((campaigns.get(position).getDeadline()));
        holder.bind(campaigns.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
