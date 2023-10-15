package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DBClass.DBConnector;
import com.example.myapplication.DBClass.DBHelper;
import com.example.myapplication.R;

public class DeleteProductActivity extends AppCompatActivity {
 TextView GetProductID;
 Button DeleteProductButton, ViewProductsButton;

 private DBConnector dbConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);
        dbConnect=new DBConnector(this);


        GetProductID = (TextView)findViewById(R.id.txt_delete_product_id);
        DeleteProductButton = (Button)findViewById(R.id.deleteProductButton);
        ViewProductsButton = (Button)findViewById(R.id.btn_view_d_product);

        DeleteProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GetProductID.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields can't be Blank", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Cursor cursor = dbConnect.deleteProduct(GetProductID.getText().toString());
                    if(cursor.getCount() == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Product Deleted", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Product Deletion Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    });

        ViewProductsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentViewProducts = new Intent(DeleteProductActivity.this, ViewProductsActivity.class);
                startActivity(intentViewProducts);

}
        });
    }
}