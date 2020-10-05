package com.naridsara.myapplication_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteUpdate;

public class InsertActivity extends AppCompatActivity {

    private EditText mEdtNameProduct;
    private EditText mEdtIdProduct;
    private EditText mEdtPriceProduct;
    private Button mBtInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mEdtIdProduct = (EditText) findViewById(R.id.Edt_IdProduct);
        mEdtNameProduct = (EditText) findViewById(R.id.Edt_NameProduct);
        mEdtPriceProduct = (EditText) findViewById(R.id.Edt_PriceProduct);
        mBtInsert = (Button) findViewById(R.id.bt_Insert);


        mBtInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String product_Id = mEdtIdProduct.getText().toString().trim();
                String product_name = mEdtNameProduct.getText().toString().trim();
                String price = mEdtPriceProduct.getText().toString().trim();

                String sql = "INSERT INTO `product`(`product_id`, `product_name`, `price`) VALUES ('"+product_Id+"','"+product_name+"','"+price+"')";
                Dru.connection(ConnectDB.getConnection())
                        .execute(sql)
                        .commit(new ExecuteUpdate() {
                            @Override
                            public void onComplete() {
                                //clear screen
                                mEdtIdProduct.setText("");
                                mEdtNameProduct.setText("");
                                mEdtPriceProduct.setText("");

                                Toast.makeText(getBaseContext(),"Insert Success",Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
    }
}