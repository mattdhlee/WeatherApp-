package com.example.matt.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matt.stormy.R;
import com.example.matt.stormy.weather.Day;

import org.w3c.dom.Text;

/**
 * Created by Matt on 2017-07-13.
 */

public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;


    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }






    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;  /// we arent going to use this. Tag items for easy reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;


        if (convertView == null) { //means it is brand new

            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);

            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView.getTag();

        }

        Day day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        holder.dayLabel.setText(day.getDayOfTheWeek());


        return convertView;
    }


    private static class ViewHolder {
        ImageView iconImageView; //public by default
        TextView temperatureLabel;
        TextView dayLabel;
    }




}
