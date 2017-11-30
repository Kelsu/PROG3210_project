package ca.on.conestogac.kjproject;

import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class ToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        CalendarView c = (CalendarView) findViewById(R.id.calendarView);

        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView c, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "You have selected: "+dayOfMonth+ "/"+month+"/"+year,4000).show();

            }
        });



    }
}
