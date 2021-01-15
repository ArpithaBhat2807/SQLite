package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confirmpassword;
    Button register;
    //Button signin;
    DatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.usernamer);
        password = (EditText) findViewById(R.id.passwordr);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        register = (Button) findViewById(R.id.register1);
        //signin = (Button) findViewById(R.id.returnl);
        DB=new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = username.getText().toString();
                String s2 = password.getText().toString();
                String s3 = confirmpassword.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter valid Details", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean check = DB.checkusername(s1);
                        if (check == false) {
                            Boolean insert = DB.insertData(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent int4 = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(int4);

                            } else
                                Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();
                        }

                    } else
                        Toast.makeText(getApplicationContext(), "Password incorrect", Toast.LENGTH_SHORT).show();

                }
            }});

        /*signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti=new Intent(getApplicationContext(),Login.class);
                startActivity(inti);
            }
        });*/
    }
}