package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Adapters.UserClass;
import com.example.myapplication.DBClass.DBHelper;
import com.example.myapplication.R;

public class RegisterActivity extends AppCompatActivity {

    EditText EditTextUserId,EditTextPassword,EditTextConfirmPassword;
    Spinner SpinnerUserType;
    Button ButtonRegister;

    String UserType[]={"Admin","User"};

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextUserId=(EditText) findViewById(R.id.txt_R_UserId);
        EditTextPassword=(EditText) findViewById(R.id.txt_R_Password);
        EditTextConfirmPassword=(EditText) findViewById(R.id.txt_R_ConfirmPassword);
        ButtonRegister=(Button) findViewById(R.id.btn_R_Register);
        SpinnerUserType=(Spinner) findViewById(R.id.sp_R_UserType);

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item,UserType);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerUserType.setAdapter(ad);

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EditTextUserId.getText().toString().isEmpty()||
                        EditTextPassword.getText().toString().isEmpty()||
                        EditTextConfirmPassword.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields can't be Blank", Toast.LENGTH_LONG).show();
                }
                else if (EditTextPassword.getText().toString().length()<3)
                {
                    Toast.makeText(getApplicationContext(), "Password must have more than 3 characters", Toast.LENGTH_SHORT).show();
                }
                else if (!EditTextPassword.getText().toString().equals((EditTextConfirmPassword.getText().toString())))
                {
                    Toast.makeText(getApplicationContext(), "Password and confirm password should match", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    UserClass userClass = new UserClass(EditTextUserId.getText().toString(),EditTextPassword.getText().toString(),
                            SpinnerUserType.getSelectedItem().toString());
                    if(dbHelper.CreateNewUser(userClass))
                    {
                        Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), " has login as " + SpinnerUserType.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "User creation Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}