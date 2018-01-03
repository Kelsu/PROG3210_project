package ca.on.conestogac.kjproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.List;

import ca.on.conestogac.kjproject.Classes.Users;
import ca.on.conestogac.kjproject.DAO.UsersDao;
import ca.on.conestogac.kjproject.Database.AppDatabase;


public class LoginActivity extends AppCompatActivity {

    private Users user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_login);

        database = AppDatabase.getDatabase(getApplicationContext());

        // add some data
        List<Users> users = database.usersDao().getAllUser();
        if (users.size()==0) {
            database.usersDao().addUser(new Users("Kelsey", "Scout"));
            user = database.usersDao().getAllUser().get(0);
            database.usersDao().addUser(new Users("Hamilton", "Eliza"));
            database.usersDao().addUser(new Users("Scout", "Meow"));
        }

    }



    public void toMainScreen(View view) {

        database = AppDatabase.getDatabase(getApplicationContext());

        EditText password = (EditText) findViewById(R.id.txtPassword);
        EditText username = (EditText) findViewById(R.id.txtUsername);

        String convertPassword = password.getText().toString();
        String convertUsername = username.getText().toString();

        Users userCheck = database.usersDao().checkUser(convertUsername, convertPassword);

        if (userCheck != null && userCheck.password.equals(convertPassword))
        {
            Toast.makeText(this, "Welcome, " + convertUsername + ".", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("convertUsername", convertUsername);
            intent.putExtra("userID", userCheck.userID);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Username or password is incorrect.", Toast.LENGTH_SHORT).show();
            username.setText("");
            username.requestFocus();
        }

    }

    public void toCreateAccount(View view) {

        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void emailUs(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Example Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm an example email.");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    public void callUs(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "888-888-8888"));
        startActivity(intent);
    }
}
