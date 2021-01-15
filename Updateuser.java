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

public class Updateuser extends AppCompatActivity {

    DatabaseHelper DB;
    Button update;
    EditText ename;
    EditText epass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);

        DB=new DatabaseHelper(this);
        update=(Button)findViewById(R.id.updateu);
        ename=(EditText)findViewById(R.id.usernameu);
        epass=(EditText)findViewById(R.id.passwordu);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=ename.getText().toString();
                String upass=epass.getText().toString();
                Boolean checkupdates=DB.updateuserdata(uname,upass);
                if(checkupdates==true) {
                    Toast.makeText(getApplicationContext(), "User updated", Toast.LENGTH_SHORT).show();
                    Intent updint=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(updint);
                }
                else
                    Toast.makeText(getApplicationContext(), "Unable to update user", Toast.LENGTH_SHORT).show();
            }
        });

    }
}