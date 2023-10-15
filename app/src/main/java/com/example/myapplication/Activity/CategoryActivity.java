package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Adapters.CategoryClass;
import com.example.myapplication.Adapters.UserClass;
import com.example.myapplication.DBClass.DBHelper;
import com.example.myapplication.R;

public class CategoryActivity extends AppCompatActivity {

    EditText EditTextCategoryId, EditTextCategoryName;
    Button ButtonSubmit;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextCategoryId = (EditText) findViewById(R.id.txt_C_CategoryId);
        EditTextCategoryName =(EditText) findViewById(R.id.txt_C_CategoryName);
        ButtonSubmit =(Button) findViewById(R.id.btn_C_Submit);

        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(EditTextCategoryId.getText().toString().isEmpty()||
                       EditTextCategoryName.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields can't be Blank", Toast.LENGTH_LONG).show();
                }
               else
               {
                   CategoryClass categoryClass = new CategoryClass(EditTextCategoryId.getText().toString(), EditTextCategoryName.getText().toString());

                   if(dbHelper.CreateNewCategory(categoryClass))
                   {
                       Toast.makeText(getApplicationContext(), "Category created", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       Toast.makeText(getApplicationContext(), "Category creation Failed", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
    }
}