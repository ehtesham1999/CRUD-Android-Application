package com.example.crudapps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "address";
    public static final String COL_4 = "phone";
    public static final String COL_5 = "email";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+TABLE_NAME+"("+COL_1+" integer primary key autoincrement, "+COL_2+" text,"+COL_3+" text,"+COL_4+" text,"+COL_5+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String address,String phone,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COL_2,name);
        content.put(COL_3,address);
        content.put(COL_4,phone);
        content.put(COL_5,email);
        long result  = db.insert(TABLE_NAME,null,content);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String address,String phone,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COL_1,id);
        content.put(COL_2,name);
        content.put(COL_3,address);
        content.put(COL_3,phone);
        content.put(COL_4,email);
        db.update(TABLE_NAME,content,"id = ?",new String[] {id} );
        return true;
    }

    public int deleteData(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id = ?",new String[]{id});
    }
}
