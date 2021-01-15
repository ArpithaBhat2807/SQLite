package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.Toast;

public class Useroperations extends AppCompatActivity {

    Button insert;
    Button update;
    Button delete;
    Button view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useroperations);


        insert=(Button)findViewById(R.id.insert);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.delete);
        view=(Button)findViewById(R.id.viewall);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertion();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updating();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletion();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewing();
            }
        });
    }

    private void viewing()
    {
        Intent viewi=new Intent(getApplicationContext(),Viewusers.class);
        startActivity(viewi);
    }

    private void deletion()
    {
        Intent int7=new Intent(this,Deleteuser.class);
        startActivity(int7);
    }

    private void updating()
    {
        Intent int6=new Intent(this, Updateuser.class);
        startActivity(int6);
    }

    private void insertion()
    {
        Intent int5=new Intent(this, Insertuser.class);
        startActivity(int5);
    }

}