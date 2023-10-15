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

public class CustomAdaptor2 extends RecyclerView.Adapter<CustomAdaptor2.MyViewHolder2> {
    Context context;
    ArrayList<String> InvoiceID, ProductID, ProductQuantity, ProductAmount;

    public CustomAdaptor2(Context context, ArrayList<String> InvoiceID, ArrayList<String> ProductID, ArrayList<String> ProductQuantity, ArrayList<String> ProductAmount){
        this.context = context;
        this.InvoiceID = InvoiceID;
        this.ProductID = ProductID;
        this.ProductQuantity = ProductQuantity;
        this.ProductAmount = ProductAmount;

    }




    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_view_orders, parent, false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.InvoiceID_txt.setText(String.valueOf(InvoiceID.get(position)));
        holder.ProductID_txt.setText(String.valueOf(ProductID.get(position)));
        holder.ProductQuantity_txt.setText(String.valueOf(ProductQuantity.get(position)));
        holder.ProductAmount_txt.setText(String.valueOf(ProductAmount.get(position)));
    }

    @Override
    public int getItemCount() {
        return InvoiceID.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView InvoiceID_txt, ProductID_txt, ProductQuantity_txt,ProductAmount_txt;


        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            InvoiceID_txt = itemView.findViewById(R.id.idInvoiceViewID);
            ProductID_txt = itemView.findViewById(R.id.idProductViewId);
            ProductQuantity_txt = itemView.findViewById(R.id.idProductQuan);
            ProductAmount_txt = itemView.findViewById(R.id.idProductAmount);

        }
    }
}
