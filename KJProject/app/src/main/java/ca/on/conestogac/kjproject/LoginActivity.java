package ca.on.conestogac.kjproject;

import android.content.Intent;
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

        database.usersDao().removeAllUsers();

        // add some data
        List<Users> users = database.usersDao().getAllUser();
        if (users.size()==0) {
            database.usersDao().addUser(new Users(1, "Kelsey", "Scout"));
            user = database.usersDao().getAllUser().get(0);
            Toast.makeText(this, String.valueOf(user.userID), Toast.LENGTH_SHORT).show();
            database.usersDao().addUser(new Users(2, "Hamilton", "Eliza"));
            database.usersDao().addUser(new Users(3, "Scout", "Meow"));
        }

    }



    public void toMainScreen(View view) {

        EditText password = (EditText) findViewById(R.id.txtPassword);
        EditText username = (EditText) findViewById(R.id.txtUsername);

        String convertPassword = password.getText().toString();
        String convertUsername = username.getText().toString();

        String mainUsername = "Kelsey";
        String mainPassword = "Password";


        if (convertUsername.equals(mainUsername) && convertPassword.equals(mainPassword))
        {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("mainUsername", mainUsername);
            startActivity(intent);
        }
        else
        {
            AlertDialog.Builder errorMessage = new AlertDialog.Builder(this);
            errorMessage.setMessage("Incorrect credentials. Please try again.");
            errorMessage.setTitle("Error");
            errorMessage.setPositiveButton("Ok",null);
            errorMessage.setCancelable(true);
            errorMessage.create().show();

            username.setText("");
            username.requestFocus();
            password.setText("");
        }

    }

    public void toCreateAccount(View view) {

        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }


}
