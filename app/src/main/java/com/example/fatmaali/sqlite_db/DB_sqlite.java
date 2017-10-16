package com.example.fatmaali.sqlite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Fatma Ali on 07/09/2017.
 */

public class DB_sqlite extends SQLiteOpenHelper {

    public static final String BDname = "data.db";

    public DB_sqlite(Context context) {
        super(context, BDname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table mytable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT ,email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS mytable");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        long result = db.insert("mytable", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList getAllResult() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable", null);
        res.moveToFirst();
       while (res.isAfterLast() == false) {
            String t1 = res.getString(0);
            //  String t1 = res.getString(res.getColumnIndex("id"));
            String t2 = res.getString(1);
            String t3 = res.getString(2);
            arrayList.add(t1+" - "+t2+" : "+t3);
            res.moveToNext();
        }
        return arrayList;
    }
    public Boolean upData(String id,String name, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        db.update("mytable",contentValues,"id=?",new String[]{id});
        return true;
    }
    public Integer delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("mytable","id=?",new String[]{id});
    }
}
