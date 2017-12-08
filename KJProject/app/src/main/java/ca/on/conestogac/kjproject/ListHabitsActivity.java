package ca.on.conestogac.kjproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ca.on.conestogac.kjproject.Classes.Files;
import ca.on.conestogac.kjproject.Classes.Habits;
import ca.on.conestogac.kjproject.Database.AppDatabase;

public class ListHabitsActivity extends AppCompatActivity {

    private Files file;
    private Habits habits;
    private AppDatabase database;
    private ArrayAdapter<Habits> adapter;
    private long currentFileID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_habits);

        database = AppDatabase.getDatabase(getApplicationContext());

        Bundle passedID = getIntent().getExtras();
        long curID = passedID.getLong("curID");
        currentFileID = curID;

        List<Habits> habits = database.habitsDao().selectHabits(curID);

        if (habits.size()==0) {
            database.habitsDao().addHabit(new Habits(curID, "Pet Sydney"));
            habits = database.habitsDao().selectHabits(curID);
        }

        ListView lstHabits = (ListView) findViewById(R.id.lstHabits);

        adapter = new ArrayAdapter<Habits>(this, R.layout.filescell, habits);

        lstHabits.setAdapter(adapter);

//
       // lstHabits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position,
//                                    long id) {
//                Intent intent = new Intent(ListHabitsActivity.this, AddHabitActivity.class);
//
//                long fileID = adapter.getItem(position).fileID;
//                intent.putExtra("curID", adapter.getItem(position).fileID);
//                startActivity(intent);
//            }
//        });

    }

    public void createHabit(View view) {
        Intent intent = new Intent(this, AddHabitActivity.class);
        intent.putExtra("curID", currentFileID);
        startActivity(intent);
    }
}
