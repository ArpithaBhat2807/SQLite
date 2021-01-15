package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.database.Cursor;
import  android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

public class Viewusers extends AppCompatActivity
{
    DatabaseHelper DB=new DatabaseHelper(this);
    Button viewu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useroperations);

        viewu=(Button)findViewById(R.id.viewall);
        viewu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=DB.getdata();
                if(cursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "No users exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(cursor.moveToNext())
                {
                    buffer.append("Name:"+cursor.getString(0)+"\n");
                    buffer.append("Password:"+cursor.getString(1)+"\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(Viewusers.this);
                builder.setCancelable(true);
                builder.setTitle("User Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
}