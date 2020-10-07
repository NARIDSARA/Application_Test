package com.naridsara.myapplication_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button mBtLogin;
    private Button mBtRegister;
    private LoginViewModel viewModel;
    private EditText mEdtUsername;
    private EditText mEdtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        mBtLogin = (Button) findViewById(R.id.Btn_LogIng);
        mBtRegister = (Button)findViewById(R.id.Btn_Register);
        mEdtUsername = (EditText)findViewById(R.id.Edt_UserName);
        mEdtPassword = (EditText)findViewById(R.id.Edt_Password);
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEdtUsername.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();
               viewModel.requestLogin(username,password);

            }
        });
        viewModel.responseLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    startActivity(new Intent(getBaseContext(),MainActivity.class));
                }else {
                    Toast.makeText(getBaseContext(), "ชื่อผู้ใช้ไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });
        viewModel.responseToast().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}