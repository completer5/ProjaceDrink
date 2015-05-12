package com.parse.starter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomAdapter extends ParseQueryAdapter<ParseObject> {

    public CustomAdapter(Context context) {
        // Use the QueryFactory to construct a PQA that will only show
        // Todos marked as high-pri

        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                //ParseUser currentUser = ParseUser.getCurrentUser();
                ParseQuery query = new ParseQuery("test");
                // query.whereEqualTo("high", true);
                return query;
            }
        });
    }


    // Customize the layout by overriding getItemView
    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {

        if (v == null) {
            v = View.inflate(getContext(), R.layout.activity_custom_adapter,
                    null);
        }

        super.getItemView(object, v, parent);
        // Add the title view


        TextView NameTextView = (TextView) v.findViewById(R.id.text1);
        NameTextView.setText(object.getString("name"));

        // sum((Integer)object.getNumber("Price"));
        TextView PriceTextView = (TextView) v.findViewById(R.id.text2);
        PriceTextView.setText(object.getString("loname"));

        // Add a reminder of how long this item has been outstanding
        TextView timestampView = (TextView) v.findViewById(R.id.timestamp);
        timestampView.setText("เวลา"+" "+object.getInt("hour".toString())+":"+object.getInt("min".toString()));
        return v;
    }



    }