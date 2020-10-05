package com.naridsara.myapplication_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private Button mBtInsert;
    private Button mBtSelect;
    private Button mBtLogin;
    private Button mBtRegister;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ConnectDB.getConnection()==null){
            Dru.failed(getBaseContext());
        }else {
            Dru.completed(getBaseContext());
        }

        mBtSelect = (Button) findViewById(R.id.bt_Select);
        mBtInsert = (Button) findViewById(R.id.bt_Insert);
        mBtLogin = (Button) findViewById(R.id.bt_Login);
        mBtRegister = (Button)findViewById(R.id.bt_Register);
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
            }
        });
        mBtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });

        mBtInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),InsertActivity.class));
            }
        });
        mBtSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "SELECT * FROM product ";
                Dru.connection(ConnectDB.getConnection())
                        .execute(sql)
                        .commit(new ExecuteQuery() {
                            @Override
                            public void onComplete(ResultSet resultSet) {
                                try {
                                    while(resultSet.next()){
                                        String product_id = resultSet.getString(1);
                                        Double price = resultSet.getDouble(3);
                                        Toast.makeText(getBaseContext(),product_id, Toast.LENGTH_SHORT).show();

                                }
                                    }catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });
    }

}
