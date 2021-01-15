package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB)
    {
        MyDB.execSQL("create Table users(name text primary key, password TEXT)");

    }



    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1)
    {
        MyDB.execSQL("drop Table if exists users");

    }

    public Boolean insertData(String username,String password)
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",username);
        contentValues.put("password",password);
        long result=MyDB.insert("users",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase MyDB =this.getWritableDatabase();
        Cursor cursor;
        cursor = MyDB.rawQuery("select * from users where name = ?",new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;
    }
    public Boolean checkusernamepassword(String username,String password)
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor;
        cursor=MyDB.rawQuery("select * from users where name = ? and password = ?",new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;
    }
    public Boolean updateuserdata(String username,String password)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",username);
        contentValues.put("password",password);
        Cursor cursor= DB.rawQuery("select * from users where name=?",new String[]{username});
        if(cursor.getCount()>0)
        {
            long result=DB.update("users",contentValues,"name=?",new String[]{username});
            if(result==-1)
                return false;
            else
                return true;
        }
        else
            return false;
    }
    public Boolean deletedata(String username)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from users where name=?",new String[]{username});
        if(cursor.getCount()>0)
        {
            long result=DB.delete("users","name=?",new String[]{username});
            if(result==-1)
                return false;
            else
                return true;
        }
        else
            return false;

    }
    public Cursor getdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from users",null);
        return cursor;
    }
}