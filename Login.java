package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText usernamel;
    EditText passwordl;
    Button login;
    DatabaseHelper DB ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernamel=(EditText)findViewById(R.id.usernamel);
        passwordl=(EditText)findViewById(R.id.passwordl);
        login=(Button)findViewById(R.id.login1);
        DB=new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String user,pass;
                user=usernamel.getText().toString();
                pass=passwordl.getText().toString();
                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent int3 = new Intent(getApplicationContext(), Useroperations.class);
                        startActivity(int3);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    }
