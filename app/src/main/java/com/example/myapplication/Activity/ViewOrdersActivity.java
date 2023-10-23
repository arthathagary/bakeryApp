package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapters.CustomAdaptor2;
import com.example.myapplication.DBClass.DBConnector;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ViewOrdersActivity extends AppCompatActivity {
    DBConnector dbConnector;
    ArrayList<String> InvoiceID, ProductID, ProductQuantity, ProductAmount;
    CustomAdaptor2 customAdapter2;
    RecyclerView recyclerView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders);
        recyclerView2 = findViewById(R.id.recyclerView2);
        dbConnector = new DBConnector(this);
        InvoiceID = new ArrayList<>();
        ProductID = new ArrayList<>();
        ProductQuantity = new ArrayList<>();
        ProductAmount = new ArrayList<>();



        storeDataInArrays2();
        customAdapter2 = new CustomAdaptor2(ViewOrdersActivity.this, InvoiceID, ProductID, ProductQuantity, ProductAmount);
        recyclerView2.setAdapter(customAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(ViewOrdersActivity.this));
    }

    void storeDataInArrays2(){
        Cursor cursor2 = dbConnector.getAllOrder();
        if(cursor2.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor2.moveToNext()){
                InvoiceID.add("Invoice ID ->  "+cursor2.getString(0));
                ProductID.add("Product ID ->  "+cursor2.getString(1));
                ProductQuantity.add("Product Quantity ->  "+cursor2.getString(2));
                ProductAmount.add("Product Amount ->  "+cursor2.getString(3));
            }
        }
    }
}