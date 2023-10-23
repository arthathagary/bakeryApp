package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapters.CustomAdapter;
import com.example.myapplication.DBClass.DBConnector;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ViewProductsActivity extends AppCompatActivity {
    DBConnector dbConnector;
    ArrayList<String> ProductID, ProductName, ProductPrice, ProductQuantity;
    CustomAdapter customAdapter;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);


        recyclerView = findViewById(R.id.recyclerView);
        dbConnector = new DBConnector(this);
        ProductID = new ArrayList<>();
        ProductName = new ArrayList<>();
        ProductPrice = new ArrayList<>();
        ProductQuantity = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(ViewProductsActivity.this, ProductID, ProductName, ProductPrice, ProductQuantity);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewProductsActivity.this));
    }
    void storeDataInArrays(){
        Cursor cursor = dbConnector.getAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ProductID.add("Product ID ->  "+cursor.getString(0));
                ProductName.add("Product Name ->  "+cursor.getString(1));
                ProductPrice.add("Product Price ->  "+cursor.getString(3));
                ProductQuantity.add("Product Quantity ->  "+cursor.getString(4));
            }
        }
    }
}

