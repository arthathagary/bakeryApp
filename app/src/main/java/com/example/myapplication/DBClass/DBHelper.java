package com.example.myapplication.DBClass;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Adapters.CategoryClass;
import com.example.myapplication.Adapters.InvoiceClass;
import com.example.myapplication.Adapters.ProductClass;
import com.example.myapplication.Adapters.UserClass;

import java.util.ArrayList;
import java.util.Vector;

public class DBHelper {
    private Context con;

    private SQLiteDatabase db;
    public DBHelper(Context con){
        this.con=con;
    }

    public DBHelper OpenDB(){
        DBConnector dbCon=new DBConnector(con);
        db=dbCon.getWritableDatabase();
        return this;
    }
    public boolean CreateNewUser(UserClass userClass){
        try
        {
            db.execSQL("insert into userInfo values('"+userClass.getUserId()+"','"
                    +userClass.getPassword()+"','"+userClass.getUserType()+"')");
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<UserClass> ValidLogin(String UserId, String Password)
    {
        ArrayList<UserClass> userList = new ArrayList<UserClass>();
        try
        {
            Cursor cursor = db.rawQuery("Select * from userInfo where UserId='"+UserId+"'and Password='"+Password+"' ",null);
            if (cursor.moveToFirst())
            {
                do {
                    UserClass user = new UserClass();
                    user.setUserId(cursor.getString(0));
                    user.setPassword(cursor.getString(1));
                    user.setUserType(cursor.getString(2));
                    userList.add(user);
                }

                while (cursor.moveToNext());
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return userList;
    }

    public boolean CreateNewCategory (CategoryClass categoryClass){
        try
        {
            db.execSQL("insert into Category values('"+categoryClass.getCategoryId()+"','"+categoryClass.getCategoryName()+"')");
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    public Vector<String> getCategory_Name(){
        Vector<String> VecCategory = new Vector<>();
        try {
            Cursor cursor = db.rawQuery("Select CategoryName from Category ",null);
            if (cursor.moveToFirst()){
                do {
                    VecCategory.add(cursor.getString(0));
                }
                while (cursor.moveToNext());
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return VecCategory;
    }
    public String getCategory_Id(String CategoryName){
        String CategoryId = null;
        try {
            Cursor cursor = db.rawQuery("Select CategoryID form Cetegory where CategoryName = '"+CategoryName+"'",null);
            if(cursor.moveToFirst()){
                CategoryId = cursor.getString(0);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return CategoryId;
    }
    public boolean InsertProduct(ProductClass productClass){
        try {
            db.execSQL("insert into Product values('"+productClass.getProductId()+"','"+productClass.getProductName()+"','" +
                    productClass.getProductId()+"','"+productClass.getPrice()+"','"+productClass.getQuantity()+"')");
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<ProductClass> SearchProduct(String ProductId)
    {
        ArrayList<ProductClass> productList = new ArrayList<ProductClass>();
        try
        {
            Cursor cursor = db.rawQuery("Select * from Product where ProductId='"+ProductId+"' ",null);
            if (cursor.moveToFirst())
            {
                do {
                    ProductClass product = new ProductClass();
                    product.setProductId(cursor.getString(0));
                    product.setProductName(cursor.getString(1));
                    product.setCategoryId(cursor.getString(2));
                    product.setPrice(cursor.getInt(3));
                    product.setQuantity(cursor.getInt(4));
                    productList.add(product);
                }

                while (cursor.moveToNext());
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return productList;
    }

    public void BuyProduct(String Product_Id, int Qty)
    {
        try
        {
            db.execSQL("update Product set Quantity = Quantity -" +Qty+"where ProductId='"+Product_Id+"'");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean InsertInvoice(InvoiceClass invoice)
    {
        try
        {
            db.execSQL("insert into Invoice values('"+invoice.getInvoiceId()+"', '"+invoice.getProductId()+"', '"+invoice.getQty()+"', '"+invoice.getTotal()+"')");
            return true;
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;

        }
    }
}
