package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class UserActivity extends AppCompatActivity {

    Button ButtonCallInvoice, ButtonCallSearchProducts,ButtonViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.R.layout.activity_user);

        ButtonCallInvoice=(Button) findViewById(R.id.btnCall_Invoice);
        ButtonCallSearchProducts=(Button) findViewById(R.id.btnCall_SearchProducts);
        ButtonViewProducts=(Button) findViewById(R.id.btn_view_products);

        ButtonCallInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInvoice = new Intent(UserActivity.this, InvoiceActivity.class);
                startActivity(intentInvoice);
            }
        });

        ButtonViewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentViewProducts = new Intent(UserActivity.this, ViewProductsActivity.class);
                startActivity(intentViewProducts);
            }
        });
    }
}