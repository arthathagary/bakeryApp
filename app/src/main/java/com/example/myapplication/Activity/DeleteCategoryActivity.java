package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DBClass.DBConnector;
import com.example.myapplication.R;

public class DeleteCategoryActivity extends AppCompatActivity {
    TextView GetCategoryID;
    Button DeleteCategoryButton, ViewCategoryButton;

    private DBConnector dbConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_category);
        dbConnect=new DBConnector(this);

        GetCategoryID = (TextView)findViewById(R.id.txt_delete_category_id);
        DeleteCategoryButton = (Button)findViewById(R.id.deleteCategoryButton);
        ViewCategoryButton = (Button)findViewById(R.id.btn_view_d_category);

        DeleteCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GetCategoryID.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields can't be Blank", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Cursor cursor = dbConnect.deleteCategory(GetCategoryID.getText().toString());
                    if(cursor.getCount() == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Category Deleted", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Category Deletion Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    });





    }
}