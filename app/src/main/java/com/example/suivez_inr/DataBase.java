package com.example.suivez_inr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String MyQuery1 = "create table patient(userID number , name text ,ATCD text,Diagnostic text,Traitement text, password text )";
        sqLiteDatabase.execSQL(MyQuery1);
        String MyQuery2 = "create table users(userID number , name text , password text )";
        sqLiteDatabase.execSQL(MyQuery2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void registerFonction(String userID, String name, String password){
        ContentValues contentValues =new ContentValues();
        contentValues.put("userID",userID);
        contentValues.put("name",name);
        contentValues.put("password",password);
        SQLiteDatabase DB = getWritableDatabase();
        DB.insert("users",null,contentValues);
        DB.close();
    }

    public int loginFonction(String userID,String password){
        int result =0;
        String str[] = new String[2];
        str[0]=userID;
        str[1]=password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where userID=? and password=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        return result;
    }

}
