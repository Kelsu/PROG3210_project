package ca.on.conestogac.kjproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ca.on.conestogac.kjproject.Classes.Users;
import ca.on.conestogac.kjproject.Database.AppDatabase;

public class CreateAccountActivity extends AppCompatActivity {

    private Users user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void createAccount(View view) {

        EditText username = (EditText) findViewById(R.id.txtUsername);
        EditText password = (EditText) findViewById(R.id.txtPassword);
        EditText confirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);

        database = AppDatabase.getDatabase(getApplicationContext());

        String convertPassword = password.getText().toString();
        String convertUsername = username.getText().toString();
        String convertCPassword = confirmPassword.getText().toString();

        Users userCheck = database.usersDao().getUser(convertUsername);

        if ((!convertUsername.isEmpty() || !convertPassword.isEmpty()) && (!convertUsername.isEmpty() && !convertPassword.isEmpty())){
            if (userCheck == null)
            {
                if (convertPassword.equals(convertCPassword))
                {
                    Users users = new Users(convertUsername.trim(), convertPassword.trim());
                    database.usersDao().addUser(users);
                    Toast.makeText(this, "User created successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(this, "Passwords must match.", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                }
            }
            else {
                Toast.makeText(this, "Username already exists.", Toast.LENGTH_SHORT).show();
                username.setText("");
                username.requestFocus();
            }
        }
        else {
            Toast.makeText(this, "Username or password is invalid.", Toast.LENGTH_SHORT).show();
            username.requestFocus();
        }
    }
}
