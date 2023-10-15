package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Adapters.UserClass;
import com.example.myapplication.DBClass.DBHelper;
import com.example.myapplication.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText EditTextUserId, EditTextPassword;
    Button ButtonLogin;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextUserId=(EditText) findViewById(R.id.txt_L_UserId);
        EditTextPassword=(EditText) findViewById(R.id.txt_L_Password);
        ButtonLogin=(Button) findViewById(R.id.btn_L_Login);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<UserClass> userDetails = dbHelper.ValidLogin(EditTextUserId.getText().toString(),EditTextPassword.getText().toString());

                if(userDetails.size()!=0)
                {
                    UserClass user = userDetails.get(0);
                    String UserType = user.getUserType();

                    Toast.makeText(getApplicationContext(), "user found"+UserType, Toast.LENGTH_SHORT).show();

                    if(UserType.equals("Admin"))
                    {
                        Intent intentAdmin = new Intent(LoginActivity.this,AdminActivity.class);
                        startActivity(intentAdmin);
                    }
                    else
                    {
                        Intent intentUser = new Intent(LoginActivity.this,UserActivity.class);
                        startActivity(intentUser);
                    }
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}