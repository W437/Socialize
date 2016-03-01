package com.alsalam.sclzroot.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.sclzservice.R;

import java.util.ArrayList;

/**
 * Created by bana on 01/03/2016.
 */
public class EventCardAdapter extends BaseAdapter
{
private Context context;
    private ArrayList<EventCard> eventCards;

    public EventCardAdapter(Context context, ArrayList<EventCard> eventCards) {
        this.context = context;
        this.eventCards = eventCards;
    }

    @Override
    public int getCount() {
        return eventCards.size();
    }

    @Override
    public Object getItem(int position) {
        EventCard e=eventCards.get(position);
        return e;
    }

    @Override
    public long getItemId(int position) {
        EventCard e=eventCards.get(position);
        return e.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(R.layout.event_card_itm,parent,false);
        TextView tvBegin2=(TextView)itemView.findViewById(R.id.tvBegin2);
        Button btMore=(Button)itemView.findViewById(R.id.btMore);
        TextView tvLocation2=(TextView)itemView.findViewById(R.id.tvLocation2);

        TextView tvEventP2=(TextView)itemView.findViewById(R.id.tvEventP2);
        EventCard e=eventCards.get(position);
        tvBegin2.setText(e.getTvBegin2());
        tvEventP2.setText(e.getTvEventP2());
        tvLocation2.setText(e.getTvLocation2());

        return itemView;
    }
}
