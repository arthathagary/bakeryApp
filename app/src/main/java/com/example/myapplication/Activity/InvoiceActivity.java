package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Adapters.InvoiceClass;
import com.example.myapplication.Adapters.ProductClass;
import com.example.myapplication.DBClass.DBHelper;
import com.example.myapplication.R;

import java.util.ArrayList;

public class InvoiceActivity extends AppCompatActivity {

    EditText EditTextProductId, EditTextProductName, EditTextCategory, EditTextPrice, EditTextQuantity, EditTextInvoiceId, EditTextBuyQuantity;
    Button ButtonSearchProduct, ButtonBuyProduct;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextProductId = (EditText) findViewById(R.id.txt_I_ProductId);
        EditTextProductName =(EditText) findViewById(R.id.txt_I_ProductName);
        EditTextCategory =(EditText) findViewById(R.id.txt_I_Category);
        EditTextPrice =(EditText) findViewById(R.id.txt_I_Price);
        EditTextQuantity =(EditText) findViewById(R.id.txt_I_Qty);
        EditTextInvoiceId =(EditText) findViewById(R.id.txt_I_InvoiceId);
        EditTextBuyQuantity =(EditText) findViewById(R.id.txt_I_BuyQty);
        ButtonSearchProduct =(Button) findViewById(R.id.btn_I_SearchProduct);
        ButtonBuyProduct =(Button) findViewById(R.id.btn_I_Buy);

        ButtonSearchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pid = EditTextProductId.getText().toString();
                ArrayList<ProductClass> productList=dbHelper.SearchProduct(Pid);
                if(productList.size()!=0)
                {
                    ProductClass product = productList.get(0);
                    EditTextProductName.setText(product.getProductName());
                    EditTextCategory.setText(product.getCategoryId());
                    EditTextPrice.setText(String.valueOf(product.getPrice()));
                    EditTextQuantity.setText(String.valueOf(product.getQuantity()));
                    Toast.makeText(getApplicationContext(), "Product Found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No Product Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ButtonBuyProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.BuyProduct(EditTextProductId.getText().toString(), Integer.parseInt(EditTextBuyQuantity.getText().toString()));

                int Total = Integer.parseInt(EditTextBuyQuantity.getText().toString())* Integer.parseInt(EditTextBuyQuantity.getText().toString());

                int qty = Integer.parseInt(EditTextBuyQuantity.getText().toString());

                InvoiceClass invoice = new InvoiceClass(EditTextInvoiceId.getText().toString(), EditTextProductId.getText().toString(),qty,Total);

                if (dbHelper.InsertInvoice(invoice))
                {
                    Toast.makeText(getApplicationContext(), "Buy: "+EditTextProductId.getText().toString()+"Total"+Total, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}