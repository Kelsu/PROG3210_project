package ca.on.conestogac.kjproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
