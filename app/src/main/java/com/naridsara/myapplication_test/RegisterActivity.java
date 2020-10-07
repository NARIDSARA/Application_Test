package com.naridsara.myapplication_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewModel viewModel;
    private Button btRegister;
    private static final String TAG = "RegisterActivity";
    private EditText edtName;
    private EditText edtSurname;
    private EditText edtUsername;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtTel;
    private EditText edtHousenumber;
    private EditText edtMoo;
    private EditText edtDistrict;
    private EditText edtSubDistrict;
    private EditText edtProvince;
    private EditText edtPostalcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        btRegister = (Button)findViewById(R.id.Btn_Register);
        edtName = (EditText)findViewById(R.id.Edt_Name);
        edtSurname =(EditText)findViewById(R.id.Edt_SurName);
        edtUsername =(EditText)findViewById(R.id.Edt_UserName);
        edtEmail =(EditText)findViewById(R.id.Edt_email);
        edtPassword =(EditText)findViewById(R.id.Edt_password);
        edtTel =(EditText)findViewById(R.id.Edt_Tel);
        edtHousenumber =(EditText)findViewById(R.id.Edt_HouseNumber);
        edtMoo =(EditText)findViewById(R.id.Edt_Moo);
        edtDistrict =(EditText)findViewById(R.id.Edt_District);
        edtSubDistrict =(EditText)findViewById(R.id.Edt_SubDistrict);
        edtProvince =(EditText)findViewById(R.id.Edt_province);
        edtPostalcode =(EditText)findViewById(R.id.Edt_PostalCode);

        viewModel.register().observe(this, new Observer<Objects>() {
            @Override
            public void onChanged(Objects objects) {
                Toast.makeText(getBaseContext(),"Register success",Toast.LENGTH_SHORT).show();
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customer_name = edtName.getText().toString().trim();
                String customer_surname = edtSurname.getText().toString().trim();
                String customer_username = edtUsername.getText().toString().trim();
                String customer_email = edtEmail.getText().toString().trim();
                String customer_tel = edtTel.getText().toString().trim();
                String customer_housenumber = edtHousenumber.getText().toString().trim();
                String customer_moo = edtMoo.getText().toString().trim();
                String customer_district = edtDistrict.getText().toString().trim();
                String customer_subdistrict = edtSubDistrict.getText().toString().trim();
                String customer_province = edtProvince.getText().toString().trim();
                String customer_postalcode = edtPostalcode.getText().toString().trim();
                String customer_password = edtPassword.getText().toString().trim();


                viewModel.register(customer_name,customer_surname,customer_username,customer_email,customer_password,customer_tel,customer_housenumber,customer_moo,customer_district,customer_subdistrict,customer_province,customer_postalcode);
            }

        });



    }
}