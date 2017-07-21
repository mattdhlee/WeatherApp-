package com.example.matt.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.matt.stormy.MainActivity;
import com.example.matt.stormy.R;
import com.example.matt.stormy.adapters.DayAdapter;
import com.example.matt.stormy.weather.Day;

import java.util.Arrays;

public class dailyForecast extends ListActivity {


    private static final String TAG = "LISTACT";
    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);



        /*String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                daysOfTheWeek);
        setListAdapter(adapter); */

        Log.e(TAG, "test test");
        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);



    }


}
