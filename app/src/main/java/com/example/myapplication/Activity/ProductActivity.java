package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Adapters.ProductClass;
import com.example.myapplication.DBClass.DBHelper;
import com.example.myapplication.R;

import java.util.Vector;

public class ProductActivity extends AppCompatActivity {

    EditText EditTextProductId, EditTextProductName, EditTextPrice, EditQuantity;
    Spinner SpinnerCategory;
    Button ButtonSubmit;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextProductId=(EditText) findViewById(R.id.txt_P_ProductId);
        EditTextProductName=(EditText) findViewById(R.id.txt_P_ProductName);
        EditTextPrice=(EditText) findViewById(R.id.txt_P_Price);
        EditQuantity=(EditText) findViewById(R.id.txt_P_Quantity);
        ButtonSubmit=(Button) findViewById(R.id.btn_P_SubmitProduct);
        SpinnerCategory=(Spinner) findViewById(R.id.sp_P_Category);

        Vector<String> vecCategory = dbHelper.getCategory_Name();
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item,vecCategory);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerCategory.setAdapter(ad);

        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EditTextProductId.getText().toString().isEmpty() || EditTextProductName.getText().toString().isEmpty() ||
                        EditTextPrice.getText().toString().isEmpty() || EditQuantity.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fields Can't be blank", Toast.LENGTH_SHORT).show();
                }
                else {
                    String CategoryId = dbHelper.getCategory_Id(SpinnerCategory.getSelectedItem().toString());

                    ProductClass product = new ProductClass(EditTextProductId.getText().toString(),EditTextProductName.getText().toString(),
                            Integer.parseInt(EditTextPrice.getText().toString()),Integer.parseInt(EditQuantity.getText().toString()), CategoryId);

                    if (dbHelper.InsertProduct(product)){
                        Toast.makeText(getApplicationContext(), "New Product insert", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}