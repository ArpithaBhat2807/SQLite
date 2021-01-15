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

public class Deleteuser extends AppCompatActivity
{
    DatabaseHelper DB;
    EditText dname;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteuser);
        DB=new DatabaseHelper(this);
        dname=(EditText)findViewById(R.id.usernamed);
        delete=(Button)findViewById(R.id.deleted);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String delname=dname.getText().toString();
                Boolean checkdeletes=DB.deletedata(delname);
                if(checkdeletes==true) {
                    Toast.makeText(getApplicationContext(), "User Deleted", Toast.LENGTH_SHORT).show();
                    Intent delint=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(delint);
                }
                else
                    Toast.makeText(getApplicationContext(), "User cannot be deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}