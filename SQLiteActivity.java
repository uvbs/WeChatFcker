package com.example.zbh.wechatfucker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import javax.sql.StatementEvent;

/**
 * Created by zbh on 2017/9/7.
 */
public class SQLiteActivity extends SQLiteOpenHelper{
    private Context mContext;
    public static final String CREATE_SMS = "create table SMS (" +
            "name text," +
            "number text," +
            "message_from text," +
            "message_to text" +
            "time text)";
    public static final String CREATE_CONTACT = "create table CONTACT (" +
            "name text," +
            "number text)";
    public static final String CREATE_RECORD = "create table RECORD (" +
            "name text," +
            "number text," +
            "message_from text," +
            "message_to text," +
            "time text)";
    public static final String CREATE_MMFRIEND = "create table MMFRIEND (" +
            "name text)";
    public SQLiteActivity(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_CONTACT);
        db.execSQL(CREATE_RECORD);
        db.execSQL(CREATE_MMFRIEND);
        db.execSQL(CREATE_SMS);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){
        db.execSQL("drop table if exists SMS");
        db.execSQL("drop table if exists RECORD");
        db.execSQL("drop table if exists MMFRIEND");
        db.execSQL("drop table if exists CONTACT");
        onCreate(db);
    }

    //////////////////////////////////////////////////////////
    //以上是类的方法
    //以下方法用于具体点击某个按钮触发某个事件时的具体数据库操作暂且放在这个类里

    public void onClickAddData(View v){
        SQLiteActivity dbHelper = new SQLiteActivity(mContext, "lalala.db", null, 1);
        //这个mContext可能会替换成this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "zbh");
        values.put("message_from", "zbh");
        values.put("message_to", "zbh");
        //etc
        db.insert("SMS", null, values);
        values.clear();

        values.put("name", "zbh");
        values.put("message_from", "zbh");
        values.put("message_to", "zbh");
        //etc
        db.insert("SMS", null, values);
    }
    public void onClickDeleteData(View v){
        SQLiteActivity dbHelper = new SQLiteActivity(mContext, "lalala.db", null, 1);
        //这个mContext可能会替换成this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("SMS", "name = ?", new String[]{"zbh"});
    }
    public void onClickSelectData(View v){
        SQLiteActivity dbHelper = new SQLiteActivity(mContext, "lalala.db", null, 1);
        //这个mContext可能会替换成this
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("SMS", null, null, null, null, null ,null, null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String number = cursor.getString(cursor.getColumnIndex("number"));
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("number", number);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }
}
