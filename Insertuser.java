package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import  android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

public class Insertuser extends AppCompatActivity {

    EditText iname,ipass;
    Button insert;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertuser);

        iname=(EditText)findViewById(R.id.usernamei);
        ipass=(EditText)findViewById(R.id.passwordi);
        insert=(Button)findViewById(R.id.insertb);
        DB=new DatabaseHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insName=iname.getText().toString();
                String insPass=ipass.getText().toString();

                Boolean checkinsertdata=DB.insertData(insName,insPass);
                if(checkinsertdata==true) {
                    Toast.makeText(getApplicationContext(), "New User Added", Toast.LENGTH_SHORT).show();
                    Intent insint=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(insint);
                }
                else
                    Toast.makeText(getApplicationContext(), "New User Could not Be Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}