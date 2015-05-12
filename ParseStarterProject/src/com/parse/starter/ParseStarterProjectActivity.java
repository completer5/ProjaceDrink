package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class ParseStarterProjectActivity extends Activity {
	/** Called when the activity is first created. */
    private CustomAdapter urgentTodosAdapter;
    private ListView listView;
    Calendar cal = Calendar.getInstance();
    boolean cd = false;
    int dayofmonth;


    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        urgentTodosAdapter = new CustomAdapter(this);
    Button tt=(Button)findViewById(R.id.button2);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cd==false){
                    dayofmonth= cal.get(Calendar.DAY_OF_MONTH);
                    cd =true;
                    Toast.makeText(getApplication(), "เก็บวันที่",
                            Toast.LENGTH_SHORT).show();
                }
                if(dayofmonth!=cal.get(Calendar.DAY_OF_MONTH)){
                    del();
                    cd = false;
                    Toast.makeText(getApplication(), "ทำการลบ",
                            Toast.LENGTH_SHORT).show();
                }else
                    del();
                cd = false;
                Toast.makeText(getApplication(), "ทำการลบ",
                        Toast.LENGTH_SHORT).show();

            }
        });


        // Initialize ListView and set initial view to mainAdapter
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(urgentTodosAdapter);
        urgentTodosAdapter.loadObjects();

        Toast.makeText(getApplication(), "แสดงรายการ",
                Toast.LENGTH_SHORT).show();

        Button bt=(Button)findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                listView.setAdapter(urgentTodosAdapter);
                urgentTodosAdapter.loadObjects();

                Toast.makeText(getApplication(), "แสดงรายการ"+dayofmonth,
                        Toast.LENGTH_SHORT).show();


            }
        });

        Button btadd=(Button)findViewById(R.id.button3);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add=new Intent(getApplicationContext(),AddActivity.class);
                startActivity(add);
            }
        });
		ParseAnalytics.trackAppOpenedInBackground(getIntent());
	}

    private void del() {
        String sender = "1";
        ParseQuery<ParseObject> query = ParseQuery.getQuery("test");
        query.whereEqualTo("del", sender);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> messages, com.parse.ParseException e) {
                if (e == null) {
                    // remove all messages at once
                    ParseObject.deleteAllInBackground(messages);

                    // OR (do not use both!)

                    // iterate over all messages and delete them
                    for(ParseObject message : messages)
                    {
                        message.deleteEventually();
                    }
                } else {

                }
            }
        });
    }


}
