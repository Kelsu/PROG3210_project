package ca.on.conestogac.kjproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ca.on.conestogac.kjproject.Classes.Files;
import ca.on.conestogac.kjproject.Classes.Habits;
import ca.on.conestogac.kjproject.Database.AppDatabase;

public class ListHabitsActivity extends AppCompatActivity {

    private Files file;
    private Habits habits;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_habits);

        database = AppDatabase.getDatabase(getApplicationContext());

        Bundle passedID = getIntent().getExtras();
        int curID = passedID.getInt("curID");

        database.habbitsDao().addHabit(new Habits(1, "Pet Sydney"));

    }
}
