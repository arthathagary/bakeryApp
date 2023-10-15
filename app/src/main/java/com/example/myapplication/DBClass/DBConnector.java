package com.example.myapplication.DBClass;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper {

    public DBConnector(Context context){
        super(context,"DBEg",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table userInfo(UserID VARCHAR PRIMARY KEY NOT NULL,Password VARCHAR,UserType VARCHAR )");
        sqLiteDatabase.execSQL("create table Category(CategoryID VARCHAR PRIMARY KEY NOT NULL,CategoryName VARCHAR)");
        sqLiteDatabase.execSQL("create table Product(ProductID VARCHAR PRIMARY KEY NOT NULL,ProductName VARCHAR,CategoryID VERCHAR,Price INTEGER, Quantity INTEGER, FOREIGN KEY(CategoryID) REFERENCES Category(CategoryID))");
        sqLiteDatabase.execSQL("create table Invoice(InvoiceID VARCHAR PRIMARY KEY NOT NULL,ProductID VARCHAR, Quantity INTEGER, Total INTEGER,FOREIGN KEY(ProductID) REFERENCES Product(ProductID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getAllData(){
        String query = "SELECT * FROM Product";
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery("select * from Product",null);
        return cursor;
    }

    public Cursor getAllOrder(){
        String query = "SELECT * FROM Invoice";
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery("select * from Invoice",null);
        return cursor;
    }

    public Cursor deleteProduct(String id){
        String query = "DELETE FROM Product WHERE ProductID = '"+id+"'";
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery(query,null);
        return cursor;
    }

    public Cursor deleteCategory(String id){
        String query = "DELETE FROM Category WHERE CategoryID = '"+id+"'";
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery(query,null);
        return cursor;
    }
}
