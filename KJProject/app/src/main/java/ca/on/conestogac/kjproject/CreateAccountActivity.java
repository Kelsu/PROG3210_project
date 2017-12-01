package ca.on.conestogac.kjproject;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void createAccount(View view) {

        EditText username = (EditText) findViewById(R.id.txtUsername);
        EditText password = (EditText) findViewById(R.id.txtPassword);
        EditText confirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);


        try {
            String convertPassword = password.getText().toString();
            String convertUsername = username.getText().toString();
            String convertCPassword = confirmPassword.getText().toString();
        }
        catch (Exception e){
            AlertDialog.Builder errorMessage = new AlertDialog.Builder(this);
            errorMessage.setMessage("Incorrect credentials. Please try again.");
            errorMessage.setTitle("Error");
            errorMessage.setPositiveButton("Ok",null);
            errorMessage.setCancelable(true);
            errorMessage.create().show();
        }





    }
}
