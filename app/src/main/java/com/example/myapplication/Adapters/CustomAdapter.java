package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    Context context;
    ArrayList<String> ProductID, ProductName, ProductPrice, ProductCategory;

    public CustomAdapter(Context context, ArrayList<String> ProductID, ArrayList<String> ProductName, ArrayList<String> ProductPrice, ArrayList<String> ProductCategory){
        this.context = context;
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.ProductCategory = ProductCategory;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_view_products, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.ProductID_txt.setText(String.valueOf(ProductID.get(position)));
        holder.ProductName_txt.setText(String.valueOf(ProductName.get(position)));
        holder.ProductPrice_txt.setText(String.valueOf(ProductPrice.get(position)));
        holder.ProductCategory_txt.setText(String.valueOf(ProductCategory.get(position)));
    }

    @Override
    public int getItemCount() {
        return ProductID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ProductName_txt, ProductPrice_txt, ProductCategory_txt, ProductID_txt;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ProductID_txt = itemView.findViewById(R.id.idProductId);
            ProductName_txt = itemView.findViewById(R.id.idProductName);
            ProductPrice_txt = itemView.findViewById(R.id.idProductPrice);
            ProductCategory_txt = itemView.findViewById(R.id.idProductCategory);
        }
    }
}
