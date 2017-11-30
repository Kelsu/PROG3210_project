package ca.on.conestogac.kjproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        String name = "Welcome " + bundle.getString("mainUsername");

        TextView welcomeMessage = (TextView) findViewById(R.id.txtWelcomeMessage);
        welcomeMessage.setText(name);
    }

    public void toToDoList(View view) {
        Intent intent = new Intent(this, ToDoListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
