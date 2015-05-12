package com.parse.starter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import com.parse.ParseObject;
public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                senddata();
                Intent mai=new Intent(getApplicationContext(),ParseStarterProjectActivity.class);
                startActivity(mai);
            }


        });
    }

    private void senddata() {
        EditText textname=(EditText)findViewById(R.id.editText);
        EditText textname1=(EditText)findViewById(R.id.editText2);
        TimePicker tim=(TimePicker)findViewById(R.id.timePicker);

        ParseObject testObject = new ParseObject("test");
        testObject.put("del","1");
        testObject.put("name", textname1.getText().toString());
        testObject.put("loname", textname.getText().toString());
        testObject.put("min",tim.getCurrentMinute());
        testObject.put("hour",tim.getCurrentHour());
        testObject.saveInBackground();

    }




}
