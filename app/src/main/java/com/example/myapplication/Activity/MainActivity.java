package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button ButtonCallLogin,ButtonCallRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonCallLogin=(Button) findViewById(R.id.btnCallLogin);
        ButtonCallRegister=(Button) findViewById(R.id.btnCallRegister);

        ButtonCallLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentRegister);

            }
        });
        ButtonCallRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intentLogin);

            }
        });

    }
}