package com.example.azkary.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DB extends SQLiteOpenHelper
{

    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    public void QueryData(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void InsetrNewZekr(String table_name , String ZekrContent , String ZekrBless , int ZekrRebeat)
    {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO "+table_name+" VALUES(NULL , ? , ? , "+ ZekrRebeat +" )";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1 , ZekrContent);
        statement.bindString(2 , ZekrBless);
        statement.executeInsert();
    }

    public Cursor getData(String sql)
    {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql , null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
