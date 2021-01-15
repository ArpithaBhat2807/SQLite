package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.loginbutton);

        register=findViewById(R.id.registerbutton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginActivity();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regActivity();
            }
        });


    }

    private void regActivity()
    {
        Intent int2=new Intent(this, Register.class);
        startActivity(int2);
    }

    private void loginActivity()
    {
        Intent int1=new Intent(this, Login.class);
        startActivity(int1);
    }
}