package com.aluminati.hack.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aluminati.hack.Objects.Campaign;
import com.aluminati.hack.R;
import com.github.lzyzsd.circleprogress.CircleProgress;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import static org.joda.time.Days.daysBetween;

/**
 * Created by Devon on 10/14/2016.
 */
public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>{

    private List<Campaign> campaigns;
    OnItemClickListener listener;

    static class CampaignViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView cardTitle;
        TextView cardDesc;
        TextView cardProgress;
        TextView cardDeadline;
        CircleProgress cProgress;

        CampaignViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.campaign_activity_card);
            cardTitle = (TextView)itemView.findViewById(R.id.campaign_activity_card_title);
            cardDesc = (TextView)itemView.findViewById(R.id.campaign_activity_card_desc);
            cardProgress = (TextView)itemView.findViewById(R.id.campaign_activity_card_progress);
            cardDeadline = (TextView)itemView.findViewById(R.id.campaign_activity_card_time);
            cProgress = (CircleProgress)itemView.findViewById(R.id.circle_progress);
        }

        void bind(final Campaign campaign, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(campaign);
                }
            });
        }
    }

    public CampaignAdapter(List<Campaign> campaigns, OnItemClickListener listener){
        this.campaigns = campaigns;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Campaign campaign);
    }

    @Override
    public CampaignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_activity_card, parent, false);
        return new CampaignViewHolder(v);
    }



    @Override
    public void onBindViewHolder(CampaignViewHolder holder, int position) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime deadline = formatter.parseDateTime(campaigns.get(position).getDeadline());

        DateTimeZone EST = DateTimeZone.forID("US/Eastern");
        DateTime now = new DateTime();
        int daysToDeadline = daysBetween(now.withTimeAtStartOfDay(),
                deadline.withTimeAtStartOfDay()).getDays();

        holder.cardTitle.setText(campaigns.get(position).getTitle());
        holder.cardDesc.setText(campaigns.get(position).getDesc());
        Double current = Double.parseDouble(campaigns.get(position).getCurrent());
        Double target = Double.parseDouble(campaigns.get(position).getTarget());
        Double percent = (current/target)*100;
        int percentage = percent.intValue();
        holder.cProgress.setProgress(percentage);
        Log.d("Percent", percentage+"");
        String progress = "$" + current + "/$" + target;
        holder.cardProgress.setText(progress);
        //holder.cardDeadline.setText((campaigns.get(position).getDeadline()));
        holder.cardDeadline.setText(daysToDeadline + " Days Left");
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
