package com.ngse.whenend;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateTimeOutput(View v) {

        TextView timeOutput = (TextView) findViewById(R.id.textview_timeOutput);
        TextView dayOutput  = (TextView) findViewById(R.id.textview_dayOutput);

        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK);
        int hr = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        /* ColonTime ct = Schedule.getPeriodEndFromTime(month, day_of_week, hr, min);
        if(ct != null) {
            ct = ct.correct();
        } else {
            ct = new ColonTime(0,0);
        }
        */

        // timeOutput.setText(ct.toString());
        timeOutput.setText(new ColonTime(hr,min).toString());
        dayOutput.setText(getDayFromInt(day_of_week));
    }

    public String getDayFromInt(int i) {
        String dayofweek = null;
        if(i == Calendar.MONDAY) {
            dayofweek = "Monday";
        } else if(i == Calendar.MONDAY) {
            dayofweek = "Tuesday";
        } else if(i == Calendar.MONDAY) {
            dayofweek = "Wednesday";
        } else if(i == Calendar.MONDAY) {
            dayofweek = "Thursday";
        } else if(i == Calendar.MONDAY) {
            dayofweek = "Friday";
        } else {
            dayofweek = "Its a weekend!";
        }

        return dayofweek;
    }
}
