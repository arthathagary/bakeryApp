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

public class CustomAdaptor3 extends RecyclerView.Adapter<CustomAdaptor3.MyViewHolder3>{
    Context context;
    ArrayList<String> CategoryID, CategoryName;

    public CustomAdaptor3(Context context, ArrayList<String> CategoryID, ArrayList<String> CategoryName){
        this.context = context;
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
    }




    @NonNull
    @Override
    public CustomAdaptor3.MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_view_categories, parent, false);
        return new CustomAdaptor3.MyViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdaptor3.MyViewHolder3 holder, int position) {
        holder.CategoryID_txt.setText(String.valueOf(CategoryID.get(position)));
        holder.CategoryName_txt.setText(String.valueOf(CategoryName.get(position)));
    }

    @Override
    public int getItemCount() {
        return CategoryID.size();
    }

    public class MyViewHolder3 extends RecyclerView.ViewHolder {
        TextView CategoryID_txt, CategoryName_txt;


        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);
            CategoryID_txt = itemView.findViewById(R.id.idCategoryViewId);
            CategoryName_txt = itemView.findViewById(R.id.idCategoryViewName);
        }
    }
}
