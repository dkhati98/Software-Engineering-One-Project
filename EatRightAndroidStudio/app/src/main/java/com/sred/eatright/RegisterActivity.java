package com.sred.eatright;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DatabaseHelper db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DatabaseHelper(this);
        final EditText userName = (EditText) findViewById(R.id.enter_name);
        final EditText userEmail = (EditText) findViewById(R.id.enter_email);
        final EditText userPassword = (EditText) findViewById(R.id.enter_password);
        final Button regButton = (Button) findViewById(R.id.create_account);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = userName.getText().toString().trim();
                final String emailAddress = userEmail.getText().toString().trim();
                final String password = userPassword.getText().toString().trim();

                long val = db.addUser(username,emailAddress,password);

                if (val>0) {
                    Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                    int _id = db.getid(username);
                    Intent moveToLogin = new Intent(RegisterActivity.this, Main2Activity.class);
                    startActivity(moveToLogin);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Registration error", Toast.LENGTH_SHORT).show();
                }


                /*
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success)
                            {
                                Intent intent = new Intent(RegisterActivity.this,Main2Activity.class);
                                RegisterActivity.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }; */
                    /*
                RegisterRequest registerRequest = new RegisterRequest(username, useremail,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
                */

            }
        });
    }
}
