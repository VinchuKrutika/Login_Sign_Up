package com.example.firstappfigma;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

    public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context ){
        super(context,"MainActivity.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table user(Username varchar ,Password varchar,ConfirmPassword varchar)");
    }

    @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("drop table if exists user");
    }
    public boolean insert(String Username,String Password,String ConfirmPassword){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Username",Username);
        contentValues.put("Password",Password);
        contentValues.put("SpecialPoliceID",ConfirmPassword);
        long ins=db.insert("user",null,contentValues);
        if (ins==1)
            return false;
        else
            return true;
    }


    }
