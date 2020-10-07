package com.naridsara.myapplication_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.naridsara.myapplication_test.model.Restaurants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mBtInsert;
    private Button mBtSelect;
    private Button mBtLogin;
    private Button mBtRegister;
    private Button mBtAddRestaurant;
    private ArrayList<Restaurants> items;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ConnectDB.getConnection() == null) {
            Dru.failed(getBaseContext());
        } else {
            Dru.completed(getBaseContext());
        }
        mBtAddRestaurant = (Button) findViewById(R.id.Btn_Add_Restaurants);

        mBtAddRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AddRestaurantsActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchRestaurants();
    }

    private void fetchRestaurants() {
        String sql= "";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            while (resultSet.next()) {
                                items = new ArrayList<Restaurants>();
                                Restaurants restaurants = new Restaurants(
                                        resultSet.getInt(1),
                                        resultSet.getString(2),
                                        resultSet.getString(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getString(6),
                                        resultSet.getString(7),
                                        resultSet.getString(8),
                                        resultSet.getString(9),
                                        resultSet.getString(10),
                                        resultSet.getString(11),
                                        resultSet.getDouble(12),
                                        resultSet.getDouble(13),
                                        resultSet.getString(14)

                                );

                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}

                    //        mBtSelect = (Button) findViewById(R.id.bt_Select);
//        mBtInsert = (Button) findViewById(R.id.bt_Insert);
//        mBtLogin = (Button) findViewById(R.id.bt_Login);
//        mBtRegister = (Button)findViewById(R.id.bt_Register);
//        mBtLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(),LoginActivity.class));
//            }
//        });
//        mBtRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
//            }
//        });
//
//        mBtInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(),InsertActivity.class));
//            }
//        });
//        mBtSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String sql = "SELECT * FROM product ";
//                Dru.connection(ConnectDB.getConnection())
//                        .execute(sql)
//                        .commit(new ExecuteQuery() {
//                            @Override
//                            public void onComplete(ResultSet resultSet) {
//                                try {
//                                    while(resultSet.next()){
//                                        String product_id = resultSet.getString(1);
//                                        Double price = resultSet.getDouble(3);
//                                        Toast.makeText(getBaseContext(),product_id, Toast.LENGTH_SHORT).show();
//
//                                }
//                                    }catch (SQLException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//            }
//        });
//    }
