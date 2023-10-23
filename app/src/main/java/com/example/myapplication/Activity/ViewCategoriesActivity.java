package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapters.CustomAdaptor3;
import com.example.myapplication.DBClass.DBConnector;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ViewCategoriesActivity extends AppCompatActivity {
    DBConnector dbConnector;
    ArrayList<String> CategoryID, CategoryName;
    CustomAdaptor3 customAdapter3;
    RecyclerView recyclerView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_categories);
        recyclerView3 = findViewById(R.id.recyclerView3);
        dbConnector = new DBConnector(this);
        CategoryID = new ArrayList<>();
        CategoryName = new ArrayList<>();


        storeDataInArrays3();
        customAdapter3 = new CustomAdaptor3(ViewCategoriesActivity.this, CategoryID, CategoryName);
        recyclerView3.setAdapter(customAdapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(ViewCategoriesActivity.this));
    }
    void storeDataInArrays3(){
        Cursor cursor3 = dbConnector.getAllCategory();
        if(cursor3.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor3.moveToNext()){
                CategoryID.add("Category ID  ->  "+cursor3.getString(0));
                CategoryName.add("Category Name  ->  "+cursor3.getString(1));
            }
        }
    }
}