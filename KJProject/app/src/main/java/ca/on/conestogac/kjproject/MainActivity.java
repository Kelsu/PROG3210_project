package ca.on.conestogac.kjproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import ca.on.conestogac.kjproject.Classes.Files;
import ca.on.conestogac.kjproject.Classes.Users;
import ca.on.conestogac.kjproject.Database.AppDatabase;

public class MainActivity extends AppCompatActivity {

    private Users user;
    private Files file;
    private AppDatabase database;
    private ArrayAdapter<Files> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDatabase.getDatabase(getApplicationContext());

        Bundle bundle = getIntent().getExtras();
        final int curID = bundle.getInt("userID");

        List<Files> files = database.filesDao().selectFiles(curID);

        if (files.size()==0) {
            database.filesDao().addFile(new Files(curID, "Monday"));
            database.filesDao().addFile(new Files(curID, "Tuesday"));
            database.filesDao().addFile(new Files(curID, "Wednesday"));
            database.filesDao().addFile(new Files(curID, "Thursday"));
            database.filesDao().addFile(new Files(curID, "Friday"));
            database.filesDao().addFile(new Files(curID, "Saturday"));
            database.filesDao().addFile(new Files(curID, "Sunday"));
            files = database.filesDao().selectFiles(curID);
            //user = database.usersDao().getAllUser().get(0);
        }

        String username = bundle.getString("convertUsername");

        final ListView lstFiles = (ListView) findViewById(R.id.lstFiles);

        adapter = new ArrayAdapter<Files>(this, R.layout.filescell, files);

        lstFiles.setAdapter(adapter);

        lstFiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, ListHabitsActivity.class);

                //long fileID = adapter.getItem(position).fileID;
                intent.putExtra("curID", adapter.getItem(position).fileID);
                startActivity(intent);
            }
        });
    }

    public void goToImage(View view) {

        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);

    }



}
