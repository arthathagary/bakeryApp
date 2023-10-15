package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AdminActivity extends AppCompatActivity {

    Button ButtonCallCategory, ButtonCallProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.R.layout.activity_admin);

        ButtonCallCategory=(Button) findViewById(R.id.btnCallCategory);
        ButtonCallProduct=(Button) findViewById(R.id.btnCallProduct);

        ButtonCallCategory.setOnClickListener(view -> {
            Intent intentCategory = new Intent(AdminActivity.this,CategoryActivity.class);
            startActivity(intentCategory);
        });

        ButtonCallProduct.setOnClickListener(view -> {
            Intent intentProduct = new Intent(AdminActivity.this,ProductActivity.class);
            startActivity(intentProduct);
        });
    }
}