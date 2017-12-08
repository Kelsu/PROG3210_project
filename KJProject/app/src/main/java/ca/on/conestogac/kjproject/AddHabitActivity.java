package ca.on.conestogac.kjproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import ca.on.conestogac.kjproject.Classes.Files;
import ca.on.conestogac.kjproject.Classes.Habits;
import ca.on.conestogac.kjproject.Classes.Users;
import ca.on.conestogac.kjproject.Database.AppDatabase;

public class AddHabitActivity extends AppCompatActivity {

    private Files file;
    private Habits habits;
    private AppDatabase database;
    private ArrayAdapter<Habits> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);


    }

    public void addHabit(View view) {

        database = AppDatabase.getDatabase(getApplicationContext());
        Bundle passedID = getIntent().getExtras();
        long curID = passedID.getLong("curID");

        EditText checkHabit = (EditText) findViewById(R.id.txtHabit);

        String newHabit = checkHabit.getText().toString();

        Habits habitsCheck = database.habitsDao().getHabit(newHabit);

        if (!newHabit.isEmpty()) {
            if (habitsCheck == null){
                Habits habits = new Habits(curID, newHabit);
                database.habitsDao().addHabit(habits);
                Toast.makeText(this, "Habit created successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddHabitActivity.this, ListHabitsActivity.class);
                intent.putExtra("curID", curID);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Habit already exists.", Toast.LENGTH_SHORT).show();
                checkHabit.setText("");
                checkHabit.requestFocus();
            }
        }
        else {
            Toast.makeText(this, "Habit can not be empty.", Toast.LENGTH_SHORT).show();
            checkHabit.requestFocus();
        }

    }
}
