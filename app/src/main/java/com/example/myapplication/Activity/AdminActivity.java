package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AdminActivity extends AppCompatActivity {

    Button ButtonCallCategory, ButtonCallProduct,ButtonViewOrders,DeleteProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.R.layout.activity_admin);

        ButtonCallCategory=(Button) findViewById(R.id.btnCallCategory);
        ButtonCallProduct=(Button) findViewById(R.id.btnCallProduct);
        ButtonViewOrders=(Button) findViewById(R.id.btnViewOrders);
        DeleteProduct=(Button) findViewById(R.id.btnDeleteProduct);


        ButtonCallCategory.setOnClickListener(view -> {
            Intent intentCategory = new Intent(AdminActivity.this,CategoryActivity.class);
            startActivity(intentCategory);
        });

        ButtonCallProduct.setOnClickListener(view -> {
            Intent intentProduct = new Intent(AdminActivity.this,ProductActivity.class);
            startActivity(intentProduct);
        });

        ButtonViewOrders.setOnClickListener(view -> {
            Intent intentViewOrders = new Intent(AdminActivity.this,ViewOrdersActivity.class);
            startActivity(intentViewOrders);
        });

        DeleteProduct.setOnClickListener(view -> {
            Intent intentDeleteProduct = new Intent(AdminActivity.this,DeleteProductActivity.class);
            startActivity(intentDeleteProduct);
        });
    }
}