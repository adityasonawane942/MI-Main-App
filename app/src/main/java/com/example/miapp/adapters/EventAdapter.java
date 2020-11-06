package com.example.miapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.miapp.R;
import com.example.miapp.Retrofit.Event;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> implements View.OnClickListener {
    private ArrayList<Event> dataSet;
    Context mContext;

    public static class ViewHolder{
        TextView event_name;
        TextView event_desc;
        TextView event_venue;
        TextView event_time;
        TextView event_date;

    }

    public EventAdapter(ArrayList<Event> data, Context context) {
        super(context, R.layout.tab4, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

    }

    private int lastPosition = -1;
    private int index= 0;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Event event = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final EventAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new EventAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listitems, parent, false);

            viewHolder.event_name=convertView.findViewById(R.id.event_name);
            viewHolder.event_desc=convertView.findViewById(R.id.event_desc);
            viewHolder.event_venue = convertView.findViewById(R.id.event_venue);
            viewHolder.event_date = convertView.findViewById(R.id.event_date);
            viewHolder.event_time = convertView.findViewById(R.id.event_time);


            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (EventAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }


        viewHolder.event_name.setText(event.getEvent_name());
        viewHolder.event_desc.setText(event.getEvent_desc());
        viewHolder.event_venue.setText(event.getEvent_venue());
        viewHolder.event_date.setText(event.getEvent_date());
        viewHolder.event_time.setText(event.getEvent_time());
        // index= index+1;

        return convertView;
    }

}
