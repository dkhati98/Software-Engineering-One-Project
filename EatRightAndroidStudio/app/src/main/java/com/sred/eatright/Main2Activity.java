package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);



        final EditText userName = (EditText) findViewById(R.id.edittext_username);
        final EditText userPassword = (EditText) findViewById(R.id.edittext_password);
        final Button loginButton = (Button) findViewById(R.id.button_login);
        final TextView registrationLink = (TextView) findViewById(R.id.textview_register);

        registrationLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationIntent = new Intent(Main2Activity.this, RegisterActivity.class);
                Main2Activity.this.startActivity(registrationIntent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString().trim();
                String password = userPassword.getText().toString().trim();
                Boolean res = db.checkUser(username, password);
                if (res == true) {
                    Toast.makeText(Main2Activity.this, "Succesfully authenticated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Main2Activity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
